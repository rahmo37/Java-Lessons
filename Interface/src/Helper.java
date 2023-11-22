
public interface Helper {
	// All variables are final and static by default;
	int MAX = 5;
	String MSG1 = "The val is now greater than 5 ";

	// All methods are abstract by default
	public void getHelpb1();

	// if you specify that this method is default or static,
	// you can specify a body in that method
	// since this method is not abstract it is not necessary to implement
	// it in the classes that implemented this interface
	default void justaMSG() {
		System.out.println("My name is Obaedur Rahman" + " Interface version");
		// private method called
		anotherMSG();
	}

	// private method
	private void anotherMSG() {
		System.out.println("Private method");
	}

}
