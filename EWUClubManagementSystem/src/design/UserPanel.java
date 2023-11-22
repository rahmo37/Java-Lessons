package design;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class UserPanel extends JFrame {
	private ImageIcon icon;
	private JLabel heading;
	public Container u;
	private Font f;
	JLabel backGroundLabel;
	public JButton noticeButton;
	public JButton alumniButton;
	public JButton memberButton;
	private JButton eventButton;


	public UserPanel() {
		setTitle("USER PANEL");
		setBounds(100, 100, 1270, 790); // setsize + set location;
		iniComp();
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void iniComp() {
		icon = new ImageIcon("download.jpg"); // icon
		this.setIconImage(icon.getImage());
		u = this.getContentPane();
		u.setLayout(null);
		f = new Font("Times New Roman", Font.HANGING_BASELINE, 20);

		initialPanel();
		u.add(heading);
		u.add(noticeButton);
		u.add(alumniButton);
		u.add(memberButton);
		u.add(eventButton);
		u.add(backGroundLabel);
	}

	public void initialPanel() {
		backGroundLabel = new JLabel("");
		backGroundLabel.setForeground(new Color(0, 0, 0));
		backGroundLabel.setBounds(0, 0, 1254, 751);
		backGroundLabel.setOpaque(true);
		backGroundLabel.setBackground(new Color(128, 128, 128));

		heading = new JLabel();
		heading.setText("WELCOME TO USER PANEL");
		heading.setBounds(500, 60, 500, 20);
		heading.setFont(f);

		noticeButton = new JButton(new ImageIcon("userIcon.jpg"));
		noticeButton.setBounds(300, 200, 200, 200);


		alumniButton = new JButton(new ImageIcon("admin.jpg"));
		alumniButton.setBounds(700, 200, 200, 200);


		memberButton = new JButton(new ImageIcon("userIcon.jpg"));
		memberButton.setBounds(300, 500, 200, 200);

		eventButton = new JButton(new ImageIcon("userIcon.jpg"));
		eventButton.setBounds(700, 500, 200, 200);
		eventButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hello");
			}
		});
	}


}
