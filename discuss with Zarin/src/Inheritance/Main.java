package Inheritance;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D d1 = new D("David", "Malan", "abc@gmail.com", 35, "123456789");
		D d2 = new D("Christiano", "Ronaldo", "xyz@gmail.com", 38, "789456123");
		D d3 = new D("Lionel", "Messi", "xyz@gmail.com", 36, "456789123");
		D d4 = new D();

		System.out.println(d1.print());
		System.out.println(d2.print());
		System.out.println(d3.print());
		System.out.println(d4.print());
	}

}
