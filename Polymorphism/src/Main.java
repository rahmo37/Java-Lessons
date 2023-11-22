
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();
		Bike bike = new Bike();
		Truck truck = new Truck();
		
		Vehicle[] race = {car,bike,truck};
		
//		for(int i = 0; i < race.length; i++) {
//			race[i].go();
//		}
		
		for (Vehicle v : race) {
			v.go();
		}
	}

}
