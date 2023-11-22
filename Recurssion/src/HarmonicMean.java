
public class HarmonicMean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double result = harmonicMean(1);
		System.out.printf("The result is: %.5f", result);
	}

	public static double harmonicMean(double n) {
		if (n > 0.125) {
			return n + harmonicMean(n / (n + 1));
		} else {
			return 0;
		}
	}

}
