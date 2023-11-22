package package2;

import package1.*;

public class Asub extends A{
	
	private String privateMessage = "I am private";
	
	
	public static void main(String[] args) {
		
		//Able to print a default message in a class that is in same package
		C c = new C();
		System.out.println(c.defaultMessage);
		
		//Able to print the public message in Asub class because the variable is public
		B b = new B();
		System.out.println(b.publicMessage);
		
		//even though the protected variables are accessible in a sub class
		//it is not possible to implement it with parent class's object
		A a = new A();

		
		//you can only instaciate it with subclass's object
		//asub in this case
		Asub asub = new Asub();
		System.out.println(asub.protectedMessage);

	}

}
