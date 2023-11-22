/*
 * User class
 * 
 * Name: Obaedur Rahman
 * 
 */
package projectPokedex;

public class User {
	static int id;
	String firstName;
	String lastName;
	String email;
	String phone;
	String password;
	boolean isAdmin;

	String dateAndTimeAdded;

	User() {
		this.firstName = null;
		this.lastName = null;
		this.email = null;
		this.phone = null;
		this.password = null;
		this.isAdmin = false;
		dateAndTimeAdded = null;
	}

	User(String firstName, String lastName, String email, String phone, String password, boolean isAdmin,
			String dateAndTimeAdded) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.isAdmin = isAdmin;
		this.dateAndTimeAdded = dateAndTimeAdded;
		id++;
	}

	public static int getId() {
		return id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getDateAndTimeAdded() {
		return dateAndTimeAdded;
	}

	public void setDateAndTimeAdded(String dateAndTimeAdded) {
		this.dateAndTimeAdded = dateAndTimeAdded;
	}

	public String toString() {
		String s = getId() + " " + getFirstName() + " " + getLastName() + " " + getEmail() + " " + getPhone() + " "
				+ getPassword() + " " + getIsAdmin() + " " + getDateAndTimeAdded();
		return s;
	}

}
