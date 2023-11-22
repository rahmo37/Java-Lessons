package CollectionAndLists;

import java.util.LinkedList;
import java.util.Queue;

public class LearningQueue {
	public static void main(String[] args) {
		// Queue is FIFO (first come first serve)
		// Element exiting/removing a queue is called dequeuin 
		// offer() method adds new element
		// Element entering/adding a queue is called enqueuing
		// poll() method removes an element
		
		Queue<String> queue = new LinkedList<String>();
		
		queue.offer("Anaconda");
		queue.offer("Bull");
		queue.offer("Cat");
		queue.offer("Dog");
		queue.add("Egg");
		
		queue.poll();
		
		
		//to look at the top most element
		System.out.println(queue.peek());
		
		//returns if the queue is empty or not
		System.out.println(queue.isEmpty());
		
		//returns the size()
		System.out.println(queue.size());
		
		//Check to see if an Element remains in the queue or not
		System.out.println(queue.contains("Egg"));
		
		// keyboard buffer
		// Printer queue
		// Used in linked list, priority queue
	}

}
