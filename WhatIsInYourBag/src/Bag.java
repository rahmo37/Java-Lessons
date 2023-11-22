import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Bag {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("What is in your bag");
		String item = sc.next();

		FileWriter writer = new FileWriter("ItemList.txt");

		while (!item.equals("done")) {

			writer.write(item + "\n");

			System.out.println("and?");
			item = sc.next();
			sc.nextLine();

		}
		writer.close();
		System.out.println("Write to file successful");

	}

}
