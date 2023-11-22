
public abstract class vehicle {
	String color;
	String company;
	int wheel;

	vehicle(String color, String company, int wheel) {
		this.color = color;
		this.company = company;
		this.wheel = wheel;
	}
	abstract String go();
	
	void primary() {
		System.out.println("The vehicle class is abstract.");
	}
	
	public String toString() {
		return "\ncolor of the vehicle is " + this.color
				+"\nvehicle company is " + this.company
				+"\nthis vehicle has "+ this.wheel + " wheels";
	}
}
