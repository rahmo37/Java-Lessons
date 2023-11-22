package ternaryOperator;

public class ternaryOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Finding the minimum of two numbers:
		int a = 10;
		int b = 20;
		int min = a < b ? a : b;
		System.out.println("Minimum: " + min); // Output: Minimum: 10

		// Converting a boolean value to its string representation:
		boolean value = true;
		String stringValue = value ? "true" : "false";
		System.out.println("String representation: " + stringValue); // Output: String representation: true

		// Checking if a number is even or odd:
		int number = 7;
		String evenOrOdd = number % 2 == 0 ? "even" : "odd";
		System.out.println("The number is " + evenOrOdd); // Output: The number is odd

		// Deciding the discount based on the user type:
		String userType = "member";
		double discount = userType.equalsIgnoreCase("member") ? 0.1 : 0.05;
		System.out.println("Discount: " + discount * 100 + "%"); // Output: Discount: 10.0%

		// Displaying the absolute value of a number:
		int x = -5;
		int absValue = x >= 0 ? x : -x;
		System.out.println("Absolute value: " + absValue); // Output: Absolute value: 5
	}

}
