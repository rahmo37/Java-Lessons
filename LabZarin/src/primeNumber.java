
public class primeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 55;

		System.out.println("The next prime number is: " + nextPrime(x));
	}

	public static int nextPrime(int x) {

		for (int i = 2; i < x; i++) {

			if (x % i == 0) {
				x++;
				i = 2;
			}

		}
		return x;

	}

}
