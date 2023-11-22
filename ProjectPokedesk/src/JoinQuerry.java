import java.sql.*;

public class JoinQuerry{

	static Connection connection;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		connect();
		read();
	}

	public static void connect() {
		String url = "jdbc:ucanaccess://MoveList.accdb";

		try {
			connection = DriverManager.getConnection(url);
			System.out.println("Connected...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void read() {
		try {
			String querry = "SELECT MoveList.Move_Id, MoveList.Move_Name, Test.Pokemon, Test.Level FROM MoveList INNER JOIN Test ON MoveList.Move_Id = Test.ID";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(querry);

			while (rs.next()) {
				System.out.println(rs.getInt("Move_Id") + " " + rs.getString("Move_Name") + " "
						+ rs.getString("Pokemon") + " " + rs.getString("Level"));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
