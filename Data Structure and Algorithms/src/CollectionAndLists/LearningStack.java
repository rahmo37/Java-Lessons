package CollectionAndLists;

import java.util.Stack;

public class LearningStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<String>();

		// push() method adds elements to the stack
		stack.push("Anaconda");
		stack.push("Boy");
		stack.push("Candle");
		stack.push("Doll");
		stack.push("Elephant");

		// empty() method returns if the stack is empty or not
		System.out.println(stack.empty());

		// to search an elemet's position we use the search method
		// search method returns an int value so we can event assign it to an int
		// variable as well
		// int x = stack.search("Elephant");
		// System.out.println(x);
		System.out.println(stack.search("Elephant"));

		// removes the top most elements
		stack.pop();

		// using pop() method to assign the element to a different String
		//String alphabet = stack.pop();

		// use peek() method to look at the top most element of the stack
		// without removing it
		System.out.println(stack.peek());

		// to print all the element in the stack just print the stack directly
		System.out.println(stack);

		// USE =
		// Undo/Redo feature in text editor
		// Moving Backward and forward in browser history
		// Back tracking algorithms
		// Calling functions

	}

}
