import java.util.Scanner;

public class moreString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first word :");
		String word1 = sc.next();
		System.out.println("Enter second word :");
		String word2 = sc.next();
		
		int a = 0;
		int b = 0;
		
		for (int i = 0; i < word1.length(); i++) {
			
			char c1 = word1.charAt(i);
			int x = word1.indexOf(c1);
			int y = word2.indexOf(c1);
			
			a = a + x;
			b = b + y;
		}

		if (a == b && word1.length() == word2.length()) {
			System.out.println("Matched!!!");
		}
		else {
			System.out.println("No match!!");
		}
		
	}
}
		
		//Equal and Equal ignore case
		
		/*System.out.println("Enter your name : ");
		String a = sc.nextLine();
		
		System.out.print(a);
		
		if (a.equalsIgnoreCase("rakib")) {
			System.out.println("its same word");
		}
		else {
			System.out.println("different name");
		}
		
		System.out.println("type a word or sentence");
		Character a = sc.nextLine().charAt(5);
		System.out.println("type a word or sentence");
		Character b = sc.nextLine().charAt(5);
		
		/*if (a.length() == b.length()) {
			System.out.println("match");
		}
		else
		{
			System.out.println("no match");
		}
		
		
		String x = "" + a;
		String y = "" + b;
		
		if (x.equalsIgnoreCase(y)) {
			System.out.println("match");
		}
		else {
			System.out.println("no match");
		}
		*/
		/*
		String line = sc.nextLine();
		
		int count = 0;
		
		for (int i = 1; i < line.length(); i++) {
			if (line.charAt(i) == ' ') {
				count = i+1;
			}
		}
		System.out.println(line.substring(count));
		*/



