package database;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		getConnection();

	}

	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/sql_hr";
			String username = "root";
			String password = "deathnote0A#";
			String query = "SELECT * FROM sql_hr.employees";
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				System.out.println(rs.getInt("employee_id") + " " + rs.getString("first_name") + " "
						+ rs.getString("last_name") + " " + rs.getString("job_title") + " " + rs.getInt("salary") + " "
						+ rs.getInt("reports_to") + " " + rs.getInt("office_id"));
			}
			st.close();

			return con;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

}
