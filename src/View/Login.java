package View;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Robot;
import Controller.LoginController;
import java.awt.Font;
import java.io.IOException;
import java.util.prefs.*;

public class Login extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Register register = new Register();
	private static MainNew mainNew;
	private ImagePanel contentPane;
	private Preferences prefs;
	Image img;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton registerButton;
	private JButton exitButton;
	private JButton loginButton;
	private JHyperlinkLabel forgottenPassword;
	private JCheckBox chckbxRememberMe;
	private boolean auto = false;

	/**
	 * Create the frame.
	 */
	public Login() {
		init();
	}
	
	public void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 521);
		img = Toolkit.getDefaultToolkit().createImage(
				"resources/LoginNewBackground.jpg");
		contentPane = new ImagePanel(img);
		contentPane.setMinimumSize(new Dimension(350, 513));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setTitle("ShowBuzz V1.0");

		usernameField = new JTextField();
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setBorder(null);
		usernameField.setBounds(112, 147, 269, 22);
		usernameField.setOpaque(false);
		usernameField.setBackground(new Color(0, 0, 0, 128));
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBorder(null);
		passwordField.setBounds(112, 235, 269, 22);
		passwordField.setOpaque(false);
		passwordField.setBackground(new Color(0, 0, 0, 128));
		contentPane.add(passwordField);

		loginButton = new JButton("");
		loginButton.setName("login");
		loginButton.setSelectedIcon(null);
		loginButton.setBorder(null);
		loginButton.setBounds(101, 387, 139, 31);
		loginButton.setOpaque(false);
		loginButton.setBackground(new Color(0, 0, 0, 128));
		loginButton.addMouseListener(this);
		contentPane.add(loginButton);
		
		registerButton = new JButton("");
		registerButton.setName("register");
		registerButton.setOpaque(false);
		registerButton.setBorder(null);
		registerButton.setBackground(new Color(0, 0, 0, 128));
		registerButton.setBounds(119, 432, 262, 31);
		registerButton.addMouseListener(this);
		contentPane.add(registerButton);

		exitButton = new JButton("");
		exitButton.setName("exit");
		exitButton.setOpaque(false);
		exitButton.setBorder(null);
		exitButton.setBackground(new Color(0, 0, 0, 128));
		exitButton.setBounds(263, 387, 139, 31);
		exitButton.addMouseListener(this);
		contentPane.add(exitButton);

		forgottenPassword = new JHyperlinkLabel("Forgot your password ?");
		forgottenPassword.setFont(new Font("Planet Kosmos", Font.PLAIN, 14));
		forgottenPassword.setForeground(new Color(0, 128, 128));
		forgottenPassword.setBounds(174, 278, 254, 22);
		forgottenPassword.addMouseListener(this);
		contentPane.add(forgottenPassword);

		chckbxRememberMe = new JCheckBox("");
		chckbxRememberMe.setForeground(Color.BLACK);
		chckbxRememberMe.setBounds(122, 326, 32, 22);
		chckbxRememberMe.setOpaque(false);
		chckbxRememberMe.setBackground(new Color(0, 0, 0, 128));
		contentPane.add(chckbxRememberMe);
		setVisible(true);
		prefs = Preferences.userNodeForPackage(this.getClass());
		if(prefs.get("UID", "none")!="none"&&prefs.get("PSW", "none")!="none"){
			auto = true;
			try {
				Robot bot = new Robot();
				int mask = InputEvent.BUTTON1_DOWN_MASK;
				bot.mouseMove((int)loginButton.getLocationOnScreen().getX()+70,(int)loginButton.getLocationOnScreen().getY()+15);
				bot.mousePress(mask);
				bot.mouseRelease(mask);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login frame = new Login();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	// Mouse Listener methods

	@SuppressWarnings("deprecation")
	public void mouseClicked(MouseEvent e) {
		prefs = Preferences.userNodeForPackage(this.getClass());
		if (e.getComponent().getClass().equals(JButton.class)) {
			switch (e.getComponent().getName()) {
			case "login": {
				LoginController log = new LoginController();
				try{
					if(auto){
						if (log.checkLogin(prefs.get("UID", "none"),"szili754")) {
							mainNew = new MainNew(prefs.get("UID", "none"));
							getMain().setVisible(true);
							dispose();
						}else{
							JOptionPane.showMessageDialog(null, "Invalid Username or Password!", "Login",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}else{
						if (log.checkLogin(usernameField.getText(),
								passwordField.getText())) {
							if(chckbxRememberMe.isSelected()){
								prefs.put("UID", usernameField.getText());
								prefs.put("PSW", passwordField.getText());
							}else{
								try {
									prefs.removeNode();
								} catch (NullPointerException e1) {
									System.out.println("nullpointer");
									e1.printStackTrace();
								} catch (IllegalStateException e2){
									System.out.println("Illegal state");
								} catch (BackingStoreException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							mainNew = new MainNew(usernameField.getText());
							getMain().setVisible(true);
							dispose();
						}else{
							JOptionPane.showMessageDialog(null, "Invalid Username or Password!", "Login",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				} catch (HeadlessException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
				
				
			
				break;
			case "register": {
				Register reg = new Register();
				reg.setVisible(true);
				dispose();
			}
				break;
			case "exit": {
				System.exit(1);
			}
				break;
			default:
				break;
			}
		} else {
			if(e.getComponent().getClass().equals(JHyperlinkLabel.class)){
				ForgotPass forgotpass = new ForgotPass();
				forgotpass.setVisible(true);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	public static Register getRegister(){
		return register;
	}
	
	public static MainNew getMain(){
		return mainNew;
	}
}
