import java.util.Scanner;

public class Modulo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number for key");
		int key = sc.nextInt();
		System.out.println("Enter number of bucket");
		int bucket = sc.nextInt();
		
		System.out.println(key % bucket);


	}

}
