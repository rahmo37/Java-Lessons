
public class Main {
	
	//question 1(Krishna vai midterm)
	String greeting;
	String user;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();

		System.out.println(m.returningString("hi", "Krishna"));

	}

	String returningString(String greeting, String user) {
		this.greeting = greeting;
		this.user = user;

		return this.greeting + " " + this.user;

	}
}

