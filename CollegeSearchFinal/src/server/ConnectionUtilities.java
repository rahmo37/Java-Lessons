package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// This is just for opening or closing connections to our database, I used SQLite as was required by the teacher.
public class ConnectionUtilities {
	public static Connection getConnection(String databaseName) {
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection("jdbc:sqlite:" + databaseName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
