
public class TimeComparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = 0;
		long endTime = 0;

		long x = 10000000;

		System.out.println("Linear time value : " + linerTime(x, startTime, endTime));
		System.out.println("Constant time value : " + constantTime(x, startTime, endTime));
	}

	public static long linerTime(long n, long startTime, long endTime) {
		startTime = System.nanoTime();
		long sum = 0;
		for (int i = 0; i <= n; i++) {
			sum += i;
		}
		endTime = System.nanoTime();

		long elapsedTime = endTime - startTime;
		System.out.println("linear time operation : " + elapsedTime);
		return sum;
	}

	public static long constantTime(long n, long startTime, long endTime) {
		startTime = System.nanoTime();
		long sum = n * (n + 1) / 2;
		endTime = System.nanoTime();
		
		long elapsedTime = endTime - startTime;
		System.out.println("Constant time operation : " + elapsedTime);
		return sum;
		
	}

}
