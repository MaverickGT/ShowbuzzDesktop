package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sun.misc.BASE64Encoder;
import Database.Connector;

public class ForgotPassController {

	
	Connection connect = Connector.getInstance();
	
	public boolean changePass(String username, String email, String pass) {
		String user = null;
		BASE64Encoder encoder = new BASE64Encoder();
		String newPass = encoder.encodeBuffer(pass.getBytes());
		try {
			Statement st = connect.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT Username FROM showbuzz.users WHERE Username = '" + username + "' AND Email = '" + email + "'");
			while (rs.next()) {
				user = rs.getString(1);
				
				}
			try {
				if(user.equals(username)){
					Statement st2 = connect.createStatement();
					 st2.execute("UPDATE showbuzz.users SET Password = '" + newPass + "' WHERE Username = '"
									+ username + "' AND Email = '" + email + "'");
							
				}else{
					return false;
				}
			} catch (Exception e) {
				return false;
			}
			
		} catch (SQLException e) {
			return false;
		}
		return true;

	}

	
}
