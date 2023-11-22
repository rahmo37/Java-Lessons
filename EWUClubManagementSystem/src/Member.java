
public abstract class Member {
	String name;
	String id;
	String department;
	String position;
	String phoneNum;
	String bloodGrp;
	String email;
	int noOfSemester;
	boolean isAdmin;

	Member() {
		name = "";
		id = "";
		department = "";
		position = "";
		phoneNum = "";
		bloodGrp = "";
		email = "";
		noOfSemester = 0;
		isAdmin = false;
	}

	Member(String name, String id, String department, String position, String phoneNum, String bloodGrp, String email,
			int noOfSemester, boolean isAdmin) {
		this.name = name;
		this.id = id;
		this.department = department;
		this.position = position;
		this.phoneNum = phoneNum;
		this.bloodGrp = bloodGrp;
		this.email = email;
		this.noOfSemester = noOfSemester;
		this.isAdmin = isAdmin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getBloodGrp() {
		return bloodGrp;
	}

	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNoOfSemester() {
		return noOfSemester;
	}

	public void setNoOfSemester(int noOfSemester) {
		this.noOfSemester = noOfSemester;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
