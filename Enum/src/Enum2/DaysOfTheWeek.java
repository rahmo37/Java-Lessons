package Enum2;

public class DaysOfTheWeek {

	public static void main(String[] args) {

		DaysOfTheWeek d = new DaysOfTheWeek();
		d.dayOfTheWeek();
	}

	public void dayOfTheWeek() {
		// TODO Auto-generated method stub

		// d is a Day variable
		// with a specific value from the Day enum

		Day d = Day.WEDNESDAY;

		// if switch parameter is d
		// the case values can be the elements inside the enum
		// if the d = WDNESDAY or THURSDAY the case will go to default message
		// because WDNESDAY and THURSDAY are not included in the switch case
		switch (d) {
		case SATURDAY:
			System.out.println("Today is Saturday");
			break;
		case SUNDAY:
			System.out.println("Today is Sunday");
			break;
		case MONDAY:
			System.out.println("Today is Monday");
			break;
		case TUESDAY:
			System.out.println("Today is TUESDAY");
			break;
		case FRIDAY:
			System.out.println("Today is FRIDAY");
			break;
		default:
			System.out.println("Day not included");

		}

		// to retrieve all the values in an enum
		// you must declare an array variable
		// a regular variable must hold a specific value
		// Whereas an array variable doesn't hold a specific value
		// a regular variable cannot be used because a specific value is undefined

		System.out.println("\nAll the days of of the weeks are : ");
		for (int i = 0; i < 7; i++) {
			Day[] a = Day.values();
			System.out.println(a[i]);
		}
		// creates a new line
		System.out.println("\n");

		// Day.Values() returns the all the values of the enum.
		// Can be saved as an array.(Shown above)
		// since a becomes a specific value from the enum in each iteration of the loop
		// a.dayNo and a.extension was possible to call
		for (Day a : Day.values()) {
			System.out.println(a + " is " + a.dayNo + a.extension + " day of the week");
		}

	}

}
