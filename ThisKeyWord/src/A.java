
public class A {
	String s;
	int x;
	A() {
		//this("Hello",100);
		s = null;
		x = 0;
		System.out.println("I am no parameter "
				+ "constructor");	
	}
	A(String s, int x) {
		this();
		this.s = s;
		this.x = x;
		System.out.println("I am parameterised "
				+ "constructor");
	}
	public void print() {
		System.out.println(this);
	}
}
