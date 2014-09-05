package View;



import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import Controller.RegisterController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;


public class Register extends JFrame implements MouseListener{

	private static final long serialVersionUID = 1L;
	private JTextField fName;
	private JTextField lName;
	private JTextField username;
	private JPasswordField pass;
	private JPasswordField rpass;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxYear, comboBoxMonth, comboBoxDay;
	private JTextField email;
	Image img;
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Register() {
		setResizable(false);
		setTitle("Register");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 696, 521);
		getContentPane().setLayout(null);
		//setting the background for the window
		img = Toolkit.getDefaultToolkit().createImage(
				"resources/RegisterBackground.jpg");
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 690, 493);
		panel = new ImagePanel(img);
		setContentPane(panel);
		//setting the cursor blinker to be white
		UIManager.put("TextField.caretForeground", new ColorUIResource(Color.white));
		UIManager.put("PasswordField.caretForeground", new ColorUIResource(Color.white));
		//initializing the first name text field and setting the preferred options
		fName = new JTextField();
		fName.setFont(new Font("BankGothic Lt BT", Font.BOLD, 14));
		fName.setForeground(Color.WHITE);
		fName.setHorizontalAlignment(SwingConstants.CENTER);
		fName.setBorder(null);
		fName.setBounds(341, 52, 316, 20);
		fName.setOpaque(false);
		fName.setBackground(new Color(0, 0, 0, 128));
		fName.setToolTipText("");
		fName.setColumns(10);
		//initializing the last name text field and setting the preferred options
		lName = new JTextField();
		lName.setBorder(null);
		lName.setForeground(Color.WHITE);
		lName.setHorizontalAlignment(SwingConstants.CENTER);
		lName.setFont(new Font("BankGothic Lt BT", Font.BOLD, 14));
		lName.setOpaque(false);
		lName.setBackground(new Color(0, 0, 0, 128));
		lName.setBounds(341, 113, 316, 20);
		lName.setToolTipText("");
		lName.setColumns(10);
		//initializing the user name text field and setting the preferred options
		username = new JTextField();
		username.setBorder(null);
		username.setForeground(Color.WHITE);
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setFont(new Font("BankGothic Lt BT", Font.BOLD, 14));
		username.setOpaque(false);
		username.setBackground(new Color(0, 0, 0, 128));
		username.setBounds(341, 169, 316, 20);
		username.setToolTipText("At least eight characters long");
		username.setColumns(10);
		//initializing the password field and setting the preferred options
		pass = new JPasswordField();
		pass.setBorder(null);
		pass.setForeground(Color.WHITE);
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.setFont(new Font("BankGothic Lt BT", Font.BOLD, 14));
		pass.setOpaque(false);
		pass.setBackground(new Color(0, 0, 0, 128));
		pass.setBounds(341, 293, 316, 20);
		//initializing the repeat password field and setting the preferred options
		rpass = new JPasswordField();
		rpass.setBorder(null);
		rpass.setForeground(Color.WHITE);
		rpass.setHorizontalAlignment(SwingConstants.CENTER);
		rpass.setFont(new Font("BankGothic Lt BT", Font.BOLD, 14));
		rpass.setOpaque(false);
		rpass.setBackground(new Color(0, 0, 0, 128));
		rpass.setBounds(341, 354, 316, 20);
		//creating the register button and setting the options as well as adding a mouse listener to it
		JButton btnRegister = new JButton("");
		btnRegister.setBorder(null);
		btnRegister.setOpaque(false);
		btnRegister.setBackground(new Color(0,0,0,128));
		btnRegister.setName("register");
		btnRegister.setBounds(365, 437, 112, 23);
		btnRegister.addMouseListener(this);
		//creating the cancel button and setting the options as well as adding a mouse listener to it
		JButton btnCancel = new JButton("");
		btnCancel.setName("cancel");
		btnCancel.setOpaque(false);
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(0,0,0,128));
		btnCancel.setBounds(507, 437, 112, 23);
		btnCancel.addMouseListener(this);
		//adding all the components to the panel
		panel.setLayout(null);
		panel.add(fName);
		panel.add(lName);
		panel.add(username);
		panel.add(pass);
		panel.add(rpass);
		panel.add(btnRegister);
		panel.add(btnCancel);
		//initializing the combo box for year of birth
		comboBoxYear = new JComboBox();
		comboBoxYear.setForeground(Color.GRAY);
		comboBoxYear.setBorder(null);
		comboBoxYear.setBackground(Color.black);
		comboBoxYear.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 11));
		comboBoxYear.setName("year");
		comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930"}));
		comboBoxYear.setOpaque(false);
		comboBoxYear.setBounds(598, 394, 59, 20);
		//adding it to the panel
		panel.add(comboBoxYear);
		//initializing the combo box for month of birth
		comboBoxMonth = new JComboBox();
		comboBoxMonth.setBorder(null);
		comboBoxMonth.setForeground(Color.gray);
		comboBoxMonth.setBackground(Color.black);
		comboBoxMonth.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 11));
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBoxMonth.setName("month");
		comboBoxMonth.setBounds(507, 394, 81, 20);
		//adding it to the panel
		panel.add(comboBoxMonth);
		//initializing the combo box for day of birth
		comboBoxDay = new JComboBox();
		comboBoxDay.setForeground(Color.GRAY);
		comboBoxDay.setBorder(null);
		comboBoxDay.setBackground(Color.BLACK);
		comboBoxDay.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 11));
		comboBoxDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxDay.setName("day");
		comboBoxDay.setBounds(457, 394, 40, 20);
		//adding it to the panel
		panel.add(comboBoxDay);
		//initializing the email text field and setting its options
		email = new JTextField();
		email.setToolTipText("At least eight characters long");
		email.setBorder(null);
		email.setForeground(Color.WHITE);
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setFont(new Font("BankGothic Lt BT", Font.BOLD, 14));
		email.setOpaque(false);
		email.setBackground(new Color(0, 0, 0, 128));
		email.setColumns(10);
		email.setBounds(341, 233, 316, 20);
		panel.add(email);
	}
	
	/**
	 * Launch the application.
	 */
