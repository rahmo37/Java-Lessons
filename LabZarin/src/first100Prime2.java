import java.util.Scanner;

public class first100Prime2 {
	public static void main(String args[]) {
		long startTime;
		long endTime;
		long elapsedTime;

		System.out.println("Enter the x ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int flag = 0;
		int count = 0;
		int sum = 0;
		
		
		startTime = System.nanoTime();
		for (int x = 2;; x++) {
			for (int i = 2; i < x; i++) {
				if (x % i == 0) {

					flag = 1;
					break;
				}
				flag = 0;
			}
			if (flag == 0) {
				count++;
				// System.out.println(x);
				// System.out.println("Total Prime Number is = " + count);
				sum = sum + x;
			}

			if (count == n) {
				// System.out.println("The Sum is = " + sum);
				// System.out.println("The code is done");
				break;
			}
		}
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;

		System.out.println("Elapsed Time: " + elapsedTime);
	}
}