package University;

import java.util.Scanner;

public class Main {
	static Scanner scanner;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addObjects();

		System.out.println("Welcome to East West University's Information Management System ");
		String userResponse = "";
		scanner = new Scanner(System.in);

		while (!userResponse.equals("n")) {
			System.out.println("\nMAIN MENU\n*******************\nEnter you choice: " + "\nPress 1 to add"
					+ "\nPress 2 to delete" + "\npress 3 to update" + "\npress 4 to print (Feature not available)"
					+ "\npress 5 to search (Feature not available)" + "\npress q to quit");
			userResponse = scanner.next();
			if (userResponse.equals("1")) {
				add();
			} else if (userResponse.equals("2")) {
				delete();
			} else if (userResponse.equals("3")) {
				update();
			} else if (userResponse.equals("q")) {
				System.out.println("Have a great day!!!\n:)");
				System.exit(0);
			}
		}

	}

	public static void add() {
		scanner = new Scanner(System.in);
		String userResponse = "";

		while (!userResponse.equals("p")) {

			System.out.println("\nADD MENU\n**********************\nEnter you choice: " + "\nPress 1 to add a student"
					+ "\nPress 2 to add a course" + "\npress 3 to add a faculty"
					+ "\npress 4 to add students and faculty in a course" + "\npress p for previous menu");
			userResponse = scanner.next();
			if (userResponse.equals("1")) {
				Student.addStudent();
			} else if (userResponse.equals("2")) {
				Course.addCourse();
			} else if (userResponse.equals("3")) {
				Faculty.addFaculty();
			} else if (userResponse.equals("4")) {
				addAtributes();
			} else if (userResponse.equals("p")) {
				return;
			}
		}
	}

	// sub method of add method
	public static void addAtributes() {
		int courseNumber = 0;
		int stuNumber = 0;
		int facultyNumber = 0;

		if (Course.AllCourseList.isEmpty()) {
			System.out.println("No course added yet!\n");
		} else {
			String userResponse = "";
			Course.printAllCourse();
			scanner.nextLine();
			System.out.println("Enter course number to add attributes: ");
			courseNumber = Integer.parseInt(userResponse = scanner.nextLine()) - 1;

			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}
			if (Student.AllStudentList.isEmpty()) {
				System.out.println("No student added yet!");
			} else {
				Student.printAllStudent();
				System.out.println("Enter student number: ");
				stuNumber = Integer.parseInt(userResponse = scanner.nextLine()) - 1;
				Course.AllCourseList.get(courseNumber).addStudentToThisCourse(Student.AllStudentList.get(stuNumber));
				System.out.println("Student added to this course");
			}

			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}

			if (Faculty.AllFacultyList.isEmpty()) {
				System.out.println("No faculty added yet!");
			} else {
				Faculty.printAllFaculty();
				System.out.println("Enter faculty number: ");
				facultyNumber = Integer.parseInt(userResponse = scanner.nextLine()) - 1;
				Course.AllCourseList.get(courseNumber)
						.addFacultyToThisCourse(Faculty.AllFacultyList.get(facultyNumber));
				System.out.println("Faculty added to this course");
			}
		}

	}

	public static void delete() {
		scanner = new Scanner(System.in);
		String userResponse = "";

		while (!userResponse.equals("p")) {

			System.out.println("\nDELETE MENU\n**********************\nEnter you choice: "
					+ "\nPress 1 to delete a student" + "\nPress 2 to delete a course" + "\npress 3 to delete a faculty"
					+ "\npress 4 to delete students and faculty in a course" + "\npress p for previous menu");
			userResponse = scanner.next();
			if (userResponse.equals("1")) {
				if (Student.AllStudentList.isEmpty()) {
					System.out.println("No student record to remove!");
				} else {
					Student.printAllStudent();
					Student.deleteStudent();
				}

			} else if (userResponse.equals("2")) {
				if (Course.AllCourseList.isEmpty()) {
					System.out.println("No course record to remove!");
				} else {
					Course.printAllCourse();
					Course.deleteCourse();
				}
			} else if (userResponse.equals("3")) {
				if (Faculty.AllFacultyList.isEmpty()) {
					System.out.println("No faculty record to remove!");
				} else {
					Faculty.printAllFaculty();
					Faculty.deleteFaculty();
				}
			} else if (userResponse.equals("4")) {
				deleteAtributes();
			} else if (userResponse.equals("p")) {
				return;
			}
		}
	}

	// sub method of delete method
	public static void deleteAtributes() {
		int courseNumber;
		if (Course.AllCourseList.isEmpty()) {
			System.out.println("No course added yet!\n");
		} else {
			String userResponse = "";
			Course.printAllCourse();
			scanner.nextLine();
			System.out.println("Enter course number to remove it's attributes: ");
			courseNumber = Integer.parseInt(userResponse = scanner.nextLine()) - 1;
			Course.AllCourseList.get(courseNumber).printStudentTakingThisCourse();
			System.out.println("\n**********************");
			System.out.println(Course.AllCourseList.get(courseNumber).getFaculty());

			System.out.println(
					"Enter s to delete a student" + "\nf to delete the faculty \nor p to return to the previous menu");
			userResponse = scanner.nextLine();

			if (userResponse.equals("f")) {
				Course.AllCourseList.get(courseNumber).setFaculty(null);
				System.out.println("Deletion successful");
			} else if (userResponse.equals("s")) {
				Course.AllCourseList.get(courseNumber).dropStudent();
			}

		}

	}

	public static void update() {
		scanner = new Scanner(System.in);
		String userResponse = "";

		while (!userResponse.equals("p")) {

			System.out.println("\nUPDATE MENU\n**********************\nEnter you choice: "
					+ "\nPress 1 to update a student" + "\nPress 2 to update a course (Feature not available)"
					+ "\npress 3 to update a faculty (Feature not available)" + "\npress p for previous menu");
			userResponse = scanner.next();
			if (userResponse.equals("1")) {
				if (Student.AllStudentList.isEmpty()) {
					System.out.println("No student record to update!");
				} else {
					Student.printAllStudent();
					updateStudent();
				}
			}
		}
	}

	public static void updateStudent() {
		int stuNumber = 0;
		scanner = new Scanner(System.in);
		String userResponse = "y";

		while (userResponse.equals("y")) {
			if (userResponse.equals("n")) {
				return;
			}
			System.out.println("Enter student number: ");
			stuNumber = Integer.parseInt(userResponse = scanner.nextLine()) - 1;
			Student.AllStudentList.get(stuNumber).updateThisStudentAttributes();

			System.out.println("Select another student? (y/n)");
			userResponse = scanner.nextLine();
		}
	}

	public static void addObjects() {
		Student s1 = new Student(123456, "Zarin Rafa", 4.00);
		Student s2 = new Student(175934, "Obaedur Rahman", 4.00);
		Student s3 = new Student(784536, "Maysha Asfer", 3.50);
		Student s4 = new Student(486157, "Ayesha Siddika", 3.50);
		Student.AllStudentList.add(s1);
		Student.AllStudentList.add(s2);
		Student.AllStudentList.add(s3);
		Student.AllStudentList.add(s4);

		Course c1 = new Course("159753", "Learn Java", 4.00);
		Course c2 = new Course("159456", "World History", 4.00);
		Course c3 = new Course("156489", "Data stucture", 4.00);
		Course c4 = new Course("354756", "Learn Python", 3.00);
		Course.AllCourseList.add(c1);
		Course.AllCourseList.add(c2);
		Course.AllCourseList.add(c3);
		Course.AllCourseList.add(c4);

		Faculty f1 = new Faculty(154756, "Ablert Einstein", "Dean");
		Faculty f2 = new Faculty(356985, "Werner Heigenberg", "Assistant");
		Faculty f3 = new Faculty(154756, "Aurthur Conan Doyal", "Dean");
		Faculty f4 = new Faculty(123789, "Rokib Hashan", "Dean");
		Faculty.AllFacultyList.add(f1);
		Faculty.AllFacultyList.add(f2);
		Faculty.AllFacultyList.add(f3);
		Faculty.AllFacultyList.add(f4);
	}
}
