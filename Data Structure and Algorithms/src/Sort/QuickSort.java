package Sort;

import java.util.ArrayList;
import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = 0;
		long endTime = 0;
		long elapsedTime = 0;

		Random random = new Random();
		int[] numbers = new int[10];
		int[] redundent = new int[20];

		int[] numbers1 = { 8, 18, 37, 11, 44, 36, 42, 35, 3, 34 };

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(50);
		}

		System.out.print("Unsorted: ");
		printArray(numbers1);
		System.out.println();

		startTime = System.nanoTime();
		quickSort(numbers1, 0, numbers1.length - 1);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;

		System.out.print("Sorted: ");
		printArray(numbers1);
		System.out.println();

		counter(numbers1);

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

		// System.out.println(redundent);
	}

	public static void quickSort(int[] numbers, int lowBound, int highBound) {
		// Find index of smallest remaining element
		if (lowBound >= highBound) {
			return;
		}

		int pivot = numbers[highBound];

		int start = lowBound;
		int end = highBound;

		while (start < end) {
			while (numbers[start] <= pivot && start < end) {
				start++;
			}

			while (numbers[end] >= pivot && start < end) {
				System.out.println(numbers[end]);
				end--;
			}

			swap(numbers, start, end);

		}
		swap(numbers, start, highBound);

		quickSort(numbers, lowBound, start - 1);
		quickSort(numbers, start + 1, highBound);
	}

	private static void swap(int[] numbers, int index1, int index2) {
		int temp = numbers[index1];
		numbers[index1] = numbers[index2];
		numbers[index2] = temp;
	}

	public static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}

}
