package MultithreadingWithExtends;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Multithreading multithreding2 = new Multithreading();

		// multithreding.run();
		// it is usual to think that we will call the run method form the Multithreding
		// class
		// but run method does not create a different thread.
		// to create a different thread we have to call the start() method
		for (int i = 0; i < 5; i++) {
			Multithreading multithreding = new Multithreading(i);
			multithreding.start();
			System.out.println();
		}
		// After calling the start method, a different thread was created
		// and that thread was printed to the console window

	}

}
