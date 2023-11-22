package Sort;

import java.util.ArrayList;
import java.util.Random;

public class mergeSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = 0;
		long endTime = 0;
		long elapsedTime = 0;

		Random random = new Random();
		int[] numbers = new int[10];
		int[] redundent = new int[20];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(200);
		}

		System.out.print("Unsorted: ");
		printArray(numbers);
		System.out.println();

		startTime = System.nanoTime();
		mergeSort(numbers);
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

		// System.out.println(redundent);
	}

	public static void mergeSort(int[] numbers) {
		// Find index of smallest remaining element
		int inputLength = numbers.length;

		if (inputLength < 2) {
			return;
		}

		int midIndex = inputLength / 2;
		int[] leftHalf = new int[midIndex];
		int[] rightHalf = new int[inputLength - midIndex];

		for (int i = 0; i < midIndex; i++) {
			leftHalf[i] = numbers[i];
		}
		for (int i = midIndex; i < numbers.length; i++) {
			rightHalf[i - midIndex] = numbers[i];
		}

		mergeSort(leftHalf);
		mergeSort(rightHalf);
		merge(numbers, leftHalf, rightHalf);

	}

	private static void merge(int[] numbers, int[] leftHalf, int[] rightHalf) {
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;

		int i = 0, j = 0, k = 0;

		while (i < leftSize && j < rightSize) {
			if (leftHalf[i] <= rightHalf[j]) {
				numbers[k] = leftHalf[i];
				i++;
			} else {
				numbers[k] = rightHalf[j];
				j++;
			}
			k++;
		}
		while (i < leftSize) {
			numbers[k] = leftHalf[i];
			i++;
			k++;
		}
		while (j < rightSize) {
			numbers[k] = rightHalf[j];
			j++;
			k++;
		}

	}

	public static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}

}
