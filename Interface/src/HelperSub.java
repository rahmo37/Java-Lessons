
public interface HelperSub extends Helper {

	// This is a subclass of first interface Helper
	// If the a class implements this interface, it will automatically have access
	// to
	// the attributes in the both of the interfaces

	int MIN = 0;
	String MSG2 = "The val is now less than 0";

	public int getHelpb2();

	public static String justaMSG1() {
		return "I am Obaedur Rahman (Static)";

	}

}
