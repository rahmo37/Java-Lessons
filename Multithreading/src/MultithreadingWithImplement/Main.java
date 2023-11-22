package MultithreadingWithImplement;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Multithreading multithreding2 = new Multithreading();

		// multithreding.run();
		// it is usual to think that we will call the run method form the Multithreding
		// class
		// but run method does not create a different thread.
		// to create a different thread we have to call the start() method

		// creating five different threads with a for loop
		for (int i = 0; i < 5; i++) {
			Multithreading multithreding = new Multithreading(i);
			Thread thread = new Thread(multithreding);
			thread.start();
			// After calling the start method, a different thread was created
			// and that thread was printed to the console window

			// Waits for the previous thread to finish completing
			// thread.join();

			// Checks if a thread is Alive or dead
			// thread.isAlive();
		}

	}

}
