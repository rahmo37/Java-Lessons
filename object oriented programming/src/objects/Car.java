package objects;

public class Car {
	String make = "BMW";
	String model = "M5";
	int year = 2022;
	String color = "olive";
	double price = 80000.00;

	void drive() {
		System.out.println("You drive " + make);
	}

	void model() {
		System.out.println("You drive " + make + model);
	}

	public String toString() {
		StringBuilder print = new StringBuilder();

		print.append(make + "\n");
		print.append(model + "\n");
		print.append(year + "\n");
		print.append(color + "\n");
		print.append(price + "\n");

		return print.toString();
	}

}
