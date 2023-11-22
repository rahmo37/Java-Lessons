package design;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchForMembers extends JFrame {
	public JTable table;
	Object[] column = { "Name", "Student Id" };
	Object[] row = new Object[2];
	public DefaultTableModel model;
	JScrollPane pane;
	public JTextField idTF;
	JLabel idLBL;
	JLabel allMemberLBL;
	public JTextArea descriptionTA;
	JLabel descriptionLBL;
	public JLabel memberCatagoryLBL;

	public SearchForMembers() {
		getContentPane().setBackground(new Color(192, 192, 192));
		formatTable();
		formatLabelAndOhters();
		this.setResizable(false);
		this.setTitle("Pending Requests");
		this.setBounds(0, 0, 1099, 776);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(pane);
		this.getContentPane().add(idTF);
		this.getContentPane().add(idLBL);
		this.getContentPane().add(allMemberLBL);
		this.getContentPane().add(descriptionTA);
		this.getContentPane().add(memberCatagoryLBL);
		this.getContentPane().add(descriptionLBL);
		

	}

	public void formatTable() {
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);

		table = new JTable();
		table.setBounds(39, 27, 383, 488);
		table.setModel(model);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setSelectionBackground(Color.GREEN);
		table.setGridColor(Color.BLACK);
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);

		pane = new JScrollPane(table);
		pane.setBounds(48, 108, 499, 488);
		pane.setForeground(Color.RED);
	}

	public void formatLabelAndOhters() {
		idTF = new JTextField();
		idTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '-') {
					e.consume();
				}
			}
		});
		idTF.setHorizontalAlignment(SwingConstants.CENTER);
		idTF.setToolTipText("");
		idTF.setBounds(181, 617, 194, 53);
		idTF.setMargin(new Insets(10, 10, 10, 10));
		idTF.setFont(new Font("Tahoma", Font.PLAIN, 25));
		idTF.setColumns(10);

		idLBL = new JLabel("Enter Student-Id to start filtering the list");
		idLBL.setBounds(100, 681, 367, 37);
		idLBL.setFont(new Font("Tahoma", Font.PLAIN, 20));

		allMemberLBL = new JLabel("All Members");
		allMemberLBL.setBounds(220, 65, 147, 32);
		allMemberLBL.setFont(new Font("Tahoma", Font.PLAIN, 25));

		descriptionTA = new JTextArea();
		descriptionTA.setBounds(598, 172, 475, 424);
		descriptionTA.setMargin(new Insets(20, 20, 20, 20));
		descriptionTA.setSelectionColor(new Color(255, 255, 255));
		descriptionTA.setLineWrap(true);
		descriptionTA.setBackground(new Color(255, 255, 255));
		descriptionTA.setForeground(new Color(0, 0, 0));
		descriptionTA.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		
		descriptionLBL = new JLabel("Description");
		descriptionLBL.setFont(new Font("Tahoma", Font.PLAIN, 25));
		descriptionLBL.setBounds(779, 612, 147, 32);
		

		memberCatagoryLBL = new JLabel("");
		memberCatagoryLBL.setForeground(new Color(0, 0, 255));
		memberCatagoryLBL.setBounds(708, 124, 334, 37);
		memberCatagoryLBL.setFont(new Font("Tahoma", Font.PLAIN, 25));
	}

	public void addRecordsToTable(String name, String id) {
		row[0] = name;
		row[1] = id;
		model.addRow(row);
	}
}
