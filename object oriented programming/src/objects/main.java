package objects;

public class main {

	public static void main(String[] args) {

		{
			Car car1 = new Car();

			System.out.println(car1);
			car1.drive();
			car1.model();
		}
		
		{
			Car car2 = new Car();

			System.out.println(car2);
			car2.drive();
			car2.model();
		}
		
		//no Matter how many objects you create 
		//it will return the same values for each objects
		
		//Thats why we need a constructor. 
		//constructor helps us to pass-in unique values for each variables
	}

}
