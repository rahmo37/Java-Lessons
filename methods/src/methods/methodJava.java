package methods;

import java.util.Scanner;

public class methodJava {
	String original = "isn't it?";
	int number = 913;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Define your first parameter");
		String changed1 = sc.nextLine();

		System.out.println("Define your second parameter");
		int changed2 = sc.nextInt();

		int result = addAndReturn(45, 60);
		System.out.println(result);

		pokemon(changed1, changed2);

	}

	// returns the sum of two number
	public static int addAndReturn(int num1, int num2) {
		int sum = num1 + num2;
		System.out.println(sum);
		return sum;
	}

	public static void pokemon(String original, int number) {

		methodJava mj = new methodJava();
		mj.original = original;
		mj.number += number;

		System.out.println(
				"Pokemon game is amazing!! " + mj.original + "\nThere are " + mj.number + " pokemon exisists so far");
	}

}
