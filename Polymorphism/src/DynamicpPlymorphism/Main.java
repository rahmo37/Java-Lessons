package DynamicpPlymorphism;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pokemon pokemon;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your choice");
		System.out.println("1 for Toxapex, 2 for Charizard, 3 for Umbreon");
		int x = scanner.nextInt();

		
		if(x == 1) {
			pokemon = new Toxapex();
			pokemon.type();
			pokemon.test();
		}
		else if(x == 2) {
			pokemon = new Charizard();
			pokemon.type();
		}
		else if(x == 3) {
			pokemon = new Umbreon();
			pokemon.type();
		}
		else {
			System.out.println("pokemon not listed");
		}
		
	}

}
