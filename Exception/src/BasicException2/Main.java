package BasicException2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("Enter a whole number");
			int x = scanner.nextInt();
			System.out.println("Enter a number to devide with");
			int y = scanner.nextInt();
			// side info,
			// if you cast x to double,
			// x is converted to double then it got divided by the y's value.
			double z = x / y;
			System.out.println(z);
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide by Zero :(");
		} catch (InputMismatchException e) {
			System.out.println("input is not a number :(");
		} catch (Exception e) {
			System.out.println("Something went wrong");
		} finally {
			scanner.close();
			System.out.println("Scanner is closing...");
		}
	}

}
