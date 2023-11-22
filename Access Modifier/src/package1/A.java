package package1;

import package2.C;


//public = anywhere 
//protected = anywhere within the package and in a subclass that is in a different package
//default = anywhere within the same package
//private = only inside the class

public class A {
	
	String defaultMessage = "I am default";
	protected String protectedMessage = "I am protected";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//not able to print the defaultVaiable that is in a class in a different package
		C c = new C();
		System.out.println(c.defaultMessage);
	}

}
