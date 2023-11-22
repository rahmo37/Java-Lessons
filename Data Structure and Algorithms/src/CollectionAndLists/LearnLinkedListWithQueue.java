package CollectionAndLists;

import java.util.LinkedList;
import java.util.Queue;

public class LearnLinkedListWithQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> linkedList = new LinkedList<>();
		
		// when linked list is used with offer method. it acts like a queue
		//poll method will remove the first element
		
		linkedList.offer("A");
		linkedList.offer("B");
		linkedList.offer("C");
		linkedList.offer("D");
		linkedList.offer("E");

		linkedList.poll();
		System.out.println("Queue like linked list:" + linkedList);
		
		//LinkedList are very quick at data insertion and deletion
		//because they contain reference for the next element in the list when used Singly Linked List
		//Also they contain reference for the next and previous element in the list when used Doubly Linked List
		linkedList.add(2,"?");
		linkedList.remove(2);
		System.out.println(linkedList);
		
		//Searching for an element is easy as well
		System.out.println((linkedList.indexOf("E")));
		
		// However accessing an element is not easy.
		// Because there is no random access to the elements like Arrays or ArrayLists
		
		Queue<String> queue = new LinkedList<>();
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		queue.offer("D");
		queue.offer("E");
		
		queue.poll();
		System.out.println("Original queue :" + queue);

	}

}
