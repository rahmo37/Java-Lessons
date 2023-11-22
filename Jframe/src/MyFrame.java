import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
	MyFrame(MyLabel1 label1, RedPanel redPanel, BluePanel bluePanel, GreenPanel greenPanel) {
		// JFrame is a GUI window

		// sets the visibility of the this
		this.setVisible(true);

		// sets the this's title
		this.setTitle("Java Frame");

		// Exit when red cross is clicked
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

		// Prevent resizing of the this
		this.setResizable(true);

		// Changes the Icon of the this
		ImageIcon icon = new ImageIcon("tw.png");
		this.setIconImage(icon.getImage());

		// Change Background color with default color or custom color
		this.getContentPane().setBackground(new Color(0, 0, 0));

		// makes the default layout to be null
		this.setLayout(null);

		// sets the size of the this
		this.setSize(1400, 800);

		// Add components to the frame
		//this.add(label1);
		this.add(redPanel);

		//this.add(bluePanel);

		this.add(greenPanel);

		// adjusts the frame to stick with its components
		// this.pack();

	}

}
