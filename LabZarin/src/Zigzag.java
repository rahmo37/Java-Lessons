import java.util.Scanner;

public class Zigzag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		int min = 1;
		int max = 5;
		System.out.println("Random number of row and column from " + min + " to " + max + ":");

		int[][] mat1;
		
		int  p= (int) Math.floor(Math.random() * (max - min + 1) + min);

		System.out.println("The number of rows in 2d array = "+p);
		
          
		for (int i = 0; i < p; i++) {

			
			int q = (int) Math.floor(Math.random() * (max - min + 1) + min);

			System.out.println("The number of columns in 2d array = "+q);
			
			
			System.out.println("**********************");
			
			mat1 = new int[p][q];
		
			
			for (int j = 0; j <q; j++) 
			{
				 mat1[i][j] = in.nextInt();
				 
				System.out.println("arr[" + i + "][" + j + "] = " + mat1[i][j]);
			}
		
		}

	}

}
