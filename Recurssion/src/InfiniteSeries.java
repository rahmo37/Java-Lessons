
public class InfiniteSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double number = result(1);
		System.out.println(number);
	}
	
	public static double result(double n) {
		
		
		System.out.println(n);
		if(n > 0) {
			return n + result(n/2);
		}
		else {
			return 0;
		}
			
		
	}

}
