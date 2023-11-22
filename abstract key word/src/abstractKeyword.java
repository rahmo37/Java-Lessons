
public class abstractKeyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		car c = new car("black", "BMW", 4, "sedan");
		truck t = new truck("white", "Dodge", 8, "small");
		bicycle b = new bicycle("green", "BMX", 2);

		System.out.println(c.toString() + "\n" + t.toString() + "\n"  + b.toString());

	}

}
