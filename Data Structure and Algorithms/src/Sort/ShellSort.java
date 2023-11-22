package Sort;

import java.util.ArrayList;
import java.util.Random;

public class ShellSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = 0;
		long endTime = 0;
		long elapsedTime = 0;

		Random random = new Random();
		int[] numbers = new int[9000];
		int[] redundent = new int[20];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(50);
		}

		System.out.print("Unsorted: ");
		printArray(numbers);
		System.out.println();

		startTime = System.nanoTime();
		shellSort(numbers);
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

	public static void shellSort(int[] numbers) {
		// Find index of smallest remaining element
		for (int gap = numbers.length / 2; gap >= 1; gap /= 2) {
			for (int i = gap; i < numbers.length; i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					if (numbers[j + gap] > numbers[j]) {
						break;
					} else {
						int temp = numbers[j];
						numbers[j] = numbers[j + gap];
						numbers[j + gap] = temp;
					}
				}
			}
		}
	}

	public static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}

}
