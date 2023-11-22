import java.util.Scanner;

public class WhileLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		{
			boolean val = true;

			while (val) {
				System.out.println("Hello");
				val = sc.nextBoolean();
			}

		}

		{
			String name = "";

			do {
				System.out.println("What is your full name??");
				sc.nextLine();
				name = sc.nextLine();
			}while (name.isBlank());
			
			System.out.println("Hello : " + name);
		}
		
		{
			int x = 99;
			
			do {
				System.out.println("\nHello " + x);
				x += 5 ;
			}while(x <15);
		}
	}

}
