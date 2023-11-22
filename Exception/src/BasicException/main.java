package BasicException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean loop = false; 
		while (loop == false) {
			try {
				Scanner sc = new Scanner(System.in);

				System.out.println("Enter the author name");
				String author = sc.nextLine();

				System.out.println("Enter the Title");
				String title = sc.nextLine();

				System.out.println("Enter the pages of the book");
				int pages = sc.nextInt();
				/*
				 * Can be wrtiien like this(Short form)
				 if (pages <= 0) {
					throw new ZeroOrNegetiveNumber();
				}*/

				bookException be = new bookException(author, title, pages);
				System.out.println(be);
				break;
			}

			catch (InputMismatchException ex) {
				System.out.println("Not valid. enter a valid integer number!");
			}
			catch (ZeroOrNegetiveNumber ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
