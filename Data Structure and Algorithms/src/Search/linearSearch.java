package Search;

import java.util.Random;

public class linearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 8, 4, 5, 6, 10, 15, 1, 7, 5 };
		Random rand = new Random();
		int searchFor = rand.nextInt(20);

		int index = linearSearch(arr, searchFor);

		if (index != -1) {
			System.out.println(":) Element " + searchFor + " found at index: " + index);
		} else {
			System.out.println(":( Element " + searchFor + " not found in the array");
		}

	}

	private static int linearSearch(int[] arr, int value) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}

}
