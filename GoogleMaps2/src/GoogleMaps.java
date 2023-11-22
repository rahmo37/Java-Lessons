import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.RenderingMode;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import javax.swing.JTextField;

public class GoogleMaps extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoogleMaps frame = new GoogleMaps();
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
	public GoogleMaps() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1203, 784);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField("https://html5test.com");
		textField.setBounds(317, 11, 453, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		//createBrowser();
	}
	public void createBrowser() {
		Engine engine = Engine.newInstance(RenderingMode.HARDWARE_ACCELERATED);
		Browser browser = engine.newBrowser();
		BrowserView view = BrowserView.newInstance(browser);
		textField.addActionListener(e -> browser.navigation().loadUrl(textField.getText()));
		contentPane.add(view, BorderLayout.CENTER);
		contentPane.add(textField, BorderLayout.NORTH);
		browser.navigation().loadUrl(textField.getText());
	}

}
