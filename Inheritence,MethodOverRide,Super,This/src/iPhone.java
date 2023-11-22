
public class iPhone extends cellPhone {

	String cable;

	iPhone() {
		this("iPhone", "iOS", "Closed Standard", 15, "Lightning");
	}

	iPhone(String name, String OS, String Standard, int version, String cable) {
		super(name, OS, Standard, version);
		this.cable = cable;

	}

	@Override
	String battery() {

		return super.battery() + "\n" + name + "battery lasts long";
	}

	@Override
	public String toString() {

		return super.toString() + battery();

	}

}
