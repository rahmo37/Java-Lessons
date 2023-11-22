import java.util.Scanner;

public class ExceptionWithExit {
	public static void main(String args[]) {
		int num1 = intInput("Enter numerator...");
		int num2 = intInput("Enter denomenator...");

		double result = quotient(num1, num2);

		System.out.printf("the result is : %.2f",result);
	}

	public static int intInput(String prompt) {
		System.out.println(prompt);
		Scanner scanner = new Scanner(System.in);

		String input = scanner.next();
		if (!isInteger(input)) {
			System.out.println("Input is not an integer");
			System.exit(1);
		}

		return Integer.parseInt(input);
	}

	public static boolean isInteger(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static double quotient(int numerator, int denomenator) {
		if (denomenator == 0) {
			System.out.println("Cannot divide by zero");
			System.exit(2);
		}

		return (double) numerator / denomenator;
	}
}
