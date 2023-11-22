package CollectionAndLists;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayVSLinked {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Experimenting the time it takes to complete certain task using arrayList and linkedList
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		ArrayList<Integer> arrayList = new ArrayList<>();

		long startTime;
		long endTime;
		long elapsedTime;

		for (int i = 0; i < 1000000; i++) {
			linkedList.add(i);
			arrayList.add(i);
		}
		

		startTime = System.nanoTime();
		System.out.println("startTime" + startTime);
//		linkedList.get(0);
//		linkedList.get(500000);
//		linkedList.get(999999);
//		linkedList.remove(0);
//		linkedList.remove(500000);
//		linkedList.remove(999999);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.println("Runtime for linked list: " + endTime + " Nanosec\n");

		startTime = System.nanoTime();
//		arrayList.get(0);
//		arrayList.get(500000);
//		arrayList.get(999999);
//		arrayList.remove(0);
//		arrayList.remove(500000);
//		arrayList.remove(999999);

		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.println("Runtime for array list: " + endTime + " Nanosec\n");

	}

}
