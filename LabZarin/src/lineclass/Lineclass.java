package lineclass;

import java.util.Scanner;

class Lineclass {
	static Line[] line1 = new Line[4];

	static boolean isIntersecting(Line line1, Line line2) {
		if (line1.findslope() == line2.findslope()) {

			return false;
		} else {

			return true;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 2; i++) {

			line1[i] = new Line();
			System.out.println("Enter the Value of X1: ");
			line1[i].setX1(sc.nextInt());
			System.out.println("Enter the Value of Y1: ");
			line1[i].setY1(sc.nextInt());

			System.out.println("Enter the Value of X2: ");
			line1[i].setX2(sc.nextInt());
			System.out.println("Enter the Value of Y2: ");
			line1[i].setY2(sc.nextInt());

		}

		System.out.println(isIntersecting(line1[0], line1[1]));

	}

}
