package Inheritance;

public class D extends C {
	String phone = "";

	D() {
		phone = "null";
	}

	D(String firstName, String lastName, String email, int age, String phone) {
		super(firstName, lastName, email, age);
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String print() {
		return super.print() + " " + getPhone();
	}

}
