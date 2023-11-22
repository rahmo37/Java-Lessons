import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class RedPanel extends JPanel {

	RedPanel() {
		this.setBackground(Color.red);
		this.setBounds(0, 0, 250, 250);
	}

	// OverLoaded constructor
	RedPanel(MyLabel2 label2) {
		this.setBackground(Color.red);
		this.setBounds(500,0 , 500, 700);
		this.setLayout(new BorderLayout());
		this.add(label2);
		
	}
	
	RedPanel(MyLabel3 label3) {
		this.setBackground(Color.red);
		this.setBounds(0, 0, 250, 250);
		this.add(label3);
	}
}
