import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GreenPanel extends JPanel {
	
	GreenPanel() {
		
		//this keyword before the methods means,
		//that the methods are for the object that will be passed from the main method
		
		//sets the background color of Panel
		this.setBackground(Color.green);
		
		//sets the panel's position and the size
		this.setBounds(0, 250, 500, 300);

	}
	
//OverLoaded constructor	
	GreenPanel(MyLabel2 label2) {
		
		//this keyword before the methods means,
		//that the methods are for the object that will be passed from the main method
		
		//sets the background color of Panel
		this.setBackground(Color.green);
		
		//sets the panel's position and the size
		this.setBounds(250, 250, 500, 500);
		
		//sets the layout of the panel
		this.setLayout(new BorderLayout());

		
		//add the label to the panel
		this.add(label2);
		
		
	}
}
