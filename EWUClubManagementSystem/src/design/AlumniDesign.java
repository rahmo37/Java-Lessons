package design;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author ASUS
 */
public class AlumniDesign extends JFrame {
// Declearing variables 
	private ImageIcon icon;
	private JLabel heading, time, dateShow;
	private Container c;
	private Font f;

	JTextPane textPane;
	JLabel l3;

	JButton savebutton;

	public AlumniDesign() {
		setTitle("ALUMNI PANEL");

		setBounds(500, 100, 800, 800); // setsize + set location;
		c = this.getContentPane();
		setTime();

		c.add(time);
		c.add(dateShow);

	}

	// User Alumni
	public void userAlumni() {
		iniUserComp();
		closing();
	}

//  ....................Initializing Components .....................// 
	public void iniUserComp() {

		icon = new ImageIcon("download.jpg"); // icon
		this.setIconImage(icon.getImage());

		f = new Font("Times New Roman", Font.HANGING_BASELINE, 20);

		heading = new JLabel();
		heading.setText("WELCOME TO ALUMNI PANEL");
		heading.setBounds(250, 60, 500, 20);
		heading.setFont(f);
		heading.setForeground(Color.CYAN);

		c.add(heading);
		userShowMessage();
		c.add(textPane);
		c.setBackground(Color.BLACK);

		l3 = new JLabel(new ImageIcon("smokenew.gif"));

		l3.setBounds(0, 150, 800, 800);

		c.add(l3);
		c.setLayout(null);

	}

	public void userShowMessage() {
		textPane = new JTextPane();
		File file = new File("Alumni.txt");
		textPane.setBounds(180, 150, 420, 300);
		textPane.setEditable(false);

		try {
			// Read the contents of the file into a string
			String content = new String(Files.readAllBytes(file.toPath()));
			// Set the text of the text pane to the contents of the file
			textPane.setText(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void adminAlumni() {
		iniAdminComp();
		closing();

	}

	public void iniAdminComp() {

		c = this.getContentPane();
		icon = new ImageIcon("download.jpg"); // icon
		this.setIconImage(icon.getImage());

		f = new Font("Times New Roman", Font.HANGING_BASELINE, 20);

		heading = new JLabel();
		heading.setText("WELCOME TO ALUMNI PANEL");
		heading.setBounds(250, 60, 500, 20);
		heading.setFont(f);
		heading.setForeground(Color.CYAN);

		c.add(heading);
		adminEditMessage();
		c.add(textPane);
		c.add(savebutton);
		c.setBackground(Color.BLACK);

		l3 = new JLabel(new ImageIcon("smokenew.gif"));

		l3.setBounds(0, 150, 800, 800);

		c.add(l3);
		c.setLayout(null);

	}

	public void adminEditMessage() {
		try {
			textPane = new JTextPane();
			File file = new File("Alumni.txt");
			textPane.setBounds(180, 150, 420, 300);
			// Read the contents of the file into a string
			String content = new String(Files.readAllBytes(file.toPath()));
			// Set the text of the text pane to the contents of the file
			textPane.setText(content);

			savebutton = new JButton("Save");
			savebutton.setBounds(650, 200, 80, 50);

// Add an action listener to the button
			savebutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Get the text from the text pane
					String text = textPane.getText();

					// Write the text to the file, appending to the end of the file
					try {
						BufferedWriter fw = new BufferedWriter(new FileWriter("Alumni.txt"));
						fw.write(text);
						fw.close();
					} catch (IOException ef) {
						// handle the exception
					}

				}
			});
		} catch (Exception e) {

		}

	}

	public void setTime() {
		time = new JLabel("TIME :");
		time.setBounds(600, 40, 49, 14);
		time.setForeground(Color.CYAN);

		dateShow = new JLabel("");
		dateShow.setBounds(600, 60, 182, 14);
		dateShow.setForeground(Color.CYAN);

		Date dt = new Date();

		String dat = String.valueOf(dt);
		dateShow.setText(dat);

	}

	public void closing() {
		setResizable(false);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) throws IOException {
		AlumniDesign alumni = new AlumniDesign();
	}

}