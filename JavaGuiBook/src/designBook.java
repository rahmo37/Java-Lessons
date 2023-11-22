import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class designBook {

	private JFrame frame;
	private JTextField textName;
	private JTextField textEdition;
	private JTextField textPrice;
	private JTable table;
	private JTextField textBookID;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					designBook window = new designBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public designBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1051, 773);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Book Shop");
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 41));
		lblNewLabel.setBounds(404, 24, 283, 112);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Resgistration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(29, 147, 480, 307);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel bNameLabel = new JLabel("Book Name");
		bNameLabel.setFont(new Font("Segoe Print", Font.BOLD, 14));
		bNameLabel.setBounds(67, 66, 85, 26);
		panel.add(bNameLabel);

		JLabel bEditionLabel = new JLabel("Book Edition");
		bEditionLabel.setFont(new Font("Segoe Print", Font.BOLD, 14));
		bEditionLabel.setBounds(67, 153, 100, 26);
		panel.add(bEditionLabel);

		JLabel bPriceLabel = new JLabel("Book Price");
		bPriceLabel.setFont(new Font("Segoe Print", Font.BOLD, 14));
		bPriceLabel.setBounds(67, 232, 85, 26);
		panel.add(bPriceLabel);

		textName = new JTextField();
		textName.setBounds(223, 70, 144, 20);
		panel.add(textName);
		textName.setColumns(10);

		textEdition = new JTextField();
		textEdition.setColumns(10);
		textEdition.setBounds(223, 157, 144, 20);
		panel.add(textEdition);

		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(223, 236, 144, 20);
		panel.add(textPrice);

		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Segoe Print", Font.BOLD, 15));
		btnSave.setBounds(39, 472, 100, 58);
		frame.getContentPane().add(btnSave);

		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Segoe Print", Font.BOLD, 15));
		btnExit.setBounds(204, 472, 100, 58);
		frame.getContentPane().add(btnExit);

		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Segoe Print", Font.BOLD, 15));
		btnClear.setBounds(361, 472, 100, 58);
		frame.getContentPane().add(btnClear);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(547, 147, 458, 307);
		frame.getContentPane().add(scrollPane);

		model = new DefaultTableModel();
		Object[] column = { "Book", "Edition", "Price" };
		Object[] row = new Object[3];
		model.setColumnIdentifiers(column);
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(39, 570, 480, 122);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel bIDLable = new JLabel("Book ID");
		bIDLable.setHorizontalAlignment(SwingConstants.CENTER);
		bIDLable.setFont(new Font("Segoe Print", Font.BOLD, 14));
		bIDLable.setBounds(34, 46, 100, 26);
		panel_1.add(bIDLable);

		textBookID = new JTextField();
		textBookID.setColumns(10);
		textBookID.setBounds(144, 40, 205, 41);
		panel_1.add(textBookID);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("Segoe Print", Font.BOLD, 15));
		btnUpdate.setBounds(638, 472, 100, 58);
		frame.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Segoe Print", Font.BOLD, 15));
		btnDelete.setBounds(804, 472, 100, 58);
		frame.getContentPane().add(btnDelete);

		JButton btnTest = new JButton("btn Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] = textName.getText();
				row[1] = textEdition.getText();
				row[2] = textPrice.getText();
				model.addRow(row);
			}
		});
		btnTest.setFont(new Font("Segoe Print", Font.BOLD, 15));
		btnTest.setBounds(708, 585, 127, 72);
		frame.getContentPane().add(btnTest);
	}
}
