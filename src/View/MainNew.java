package View;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.JTextField;
import javax.swing.JTree;
import org.apache.commons.net.ftp.FTPClient;

import Controller.LoginController;
import media.MediaPlayerVLC;

import javax.swing.JButton;

import java.awt.Component;

public class MainNew extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane Banner;
	private JTextField textField;
	private Preferences prefs;
	MediaPlayerVLC player;
	Login login;
	Browser browser;
	AboutShowBuzz about;
	MediaPlayerVLC mediaPlayer;
	String selection;
	java.awt.Image img;

	public MainNew(final String username) {
		LoginController log = new LoginController();
		User user = new User();
		user =  log.getInfo(username);
		setLocationRelativeTo(null);
		setResizable(false);
		UIManager.put("Tree.rendererFillBackground", false);
		setForeground(Color.WHITE);
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources/MainImg/logo.png"));
		img = Toolkit.getDefaultToolkit().createImage(
				"resources/mainBackground.jpg");
		setTitle("ShowBuzz Client V1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 570);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		menuBar.setBackground(Color.GRAY);
		setJMenuBar(menuBar);
		browser = new Browser("http://polisciuk.com/ShowBuzz/News/weeklyNews.html");
		JMenu mnFileMenu = new JMenu("File");
		mnFileMenu.setIcon(new ImageIcon(MainNew.class.getResource("/MainImg/logo.png")));
		menuBar.add(mnFileMenu);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		
		mntmLogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prefs = Preferences.userNodeForPackage(this.getClass());
				if(prefs.get("UID", "none")!="none"&&prefs.get("PSW", "none")!="none"){
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
				login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		mnFileMenu.add(mntmLogOut);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(1);
			}
		});
		
		mnFileMenu.add(mntmNewMenuItem);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setIcon(new ImageIcon(MainNew.class.getResource("/MainImg/edit.png")));
		menuBar.add(mnEdit);
		
		JMenuItem mntmAccDetails = new JMenuItem("Change Account Details");
		mntmAccDetails.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("bent");
				AccountDetails acc = new AccountDetails(username);
				acc.setVisible(true);
				}
		});
		mnEdit.add(mntmAccDetails);
		
		
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setIcon(new ImageIcon(MainNew.class.getResource("/MainImg/help.png")));
		menuBar.add(mnHelp);
		
		JMenuItem mntmAboutShowbuzz = new JMenuItem("About ShowBuzz");
		mntmAboutShowbuzz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				about = new AboutShowBuzz();
				about.setVisible(true);
				
			}
		});
		mnHelp.add(mntmAboutShowbuzz);
		
		JLabel ProfileImage = new JLabel(user.getFirstName() + " " + user.getLastName());
