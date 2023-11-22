import java.util.Scanner;

public class StringMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		{
			System.out.println("Enter your password :");
			String password = scanner.nextLine();

			String trim = "     hi     ";

			// Equals method
			boolean result = password.equals("deathnote0A");

			if (result) {
				System.out.println("Welcome!!");

				// length method
				System.out.println(password.length());
				// char at method
				System.out.println("charAt method :" + password.charAt(10));
				// indexOf
				System.out.println("indexOf method :" + password.indexOf("n"));
				// trim method
				System.out.println("trim method :" + trim.trim());

				System.out.println("What is the current president's last name??");

				String lastname = scanner.next();
				// toUppercase
				System.out.println("toUppercase method :" + lastname.toUpperCase());
				// toLowercase
				System.out.println("toLowercase method :" + lastname.toLowerCase());
				// replace method
				System.out.println("Replace method :" + lastname.replace('b', 'c'));

				// equalsIgnoreCase method
				boolean president = lastname.equalsIgnoreCase("Biden");

				System.out.println(president);

			} else {
				System.out.println("Wrong password!!");
				// isEmpty method
				boolean empty = password.isEmpty();
				System.out.println("isEmpty method : " + empty);
			}

		}
		//substring
	}

}
