import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class HelperMethod {

	public static boolean isValidId(String id) {
		if (id.length() != 13) {
			System.out.println("Id length is not 13");
			return false;
		} else if (id.charAt(4) == '-' && id.charAt(6) == '-' && id.charAt(9) == '-') {
			for (int i = 0; i < id.length(); i++) {
				if (Character.isAlphabetic(id.charAt(i))) {
					System.out.println("Alphabetic character found!");
					return false;
				}
			}
			return true;
		}
		System.out.println("Hyphen missing!!");
		return false;
	}

	public static boolean isEmpty(ArrayList<Object> listTF) {
		for (int i = 0; i < listTF.size(); i++) {
			if (((JTextField) listTF.get(i)).getText().equals("")) {
				return true;
			}
		}
		return false;
	}

	public static void writeMemberInfo(ArrayList<Object> list, String fileName, boolean isAppend) {
		String delimeter = ",";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, isAppend));
			for (int i = 0; i < list.size(); i++) {
				if (i == list.size() - 1) {
					delimeter = "";
				}
				if (list.get(0) instanceof JTextField) {
					bw.write(((JTextField) list.get(i)).getText() + delimeter);
				} else {
					bw.write(list.get(i) + delimeter);
				}
			}
			bw.newLine();
			bw.close();
		} catch (IOException e) {
		}
	}

	public static ArrayList<ArrayList<Object>> filter(ArrayList<ArrayList<Object>> allMembers, String partialId) {
		ArrayList<ArrayList<Object>> resultList = new ArrayList<ArrayList<Object>>();
		boolean isMatch = true;
		for (int i = 0; i < allMembers.size(); i++) {
			isMatch = true;
			for (int j = 0; j < partialId.length(); j++) {
				if (partialId.charAt(j) == ((String) allMembers.get(i).get(1)).charAt(j)) {
					continue;
				} else {
					isMatch = false;
					break;
				}
			}
			if (isMatch) {
				resultList.add(allMembers.get(i));
			}
		}
		return resultList;
	}

	public static StringBuilder buildTextArea(ArrayList<ArrayList<Object>> list, int selectedRow) {
		StringBuilder build = new StringBuilder();
		build.append("Name: " + list.get(selectedRow).get(0) + "\n");
		build.append("Id: " + list.get(selectedRow).get(1) + "\n");
		build.append("Department: " + list.get(selectedRow).get(2) + "\n");
		build.append("Position: " + list.get(selectedRow).get(3) + "\n");
		build.append("Phone: " + list.get(selectedRow).get(4) + "\n");
		build.append("Blood Group: " + list.get(selectedRow).get(5) + "\n");
		build.append("Email: " + list.get(selectedRow).get(6) + "\n");
		build.append("No. of Semester: " + list.get(selectedRow).get(7) + "\n");
		build.append("No. of Vote: " + list.get(selectedRow).get(8) + "\n");
		build.append("No. of Months: " + list.get(selectedRow).get(9) + "\n");
		build.append("Is Admin: " + list.get(selectedRow).get(10) + "\n");
		return build;
	}
}
