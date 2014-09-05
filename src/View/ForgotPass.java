package View;



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import Controller.ForgotPassController;

@SuppressWarnings("serial")
public class ForgotPass extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JTextField username;
	private JTextField newpass;
	private JTextField rptpass;
	private JTextField email;

	/**
	 * Create the frame.
	 */
	public ForgotPass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		setTitle("Forgot Password");
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(43, 40, 87, 17);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(140, 38, 151, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("New password");
		lblNewPassword.setBounds(43, 99, 87, 17);
		contentPane.add(lblNewPassword);
		
		newpass = new JPasswordField();
		newpass.setColumns(10);
		newpass.setBounds(140, 97, 151, 20);
		contentPane.add(newpass);
		
		JLabel lblRepeatPassword = new JLabel("Repeat");
		lblRepeatPassword.setBounds(43, 129, 87, 17);
		contentPane.add(lblRepeatPassword);
		
		rptpass = new JPasswordField();
		rptpass.setColumns(10);
		rptpass.setBounds(140, 127, 151, 20);
		contentPane.add(rptpass);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(43, 70, 87, 17);
		contentPane.add(lblEmail);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(140, 68, 151, 20);
		contentPane.add(email);
		
		JButton btnChangePassword = new JButton("Change");
		btnChangePassword.setName("changepass");
		btnChangePassword.addMouseListener(this);
		btnChangePassword.setBounds(43, 171, 119, 23);
		contentPane.add(btnChangePassword);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setName("cancel");
		btnCancel.addMouseListener(this);
		btnCancel.setBounds(172, 171, 119, 23);
		contentPane.add(btnCancel);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getComponent().getClass().equals(JButton.class)) {
			switch (e.getComponent().getName()) {
			case "changepass": {
				ForgotPassController fpc = new ForgotPassController();
				if(newpass.getText()!=""&&rptpass.getText()!=""&&newpass.getText().equals(rptpass.getText())){
			        if(fpc.changePass(username.getText(), email.getText(), newpass.getText())){ 
			        	JOptionPane.showMessageDialog(this,"Password Change Successful!");
			        	dispose();
			        }else{
			        	JOptionPane.showMessageDialog(this,"Username and/or E-Mail not correct!");
			        }
				}else{
					JOptionPane.showMessageDialog(this,"Passwords don't match!");
				}
				}
				break;
			case "cancel":{
				dispose();
				}
				break;
			default: break;
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
}
