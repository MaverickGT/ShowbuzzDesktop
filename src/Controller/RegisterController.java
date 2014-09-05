package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import sun.misc.BASE64Encoder;

import Database.Connector;

import com.mysql.jdbc.PreparedStatement;

public class RegisterController {
	private Connection conn = Connector.getInstance();
	
	Date myDate;
	String newPass;
	
	public boolean register(String fName, String lName, String user, String pass, String email, String birth) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date date = formatter.parse(birth);
			myDate = new java.sql.Date(date.getTime());
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		try {
			String sql = "INSERT INTO Users(FirstName, LastName, Username, Email, Password, BirthDate)"
					+ "VALUES(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setString(1, fName);
			preparedStatement.setString(2, lName);
			preparedStatement.setString(3, user);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, getEncodedPass(pass));
			preparedStatement.setDate(6, myDate);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
			
		}
	}
	
	public static String getEncodedPass(String pass){
		BASE64Encoder encoder = new BASE64Encoder();
		String newPass = encoder.encodeBuffer(pass.getBytes());
		return newPass;
	}

}
