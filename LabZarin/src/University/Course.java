package University;

import java.util.ArrayList;
import java.util.Scanner;

public class Course {
	private String courseId;
	private String courseTitle;
	private double credit;
	private Student[] studentList = new Student[25];;
	private int numberOfStudent;
	Faculty faculty;
	static Scanner scanner;
	static ArrayList<Course> AllCourseList = new ArrayList<>();

	Course() {
		this.courseId = "";
		this.courseTitle = "";
		this.credit = 0;
	}

	Course(String courseId, String courseTitle, double credit) {
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.credit = credit;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public int getNumberOfStudent() {
		return numberOfStudent;
	}

	public void setNumberOfStudent(int numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public String toString() {
		String string = "CourseId: " + courseId + "    courseTitle: " + courseTitle + "    credit: " + credit;
		return string;
	}

	/**************************************************
	 * add Student to this course
	 *****************************************************/

	public void addStudentToThisCourse(Student student) {
		studentList[numberOfStudent] = student;
		numberOfStudent++;
	}

	/**************************************************
	 * add Faculty to this course
	 *****************************************************/

	public void addFacultyToThisCourse(Faculty faculty) {
		this.faculty = faculty;
	}

	/**************************************************
	 * drop student form this course
	 *****************************************************/

	public void dropStudent() {
		scanner = new Scanner(System.in);
		String userResponse = "y";

		while (userResponse.equals("y")) {
			boolean invalidId = true;

			if (userResponse.equals("n")) {
				return;
			}
			System.out.println("Enter student id: ");
			int studentId = Integer.parseInt(userResponse = scanner.next());
			for (int i = 0; i < 25; i++) {
				if (studentList[i] == null) {
					continue;
				}
				if (studentId == studentList[i].getStudentID()) {
					studentList[i] = null;
					invalidId = false;
				}
			}
			if (invalidId) {
				System.out.println("No matching id found!");
				userResponse = "y";
				continue;
			}
			System.out.println("Student deletion successful!");
			System.out.println("Delete another student id? (y/n)");
			userResponse = scanner.next();
		}
	}

	/**************************************************
	 * print Student taking this course
	 *****************************************************/

	public void printStudentTakingThisCourse() {
		System.out.println("\n\nStudent List");
		System.out.println("****************************");
		for (int i = 0; i < studentList.length; i++) {
			System.out.println(studentList[i]);
		}
	}

	/**************************************************
	 * print Faculty to this course
	 *****************************************************/

	public void printFacultyTeachingThisCourse() {
		System.out.println(faculty);
	}

	/**************************************************
	 * add a course
	 *****************************************************/

	public static void addCourse() {
		scanner = new Scanner(System.in);
		String userResponse = "y";

		while (userResponse.equals("y")) {
			System.out.println("Enter course id: ");
			String courseId = userResponse = scanner.nextLine();

			System.out.println("Enter course title: ");
			String courseTitle = userResponse = scanner.nextLine();

			System.out.println("Enter credit for this course: ");
			double credit = Double.parseDouble(userResponse = scanner.nextLine());

			AllCourseList.add(new Course(courseId, courseTitle, credit));
			System.out.println("Course added successfully!");

			System.out.println("Add another course? (y/n)");
			userResponse = scanner.nextLine();
		}
	}

	/**************************************************
	 * Delete a course
	 *****************************************************/

	public static void deleteCourse() {
		scanner = new Scanner(System.in);
		String userResponse = "y";
		while (userResponse.equals("y")) {
			boolean invalidId = true;
			if (userResponse.equals("n")) {
				return;
			}
			System.out.println("Enter course id: ");
			String courseId = userResponse = scanner.next();
			for (int i = 0; i < AllCourseList.size(); i++) {
				if (courseId.equals(AllCourseList.get(i).courseId)) {
					AllCourseList.remove(i);
					invalidId = false;
				}
			}
			if (invalidId) {
				System.out.println("No matching id found!");
				userResponse = "y";
				continue;
			}
			System.out.println("Course deletion successful!");
			System.out.println("Delete another Course? (y/n)");
			userResponse = scanner.next();
		}
	}

	/**************************************************
	 * print all courses
	 *****************************************************/

	public static void printAllCourse() {
		if (AllCourseList.isEmpty()) {
			System.out.println("No course added yet!");
		} else {
			System.out.println("All courses\n*****************");
			for (int i = 0; i < AllCourseList.size(); i++) {
				System.out.println(i + 1 + ". " + AllCourseList.get(i));
			}
			System.out.println();
		}
	}
}
