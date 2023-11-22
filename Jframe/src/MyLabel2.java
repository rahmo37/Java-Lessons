import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyLabel2 extends JLabel{

	MyLabel2() {
		//Creates an image icon
		ImageIcon icon = new ImageIcon("ig.png");
		//sets the image icon for label 2
		this.setIcon(icon);
		
		//sets the text of label 2
		this.setText("Hi");
		
		//sets the alignment of the component vertically
		this.setVerticalAlignment(JLabel.BOTTOM);
		
		//sets the alignment of the component horizontally
		this.setHorizontalAlignment(JLabel.CENTER);
		
		
	}
}
