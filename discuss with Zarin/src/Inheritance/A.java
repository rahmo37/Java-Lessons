package Inheritance;
//Parent class
public class A {
	String firstName;
	String lastName;
	
	A() {
		firstName = "null";
		lastName = "null";
	}
	
	A(String firstName, String lastName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String print() {
		return getFirstName() + " " + getLastName();
	}
}
