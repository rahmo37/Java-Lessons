package variableScope;

import java.util.Random;

public class diceRoller1 {
	
	diceRoller1() {
		Random random = new Random();
		int number = 0;
		roll(number,random);
	}
	
	//int and random variables are not visible to method roll
	//thats why we passed parameter to the roll method in the constructor
	
	void roll (int number, Random random){
		
		number = random.nextInt(6)+1;
		System.out.println(number);
	}
}
