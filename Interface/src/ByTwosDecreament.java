
public class ByTwosDecreament implements HelperSub {

	int val;

	ByTwosDecreament() {
		val = 5;
	}

	// must implement all the methods from the interface since they are abstract

	@Override
	public void getHelpb1() {
		// TODO Auto-generated method stub

	}

	// even if the method is empty in the implementing class

	@Override
	public int getHelpb2() {
		// TODO Auto-generated method stub

		// calling the values from interface helper
		for (int i = 5; i > -1; i--) {
			val--;

			if (val < MIN) {
				System.out.println(MSG2);
				return val;
			} else {
				System.out.println("The decremented value is :" + val);

			}
		}
		return 0;
		// Side info: if a method returns anything the method dies right then and there
		// even if the for loop did not end
	}

	@Override
	public void justaMSG() {
		System.out.println("I am Obaedur Rahman" + " Overridden version");

	}

}
