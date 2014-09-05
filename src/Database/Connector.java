package Database;

import java.sql.*;
public class Connector {
    private static Connection instance = null;
   
    public static synchronized Connection getInstance() {
        if (instance == null) {
        	
            try {
				instance = DriverManager.getConnection(
				        "jdbc:mysql://localhost/showbuzz", "root", "Passw0rd");
			} catch (SQLException e) {
				e.printStackTrace();
			};
        }
        return instance;
    }
}