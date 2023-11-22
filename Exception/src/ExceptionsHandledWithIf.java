
import java.util.Scanner;

/**
 * Validating that both inputs are integers and the denominator is not zero an
 * using if statements.
 * 
 * @author Prof. Carl B. Struck
 * @version Copyright (c) 2002 -- SCCC West
 */
public class ExceptionsHandledWithIf {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter first input :");
		String numberString1 = scanner.next();
		System.out.println("Enter second input :");
		String numberString2 = scanner.next();

		System.out.println(isInteger(numberString1) + " " + isInteger(numberString2));

		if (isInteger(numberString1) && isInteger(numberString2)) {
			int x = Integer.parseInt(numberString1);
			int y = Integer.parseInt(numberString2);
			if (y == 2) {
				System.out.println("Connot divide by zero");
			}

			else {
				int z = quotient(x, y);
				System.out.println(z);
			}
		} else {
			if (!isInteger(numberString1)) {
				System.out.println("Input for 1st value must be a number");
			} else {
				System.out.println("Input for 2nd value must be a number ");
			}
		}

	}

	public static boolean isInteger(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static int quotient(int n1, int n2) {
		return n1 / n2;
	}

}
