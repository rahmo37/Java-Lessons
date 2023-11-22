package MultithreadingWithExtends;

public class Multithreading extends Thread {

	private int threadNumber;

	Multithreading(int threadNumber) {
		this.threadNumber = threadNumber;
	}

	// Overriding the run method of the thread class
	// The code that is intended to run in multithread, we have to include it in the
	// run method
	@Override
	public void run() {
		
			for(int j = 1; j <= 5; j++) {
			System.out.print(j);
			
			
			//Even if a threadNumber runs into an exception, 
			//other threads just follow their instruction
//			if(threadNumber == 3) {
//				throw new RuntimeException();
//			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {

			}
		}

	}
}
