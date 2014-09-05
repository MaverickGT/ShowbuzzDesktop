package View;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.LoginController;
import Controller.UpdateAccountController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class AccountDetails extends JFrame{

	private JPanel contentPane;
	private JTextField username;
	private JTextField email;
	private JTextField firstName;
	private JTextField lastName;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AccountDetails frame = new AccountDetails("jakabszili13");
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AccountDetails(String uName) {
		LoginController log = new LoginController();
		User user = new User();
		user = log.getInfo(uName);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(53, 36, 100, 14);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(179, 36, 200, 20);
		username.setText(user.getUsername());
		username.setEditable(false);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(53, 70, 100, 14);
		contentPane.add(lblEmail);
		
		email = new JTextField();
		email.setColumns(10);
		email.setText(user.getEmail());
		email.setBounds(179, 70, 200, 20);
		contentPane.add(email);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(53, 104, 100, 14);
		contentPane.add(lblFirstName);
		
		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setText(user.getFirstName());
		firstName.setBounds(179, 104, 200, 20);
		contentPane.add(firstName);
		
		JLabel lblSecondName = new JLabel("Second Name");
		lblSecondName.setBounds(53, 139, 100, 14);
		contentPane.add(lblSecondName);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setText(user.getLastName());
		lastName.setBounds(179, 139, 200, 20);
		contentPane.add(lastName);
		contentPane.setVisible(true);
		
		JButton btnUpdateData = new JButton("Update Details");
		btnUpdateData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateAccountController uac = new UpdateAccountController();
				if(uac.changeDetails(username.getText(), email.getText(), firstName.getText(), lastName.getText())){
					JOptionPane.showMessageDialog(null, "Account details successfully changed.", "Account Details",
							JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "There was an error, please try again later.", "Account Details",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnUpdateData.setBounds(75, 196, 122, 23);
		contentPane.add(btnUpdateData);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(228, 196, 122, 23);
		contentPane.add(btnCancel);
	
	}
	
	
	
}

