import java.util.ArrayList;

public class ArrayListClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList is resizable.
		//Elements can be added or removed after.
		//but only stores reference data type
		ArrayList<String> food = new ArrayList<String>();
		ArrayList<String> soup = new ArrayList<String>();
		
		soup.add("Egg soup");
		soup.add("Noodle soup");
		
		food.add("Somucha");
		food.add("Shingara");
		food.add("Borhani");
		food.add("Kachhi");
		
		//Set method
		food.set(0, "Egg roll");
		//Remove method
		food.remove(1);
		//clear method
		food.clear();
		//Add all method
		food.addAll(soup);
		
		for (int i = 0; i < food.size(); i++) {
			System.out.println(food.get(i));
		}

	}

}
