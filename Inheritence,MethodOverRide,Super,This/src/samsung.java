
public class samsung extends cellPhone {

	String cable;

	// default constructor
	// the this keyword is passing default values to the parameterized constructor
	// below
	samsung() {
		this("Samsung", "Android", "Open Standard", 12, "USB-c");
	}

	samsung(String name, String OS, String Standard, int version, String cable) {
		super(name, OS, Standard, version);
		//this.calble means, the variable "cable" for the samsung object = parameter "cable".
		this.cable = cable;
	}

	@Override
	String battery() {
		
		return super.battery()+ "\n" + name + " battery does not last long\n";
	}
	
	@Override
	public String toString() {

		return super.toString() + battery();

	}

}
