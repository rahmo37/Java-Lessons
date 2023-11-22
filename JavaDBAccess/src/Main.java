import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contacts cn1 = new Contacts("Obaedur Rahman", "arnobahemd12345@gamail.com", "6319653230");
		Contacts cn2 = new Contacts("Zarin Rafa", "ZarinRafa12345@gamail.com", "123456789");
		Contacts cn3 = new Contacts("Mesbah Uddin", "MesbahUddin12345@gamail.com", "789456123");
		Contacts cn4 = new Contacts("Umme Roushan", "UmmeRoushan12345@gamail.com", "456789123");
		Contacts cn5 = new Contacts("Nadia Shawlin", "NadiaShawlin@gamail.com", "123456654");

		ArrayList<Contacts> contactList = new ArrayList<>(Arrays.asList(cn1, cn2, cn3, cn4, cn5));

		wrtiteToDB(contactList);
	}

	public static void wrtiteToDB(ArrayList<Contacts> contactList) {
		String databaseUrl = "jdbc:ucanaccess://C:/Users/idiot/eclipse-workspace/JavaDBAccess/MyContact.accdb";
		String sql = "";
		try {
			Connection connection = DriverManager.getConnection(databaseUrl);
			System.out.println("Database Connected...");
			Statement statement = connection.createStatement();
			int rows = 0;

			for (int i = 0; i < 5; i++) {
				sql = "INSERT INTO Contacts (Full_Name, Email, Phone) VALUES ('" + contactList.get(i).fullName + "','"
						+ contactList.get(i).email + "','" + contactList.get(i).phoneNumber + "')";
				rows = statement.executeUpdate(sql);
			}

			if (rows > 0) {
				System.out.println(rows + " rows updated");
			}

			statement.close();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

	}

}
