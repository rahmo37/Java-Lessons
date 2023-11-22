package CollectionAndLists;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LearingPriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//priority Orders the queue with priority
		// Collection.reverse reverses the queue

		Queue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());
		

		queue.offer(1.5);
		queue.offer(3.5);
		queue.offer(4.0);
		queue.offer(3.0);
		queue.offer(1.2);
		
		//not understanding why it is messing up the order when just displaying
		System.out.println(queue);
		
		// giving accurate result when removing the elements with pop method
		// retaining the order accurately
		while (!queue.isEmpty()) {
			System.out.println(queue.peek());
			queue.poll();
		}

	}

}
