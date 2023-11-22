import java.util.Scanner;

public class first100thPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime;
		long endTime;
		long elapsedTime;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your number :");
		int x = scanner.nextInt();
		int j = 0;
		int sum = 5;
		int count = 0;

		startTime = System.nanoTime();
		for (int i = 4; i < Integer.MAX_VALUE; i++) {
			for (j = 2; j < i; j++) {
				if (i % j == 0) {
					break;
				}

			}
			if (j == i) {
				count++;
				//System.out.println(i);
				sum = sum + i;
				if (count + 2 == x) {
					break;
				}
			}

		}
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;

		System.out.println("Elapsed Time: " + elapsedTime);
	}
}
