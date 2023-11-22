package nestedForLoop;

import javax.swing.JOptionPane;

public class nestedForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows = Integer.parseInt(JOptionPane.showInputDialog("How many rows??"));
		int columns = Integer.parseInt(JOptionPane.showInputDialog("How many columns??"));
		String symbol = JOptionPane.showInputDialog("How many columns??");

		for (int i = 0; i < rows; i++) {
			System.out.println();
			for (int j = 0; j < columns; j ++) {
				System.out.print(symbol);
			}
		}

	}

}
