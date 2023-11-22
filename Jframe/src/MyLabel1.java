import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class MyLabel1 extends JLabel {

	MyLabel1() {
		// Sets the text for label

		ImageIcon icon = new ImageIcon("PokeBall.png");
		Border border = BorderFactory.createLineBorder(Color.GREEN, 5);

		// Sets the text
		this.setText("Pokeball");

		// Sets the Icon in the label
		this.setIcon(icon);

		// Changes the text position of the label horizontally relative to the
		// image(Left,Right,Center)
		this.setHorizontalTextPosition(JLabel.RIGHT);

		// Changes the text position of the label vertically relative to the
		// image(Top,Bottom,Center)
		this.setVerticalTextPosition(JLabel.CENTER);

		// Changes the text color
		this.setForeground(Color.red);

		// Changes the font, its style and size
		this.setFont(new Font("Segoe Script", Font.BOLD, 20));

		// Sets the gap between the text and the image
		this.setIconTextGap(200);

		// Enables the Label's background color to take over
		// Otherwise if false, the Label's background color does not take effect
		this.setOpaque(false);

		// sets the label's background

		// By default a label takes the all the area in the frame
		this.setBackground(Color.black);

		// Adds a border to the label
		this.setBorder(border);

		// sets the alignment of the components within the Label
		// Vertically(Top,Bottom,Center)
		this.setVerticalAlignment(JLabel.CENTER);

		// sets the alignment of the components within the Label
		// Horizontally(Right,Left,Center);
		this.setHorizontalAlignment(JLabel.CENTER);

		// sets the label on the specified location and sets its size as-well
		// (x,y,w,h);
		this.setBounds(200, 200, 500, 500);

	}

}
