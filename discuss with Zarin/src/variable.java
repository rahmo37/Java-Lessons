import java.util.Scanner;

public class variable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//Equal and Equal ignore case
		
		/*System.out.println("Enter your name : ");
		String a = sc.nextLine();
		
		System.out.print(a);
		
		if (a.equalsIgnoreCase("rakib")) {
			System.out.println("its same word");
		}
		else {
			System.out.println("different name");
		}*/
		
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
		*/
		
		String x = "" + a;
		String y = "" + b;
		
		if (x.equalsIgnoreCase(y)) {
			System.out.println("match");
		}
		else {
			System.out.println("no match");
		}
		
	}

}
