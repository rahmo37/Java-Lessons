package Methods;

import java.util.Scanner;

public class testScanner {
	public static void main(String args[]) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String st = "";
		
		System.out.println("Enter data: ");
		st = sc.nextLine();
		for (int i = 0; i < 4; i++) {
			if (st.isEmpty()) {
				System.out.println("empty");
			}else {
				System.out.print("\n" + st);
			}
			st = sc.nextLine();
			System.out.print(sc.hasNextLine());
		}


	}
}
