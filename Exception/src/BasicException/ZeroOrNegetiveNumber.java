package BasicException;

public class ZeroOrNegetiveNumber extends Exception {

	public ZeroOrNegetiveNumber() {
		this("value must be greater than 0 and posetive");
	}

	public ZeroOrNegetiveNumber(String message) {
		super(message);

	}

}
