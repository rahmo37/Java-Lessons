
public class MathClass {
	double x = 3.14;
	double y = -10;

	public void max() {
		double z = Math.max(y, x);
		System.out.println("Maximum of x and y is :" + z);
	}

	public void min() {
		double z = Math.min(y, x);
		System.out.println("Minimum of x and y is :" + z);
	}

	public void abs() {
		double z = Math.abs(y);
		System.out.println("The absolute value of y is : " + z);
	}

	public void round() {
		double z = Math.round(x);
		System.out.println("x is rounded to " + z);
	}
	
	public void ceil() {
		// a method to round up
		double z = Math.ceil(x);
		System.out.println("x is rounded 'up' to " + z);
	}
	
	public void floor() {
		// a method to round down
		double z = Math.floor(x);
		System.out.println("x is rounded 'down' to " + z);
	}

	public static void main(String[] args) {

		MathClass mc = new MathClass();

		mc.max();
		mc.min();
		mc.abs();
		mc.round();
		mc.ceil();
		mc.floor();

	}

}
