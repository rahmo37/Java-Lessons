package Inheritance;

public class C extends B {
	int age;

	C() {
		age = 0;
	}

	C(String firstName, String lastName, String email, int age) {
		super(firstName, lastName, email);
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String print() {
		return super.print() + " " + getAge();
	}
}
