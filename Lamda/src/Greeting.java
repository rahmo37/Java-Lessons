/**
 * 
 */

/**
 * @author pokeo
 *
 */
public class Greeting {
	public void Greet(Greeter greet) {
		greet.perform();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HelloWorld hw = new HelloWorld();
		Greeting greeting = new Greeting();
		
		

		greeting.Greet(hw);
	}

}
