
public class car extends vehicle {

	String type;

	car(String color, String company, int wheel, String type) {
		super(color, company, wheel);
		this.type = type;
	}
	
	@Override
	String go() {
		return "\nthis vehicle goes fast";
	}
	@Override
	public String toString() {
		return super.toString() + "\nthis car is a " + type + go();
	}
}
