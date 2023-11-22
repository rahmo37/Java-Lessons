package design;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UserLoginDesign extends JFrame {
	public JTextField IdTextField;
	public JLabel EnterIdLabel;
	public JLabel UserLoginLabel;
	JLabel BackgroundLabel;
	public JButton userLoginButton;
	public JLabel statusLabel;

	public UserLoginDesign() {
		initialize();
		this.getContentPane().setLayout(null);
		this.setBounds(100, 100, 1270, 790);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().add(statusLabel);
		this.getContentPane().add(userLoginButton);
		this.getContentPane().add(IdTextField);
		this.getContentPane().add(EnterIdLabel);
		this.getContentPane().add(UserLoginLabel);
		this.getContentPane().add(BackgroundLabel);
	}

	private void initialize() {

		statusLabel = new JLabel();
		statusLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		statusLabel.setBounds(476, 469, 778, 81);

		userLoginButton = new JButton("Login");
		userLoginButton.setBounds(641, 392, 89, 23);

		IdTextField = new JTextField("2022-1-60-267");
		IdTextField.setFont(new Font("Times New Roman", Font.HANGING_BASELINE, 25));
		IdTextField.setForeground(new Color(0, 0, 0));
		IdTextField.setBackground(new Color(255, 255, 255));
		IdTextField.setBounds(601, 312, 168, 46);
		IdTextField.setColumns(10);

		EnterIdLabel = new JLabel("Enter Student ID: ");
		EnterIdLabel.setFont(new Font("Times New Roman", Font.HANGING_BASELINE, 20));
		EnterIdLabel.setForeground(new Color(255, 255, 255));
		EnterIdLabel.setBounds(416, 301, 185, 73);

		UserLoginLabel = new JLabel("User Login");
		UserLoginLabel.setForeground(new Color(255, 255, 255));
		UserLoginLabel.setBounds(504, 47, 233, 81);
		UserLoginLabel.setFont(new Font("Times New Roman", Font.HANGING_BASELINE, 50));

		BackgroundLabel = new JLabel("");
		BackgroundLabel.setForeground(new Color(0, 0, 0));
		BackgroundLabel.setBounds(0, 0, 1254, 751);
		BackgroundLabel.setOpaque(true);
		BackgroundLabel.setBackground(new Color(128, 128, 128));
	}
}
