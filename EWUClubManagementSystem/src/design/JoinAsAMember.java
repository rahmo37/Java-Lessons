package design;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JoinAsAMember extends JFrame {

	public JTextField noOfSemesterTF;
	public JTextField positionTF;
	public JTextField departmentTF;
	public JTextField bloodGroupTF;
	public JTextField emailTF;
	public JTextField phoneTF;
	public JTextField studentidTF;
	public JTextField nameTF;
	JLabel phoneLB;
	JLabel noOfSemesterLB;
	JLabel emailLB;
	JLabel bloodGroupLB;
	JLabel positionLB;
	JLabel departmentLB;
	JLabel studentIdLB;
	JLabel nameLB;
	JLabel statusLabel;
	JLabel backGroundLabel;
	public JButton submitButton;

	public JoinAsAMember() {
		this.setBounds(100, 100, 1270, 790);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		formatButtonAndLabel();
		this.getContentPane().setLayout(null);
		this.getContentPane().add(submitButton);
		this.getContentPane().add(bloodGroupTF);
		this.getContentPane().add(phoneTF);
		this.getContentPane().add(studentidTF);
		this.getContentPane().add(emailTF);
		this.getContentPane().add(nameTF);
		this.getContentPane().add(departmentTF);
		this.getContentPane().add(positionTF);
		this.getContentPane().add(noOfSemesterTF);
		this.getContentPane().add(backGroundLabel);
		this.getContentPane().add(bloodGroupLB);
		this.getContentPane().add(phoneLB);
		this.getContentPane().add(studentIdLB);
		this.getContentPane().add(emailLB);
		this.getContentPane().add(nameLB);
		this.getContentPane().add(departmentLB);
		this.getContentPane().add(positionLB);
		this.getContentPane().add(noOfSemesterLB);
		this.getContentPane().add(statusLabel);
		this.getContentPane().add(backGroundLabel);
		this.setVisible(true);
		this.setResizable(false);
	}

	public void formatButtonAndLabel() {
		submitButton = new JButton("Submit");
		submitButton.setBounds(625, 700, 89, 23);

		bloodGroupTF = new JTextField();
		bloodGroupTF.setColumns(10);
		bloodGroupTF.setBounds(628, 558, 86, 20);

		phoneTF = new JTextField();
		phoneTF.setColumns(10);
		phoneTF.setBounds(628, 329, 86, 20);

		studentidTF = new JTextField();
		studentidTF.setColumns(10);
		studentidTF.setBounds(628, 267, 86, 20);

		emailTF = new JTextField();
		emailTF.setColumns(10);
		emailTF.setBounds(628, 386, 86, 20);

		nameTF = new JTextField();
		nameTF.setColumns(10);
		nameTF.setBounds(628, 212, 86, 20);

		departmentTF = new JTextField();
		departmentTF.setColumns(10);
		departmentTF.setBounds(628, 445, 86, 20);

		positionTF = new JTextField();
		positionTF.setColumns(10);
		positionTF.setBounds(628, 503, 86, 20);

		noOfSemesterTF = new JTextField();
		noOfSemesterTF.setBounds(628, 617, 86, 20);
		noOfSemesterTF.setColumns(10);

		phoneLB = new JLabel("Phone:");
		phoneLB.setForeground(new Color(255, 255, 255));
		phoneLB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phoneLB.setBounds(433, 307, 128, 57);

		noOfSemesterLB = new JLabel("No. Of Semester:");
		noOfSemesterLB.setForeground(new Color(255, 255, 255));
		noOfSemesterLB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		noOfSemesterLB.setBounds(433, 595, 161, 57);

		emailLB = new JLabel("Email:");
		emailLB.setForeground(new Color(255, 255, 255));
		emailLB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emailLB.setBounds(433, 364, 128, 57);

		bloodGroupLB = new JLabel("Blood Group:");
		bloodGroupLB.setForeground(new Color(255, 255, 255));
		bloodGroupLB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bloodGroupLB.setBounds(433, 536, 128, 57);

		positionLB = new JLabel("Position:");
		positionLB.setForeground(new Color(255, 255, 255));
		positionLB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		positionLB.setBounds(433, 481, 128, 57);

		departmentLB = new JLabel("Department:");
		departmentLB.setForeground(new Color(255, 255, 255));
		departmentLB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		departmentLB.setBounds(433, 423, 128, 57);

		studentIdLB = new JLabel("Student ID:");
		studentIdLB.setForeground(new Color(255, 255, 255));
		studentIdLB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		studentIdLB.setBounds(433, 251, 112, 45);

		nameLB = new JLabel("Name: ");
		nameLB.setForeground(new Color(255, 255, 255));
		nameLB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameLB.setBounds(433, 196, 75, 45);

		statusLabel = new JLabel("Join as a Member");
		statusLabel.setForeground(new Color(0, 255, 128));
		statusLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		statusLabel.setBounds(447, 25, 276, 78);

		backGroundLabel = new JLabel("");
		backGroundLabel.setForeground(new Color(0, 0, 0));
		backGroundLabel.setBounds(0, 0, 1254, 751);
		backGroundLabel.setOpaque(true);
		backGroundLabel.setBackground(new Color(128, 128, 128));
	}
}
