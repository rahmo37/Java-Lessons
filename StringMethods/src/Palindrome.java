import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		String rvrs = "";
		
		int strLength = str.length();
		
		for (int i = (strLength - 1); i >= 0; --i ) {
			
			rvrs = rvrs + str.charAt(i);
		}
		
		if (str.equalsIgnoreCase(rvrs)) {
			System.out.println( str + " is a Palindrome String");
		}
		else {
			System.out.println(str + " in not a Palindrome String");
		}
		
	}

}
