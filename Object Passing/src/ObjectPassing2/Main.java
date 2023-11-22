package ObjectPassing2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1 = new Car("Hyundai", "Ioniq", 2019);

		// call the copy method by the no argument constructor
		Car car2 = new Car(car1);

		// or call the copy method itself
		car2.copy(car1);
		System.out.println(car1 + "\n\n" + car2);

	}

}
