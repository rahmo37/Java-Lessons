package overLoadedConstructor;

public class overLoadedConstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		pizza p1 = new pizza("HandTossed", "Marinara");
		count++;
		System.out.println("Ingredients for your pizza :" + count);
		System.out.println(p1.dough + "\n" );
		
		pizza p2 = new pizza("HandTossed", "Marinara");
		count++;
		System.out.println("Ingredients for your pizza :" + count);
		System.out.println(p2.dough + "\n" + p2.sauce + "\n");
		
		pizza p3 = new pizza("HandTossed", "Marinara", "Black Olives");
		count++;
		System.out.println("Ingredients for your pizza :" + count);
		System.out.println(p3.dough + "\n" + p3.sauce + "\n" + p3.topping + "\n");
		
		pizza p4 = new pizza("HandTossed", "Marinara", "Black Olives", "American");
		count++;
		System.out.println("Ingredients for your pizza :" + count);
		System.out.println(p4.dough + "\n" + p4.sauce + "\n" + p4.topping + "\n" + p4.cheese + "\n");
	}

}
