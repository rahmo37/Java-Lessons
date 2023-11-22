package variableScope;

import java.util.Random;

public class diceRoller2 {
	
	int number;
	Random random;
	
	diceRoller2() {
		roll();
	}
	
	void roll() {
		random = new Random();
		
		number = random.nextInt(6)+1;
		System.out.println(number);
	}

}
