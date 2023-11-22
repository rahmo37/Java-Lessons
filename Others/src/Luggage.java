import java.util.Scanner;


public class Luggage {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		double x = 0;
		double y = 0;
		
		System.out.printf("\nLuggage weigth is : %d Kg",(int)weightCalculator(x,y));

	}
	
	public static double weightCalculator(double totalWeigth, double yourWeight) {
		System.out.println("What is the total weigth?? (you + luggage) :");
		totalWeigth = scanner.nextDouble()/ 2.2;
		System.out.printf("Or %.2f KG\n",totalWeigth);
		
		System.out.println("What is your weight??");
		yourWeight = scanner.nextDouble()/ 2.2;
		
		System.out.printf("Or %.2f KG\n",yourWeight);
		
		double luggageWeight = totalWeigth - yourWeight;
		return luggageWeight;
		
		
	}

}
