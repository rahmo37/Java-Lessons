
public class truck extends vehicle {

	String type;

	truck(String color, String company, int wheel, String type) {
		super(color, company, wheel);
		this.type = type;
	}

	@Override
	String go() {
		return "\nthis vehicle goes very fast";
	}
	@Override
	public String toString() {
		return super.toString() + "\nthis is a small truck" + type + go();
	}

}
