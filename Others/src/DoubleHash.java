import java.util.Scanner;

public class DoubleHash {

	public static void main(String args[]) {
		int key, h1mod, h2mod ,h1, h2, i, hashTableSize, bucket;

		Scanner scanner = new Scanner(System.in);
		
		String respond = "n";
		
		while(!respond.equals("y")) {

		System.out.println("What is the value of the key: ");
		key = scanner.nextInt();
		System.out.println("What is the value of i");
		i = scanner.nextInt();
		System.out.println("What is the value of the h1 modulo: ");
		h1mod = scanner.nextInt();
		System.out.println("What is the value of the h2 modulo: ");
		h2mod = scanner.nextInt();
		System.out.println("What is the Hash Table Size: ");
		hashTableSize = scanner.nextInt();

		h1 = key % h1mod;
		h2 = (h2mod - key % h2mod);

		bucket = (h1 + (i * h2)) % hashTableSize;
		
		System.out.println(bucket);
		
		System.out.println("Did you find the proper index? (y/n)");
		respond = scanner.next();
		
		}
		System.out.println("Great!!");
	}
}
