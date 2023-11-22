import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyLabel3 extends JLabel {
	MyLabel3() {
		ImageIcon icon = new ImageIcon("food.png");
		this.setIcon(icon);

		this.setText("Cookie");

		
	}
}
