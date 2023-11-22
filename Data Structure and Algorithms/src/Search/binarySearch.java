package Search;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class binarySearch {
	public static void main(String[] args) {

		int array[] = new int[1000];
		int index = 0;
		Random rn = new Random();
		Scanner sc = new Scanner(System.in);
		int target = 0;

		for (int i = 0; i < array.length; i++) {
			array[i] = i + rn.nextInt(100);
		}
		Arrays.sort(array);

		System.out.println("Enter your number: ");
		target = sc.nextInt();

		//binarySearchBuiltIn(array, target);
		
		
		index  = binarySearchCustomMade(array, target);
		if (index == -1) {
			System.out.println("Element not found!");
		} else {
			System.out.println("Element found at index: " + index);
		}
	}

	public static void binarySearchBuiltIn(int[] array, int target) {
		int index = Arrays.binarySearch(array, target);

		if (index < 0) {
			System.out.println("Element not found!");
		} else {
			System.out.println("Element found at index: " + index);
		}

	}

	public static int binarySearchCustomMade(int array[], int target) {
		int low = 0;
		int high = array.length - 1;
		int middle = 0;
		int value = 0;

		while (low <= high) {

			middle = low + (high - low) / 2;
			value = array[middle];

			System.out.println("middle is: " + value);

			if (value < target)
				low = middle + 1;
			else if (value > target)
				high = middle - 1;
			else
				return middle;

		}
		return -1;
	}

}
