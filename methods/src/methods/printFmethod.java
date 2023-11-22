package methods;
import javax.swing.*;


public class printFmethod {

	public static void main(String[] args) {

		// printf() = a optional method to control, format and display text to the
		// console window
		// takes two arguments = format String + (object/variable/value);
		// syntax = (format specifier)% [Flags] [precision] [width]
		// [conversion-character]

		System.out.printf("First example : %d \n", 456);

		// conversion-character(b,d,c,f,s)
		boolean b = true;
		System.out.printf("its a boolean value %b \n", b);

		int i = 123;
		System.out.printf("its a decimal/integer value %d \n", i);

		char c = 'n';
		System.out.printf("its a character value %c \n", c);

		double d = 12560.564654654654;
		System.out.printf("its a double/float value %f \n", d);

		String s = "Arnob";
		System.out.printf("its a String value %s \n", s);

		// width
		// space before the specified value

		System.out.printf("Hello %10s \n", s);

		// precision (float or double)
		// .2 represents the decimal place

		System.out.printf("Money amount %.4f \n", d);
		JOptionPane.showMessageDialog(null, String.format("Money amount %.2f", d), "Hi", JOptionPane.PLAIN_MESSAGE );
		// flags
		// left-justify/space after the specified value
		System.out.printf("hello %-20s \n", s);

		// show sign before a double or int value

		System.out.printf("i have %+d \n", i);
		System.out.printf("i have %+f \n", d);

		// padding 0

		System.out.printf("i have %020d \n", i);

		// comma (automatically places comma in 1000th place)

		System.out.printf("i have %,f", d);

	}

}
