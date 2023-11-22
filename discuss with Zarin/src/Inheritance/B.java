package Inheritance;

public class B extends A {

	String email;

	B() {
		email = "null";
	}

	B(String firstName, String lastName, String email) {
		super(firstName, lastName);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// super.print() is calling its parent classes print method
	@Override
	public String print() {
		return super.print() + " " + getEmail();
	}

}
