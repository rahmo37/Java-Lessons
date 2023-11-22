package design;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class customizeMember extends JFrame {

	Container c;
	public JButton pendingRequestBTN;
	public JButton searchBTN;
	public JButton removeBTN;
	public JButton addBTN;
	JLabel taitleLBL;
	JLabel backgroundLBL;
	private JLabel addLBL;
	private JLabel removeLBL;
	private JLabel searchLBL;
	private JLabel prLBL;

	public customizeMember() {
		setBounds(500, 100, 1260, 788);
		initialize();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void initialize() {
		c = this.getContentPane();
		getContentPane().setLayout(null);
		formatButtons();
		formatLabels();
		c.add(addLBL);
		c.add(removeLBL);
		c.add(prLBL);
		c.add(searchLBL);
		c.add(pendingRequestBTN);
		c.add(searchBTN);
		c.add(removeBTN);
		c.add(addBTN);
		c.add(taitleLBL);
		c.add(backgroundLBL);
	}

	public void formatButtons() {
		pendingRequestBTN = new JButton("");
		pendingRequestBTN.setBounds(805, 477, 234, 168);

		searchBTN = new JButton("");
		searchBTN.setBounds(221, 477, 234, 168);

		removeBTN = new JButton("");
		removeBTN.setBounds(805, 175, 234, 168);

		addBTN = new JButton("");
		addBTN.setBounds(221, 175, 234, 168);

	}

	public void formatLabels() {
		taitleLBL = new JLabel("<HTML>Add - Remove - Search for a Member Or approve a Pending Request<HTML>");
		taitleLBL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		taitleLBL.setBounds(331, 38, 612, 87);

		addLBL = new JLabel("ADD");
		addLBL.setBounds(323, 354, 46, 14);

		removeLBL = new JLabel("REMOVE");
		removeLBL.setBounds(900, 354, 90, 14);

		searchLBL = new JLabel("SEARCH");
		searchLBL.setBounds(313, 656, 75, 14);

		prLBL = new JLabel("PENDING REQUEST");
		prLBL.setBounds(877, 651, 154, 25);

		backgroundLBL = new JLabel("");
		backgroundLBL.setOpaque(true);
		backgroundLBL.setBackground(new Color(192, 192, 192));
		backgroundLBL.setBounds(0, 11, 1245, 745);

	}
	
}
