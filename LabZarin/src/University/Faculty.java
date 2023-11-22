package University;

import java.util.ArrayList;
import java.util.Scanner;

public class Faculty {
	private int facultyId;
	private String facultyName;
	private String facultyPosition;
	static Scanner scanner;
	static ArrayList<Faculty> AllFacultyList = new ArrayList<>();

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getFacultyPosition() {
		return facultyPosition;
	}

	public void setFacultyPosition(String facultyPosition) {
		this.facultyPosition = facultyPosition;
	}

	Faculty() {
		this.facultyId = 0;
		this.facultyName = "";
		this.facultyPosition = "";
	}

	Faculty(int facultyId, String facultyName, String facultyPosition) {
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.facultyPosition = facultyPosition;
	}

	public String toString() {
		String string = "faculty id: " + facultyId + "\tfaculty name: " + facultyName + "\tfacultyPosition: "
				+ facultyPosition;

		return string;
	}

	/**************************************************
	 * add Faculty
	 *****************************************************/

	public static void addFaculty() {
		scanner = new Scanner(System.in);
		String userResponse = "y";

		while (userResponse.equals("y")) {
			System.out.println("Enter faculty id: ");
			int facultyId = Integer.parseInt(userResponse = scanner.nextLine());

			System.out.println("Enter faculty name: ");
			String facultyName = userResponse = scanner.nextLine();

			System.out.println("Enter faculty position: ");
			String position = userResponse = scanner.nextLine();

			AllFacultyList.add(new Faculty(facultyId, facultyName, position));
			System.out.println("faculty added successfully!");

			System.out.println("Add another faculty? (y/n)");
			userResponse = scanner.nextLine();
		}
	}

	/**************************************************
	 * Delete a faculty
	 *****************************************************/

	public static void deleteFaculty() {
		scanner = new Scanner(System.in);
		String userResponse = "y";
		while (userResponse.equals("y")) {
			boolean invalidId = true;
			if (userResponse.equals("n")) {
				return;
			}
			System.out.println("Enter faculty id: ");
			int facultyId = Integer.parseInt(userResponse = scanner.next());
			for (int i = 0; i < AllFacultyList.size(); i++) {
				if (facultyId == AllFacultyList.get(i).facultyId) {
					AllFacultyList.remove(i);
					invalidId = false;
				}
			}
			if (invalidId) {
				System.out.println("No matching id found!");
				userResponse = "y";
				continue;
			}
			System.out.println("Faculty deletion successful!");
			System.out.println("Delete another Faculty? (y/n)");
			userResponse = scanner.next();
		}
	}

	/**************************************************
	 * print all Faculty
	 *****************************************************/

	public static void printAllFaculty() {
		if (AllFacultyList.isEmpty()) {
			System.out.println("No faculty added yet!");
		} else {
			System.out.println("All Faculty\n********************");
			for (int i = 0; i < AllFacultyList.size(); i++) {
				System.out.println(i + 1 + ". " + AllFacultyList.get(i));
			}
		}
		System.out.println();
	}
}
