
public class Method {
	static int x = 5;
	static int y = 6;

	
	public static void main(String[] args) {
		System.out.println("add method :" + add());
		System.out.println("subtract method :" + subtract());
		System.out.println(add() +  subtract());
		print();
		
		
	}
	
	// add() = x + y
	
	public static int add() {

		return x + y;
	}
	
	public static int subtract() {
		return y - x;
	}
	
	//print() = x + y
	
	public static void print() {
		System.out.println(x+y);
	}
}
