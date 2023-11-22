import java.util.*;

public class forName {

	Scanner sc = new Scanner(System.in);
	static String familyName = "Rahman";
	String givenName = "";

	// Static block is only called by the forName() method
	static {
		System.out.println("Family name is " + familyName);
	}

	// .newInstance() method calls the instance block and the constructor

	// Instance
	{
		System.out.println("Hi");
	}

	// Constructor
	forName() {
		givenName = "";
		System.out.println("full name is: " + givenName + " " + familyName);
	}

	String print() {
		System.out.println("Enter your given name: ");
		return sc.next();
	}

}
