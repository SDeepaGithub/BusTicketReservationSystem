package busReservationSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	static String url ="jdbc:mysql://localhost:3306/busreservation";
	static String username = "root";
	static String password = "rootuser";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
	
}
