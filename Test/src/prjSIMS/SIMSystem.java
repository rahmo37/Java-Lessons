package prjSIMS;

import java.io.IOException;

/****************************************************************************************
 * Project Name:	prjSIMS
 * Class:			SIMSystem
 * Author:			CSC 229 Fall 2022 Students
 * Date:			September 21, 2022
 * Purpose:			This is the main class for the Store Inventory Management System.	
 ***************************************************************************************/

public class SIMSystem {

	public static void main(String[] args) throws IOException {
		
		Store costco = new Store();
		costco.loadProducts();
		costco.checkInventory();

		//login
	//costco.welcome();
	//costco.showMenu();

	}

}
