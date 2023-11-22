package design;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author ASUS
 */
public class AdminPanel extends JFrame {

	// variable's declearation
	private ImageIcon icon;
	private JLabel heading;
	private Container c;
	private Font f;

	public JButton noticeButton;
	public JButton alumniButton;
	public JButton memberButton;
	private JButton eventButton;
	private JLabel noticeLB;
	private JLabel alumniLB;
	private JLabel eventLB;
	private JLabel memberLB;

	// Default Constructor
	public AdminPanel() {
		setTitle("ADMIN PANEL");
		setBounds(623, 623, 623, 623); // setsize + set location;
		iniComp();
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void iniComp() {
		icon = new ImageIcon("download.jpg"); // icon
		this.setIconImage(icon.getImage());
		c = this.getContentPane();
		f = new Font("Times New Roman", Font.HANGING_BASELINE, 20);
		formatLabels();
		getContentPane().setLayout(null);
		c.add(heading);
		formatButton();
		c.add(noticeLB);
		c.add(alumniLB);
		c.add(eventLB);
		c.add(memberLB);
		c.add(noticeButton);
		c.add(alumniButton);
		c.add(memberButton);
		c.add(eventButton);
	}

	public void formatLabels() {
		heading = new JLabel();
		heading.setBounds(500, 60, 500, 20);
		heading.setText("WELCOME TO ADMIN PANEL");
		heading.setFont(f);

		memberLB = new JLabel(
				"<HTML>Add Remove Search for a Member<BR>Or Approve a Pending Request<HTML>");
		memberLB.setOpaque(true);
		memberLB.setBounds(309, 653, 217, 54);

		noticeLB = new JLabel("<HTML>Create, Update Or Remove a Notice<HTML>");
		noticeLB.setOpaque(true);
		noticeLB.setBounds(309, 348, 217, 54);

		alumniLB = new JLabel("<HTML>Create, Update Or Remove Alumni Info<HTML>");
		alumniLB.setOpaque(true);
		alumniLB.setBounds(739, 348, 217, 54);

		eventLB = new JLabel("<HTML>Create, Update Or Remove Event<HTML>");
		eventLB.setOpaque(true);
		eventLB.setBounds(751, 646, 217, 54);
	}

	public void formatButton() {
		noticeButton = new JButton("");
		noticeButton.setVerticalTextPosition(JButton.TOP);
		noticeButton.setHorizontalTextPosition(JButton.LEFT);
		noticeButton.setOpaque(true);
		noticeButton.setIcon(new ImageIcon("userIcon.jpg"));
		noticeButton.setBounds(309, 138, 200, 206);


		alumniButton = new JButton(new ImageIcon("admin.jpg"));
		alumniButton.setHorizontalTextPosition(SwingConstants.CENTER);
		alumniButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		alumniButton.setOpaque(true);
		alumniButton.setBounds(751, 138, 200, 206);

		memberButton = new JButton(new ImageIcon("userIcon.jpg"));
		memberButton.setBounds(309, 450, 200, 200);

		eventButton = new JButton(new ImageIcon("userIcon.jpg"));
		eventButton.setBounds(751, 450, 200, 200);
		eventButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Event");
			}
		});
	}
}
