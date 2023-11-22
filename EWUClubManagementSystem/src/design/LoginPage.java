package design;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPage extends JFrame {

	public JLabel promptForIdLabel = new JLabel();
	public JLabel resultLabel = new JLabel();
	public JPanel panel = new JPanel();
	public JTextField IdTextField = new JTextField("12341-12-123");
	final int WIDTH = 1080;
	final int HEIGHT = 720;

	public LoginPage() {

		formatPanel();
		this.setTitle("Login Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		//this.add(panel);
	}

	public void formatIdTextField() {
		IdTextField.setBounds(WIDTH / 5 + 155, HEIGHT / 6 + 75, 150, 45);
		IdTextField.setFont(new Font("MV Boli", Font.PLAIN, 20));
	}

	public void formatPrompForIdLabel() {
		promptForIdLabel.setBounds(WIDTH / 4, HEIGHT / 6, 200, 200);
		promptForIdLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
	}

	public void formatResultLabel() {
		resultLabel.setBounds(WIDTH / 4, HEIGHT / 4, 200, 200);
		resultLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
	}

	public void formatPanel() {
		formatPrompForIdLabel();
		formatIdTextField();
		formatResultLabel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		panel.setBounds(0, 0, WIDTH, HEIGHT - 200);
		panel.add(promptForIdLabel);
		panel.add(IdTextField);
		panel.add(resultLabel);
	}

}
