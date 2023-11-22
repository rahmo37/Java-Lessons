
public class Arrays2d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
			String[][] pokemon = new String[3][6];

			pokemon[0][0] = "Legendary :";
			pokemon[0][1] = "Rayquaza";
			pokemon[0][2] = "Mewtwo";
			pokemon[0][3] = "Zygard";
			pokemon[0][4] = "Zekrom";
			pokemon[0][5] = "Kyogre";

			pokemon[1][0] = "Starter :";
			pokemon[1][1] = "Mudkip";
			pokemon[1][2] = "Torchik";
			pokemon[1][3] = "Treeko";
			pokemon[1][4] = "Charmendar";
			pokemon[1][5] = "Totodial";

			pokemon[2][0] = "Electric :";
			pokemon[2][1] = "Magnemite";
			pokemon[2][2] = "Electrike";
			pokemon[2][3] = "Rotom";
			pokemon[2][4] = "Raiku";
			pokemon[2][5] = "Luxary";

			for (String[] a : pokemon) {
				System.out.println("Hi");
				for (String b : a ) {
					System.out.print(b + " ");
				}
			}
		}
		
		{
			String[][] cars = 
			{
					{"\nNissan","Toyota","Hyndai"},
					{"Lexus","Infinity","Jeep"},
					{"Lamborghini","Ferrari","BMW"}
					
			};
			
			for (int i = 0; i < cars.length; i++) {
				System.out.println();
				for (int j = 0; j < cars[i].length; j++) {
					System.out.print(cars[i][j] + " ");
				}

			}
		}

	}

}
