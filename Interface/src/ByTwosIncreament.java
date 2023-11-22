
public class ByTwosIncreament implements HelperSub {
	int val;

	ByTwosIncreament() {
		val = 0;
	}

	// must implement all the methods from the interface since they are abstract

	@Override
	public void getHelpb1() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 6; i++) {
			val++;
			if (val > MAX) {
				System.out.println(MSG1);
			}
			System.out.println(val);
		}

	}
	// even if the method is empty in the implementing class

	@Override
	public int getHelpb2() {
		// TODO Auto-generated method stub
		return 0;
	}
}
