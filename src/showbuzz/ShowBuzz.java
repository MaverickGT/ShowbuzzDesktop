/*
License Belongs To Developers...

 */

package showbuzz;

import javax.swing.JFrame;

import View.Login;


public class ShowBuzz extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Login login = new Login();
	
	
	
    public static void main(String[] args) {
    	
     getLogin();
     
            
    }
    
    public static Login getLogin(){
    	return login;
    }
    
}
