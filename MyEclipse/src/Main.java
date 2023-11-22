import java.util.Scanner;

//import javax.swing.JOptionPane;
public class Main {

	boolean a;
	int b;
	long c;
	byte d;
	double e;
	String f;
	char g;
	short h;
	float i;

	public void DataTypes() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the value for a : (Boolean)");
		a = scanner.nextBoolean();

		System.out.println("Enter the value for b : (int)");
		b = scanner.nextInt();
		
		System.out.println("Enter the value for c : (long)");
		c = scanner.nextLong();
		
		System.out.println("Enter the value for d : (Byte)");
		d = scanner.nextByte();
		
		System.out.println("Enter the value for e : (Double)");
		e = scanner.nextDouble();
		
		System.out.println("Enter the value for f : (String)");
		f = scanner.next();
		scanner.next();
		
		System.out.println("Enter the value for g : (Char)");
		g = scanner.next().charAt(0);
		
		System.out.println("Enter the value for h : (Short)");
		h = scanner.nextShort();
		
		System.out.println("Enter the value for i : (Float)");
		i = scanner.nextFloat();
		
		System.out.println("boolean " + a + "\n\nInt " + b + "\n\nLong " + c + "\n\nByte " + d + "\n\nDouble " + e + 
		"\n\nString " + f + "\n\nCharecter " + g + "\n\nShort " + h + "\n\nFloat " + i);
		
		
		
		
	}

	public static void main(String args[]) {
		Main m = new Main();
		m.DataTypes();

	}

}
