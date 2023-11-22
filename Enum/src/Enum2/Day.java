package Enum2;

public enum Day {

	MONDAY(1, "st"),
	TUESDAY(2, "nd"),
	WEDNESDAY(3, "rd"),
	THURSDAY(4, "th"),
	FRIDAY(5, "th"),
	SATURDAY(6, "th"),
	SUNDAY(7, "th");

	final int dayNo;
	final String extension;

	Day(int dayNo, String extension) {
		this.dayNo = dayNo;
		this.extension = extension;
	}
}
