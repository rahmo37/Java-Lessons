import java.io.FileReader;
import java.io.IOException;


public class FileReaderClas {
	public static void main(String[] args) throws IOException {
		
		FileReader reader = new FileReader("GroceryList.txt");
		
		int data = reader.read();
		
		while(data != -1) {
			System.out.print((char)data ) ;
			data = reader.read();
		}
		reader.close();
		
	}
}
