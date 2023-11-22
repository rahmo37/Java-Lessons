/*
 * HelperMethod class
 * 
 * Name: Obaedur Rahman
 * 
 */
package projectPokedex;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class HelperMethod {

	public static void main(String args[]) {
//		String st = "100    fire blast";
//		System.out.println(returnNumbers(st));
//		System.out.println(returnWords(st));
//		String st = "631-965-3230";
//		System.out.println(isValidPhone(st));
		// System.out.println(search(st));
		// String st = "R";
	}

	public static String returnNumbers(String st) {
		String c = "";
		for (int i = 0; i < st.length(); i++) {
			if (Character.isDigit(st.charAt(i))) {
				c = c + st.charAt(i);
			}
		}
		return c;
	}

	public static String returnWords(String st) {
		String c = "";
		String s = "";
		for (int i = 0; i < st.length(); i++) {
			if (Character.isAlphabetic(st.charAt(i)) || (st.charAt(i) == ' ')) {
				c = c + st.charAt(i);
			}
		}
		String[] arr = c.split(" ");
		for (int j = 0; j < arr.length; j++) {
			if (!arr[j].equals("")) {
				s = s + arr[j] + " ";
			}
		}
		return s;
	}

	public static String timeStamp() {
		String timeStamp = "";
		String dateTimePattern = "E,MMM-dd-yyyy HH:mm:ss";
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(dateTimePattern);
		return timeStamp = localDateTime.format(dateTimeFormat);
	}

	public static Boolean isValidPhone(String st) {
		for (int i = 0; i < st.length(); i++) {
			if (st.charAt(i) == '-') {
				continue;
			} else if (!Character.isDigit(st.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static Boolean isValidEmail(String st) {
		for (int i = 0; i < st.length(); i++) {
			if (st.charAt(i) == '@') {
				for (int j = 0; j < st.length(); j++) {
					if (st.charAt(j) == '.') {
						return true;
					}
				}
			}

		}
		return false;
	}

	public static void insertionSort(ArrayList<String> strArr) {
		String temp;

		for (int i = 0; i < strArr.size(); i++) {
			for (int j = i + 1; j < strArr.size(); j++) {
				if (strArr.get(i).compareToIgnoreCase(strArr.get(j)) > 0) {
					temp = strArr.get(i);
					strArr.set(i, strArr.get(j));
					strArr.set(j, temp);
				}
			}
		}
	}
}