//		ProfileImage.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				
//			}
//		});
		
		bannerAndProfileImage(menuBar, ProfileImage);
       
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		ImagePanel panel = new ImagePanel(img);
		panel.setLayout(null);
		contentPane.add(panel);
		JLabel lblSearch = new JLabel("Search: ");
		lblSearch.setBounds(5, 11, 56, 14);
		panel.add(lblSearch);
		textField = new JTextField();
		textField.setBounds(52, 8, 132, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(browser);
		scrollPane.setBounds(188, 0, 724, 457);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(new Color(0,0,0,128));
		panel_1.setBounds(10, 386, 168, 70);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		final JButton btnNewButton = new JButton("");
		btnNewButton.setOpaque(false);
		btnNewButton.setBackground(new Color(0,0,0,128));
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(19, 9, 135, 28);
		
		panel_1.add(btnNewButton);
		
		playButton(btnNewButton);

		ftpConnection(panel);
		  
	}

	private void bannerAndProfileImage(JMenuBar menuBar, JLabel ProfileImage) {
		///////////////////////////////// Resize image format to Main window friendly
		
        try {
        	BufferedImage img;
			img = ImageIO.read(new URL("http://s18.postimg.org/docpgwjt5/Show_Buzz_Banner.jpg"));
			 ImageIcon ii = new ImageIcon(img);
			 
			 java.awt.Image img1 = ii.getImage();
			 
			 java.awt.Image newimg = img1.getScaledInstance(470, 64,  java.awt.Image.SCALE_SMOOTH);  
			 ImageIcon newIcon = new ImageIcon(newimg);  
			 
			 Banner = new javax.swing.JScrollPane(new JLabel(newIcon));
			 Banner.setPreferredSize(new Dimension(470,64));
			
			 menuBar.add(Banner);
			 
			 
			 
			 
			 //BufferedImage imge;
				//imge = ImageIO.read(new URL("http://www.polisciuk.com/ShowBuzz/ProfilePicture/ProfileImage.jpg"));
				// ImageIcon iii = new ImageIcon(imge);
				 
				 //.awt.Image imgi1 = iii.getImage();
				// ImageIcon newIcone = new ImageIcon(imgi1);  
			 
			 
			 	//ProfileImage.setIcon(newIcone);
				//ProfileImage.setHorizontalAlignment(SwingConstants.RIGHT);
				
				menuBar.add(ProfileImage);
			 
			 
			 
			 
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "serial" })
	private void ftpConnection(ImagePanel panel) {
		// get an ftpClient object  
		  FTPClient ftpClient = new FTPClient();  
		  try {  
		   // pass directory path on server to connect  
		   ftpClient.connect("ftp.polisciuk.com");
		   // pass username and password, returned true if authentication is  
		   // successful  
		   boolean login = ftpClient.login("polisciukcom", "Klaipeda_88");  
		  //change working directory
		   ftpClient.enterLocalPassiveMode();
		   ftpClient.changeWorkingDirectory("/ShowBuzz/resume/");
		   if (login) {  
		    System.out.println("Connection established...");  
		    System.out.println("Status: "+ftpClient.getStatus());  
		    String[] files = ftpClient.listNames();
		             
		        @SuppressWarnings("rawtypes")
				Hashtable hash = new Hashtable();
		             
		        for(int i = 0; i < files.length; i++) 
		        {
		            hash.put("Trailers",files);
		            System.out.println(files[i].substring(0, files[i].indexOf(".")));
		        }       
		        final JTree tree = new JTree(hash);
		        
		        tree.setCellRenderer(new DefaultTreeCellRenderer(){
		            public Component getTreeCellRendererComponent(JTree tree,Object value,
		                boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){
		              JLabel node = (JLabel)super.getTreeCellRendererComponent(tree,value,sel,expanded,leaf,row,hasFocus);
		              node.setForeground(Color.white);
		              return node;
		            }
		          });
		        //expand tree automatically without user interfering
		        for(int i=0;i<tree.getRowCount();i++)  
		        {  
		            tree.expandRow(i);  
		        }
		        ftpClient.disconnect();
		        
		   
		        
		      /////////////////////////////////////////////  ///// End FTP
		        
		        
		tree.setBounds(0, 52, 187, 300);
		tree.setOpaque(false);
		
		tree.setBackground(new Color(0,0,0,128));
		panel.add(tree);
		
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				    final DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                           tree.getLastSelectedPathComponent();
				   if(node != null && node.isLeaf()){
					   browser.showPage("http://www.polisciuk.com/ShowBuzz/resume/"+node);
					   selection = node.toString().substring(0,node.toString().indexOf("."));
				   }
				   		
			}
		});
		
	
		
		
	}

}catch(IOException e){
	  
	  }
	}

	private void playButton(final JButton btnNewButton) {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mediaPlayer = null;
				String str = null;
				try{
					if(!selection.equals(null)){
					String nodeString = selection;
						str = nodeString + ".mp4";
						mediaPlayer = new MediaPlayerVLC("http://www.polisciuk.com/trailers/"+ str,str);
						selection = null;
					}
				}
				catch (Exception e){
					JOptionPane.showMessageDialog(null, "You must select a movie before starting the media player", "ShowBuzz",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
}
