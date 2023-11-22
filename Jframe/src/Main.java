import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLabel1 label1 = new MyLabel1();
		MyLabel2 label2 = new MyLabel2();
		MyLabel3 label3 = new MyLabel3();

		
		BluePanel bluePanel = new BluePanel();
		GreenPanel greenPanel = new GreenPanel();
		RedPanel redPanel = new RedPanel(label2);
		

		new MyFrame(label1, redPanel, bluePanel, greenPanel);

	}

}
