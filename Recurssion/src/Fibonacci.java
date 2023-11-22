
public class Fibonacci {
	public static void main(String[] args) {
		int first = 0;
		int next = first + 1;
		for (int i = 0; i < 60; i++) {

			System.out.println(first);

			int sum = first + next;
			first = next;
			next = sum;
		}

	}
}
