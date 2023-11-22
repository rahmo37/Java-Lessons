
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//When Upcasted the object is able to all the attributes in its parent class
		//but cant access any attributes in its own class accept override method
		
		//Upcasting method 1
		Animal cat = new Cat();

		cat.makeNoise();

		//Upcasting method 2
		Dog dog = new Dog();
		doAnimalStuff(dog);
	}

	public static void doAnimalStuff(Animal animal) {
		animal.makeNoise();
	}

}
