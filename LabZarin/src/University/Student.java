package University;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	private int studentID;
	private String studentName;
	private double studentCGPA;
	static Scanner scanner;

	static ArrayList<Student> AllStudentList = new ArrayList<>();

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getStudentCGPA() {
		return studentCGPA;
	}

	public void setStudentCGPA(double studentCGPA) {
		this.studentCGPA = studentCGPA;
	}

	Student() {
		this.studentID = 0;
		this.studentName = "";
		this.studentCGPA = 0.0;
	}

	Student(int studentID, String studentName, double studentCGPA) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentCGPA = studentCGPA;
	}

	public String toString() {
		String string = "student id: " + studentID + "\tstudentName: " + studentName + "\tstudentCGPA: " + studentCGPA;
		return string;
	}

	/**************************************************
	 * add Student
	 *****************************************************/

	public static void addStudent() {

		scanner = new Scanner(System.in);
		String userResponse = "y";

		while (userResponse.equals("y")) {
			if (userResponse.equals("n")) {
				return;
			}

			System.out.println("Enter student name: ");
			String name = userResponse = scanner.nextLine();

			System.out.println("Enter student id: ");
			int id = Integer.parseInt(userResponse = scanner.nextLine());
			;

			System.out.println("Enter student CGPA: ");
			double CGPA = Double.parseDouble(userResponse = scanner.nextLine());

			AllStudentList.add(new Student(id, name, CGPA));

			System.out.println("Add another student? (y/n)");
			userResponse = scanner.nextLine();
		}

	}

	/**************************************************
	 * Delete a student
	 *****************************************************/

	public static void deleteStudent() {
		scanner = new Scanner(System.in);
		String userResponse = "y";
		while (userResponse.equals("y")) {
			boolean invalidId = true;
			if (userResponse.equals("n")) {
				return;
			}
			System.out.println("Enter student id: ");
			int studentId = Integer.parseInt(userResponse = scanner.next());
			for (int i = 0; i < AllStudentList.size(); i++) {
				if (studentId == AllStudentList.get(i).studentID) {
					AllStudentList.remove(i);
					invalidId = false;
				}
			}
			if (invalidId) {
				System.out.println("No matching id found!");
				userResponse = "y";
				continue;
			}
			System.out.println("Student deletion successful!");
			System.out.println("Delete another student? (y/n)");
			userResponse = scanner.next();
		}
	}

	/**************************************************
	 * Update a student
	 *****************************************************/

	public void updateThisStudentAttributes() {
		scanner = new Scanner(System.in);
		String userResponse = "y";
		while (userResponse.equals("y")) {

			System.out.println("Press 1 to update student id\nPress 2 to update student Name"
					+ "\nPress 3 to update CGPA\nOr p to return to previous menu");
			userResponse = scanner.nextLine();
			if (userResponse.equals("p")) {
				return;
			} else if (userResponse.equals("1")) {
				System.out.println("Enter new Student id: ");
				setStudentID(Integer.parseInt(userResponse = scanner.nextLine()));
			} else if (userResponse.equals("2")) {
				System.out.println("Enter new Student name: ");
				setStudentName(userResponse = scanner.nextLine());
			} else if (userResponse.equals("3")) {
				System.out.println("Enter new CGPA ");
				setStudentCGPA(Double.parseDouble(userResponse = scanner.nextLine()));
			}
			System.out.println("Record updated");
			System.out.println("Change another record of this student? (y/n)");
			userResponse = scanner.nextLine();
		}
	}

	/**************************************************
	 * print all Student
	 *****************************************************/

	public static void printAllStudent() {
		if (AllStudentList.isEmpty()) {
			System.out.println("No student added yet!");
		} else {
			System.out.println("All students\n********************");
			for (int i = 0; i < AllStudentList.size(); i++) {
				System.out.println(i + 1 + ". " + AllStudentList.get(i));
			}
		}
		System.out.println();
	}

}
