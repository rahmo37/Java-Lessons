import java.util.Scanner;

public class hypotenuse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x;
		double y;
		double z;

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter side x :");
		x = sc.nextDouble();

		System.out.println("Enter side y :");
		y = sc.nextDouble();

		z = Math.sqrt(Math.pow(x,2) + Math.pow(y,2) );


		System.out.println("The hypotenuse is : " + z);

	}

}