@SuppressWarnings("deprecation")
	//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Register frame = new Register();
//					frame.setVisible(true);
//			} catch (Exception e) {
//				e.printStackTrace();
//				}
//			}
//		});
//	}
//in this method we define what happens when you get an event from the mouse listener
	@Override
	public void mouseClicked(MouseEvent e) {
		int days=0, month=0;
		String bDay=comboBoxYear.getSelectedItem().toString();
		if (e.getComponent().getClass().equals(JButton.class)) {
			if(e.getComponent().getName()=="cancel") {
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}else{
				if(e.getComponent().getName()=="register") {
					switch(comboBoxMonth.getSelectedItem().toString()){
					case "January": month=1; days=31;break;
					case "February": month=2; days=getYear(comboBoxYear.getSelectedItem().toString());break;
					case "March": month=3; days=31;break;
					case "April": month=4; days=30;break;
					case "May": month=5; days=31;break;
					case "June": month=6; days=30;break;
					case "July": month=7; days=31;break;
					case "August": month=8; days=31;break;
					case "September": month=9; days=30;break;
					case "October": month=10; days=31;break;
					case "November": month=11; days=30;break;
					case "December": month=12; days=31;break;
					}
				
					int day=Integer.parseInt(comboBoxDay.getSelectedItem().toString());
					if(day<=days){
						bDay+="-" + month + "-" + comboBoxDay.getSelectedItem().toString();
						if(mailValidation(email.getText())){
							if(!username.getText().isEmpty()&&!pass.getPassword().toString().isEmpty()&&!rpass.getPassword().toString().isEmpty()&&!email.getText().isEmpty()&&passwordMatch(pass.getPassword(), rpass.getPassword())){
								RegisterController reg = new RegisterController();
								if(!reg.register(fName.getText(),lName.getText(),username.getText(), pass.getText(), email.getText(), bDay)){
									JOptionPane.showMessageDialog(this, "This username or e-mail already exists!");
								}
							}else{
								JOptionPane.showMessageDialog(this, "Please fill out all the required fields!");
							}
						}else{
							JOptionPane.showMessageDialog(this, "This E-Mail address is not valid. Please enter a valid E-Mail address.");
						}				
					}else{
						JOptionPane.showMessageDialog(this, "This date is not valid. Please select a valid date.");
					}
				}
				JOptionPane.showMessageDialog(this, "Registration Successful");
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		}		
	}

	
	public static boolean passwordMatch(char[] pass1, char[] pass2){
		for(int i=0;i<pass1.length;i++){
			if(!(pass1[i]==pass2[i]&&pass1.length==pass2.length)){
				return false;
			}
		}
		return true;
	}
		
	
	public static boolean mailValidation(String email) {
		final String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		 return email.matches(pattern);
	}
	    
	
	private int getYear(String selectedItem) {
		
		int year=Integer.parseInt(selectedItem);
		if(year%4==0){
			if(year%100==0){
				return 28;
			}else{
				return 29;
				}
		}else{
				return 28;
			}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
