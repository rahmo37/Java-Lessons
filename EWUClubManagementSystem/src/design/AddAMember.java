package design;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddAMember extends JFrame {

	public JTextField noOfSemesterTF;
	public JTextField positionTF;
	public JTextField departmentTF;
	public JTextField bloodGroupTF;
	public JTextField emailTF;
	public JTextField phoneTF;
	public JTextField studentidTF;
	public JTextField nameTF;
	public JTextField voteTF;
	public JTextField noOfMonthsTF;
	public JTextField isAdminTF;
	public JButton submitButton;
	JLabel phoneLB;
	JLabel noOfSemesterLB;
	JLabel emailLB;
	JLabel bloodGroupLB;
	JLabel positionLB;
	JLabel departmentLB;
	JLabel studentIdLB;
	JLabel nameLB;
	JLabel statusLabel;
	private JLabel voteLBL;
	private JLabel noOfMonthsLBL;
	private JLabel isAdminLBL;

	public AddAMember() {
		formatButtonAndLabel();
		this.getContentPane().setBackground(new Color(192, 192, 192));
		this.setResizable(false);
		this.setTitle("Pending Requests");
		this.setBounds(0, 0, 1099, 776);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(true);
		getContentPane().setLayout(null);

		isAdminTF = new JTextField();
		isAdminTF.setColumns(10);
		isAdminTF.setBounds(631, 635, 134, 20);
		getContentPane().add(isAdminTF);

		voteTF = new JTextField();
		voteTF.setColumns(10);
		voteTF.setBounds(631, 530, 134, 20);
		getContentPane().add(voteTF);

		noOfMonthsTF = new JTextField();
		noOfMonthsTF.setColumns(10);
		noOfMonthsTF.setBounds(631, 583, 134, 20);
		getContentPane().add(noOfMonthsTF);
		this.getContentPane().add(submitButton);
		this.getContentPane().add(bloodGroupTF);
		this.getContentPane().add(phoneTF);
		this.getContentPane().add(studentidTF);
		this.getContentPane().add(emailTF);
		this.getContentPane().add(nameTF);
		this.getContentPane().add(departmentTF);
		this.getContentPane().add(positionTF);
		this.getContentPane().add(noOfSemesterTF);
		this.getContentPane().add(bloodGroupLB);
		this.getContentPane().add(phoneLB);
		this.getContentPane().add(studentIdLB);
		this.getContentPane().add(emailLB);
		this.getContentPane().add(nameLB);
		this.getContentPane().add(departmentLB);
		this.getContentPane().add(positionLB);
		this.getContentPane().add(noOfSemesterLB);
		this.getContentPane().add(statusLabel);

		voteLBL = new JLabel("Vote:");
		voteLBL.setForeground(Color.WHITE);
		voteLBL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		voteLBL.setBounds(436, 508, 161, 57);
		getContentPane().add(voteLBL);

		noOfMonthsLBL = new JLabel("No. Of Months:");
		noOfMonthsLBL.setForeground(Color.WHITE);
		noOfMonthsLBL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		noOfMonthsLBL.setBounds(436, 561, 161, 57);
		getContentPane().add(noOfMonthsLBL);

		isAdminLBL = new JLabel("IsAdmin:");
		isAdminLBL.setForeground(Color.WHITE);
		isAdminLBL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		isAdminLBL.setBounds(436, 613, 161, 57);
		getContentPane().add(isAdminLBL);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(128, 128, 128));
		lblNewLabel.setBounds(0, 0, 1083, 737);
		getContentPane().add(lblNewLabel);
	}

	public void formatButtonAndLabel() {
		submitButton = new JButton("Submit");
		submitButton.setBounds(652, 703, 89, 23);

		bloodGroupTF = new JTextField();
		bloodGroupTF.setBounds(631, 424, 134, 20);
		bloodGroupTF.setColumns(10);

		phoneTF = new JTextField();
		phoneTF.setBounds(631, 212, 134, 20);
		phoneTF.setColumns(10);

		studentidTF = new JTextField();
		studentidTF.setBounds(631, 159, 134, 20);
		studentidTF.setColumns(10);

		emailTF = new JTextField();
		emailTF.setBounds(631, 265, 134, 20);
		emailTF.setColumns(10);

		nameTF = new JTextField();
		nameTF.setBounds(631, 112, 134, 20);
		nameTF.setColumns(10);

		departmentTF = new JTextField();
		departmentTF.setBounds(631, 318, 134, 20);
		departmentTF.setColumns(10);

		positionTF = new JTextField();
		positionTF.setBounds(631, 371, 134, 20);
		positionTF.setColumns(10);

		noOfSemesterTF = new JTextField();
		noOfSemesterTF.setBounds(631, 477, 134, 20);
		noOfSemesterTF.setColumns(10);

		phoneLB = new JLabel("Phone:");
		phoneLB.setBounds(436, 190, 128, 57);
		phoneLB.setForeground(new Color(255, 255, 255));
		phoneLB.setFont(new Font("Tahoma", Font.PLAIN, 20));

		noOfSemesterLB = new JLabel("No. Of Semester:");
		noOfSemesterLB.setBounds(436, 455, 161, 57);
		noOfSemesterLB.setForeground(new Color(255, 255, 255));
		noOfSemesterLB.setFont(new Font("Tahoma", Font.PLAIN, 20));

		emailLB = new JLabel("Email:");
		emailLB.setBounds(436, 243, 128, 57);
		emailLB.setForeground(new Color(255, 255, 255));
		emailLB.setFont(new Font("Tahoma", Font.PLAIN, 20));

		bloodGroupLB = new JLabel("Blood Group:");
		bloodGroupLB.setBounds(436, 402, 128, 57);
		bloodGroupLB.setForeground(new Color(255, 255, 255));
		bloodGroupLB.setFont(new Font("Tahoma", Font.PLAIN, 20));

		positionLB = new JLabel("Position:");
		positionLB.setBounds(433, 349, 128, 57);
		positionLB.setForeground(new Color(255, 255, 255));
		positionLB.setFont(new Font("Tahoma", Font.PLAIN, 20));

		departmentLB = new JLabel("Department:");
		departmentLB.setBounds(436, 296, 128, 57);
		departmentLB.setForeground(new Color(255, 255, 255));
		departmentLB.setFont(new Font("Tahoma", Font.PLAIN, 20));

		studentIdLB = new JLabel("Student ID:");
		studentIdLB.setBounds(436, 143, 112, 45);
		studentIdLB.setForeground(new Color(255, 255, 255));
		studentIdLB.setFont(new Font("Tahoma", Font.PLAIN, 20));

		nameLB = new JLabel("Name: ");
		nameLB.setBounds(436, 96, 75, 45);
		nameLB.setForeground(new Color(255, 255, 255));
		nameLB.setFont(new Font("Tahoma", Font.PLAIN, 20));

		statusLabel = new JLabel("Add a Member");
		statusLabel.setBackground(new Color(0, 0, 0));
		statusLabel.setBounds(465, 7, 276, 78);
		statusLabel.setForeground(new Color(0, 0, 255));
		statusLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
	}

	public static void main(String[] args) {
		AddAMember am = new AddAMember();

	}
}
