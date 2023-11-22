package Sort;

import java.util.ArrayList;
import java.util.Random;

public class InsertionSort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = 0;
		long endTime = 0;
		long elapsedTime = 0;

		Random random = new Random();
		int[] numbers = new int[10];
		int[] redundent = new int[20];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(50);
		}

		System.out.print("Unsorted: ");
		printArray(numbers);
		System.out.println();

		startTime = System.nanoTime();
		insertionSort(numbers);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;

		System.out.print("Sorted: ");
		printArray(numbers);
		System.out.println();

		counter(numbers);

		System.out.println("\nTime Elapsed " + elapsedTime + " NanoSec");
	}

	public static void counter(int[] numbers) {
		ArrayList<Integer> redundent = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {

			if (redundent.contains(numbers[i])) {
				continue;
			}
			
			int counter = 1;
			for (int j = i + 1; j < numbers.length; j++) {

				if (numbers[i] == numbers[j]) {
					counter++;

				}
			}
			redundent.add(numbers[i]);
			System.out.println(numbers[i] + " occered " + counter + " times");
		}

		//System.out.println(redundent);
	}

	public static void insertionSort(int[] numbers) {
		// Find index of smallest remaining element
		for (int i = 1; i < numbers.length; i++) {
			int current = numbers[i];
			int j = i - 1;
			while (j >= 0 && numbers[j] > current) {
				numbers[j + 1] = numbers[j];
				j--;
			}
			numbers[j + 1] = current;
		}

	}

	public static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}

}
