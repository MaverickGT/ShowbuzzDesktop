package View;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Label;

@SuppressWarnings("serial")
public class AboutShowBuzz extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutShowBuzz frame = new AboutShowBuzz();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AboutShowBuzz() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("ShowBuzz V1.0");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 130, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -130, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 18));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 28, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -172, SpringLayout.SOUTH, contentPane);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblCreatedBy = new JLabel("Created by ");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCreatedBy, -150, SpringLayout.EAST, contentPane);
		lblCreatedBy.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCreatedBy, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCreatedBy, 150, SpringLayout.WEST, contentPane);
		lblCreatedBy.setFont(new Font("Rockwell", Font.BOLD, 15));
		contentPane.add(lblCreatedBy);
		
		JLabel lblKestutisPolisciukas = new JLabel("Kestutis Polisciukas");
		lblKestutisPolisciukas.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblKestutisPolisciukas, 150, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblKestutisPolisciukas, -150, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblKestutisPolisciukas, -120, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblKestutisPolisciukas, 106, SpringLayout.NORTH, contentPane);
		contentPane.add(lblKestutisPolisciukas);
		
		JLabel lblGeorgiTerziyski = new JLabel("Georgi Terziyski");
		lblGeorgiTerziyski.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGeorgiTerziyski, 6, SpringLayout.SOUTH, lblKestutisPolisciukas);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGeorgiTerziyski, 150, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblGeorgiTerziyski, -100, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblGeorgiTerziyski, -150, SpringLayout.EAST, contentPane);
		contentPane.add(lblGeorgiTerziyski);
		
		JLabel lblSzilrdJakab = new JLabel("Szil\u00E1rd Jakab");
		lblSzilrdJakab.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblSzilrdJakab, 13, SpringLayout.SOUTH, lblGeorgiTerziyski);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblSzilrdJakab, 150, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblSzilrdJakab, -150, SpringLayout.EAST, contentPane);
		contentPane.add(lblSzilrdJakab);
		
		Label label = new Label("KEA 2014 June");
		label.setAlignment(Label.CENTER);
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 14, SpringLayout.SOUTH, lblSzilrdJakab);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 150, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label, -20, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, label, -150, SpringLayout.EAST, contentPane);
		contentPane.add(label);
	}
}
