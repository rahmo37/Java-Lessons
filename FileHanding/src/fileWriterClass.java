import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class fileWriterClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileWriter writer = new FileWriter("GroceryList.txt");
			

			writer.write("Rice \nTomato \nEgg");
			writer.append("\nGrocery list");
			writer.close();
		} catch (IOException e) {
			System.out.println("An error occored!");
		}

	}

}
