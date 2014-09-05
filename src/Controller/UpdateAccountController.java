package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Database.Connector;

public class UpdateAccountController {

	
	Connection connect = Connector.getInstance();
	
	public boolean changeDetails(String username, String email, String firstName, String lastName){
		Statement st2;
		try {
			st2 = connect.createStatement();
		
		st2.execute("UPDATE showbuzz.users SET Email = '" + email + "', FirstName = '" + firstName + "', LastName = + '" + lastName + "' WHERE Username = '"+ username + "'");
		} catch (SQLException e) {
			return false;
			}
		return true;
	}
	
	
}
