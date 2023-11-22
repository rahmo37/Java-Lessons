
public class GeneralMembers extends Members {
	
	int noOfSemesters = 0;
	
	GeneralMembers(String name, String phone, int noOfSemesters) {
		super(name, phone);
		this.noOfSemesters = noOfSemesters;
	}
	
	public void setNoOfSemesters(int noOfSemesters) {
		if (noOfSemesters < 4) {
			this.noOfSemesters = noOfSemesters;
		}
		else {
			System.out.println("Invalid Input!!");
		}
	}
	
	public String toString() {
		return "\nGeneral Member\n***************" + "\nFull Name: " + name + "\n" + "Phone num: " + phone + "\n"
				+ "Number of Semester: " + noOfSemesters;
	}
}
