package StaticVariable;

public class StaticKeyWord {
	String studentName;
	int studentId;
	static String universityName = "Farmingdale State College";

	StaticKeyWord(String studentName, int studentId) {
		this.studentName = studentName;
		this.studentId = studentId;
	}

	void print() {
		System.out.println("Student name :" + studentName + "\n" + "Student Id :" + studentId + "\n" + "University :"
				+ universityName);

	}
}
