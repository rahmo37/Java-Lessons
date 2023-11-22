package pkgSIMS;

import java.io.IOException;
import java.sql.SQLException;

/****************************************************************************************
 * Project Name:	prjSIMS
 * Class:			SIMSystem
 * Author:			CSC 229 Fall 2022 Students
 * Date:			September 21, 2022
 * Purpose:			This is the main class for the Store Inventory Management System.	
 ***************************************************************************************/

public class SIMSystem {

	public static void main(String[] args) {
		
		Store costco = new Store();

		try
		{	costco.connectDB();
			costco.loadData();
			costco.welcome();
			costco.login();
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			System.out.println("Input-Output Exception, Program Terminated!");
			System.exit(1000);
		}
		catch (ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
			System.out.println("Database Driver Exception, Program Terminated!");
			System.exit(2000);
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			System.out.println("Database Exception, Program Terminated!");
			System.exit(3000);
		}
		
	

	}

}
