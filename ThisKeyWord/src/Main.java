
public class Main {
	public static void main(String[] args) {
		A a = new A("Hello", 100);

		// printing a would give the address of the 'a' object. and a.print method print
		// the "this" keyword.
		// when printed both returned the same address proving both pointeing to the
		// same location in the memory
		// and they reffere to the same object.
		System.out.println(a);
		a.print();

		System.out.println(a.s);
		System.out.println(a.x);
		
		Child c = new Child();
	}
}
