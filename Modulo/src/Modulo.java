import java.util.Scanner;

public class Modulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Optional information
		/*double can be converted to int, but int cannot be 
		converted to double, because int could be used in an array*/
		
		//Optional code//
		{double friend = 10;
		friend = (int) friend / 3;
		System.out.println(friend);}
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number for a");
		int a = sc.nextInt();
		System.out.println("Enter number for b");
		int b = sc.nextInt();

		int modulo = a % b;

		System.out.println(b + " goes " + (a / b) + " time(s) in " + a + ".");

		if (modulo != 0) {
			System.out.println("reaching upto " + ((a / b) * b));
			System.out.println("with a remainder of " + modulo);

		} else {
			System.out.println("No remainder left!!");
		}

	}

}
