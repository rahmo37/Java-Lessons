package Map;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kingaspx.util.BrowserUtil;
import com.kingaspx.version.Version;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.events.TitleEvent;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import com.teamdev.jxbrowser.chromium.events.ConsoleEvent;
import com.teamdev.jxbrowser.chromium.events.FinishLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.LoadAdapter;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	JPanel map_panel = new JPanel();
	private JPanel contentPane;
	private JTextField textField;
	Browser browser;
	BrowserView view;

	/**
	 * Launch the application.
	 */
	private void open_site() {
		BrowserUtil.setVersion(Version.V6_22);
		browser = new Browser();
		view = new BrowserView(browser);
		map_panel.add(view, BorderLayout.CENTER);
		
		browser.addTitleListener((TitleEvent evt) -> {
			setTitle(evt.getTitle());
		});
		
		browser.addConsoleListener((ConsoleEvent evt) -> {
			System.out.println("LOG: " + evt.getMessage());
		});
		browser.addLoadListener(new LoadAdapter() {
			@Override
			public void onFinishLoadingFrame(FinishLoadingEvent evt) {
				evt.getBrowser().setZoomLevel(-2);
			}
		});
		browser.loadURL("C:\\Users\\idiot\\Desktop\\HTMLGmaps\\simple_map.html");
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1190, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 0, 1174, 729);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Google");
		lblNewLabel.setForeground(new Color(60, 189, 102));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setBounds(59, 11, 85, 77);
		panel.add(lblNewLabel);
		
		JLabel lblMaps = new JLabel("Maps");
		lblMaps.setForeground(new Color(60, 189, 102));
		lblMaps.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMaps.setBounds(142, 25, 59, 49);
		panel.add(lblMaps);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 68, 234, 26);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 234, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(40, 105, 89, 23);
		panel.add(btnNewButton);
		
		JPanel map_panel = new JPanel();
		map_panel.setBounds(264, 0, 900, 729);
		panel.add(map_panel);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(142, 105, 89, 23);
		panel.add(btnSearch);
	}
}
