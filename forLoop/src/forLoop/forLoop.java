package forLoop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class forLoop {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DataOutputStream outFile = new DataOutputStream(new FileOutputStream("App_Data/Pokemon.data"));
		DataInputStream readFile = new DataInputStream(new FileInputStream("App_Data/Pokemon.data"));
		Scanner sc = new Scanner(System.in);
		int x = 5;
		String[] pokemon = new String[x];
		
		//Since x = 5, all the for loop will iterate 5 times.
		
		
		for (int i = 0; i < x; i++) {
			//This for loop is adding string values to the array (pokemon)
			System.out.println("\nEnter your favorite pokemon?");
			pokemon[i] = sc.nextLine();
		}
		
		for (int j = 0; j < x; j++) {
			//Taking elements from the array and writing it to the outFile object(Pokemon file).
			outFile.writeUTF(pokemon[j]);

		}
		outFile.close();
		
		for (int k = 0; k < x; k++) {
			//Reading from the (Pokemon file)
			System.out.print(readFile.readUTF());
			System.out.print(" ");
		}

	}

}
