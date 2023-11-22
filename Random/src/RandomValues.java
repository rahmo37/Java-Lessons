import java.util.Random;

public class RandomValues {

	public void randInt() {
		Random random = new Random();
		int x = random.nextInt(10);
		System.out.println("Random int is " + x);
	}

	public void randDouble() {
		Random random = new Random();
		double x = random.nextDouble(6);
		System.out.println("Random double is " + x);
	}

	public void randBoolean() {
		Random random = new Random();
		boolean x = random.nextBoolean();
		System.out.println("Random boolean is " + x);
	}

	public void randChar() {
		Random random = new Random();
		char x = (char) (random.nextInt(30) + '!');
		System.out.println("Random charecter is " + x);
	}

	public void randAlphabet() {
		Random random = new Random();
		String alpha = "abcdefghigklmnopqrstuvwzxy";
		int x = random.nextInt(alpha.length());
		char randAlpha = alpha.charAt(x);
		System.out.println("Random int which corresponedce to the random charecter :" + x);
		System.out.println("Random charcter from the list is " + randAlpha);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RandomValues rv = new RandomValues();

		rv.randInt();
		rv.randDouble();
		rv.randBoolean();
		rv.randChar();
		rv.randAlphabet();

		/*
		 * char variable take number to specify the character located in that position
		 * starting 97 = a, 98 = b, 99 = c, and so on....
		 */
		int in = 'Z';
		char ch = 97;
		System.out.println("Ascii value for Z is " + in);
		System.out.println("value 97 corresponece to " + ch);

	}

}
