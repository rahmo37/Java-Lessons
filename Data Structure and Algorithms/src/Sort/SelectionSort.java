package Sort;

import java.util.Random;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = 0;
		long endTime = 0;
		long elapsedTime = 0;
		
		Random random = new Random();
		int[] numbers = new int[5000];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(50);
		}
		System.out.print("Unsorted: ");
		printArray(numbers);
		System.out.println();
		
		startTime = System.nanoTime();
		selectionSort(numbers);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		
		System.out.print("Sorted: ");
		printArray(numbers);
		
		System.out.println("\nTime Elapsed " + elapsedTime + " NanoSec");
	}

	public static void selectionSort(int[] numbers) {
		// Find index of smallest remaining element

		
		
		for (int i = 0; i < numbers.length - 1; i++) {
			int indexSmallest = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] < numbers[indexSmallest]) {
					indexSmallest = j;
				}
			}
			// Swap numbers[i] and numbers[indexSmallest]
			int temp = numbers[i];
			numbers[i] = numbers[indexSmallest];
			numbers[indexSmallest] = temp;
		}
		
	}

	public static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}

}
