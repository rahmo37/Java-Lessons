
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// calling the methods from the implemented classes
		// commented out at this moment
		// *
		ByTwosIncreament b1 = new ByTwosIncreament();

		// b1.getHelpb1();

		ByTwosDecreament b2 = new ByTwosDecreament();
		// b2.getHelpb2();

		// *

		// *

		// creating an object of the interface and making it point to the
		// class object
		Helper help1;

		help1 = b1;
		help1.getHelpb1();

		HelperSub help2;
		help2 = b2;
		System.out.println(help2.getHelpb2());

		// the interface object is smart enough to figure out which method to call

		// However it cannot call any other method, other than those in the interface
		// and overridden by the implemented class

		// *

		// *
		// Calling the interface version of the method with regular class object
		// calling it with the b1 object since it is's class did not implement this
		// method
		// and will call the interface version of this method
		b1.justaMSG();
		// Calling the overridden version of the method since the method is overridden
		// in the b2's class
		b2.justaMSG();
		//
		// *

		// *
		//calling the static method from HelperSub interface
		//cannot call with an object
		System.out.println(HelperSub.justaMSG1());
		
		// *

	}

}
