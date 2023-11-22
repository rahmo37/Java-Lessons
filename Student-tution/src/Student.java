import java.util.ArrayList;
import java.util.Collections;

public abstract class Student {
	private String firstName;
	private String lastName;
	private String grade;
	private int credits;

	public Student(String firstName, String lastName, String grade, int credits) {
		setFirstName(firstName);
		setLastName(lastName);
		setGrade(grade);
		setCredits(credits);
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGrade(String grade) {
		ArrayList<String> validGrades = new ArrayList();
		String[] grades = {"A", "B+", "B", "C+", "C", "D+", "D", "F"};

		Collections.addAll(validGrades, grades);

		if ( validGrades.indexOf(grade) != -1) {
			System.out.println(validGrades.indexOf(grade));
			this.grade = grade;
		}
		/*
        ArrayList<String> validGrades = new ArrayList();
        String[] grades = {"A", "B+", "B", "C+", "C", "D+", "D", "F"};
        
        Collections.addAll(validGrades, grades);

        if ( validGrades.indexOf(grade) != -1 )
        {
            this.grade = grade;
        }*/
	}

	public void setCredits(int credits) {
		if (credits >= 0) {
			this.credits = credits;
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGrade() {
		return grade;
	}

	public int getCredits() {
		return credits;
	}

	public abstract String getTuitionString();

	public String toString() {
		return "Student: " + getFirstName() + " " + getLastName()
		+ "\n" + "Grade: " + getGrade()
		+ "\n" + "Credits: " + getCredits() 
		+ " ";
	}
}
