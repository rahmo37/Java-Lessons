package prjSIMS;


/*********************************************************
 * 
 * Project Name: prjSIMS
 * Class: Employee
 * Author: Kevin, Obaedur, Rodrigo, Amir, Luis
 * Date: September 21st 2022
 * Purpose: This class reflects the departments
 * *******************************************************/


public class Department {
	

	private String deptNum;
	private String deptName;
	private String empId;

	Department() {
		deptNum = "";
		deptName = "";
		empId = "";
	}

	Department(String deptNum, String deptName, String empId) {
		this.deptNum = deptNum;
		this.deptName = deptName;
		this.empId = empId;

	}

	public void setDeptNum(String deptNum) {
		this.deptNum = deptNum;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDeptNum() {
		return deptNum;
	}

	public String getDeptName() {
		return deptName;
	}

	public String getEmpId() {
		return empId;
	}



}
