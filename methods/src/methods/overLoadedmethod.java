package methods;

public class overLoadedmethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Overloaded method = same name but different parameters
		//Method signature = method name + parameters (makes a method unique)
		
		System.out.println("calling the double add "
				+ "overloaded method with 3 parameter " + add(1.0,2.3,3.5));
		System.out.println("calling the int add "
				+ "overloaded method with 4 parameter " + add(1,2,3,6));

	}
	
	static int add(int a, int b) {
		return a + b;
	}
	static int add(int a, int b, int c) {
		return a + b + c;
	}
	static int add(int a, int b, int c,int d) {
		return a + b + c + d;
	}
	static double add(double a, double b) {
		return a + b;
	}
	static double add(double a, double b, double c) {
		return a + b + c;
	}
	static double add(double a, double b, double c, double d) {
		return a + b + c + d;
	}
}
