package toString;

public class toStringMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//toString() = special method that all the object inherits.
		//returns string that textually represents an object.
		//this method work even if the method is not called explicitly
		
		//(extra)makes a default constructor. which takes no parameter
		pokemon p = new pokemon();
		
		
		System.out.println(p.toString("Zacian",100,"legendary"));

	}

}
