import java.util.Scanner;

public class Swapping {
	public static void main(String[] args) {
		int x = 10;
		
		int[] array = new int[x];

		for(int i = 0; i < x; i++) {
			array[i] = i + 1;
			//System.out.println(array[i]);
		}

		System.out.println(add(array));
	}

	public static int add(int array[]) {
		int total = 0;
		
		for (int i = 0; i < array.length; i++) {
			total += array[i];
			System.out.println("Hi");
		}
		return total;
	}

}
