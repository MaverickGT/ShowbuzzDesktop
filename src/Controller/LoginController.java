package Controller;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import View.User;
import sun.misc.BASE64Decoder;
import Database.Connector;

public class LoginController {
	private Connection conn = Connector.getInstance();
	String decodedPass;
	String dbPass;
	public User user;

	public boolean checkLogin(String username, String password) throws IOException{
		 BASE64Decoder decoder = new BASE64Decoder();
		 try{
	      byte[] decodedBytes = decoder.decodeBuffer(checkPassword(username));
	      decodedPass = new String(decodedBytes);
		 } catch(Exception e){
			 return false;
		 }
	           
		if (password.equals(decodedPass)) {
			return true;
		} else {
			return false;
		}
	}

	public User getInfo(String username){
		user = new User();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT Username, Email, FirstName, LastName, Birthdate FROM showbuzz.users WHERE Username = '"
							+ username + "'");
			while (rs.next()) {
				
				user.setUsername(rs.getString(1));
				user.setEmail(rs.getString(2));
				user.setFirstName(rs.getString(3));
				user.setLastName(rs.getString(4));
				user.setBirthDate(rs.getDate(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	} 
	
	
	private String checkPassword(String username) {
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT Password FROM showbuzz.users WHERE Username = '"
							+ username + "'");
			while (rs.next()) {
				dbPass = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dbPass;

	}

}
