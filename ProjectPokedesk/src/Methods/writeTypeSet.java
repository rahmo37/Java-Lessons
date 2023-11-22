package Methods;

import java.sql.*;

public class writeTypeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lodingMoveSet.connection("TypeList.accdb");
//		readAndWriteToDb();
		writeToDb();
	}

	public static void writeToDb() {
		try {
			int rows = 0;
			int type1 = 0;
			int type2 = 0;
			String querryW = "INSERT INTO TypeSetNumber (Id, Type1, Type2) VALUES (? ,? ,?)";
			PreparedStatement pst3;
			pst3 = lodingMoveSet.connection.prepareStatement(querryW);

			for (int i = 1; i < 664; i++) {
				type1 = readFromToDb(i, 1);
				type2 = readFromToDb(i, 2);
				pst3.setInt(1, i);
				pst3.setInt(2, type1);
				pst3.setInt(3, type2);

				rows += pst3.executeUpdate();
			}

			if (rows > 0) {
				System.out.println(rows + " rows updated..!");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static int readFromToDb(int i, int x) {
		try {
			int rows = 0;
			String querryR1 = "SELECT TypeSetString.[Type I], TypeSetString.[Type II] FROM TypeSetString WHERE TypeSetString.ID=?";
			String querryR2 = "SELECT AllTypes.Id FROM AllTypes WHERE AllTypes.Type=?";
			
			
			PreparedStatement pst1 = lodingMoveSet.connection.prepareStatement(querryR1);
			PreparedStatement pst2 = lodingMoveSet.connection.prepareStatement(querryR2);
			pst1.setString(1, Integer.toString(i));
			ResultSet rs1 = pst1.executeQuery(); // Type I , Type II
			ResultSet rs2 = null;

			rs1.next();
			pst2.setString(1, rs1.getString(x));
			rs2 = pst2.executeQuery();
			rs2.next();
			return rs2.getInt("Id");

		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}

}
