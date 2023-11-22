import java.util.Scanner;
import java.util.HashMap;

public class hashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first word :");
		String word1 = sc.next();
		System.out.println("Enter second word :");
		String word2 = sc.next();
		int a = 0;
		int b = 0;

		HashMap<Character, Integer> anaGram = new HashMap<Character, Integer>();

		for (int i = 0; i < 26; i++) {

			Character c = (char) ('a' + i); // increments the 'a' to 'b'..........'z'

			// adding each index of i to the character c variable
			anaGram.put(c, i);

		}
		// System.out.println(anaGram);

		for (int j = 0; j < word1.length(); j++) {

			/*
			 * returned int values from word(1/2).charAt methods are stored in x an y
			 * variables
			 */
			int x = anaGram.get(word1.charAt(j));

			/*
			 * a = a + x; meaning a = whatever x's value is. since a = 0. the for loop makes
			 * the variable a's value go up. adding the a's current value with the previous
			 * value of a same thing with b
			 */
			a = a + x;

		}
		for (int k = 0; k < word2.length(); k++) {
			int y = anaGram.get(word2.charAt(k));
			b = b + y;
		}

		// prints the value of a and b
		System.out.println(a);
		System.out.println(b);

		// if a and b matches then its an anagram, else its not anagram
		if (a == b) {
			System.out.println("its an anagram!!");
		} else {
			System.out.println("Its not an anagram!!");
		}

	}

}
