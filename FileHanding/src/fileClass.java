import java.io.File;

public class fileClass {
	public static void main(String args[]) {
		File file1 = new File("C:/Users/idiot/OneDrive/Desktop/Test.txt");
		File file2 = new File("Test.txt");

		// exists method checks if the files exists or not
		if (file1.exists() && file2.exists()) {

			System.out.println("Test file exists");
			// getPath method returns the initial path
			System.out.println("Initial path for the file 1 :" + file1.getPath());
			// getAbsolutePath method returns the absolute path
			System.out.println("Absolute path for file 2 :" + file2.getAbsolutePath());
			//Checks if it really is a file or not
			System.out.println(file1.isFile());
			//file1.delete() method deletes a file

		} else {
			System.out.println("Test file missing");
		}
	}
}
