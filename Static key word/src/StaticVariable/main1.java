package StaticVariable;

public class main1 {

	public static void main(String[] args) {  //if static						//if non-static
		friends f1 = new friends("Obaedur"); // numberOfFriends = 0 to 1		// numberOfFriends = 0 to 1
		friends f2 = new friends("Rahman"); // numberOfFriends = 1 to 2			// numberOfFriends = 0 to 1
		friends f3 = new friends("Arnob"); // numberOfFriends = 2 to 3			// numberOfFriends = 0 to 1

		
		
		//possible to define with objects
		System.out.println(f1.numberOfFriends); 
		System.out.println(f2.numberOfFriends); 
		System.out.println(f3.numberOfFriends); 
		//but makes scence to define with class
		System.out.println(friends.numberOfFriends); 

	}

}
