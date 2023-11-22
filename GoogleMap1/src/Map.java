import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Map extends JFrame {
	GoogleApi gApi = new GoogleApi();
	String location = "New York";
	JLabel gMap;
	private JTextField textField;

	public Map() {
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				location = textField.getText();
				gApi.downloadMap(location);
				gMap.setIcon(gApi.getMap(location));
			}
		});
		btnNewButton.setBounds(300, 78, 76, 23);
		getContentPane().add(btnNewButton);
		gApi.downloadMap(location);
		gMap = new JLabel(gApi.getMap(location));
		gMap.setBounds(0, 0, 607, 584);
		gApi.fileDelete(location);
		setBounds(500, 100, 623, 623);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Location");
		lblNewLabel.setBounds(175, 37, 76, 33);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(256, 39, 162, 28);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		getContentPane().add(gMap);
		setTitle("Google Maps");
		setVisible(true);
	}
}
