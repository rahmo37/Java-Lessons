package package2;

import package1.*;

public class C {
	
	String defaultMessage = "I am default";
	
	public static void main(String[] args) {
		
		//defaultMessage variable from the class A,package1, can be implemented in this class 
		C c = new C();
		System.out.println(c.defaultMessage);
		
		//but protectedVariable cant be accessed because its not a subcalss of A
		//Extend the C class to A to experiment 
		//if C extends A the varibale can be accessed
		System.out.println(c.protectedMessage);
		
		
		//privateMessage is private therefore it can't be accessed.
		Asub asub = new Asub();
		System.out.println(asub.privateMessage);
	}

}
