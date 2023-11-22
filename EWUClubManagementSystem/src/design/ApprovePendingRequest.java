package design;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import java.awt.Insets;
import javax.swing.JLabel;

public class ApprovePendingRequest extends JFrame {
	public JTable table = new JTable();
	Object[] column = { "Name", "Student Id" };
	Object[] row = new Object[2];
	public DefaultTableModel model;
	JScrollPane pane;
	public JTextArea textArea;
	public JButton addBTN;
	public JButton rejectBTN;
	JLabel descriptionLBL;
	JLabel pendingReqLBL;

	public ApprovePendingRequest() {
		formatButtonAndOthers();
		formatTable();
		this.setResizable(false);
		this.setTitle("Pending Requests");
		this.getContentPane().setLayout(null);
		this.setBounds(0, 0, 1099, 776);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.getContentPane().add(pane);
		this.getContentPane().add(textArea);
		this.getContentPane().add(rejectBTN);
		this.getContentPane().add(addBTN);
		this.getContentPane().add(pendingReqLBL);
		this.getContentPane().add(descriptionLBL);
	}

	public void formatButtonAndOthers() {
		rejectBTN = new JButton("Reject");
		rejectBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rejectBTN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rejectBTN.setForeground(new Color(255, 17, 23));
		rejectBTN.setBounds(351, 680, 105, 46);
		

		addBTN = new JButton("Add");
		addBTN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addBTN.setForeground(new Color(0, 191, 0));
		addBTN.setBounds(122, 680, 105, 46);
		


		textArea = new JTextArea();
		textArea.setMargin(new Insets(2, 20, 20, 20));
		textArea.setSelectionColor(new Color(255, 255, 255));
		textArea.setLineWrap(true);
		textArea.setBackground(new Color(192, 192, 192));
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		textArea.setBounds(598, 189, 475, 339);
		
		pendingReqLBL = new JLabel("Pending Requests");
		pendingReqLBL.setForeground(new Color(0, 128, 192));
		pendingReqLBL.setFont(new Font("Tahoma", Font.PLAIN, 30));
		pendingReqLBL.setBounds(174, 11, 306, 58);
		
		descriptionLBL = new JLabel("Description");
		descriptionLBL.setForeground(new Color(0, 128, 192));
		descriptionLBL.setFont(new Font("Tahoma", Font.PLAIN, 30));
		descriptionLBL.setBounds(747, 120, 159, 58);
		
	}

	public void formatTable() {
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);

		table.setModel(model);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setSelectionBackground(Color.GREEN);
		table.setGridColor(Color.BLACK);
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);

		pane = new JScrollPane(table);
		pane.setForeground(Color.RED);
		pane.setBackground(Color.RED);
		pane.setBounds(10, 102, 561, 533);
	}

	public void addRecordsToTable(String name, String id) {
		row[0] = name;
		row[1] = id;
		model.addRow(row);
	}

	public static void main(String[] args) {

		ApprovePendingRequest apr = new ApprovePendingRequest();
	}
}
