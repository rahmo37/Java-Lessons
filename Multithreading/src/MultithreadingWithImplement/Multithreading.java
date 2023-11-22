package MultithreadingWithImplement;

public class Multithreading implements Runnable {

	private int threadNumber;

	Multithreading(int threadNumber) {
		this.threadNumber = threadNumber;
	}

	// Overriding the run method of the thread class
	// The code that is intended to run in multithread, we have to include it in the
	// run method
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + " From the thread number :" + threadNumber);
			
			//Even if a threadNumber runs into an exception, 
			//other threads just follow their instruction
			if(threadNumber == 3) {
				throw new RuntimeException();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {

			}
		}

	}
}
