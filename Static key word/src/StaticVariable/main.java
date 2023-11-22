package StaticVariable;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticKeyWord s1 = new StaticKeyWord("Obaedur Rahman", 123);
		StaticKeyWord s2 = new StaticKeyWord("Zarin Rafa", 321);

		//if static value is changed in one place, 
		//all the object gets the changed value
		StaticKeyWord.universityName = "Stony Brook\n";
		s1.print();
		s2.print();

	}

}
