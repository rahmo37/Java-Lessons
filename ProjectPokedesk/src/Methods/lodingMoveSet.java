package Methods;

import java.sql.*;
import java.util.Hashtable;
import java.util.Scanner;

public class lodingMoveSet {
	static Hashtable<String, Integer> hashT = new Hashtable<>();
	static Connection connection;
	static Scanner scanner;

	public static void main(String[] args) {
		connection("MoveSet.accdb");
		writeDatabase();
	}

	public static void connection(String DbName) {
		String urlMoveSet = "jdbc:ucanaccess://" + DbName;
		try {
			connection = DriverManager.getConnection(urlMoveSet);
			System.out.println("DataBase Connected...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void writeDatabase() {
		try {
			scanner = new Scanner(System.in);
			String querry = "INSERT INTO MoveSet (Pokemon ,Move1, Move2, Move3, Move4, Move5, Move6, Move7, Move8, Move9, Move10, Move11, Move12, Move13, Move14, Move15, Move16, Move17, Move18, Move19, Move20, Move21, Move22, Move23, Move24, Move25)"
					+ "VALUES (? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(querry);
			int rows = 0;

			int i;
			String response = "y";
			while (!response.equals("n")) {
				System.out.println("Enter move set: ");
				String move;
				for (i = 1; i < 27; i++) {
					move = scanner.nextLine();
					if(move.isEmpty()) {
						preparedStatement.setString(i, "N/A");
					}
					else {
					preparedStatement.setString(i, move);
					}
				}
				rows += preparedStatement.executeUpdate();

				if (rows > 0) {
					System.out.println(rows + "rows has been updated..");
				}

				System.out.println("Have Another move set?");
				response = scanner.nextLine();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
