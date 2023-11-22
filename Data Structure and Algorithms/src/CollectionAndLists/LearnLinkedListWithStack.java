package CollectionAndLists;

import java.util.LinkedList;
import java.util.Stack;

public class LearnLinkedListWithStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> linkedList = new LinkedList<>();
		Stack<String> stack = new Stack<>();



		{
			// if push method is used LinkedList works like a stack
			// though linked list(which is used with push method) will represent the data
			// right to left, right being the bottom and left being the top
			// so using a pop method will remove the left most(top) item
			// Interestingly the index will always start with left most element
			// ending with right most element
			// so the first element is left most 
			// and the last element is right most
			
			linkedList.push("A");
			linkedList.push("B");
			linkedList.push("C");
			linkedList.push("D");
			linkedList.push("E");

			System.out.println(linkedList.get(0));
			linkedList.pop();
			System.out.println("Stack like linked list:" + linkedList);

			linkedList.push("?");
			System.out.println(linkedList);

			// whereas in original stack data is represented from left to right
			// left being the bottom and right being the top
			// so pop method will remove the right most item
			stack.push("A");
			stack.push("B");
			stack.push("C");
			stack.push("D");
			stack.push("E");

			stack.pop();

			System.out.println("Original Stack :" + stack +"\n");
		}
		
		{
			//some use-full methods of linked list
			System.out.println(linkedList.peekFirst());
			System.out.println(linkedList.peekLast());
			linkedList.addFirst("E");
			linkedList.addLast("0");
			linkedList.removeFirst();
			linkedList.removeLast();
			System.out.println("\n" + linkedList);
			
		}

	}

}
