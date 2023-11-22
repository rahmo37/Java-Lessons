import javax.swing.JOptionPane;


public class JOptionpane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//JOption pane always takes strings
		String name = JOptionPane.showInputDialog("What is you name??");
		
		int age = Integer.parseInt(JOptionPane.showInputDialog("How old are you")); 

		
		double height = Double.parseDouble(JOptionPane.showInputDialog("What is your height??")); 
		
		
		
		JOptionPane.showMessageDialog(null, "Your name is : " + name + 
				"\nYour age :" + age + "\nYour height :" + height);
		
		

	}

}
