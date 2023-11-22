import java.util.Random;
import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class PasswordGenerator {

	public static void main(String[] args) throws Exception {
		int passLength = 0;
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (!(passLength > 0)) {
			System.out.println("Enter password length :");
			passLength = sc.nextInt();

			if (passLength > 30) {
				System.out.println("Password must be less than or equal to 30 charectesrs");
				passLength = 0;
			}
		}
		
		for (int i = 0; i < passLength; i++){
			
			DataOutputStream outFile = new DataOutputStream( new FileOutputStream("App_Data/product.data") );
			
			Random random = new Random();
			char x = (char) (random.nextInt(26) + '!');
			
			outFile.writeChar(x);
			System.out.print(x);
		}
		
	}

}
