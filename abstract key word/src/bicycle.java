
public class bicycle extends vehicle {

	bicycle(String color, String company, int wheel) {
		super(color, company, wheel);
	}

	@Override
	String go() {
		return "\nthis vehicle goes very slow";
	}

	@Override
	public String toString() {
		return super.toString() + go();
	}

}
