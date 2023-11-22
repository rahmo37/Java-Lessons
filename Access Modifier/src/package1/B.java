package package1;


public class B {
	public String publicMessage = "i am public";

	public static void main(String[] args) {
		
		//Able to print the variable from a 
		//class within the same package since its protected
		A a = new A();
		System.out.println(a.protectedMessage);
		

	}
}
