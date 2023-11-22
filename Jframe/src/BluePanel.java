import java.awt.Color;

import javax.swing.JPanel;

public final class BluePanel extends JPanel{

	BluePanel() {
		this.setBackground(Color.blue);
		this.setBounds(250, 0, 250, 250);
	}
	
	BluePanel(MyLabel2 label2) {
		this.setBackground(Color.blue);
		this.setBounds(250, 0, 250, 250);
		this.add(label2);
	}


}
