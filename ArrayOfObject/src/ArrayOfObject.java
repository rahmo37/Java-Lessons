
public class ArrayOfObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Afamily person1 = new Afamily("Mesbah uddin");
		Afamily person2 = new Afamily("Obaedur Rahman");
		Afamily person3 = new Afamily("Zarin Rafa");
		Afamily person4 = new Afamily("Umme Roushan");

		Afamily[] person = { person1, person2, person3, person4 };

		for (int i = 0; i < person.length; i++) {
			System.out.println(person[i].name);
		}

	}

}
