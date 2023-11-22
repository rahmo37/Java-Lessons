
public class Factorial {

	public static void main(String[] args) {
		/*
		 * Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120. Write a java program to find
		 * Factorial of a given number using Recursion as well as Iteration.
		 *
		 */
		int number = result(60);
		System.out.println(number);

	}

	public static int result(int n) {
		if(n == 0) {
			return 1;
		}
		return n * result(n - 1);
	}
}
