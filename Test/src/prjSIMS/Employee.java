package prjSIMS;

/*********************************************************
 * 
 * Project Name: prjSIMS
 * Class: Employee
 * Author: Cyril, Talha, Johnson, Josh, Ghulam
 * Date: September 21st 2022
 * Purpose: This class reflects the employees available
 * *******************************************************/

public class Employee {

	String empid; //EmployeeID
	String empName; //EmployeeName
	String email; //Employee Email/Username Synonymous
	String password;//Employee Password
	Boolean isAdmin; //Employee isAdmin
	
	
	
	public Employee() {
		super();
		this.empid= "";
		this.empName = "";
		this.email = "";
		this.password = "";
		this.isAdmin = false;
	}
	
	public Employee(String empid, String empName, String email, String password, Boolean isAdmin) {
		super();
		this.empid = empid;
		this.empName= empName;
		this.email = email;
		this.password= password;
		this.isAdmin = isAdmin;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empName;
	}

	public void setEmpname(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAdmin() {
		return isAdmin;
	}

	public void setAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	

}