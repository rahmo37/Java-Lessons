
public class PrintAnything<T> {
	/*
	 * T represenets Type. Y You can send in any type of object in this class and
	 * work with it
	 */

	T printObject;

	public PrintAnything(T printObject) {
		this.printObject = printObject;
	}

	public int add() {
		int x = (int) printObject + 5;
		return x;
	}

	public void print() {
		System.out.println(printObject);
	}
}
