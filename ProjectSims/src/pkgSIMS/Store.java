package pkgSIMS;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;



public class Store {


	ArrayList<Inventory> productsonhand;		//all of the products on hand
	Vector <Product> items;
	Vector <Employee> staff;
	ArrayList<Department> deptArray;
	Scanner keyboard;
	Business biz;
	Hashtable<Integer, Supplier> vendors;
	Vector<Integer> htKeys;
	int loggedinuser = -1;						//index of the logged in person
	//update flags
	int numSupdates; 
	int numEupdates; 
	int numPupdates; 
	int numIupdates; 
	int nextupdPricenum;
	
	//Database objects
	 Connection connection;
	 Statement statement;
	 ResultSet resultSet;

	/*******************************************************CONSTRUCTOR*****************************************************/
	Store()
	{		productsonhand = new ArrayList<Inventory>();
			items = new Vector<Product>();
			staff = new Vector<Employee>();
			deptArray = new ArrayList<Department>();
			biz = new Business();
			vendors = new Hashtable<>();
			htKeys = new Vector<Integer>();
			keyboard = new Scanner (System.in);
			nextupdPricenum = 0;
			numSupdates = 0; 
			numEupdates = 0; 
			numPupdates = 0; 
			numIupdates = 0; 
			connection = null;
			statement = null;
			resultSet = null;
	}
	/**************************************************END OF CONSTRUCTOR*****************************************************/

	
	/*******************************************************LOAD METHODS******************************************************/
	//this method calls the load methods for each text files
	void loadData() throws SQLException
	{
		loadBusiness();
		loadInventory();
		loadDepartments();
		loadProducts();
		loadEmployees();
		loadSuppliers();
	}
	
	
	void loadBusiness()  throws SQLException
	{	
		//create the variables for each field in the file
		
		String storenum, storename, address, city, state, zip, phone, empid;
		int totalrows = 0, index = 0;
					
		//Get the total rows in the table to loop through the result set
		 resultSet = statement.executeQuery("SELECT * FROM Business"); 
		 while (resultSet.next()) //tests for the eof
		 {   totalrows = resultSet.getRow();
			storenum = resultSet.getString("storenum"); // or 	i = resultSet.getString("storenum");
			storename = resultSet.getString(1);
			address = resultSet.getString(2);
			city = resultSet.getString(3);
			state = resultSet.getString(4);
			zip = resultSet.getString(5);
			phone = resultSet.getString(6);
			empid = resultSet.getString(7);
		
			biz = new Business(Integer.parseInt(storenum), storename, address, city, state, zip, phone, empid); //create the store
		 
		 	index++;
		}//end of loading Business record
		
			System.out.println("Business Loaded");
	}
	/***************END LOAD BUSINESS******************************/

	
	void loadInventory() throws SQLException
	{
		//create the variables for each field in the database
		long u = 0;
		int q = 0;
		int totalrows = 0, index = 0;
		
		//Get the total rows in the table to loop through the result set
		 resultSet = statement.executeQuery("SELECT * FROM Inventory"); 
		 while (resultSet.next()) //tests for the eof
		 {   totalrows = resultSet.getRow();
			u = Long.parseLong(resultSet.getString(1)); 
			q = Integer.parseInt(resultSet.getString(2));
			productsonhand.add(new Inventory(u,q)); //add to the arraylist
			index++;
		 }//end of loading Inventory
		System.out.println("Inventory Loaded");
	} //end of loadInventory() method
	
	/***************END LOAD INVENTORY******************************/

	void loadDepartments() throws SQLException {
		
		String d = "";
		String dn = "";
		String ei = "";
		int totalrows = 0, index = 0;
			
		//Get the total rows in the table to loop through the result set
		 resultSet = statement.executeQuery("SELECT * FROM Departments"); 
		 while (resultSet.next()) //tests for the eof
		 {   totalrows = resultSet.getRow();
			d = resultSet.getString(1); 
			dn = resultSet.getString(2);
			ei = resultSet.getString(3);
			deptArray.add(new Department(d, dn, ei)); // add the Department to the ArrayList
			index++;
		 }//end of loading Departments

		System.out.println("Departments loaded");
	} // end of loadDepartments() method

	/***************END LOAD DEPARTMENTS******************************/

	void loadProducts()  throws SQLException
	{	
		//create the variables for each field in the database
			long up = 0;
		    String pn = "";
		    String dn = "";
		    double pc = 0.00;
		    int xd = 0;
		    int sn = 0;
		    int totalrows = 0, index = 0;
					
		//Get the total rows in the table to loop through the result set
		 resultSet = statement.executeQuery("SELECT * FROM Products"); 
		 while (resultSet.next()) //tests for the eof
		 {   totalrows = resultSet.getRow();
	
			up = Long.parseLong(resultSet.getString("upc")); // or 	i = resultSet.getString("upc");
			pn = resultSet.getString("productName");
			dn = resultSet.getString("deptNum");
			pc = Double.parseDouble(resultSet.getString("price"));
			xd = Integer.parseInt(resultSet.getString("expDays"));
			sn = Integer.parseInt(resultSet.getString("supplierNum"));
		
			items.add (new Product(up, pn, dn, pc,xd,sn)); //add the product to the Vector	
			index++;
		}//end of loading to Vector
		
			System.out.println("Products Loaded");
			
			//Get the total rows in the table to loop through the result set
			 resultSet = statement.executeQuery("SELECT MAX(phnum) FROM ProductHistory"); 
			 totalrows = resultSet.getRow();
			 resultSet.next();
			 nextupdPricenum = resultSet.getInt(1);
			 nextupdPricenum++;
			System.out.println(nextupdPricenum);
			
	}
	/***************END LOAD PRODUCT******************************/
	
	void loadEmployees() throws SQLException {
			String i="";
			String n="";
			String e="";
			String p="";
			boolean m=false;
			String manager = "";
			int totalrows = 0, index = 0;
				
				//Get the total rows in the table to loop through the result set
				 resultSet = statement.executeQuery("SELECT * FROM Employees"); 
					
				while (resultSet.next()) //tests for the eof
				{   totalrows = resultSet.getRow();
			
					i = resultSet.getString("empid"); // or 	i = resultSet.getString(1);
					n = resultSet.getString("empName");
					e = resultSet.getString("email");
					p = resultSet.getString("password");
					manager =  resultSet.getString("isAdmin");
					if (manager.equals("True")) m = true;
					
					 staff.add (new Employee(i, n, e, p,m)); //add the product to the Vector
					 m = false; //reset manager status
					index++;
				}//end of loading to Vector
			System.out.println("Employees Loaded");
	 } // end of loadEmployees method
	
	/***************END LOAD EMPLOYEES******************************/
	
	void loadSuppliers() throws SQLException {
		
			int supplierNum;
			String supplierName;
			String supplierAddress;
			String supplierEmail;
			String supplierPhone;
			int totalrows = 0, index = 0;
			
			//Get the total rows in the table to loop through the result set
			 resultSet = statement.executeQuery("SELECT * FROM Suppliers"); 
			 while (resultSet.next()) //tests for the eof
			 {   totalrows = resultSet.getRow();
		
				supplierNum = Integer.parseInt(resultSet.getString("supplierNum")); // or 	i = resultSet.getString("upc");
				supplierName = resultSet.getString("supplierName");
				supplierAddress = resultSet.getString("supplierAddress");
				supplierEmail = resultSet.getString("supplierEmail");
				supplierPhone =  resultSet.getString("supplierPhone");
				
				htKeys.add(supplierNum);
				vendors.put(supplierNum, new Supplier(supplierNum, supplierName, supplierAddress,  supplierEmail, supplierPhone));
				index++;
			}//end of loading to Vector
			System.out.println("Suppliers Loaded");
	 } // end of loadSuppliers method
	
	
	/***************END LOAD SUPPLIERS******************************/

	
	/**********************************END OF LOAD METHODS********************************/
 
	/**************************LOGIN METHOD ************************/

	void login() throws IOException, SQLException {
		String empEmail ="", entPass ="";
		
		boolean isValid = false;
		int counter = 0;
		System.out.println("************************LOGIN SCREEN**************************");
		do {
			counter++;
			System.out.print("Enter Email Address: ");
			empEmail = keyboard.next();
			System.out.print("Enter Password: ");
			entPass = keyboard.next();
			for(int i = 0; i < staff.size(); i++) {
				if(empEmail.equals(staff.get(i).getEmail()) && entPass.equals(staff.get(i).getPassword())) {
					isValid = true;
					loggedinuser = i;
			
				}
			}
			System.out.println("Wrong Email or Password!");
		} while(counter < 3 && !isValid);
		
		if(!isValid) {
			System.out.println("Max Attempts Exceeded, Shutting Down System");
			System.exit(0);
			
		}
		//Welcome the Logged In User
		
		System.out.println("Welcome "+ staff.get(loggedinuser).getEmpname() + " Admin: " + staff.get(loggedinuser).getAdmin());
		if(staff.get(loggedinuser).getAdmin()) {
			showMenu();
			
		}else{
			showManagerMenu();
		}
		
	}
	
	/*********************************END OF LOGIN METHOD********************************/

	/************************************WELCOME METHOD********************************/
	
	//Welcome Menu
	void welcome()
	
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		int width = 150;
		int height = 100;
	   
		//Create a program logo
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("SansSerif", Font.BOLD, 23));
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.drawString("Store", 5, 20);
		graphics.drawString("Inventory", 5, 40);
		graphics.drawString("Management", 5, 60);
		graphics.drawString("System", 5, 80);
	   
		for (int y = 0; y < height; y++) 
		{
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < width; x++) 
				{	sb.append(image.getRGB(x, y) == -16777216 ? "*" : " ");  	}
	   
			if (sb.toString().trim().isEmpty()) 
			{	continue;	 }
	   
			System.out.println(sb);
		}
		
		
		
		System.out.println("\n\n");
		System.out.println("-------------------------------------------");
		System.out.println("               WELCOME MENU                ");
		System.out.println("-------------------------------------------");	
		
		System.out.println("*********************************************");	
		System.out.println("Welcome to "+ biz.getStorename() + " System!");
		System.out.println("**********************************************");	
	}
	
	/*********************************END OF WELCOME METHOD*******************************/

	/********************************SHOW MENU METHOD*************************************/
	
	 //Display Menu
	void showMenu() throws IOException, SQLException
	{	
		int option = -1;

		do {
			
			System.out.println("\n\n");
			System.out.println("-------------------------------------------");
			System.out.println("             ADMINISTRATOR MENU            ");
			System.out.println("-------------------------------------------");	
			System.out.println("1. Check Inventory");
			System.out.println("2. Restock");
			System.out.println("3. Update Price");
			System.out.println("4. Add New Supplier");
			System.out.println("5. Add New Product");
			System.out.println("6. Add New Employee");
			System.out.println("7. Exit");
			System.out.print("Choose a system process (1-7): ");
			option = keyboard.nextInt();
			switch (option)
			{
				case (1):
				{	 checkInventory();
					break;
				}
				case (2):
				{	restockInventory();
					break;
				}
				case (3):
				{	 updatePrice();
					break;
				}
				case (4):
				{	addNewSupplier();
					break;
				}
				case (5):
				{	addNewProduct();
					break;
				}
				case (6):
				{	addNewEmployee();
					break;
				}
				case (7):
				{	updateRecords();
					exitSIMSystem();
				}
				default:
				{	System.out.println("Invalid choice, please choose between 1-7"); }
		
			} //end of switch
			}while (option != 7);
			
		
	}
	
	/*********************************END OF SHOW MENU METHOD******************************/
	
	 //Display Menu
		void showManagerMenu() throws IOException, SQLException
		{	
			int option = -1;

			do {
				//DISPLAY MENU HEADER
				System.out.println("\n\n");
				System.out.println("-------------------------------------------");
				System.out.println("                MANAGER MENU               ");
				System.out.println("-------------------------------------------");	
				System.out.println("1. Check Inventory");
				System.out.println("2. Restock");
				System.out.println("3. Update Price");
				System.out.println("4. Exit");
				System.out.print("Choose a system process (1-4): ");
				option = keyboard.nextInt();
				switch (option)
				{
					case (1):
					{	 checkInventory();
						break;
					}
					case (2):
					{	 restockInventory();
						break;
					}
					case (3):
					{	 updatePrice();
						break;
					}
					case (4):
					{	updateRecords();
						exitSIMSystem();
					}
					default:
					{	System.out.println("Invalid choice, please choose between 1-7"); }
			
				} //end of switch
				}while (option != 4);
				
			
		}
		
		/************************************************END OF SHOW MENU METHOD******************************************************/
	
	

	/**************************************************CHECK INVENTORY METHOD******************************************************/
	//	Kevin,Obaedur,Luis,Rod,Amir
 /******************************************************/

//This Method was written inside the Store class for simplicity, then cutted and pasted in a notepad. 
  //Copying and pasting the code to the store class will reactivate the method

	public void checkInventory() {

		//DISPLAY MENU HEADER
		System.out.println("\n\n");
		System.out.println("-------------------------------------------");
		System.out.println("             CHECK INVENTORY               ");
		System.out.println("-------------------------------------------");	

	
		Scanner keyboard = new Scanner(System.in);
		String adminResponse1 = "";
	
		while (!adminResponse1.equals("0")) {
	
			System.out.println("Welcome \nPress 1 to search or 0 to quit");
			System.out.print("--> ");
			adminResponse1 = keyboard.next();
	
			if (adminResponse1.equals("1")) {
				String adminResponse2 = "";
				while (!adminResponse2.equals("0")) {
	
					System.out.println("\nPress 1 to view all products and departments."
							+ "\nPress 2 to view all departments." + "\nPress 3 to search for UPC with product name"
							+ "\nPress 0 to return to the main menu");
					System.out.print("--> ");
					adminResponse2 = keyboard.next();
	
					if (adminResponse2.equals("1")) {
						System.out.println(
								"\nProducts and Departments" + "\n*************************************************");
						allProducts();
						String adminResponse3 = "";
						while (!adminResponse3.equals("0")) {
							System.out.println("\nEnter the product number to see more details");
							System.out.println("Press 0 to return to the previous page");
							System.out.println("Type q quit the System");
							System.out.print("--> ");
							adminResponse3 = keyboard.next();
	
							if (adminResponse3.equals("q")) {
								System.out.println("Have a nice day!");
								return;
							}
	
							int tempVal = Integer.parseInt(adminResponse3) - 1;
							if (adminResponse3.equals("0")) {
								continue;
							} else if (tempVal < 0 || tempVal >= items.size()) {
								System.out.println("Invalid input");
							} else {
								System.out.println("\n*********************************************************\n"
										+ "Product Name: " + items.get(tempVal).getProductName()
										+ "\tUpc: " + items.get(tempVal).getUpc()
										+ "\tPrice: " +items.get(tempVal).getPrice()
										+ "\tExp date: " + items.get(tempVal).getExpDays()
									    + "\tQuantity: " + productsonhand.get(tempVal).getQuantity());
							}
						}
					}
	
					else if (adminResponse2.equals("2")) {
						System.out.println("\n*************************************************\n");
						allDepartments();
						String adminResponse3 = "";
						while (!adminResponse3.equals("0")) {
							System.out.println(
									"\n\nEnter the department number to see all the products on that department");
							System.out.println("Press 0 to return to the previous page");
							System.out.println("Type q quit the System");
							System.out.print("--> ");
							adminResponse3 = keyboard.next();
	
							if (adminResponse3.equals("q")) {
								System.out.println("Have a nice day!");
								return;
							}
	
							int tempVal = Integer.parseInt(adminResponse3) - 1;
							if (adminResponse3.equals("0")) {
								continue;
							} else if (tempVal < 0 || tempVal >= deptArray.size()) {
								System.out.println("Invalid input");
							} else {
								System.out.println("********************************\n" + "Department : "
										+ deptArray.get(tempVal).getDeptName() + "\n");
								int counter = 0;
								for (int i = 0; i < items.size(); i++) {
	
									if (deptArray.get(tempVal).getDeptNum().equals(items.get(i).getDeptNum())) {
										counter += 1;
										System.out.println(counter + ". " + items.get(i).getProductName());
									}
								}
							}
						}
	
					} else if (adminResponse2.equals("3")) {
						String adminResponse3 = "";
						boolean validInput = false;
						while (!validInput) {
							System.out.println("\nEnter a product name to see its UPC\nOr");
							System.out.print("Press 0 to return to the main menu\n--> ");
							keyboard.nextLine();
							adminResponse3 = keyboard.nextLine();
	
							for (int i = 0; i < items.size(); i++) {
								if ((items.get(i).getProductName().equals(adminResponse3))) {
									// System.out.println(items.get(i).getProductName().toLowerCase());
									validInput = true;
									System.out.println("--> " + items.get(i).getUpc());
								}
	
							}
							if (adminResponse3.equals("0")) {
								validInput = true;
							} else if (!validInput) {
								System.out.println("Invalid input");
							}
						}
					} else if (adminResponse2.equals("0")) {
						continue;
					} else {
						System.out.println("Invalid input");
					}
	
				}
	
			} else if (adminResponse1.equals("0")) {
				System.out.println("Have a nice day!");
				return;
			} else {
				System.out.println("Invalid input\n\n");
			}
		}
	
	}
	
	// sub-method that implements check inventory
	public void allProducts() {
		for (int i = 0; i < items.size(); i++) {
			System.out.print((i + 1) + ". " + items.get(i).getProductName() + " | ");
			for (int j = 0; j < deptArray.size(); j++) {
				if (items.get(i).getDeptNum().equals(deptArray.get(j).getDeptNum())) {
					System.out.println(deptArray.get(j).getDeptName());
				}
			}
		}
	
	}
	
	// sub-method that implements check inventory
	public void allDepartments() {
		for (int i = 0; i < deptArray.size(); i++) {
			System.out.println(i + 1 + ". " + deptArray.get(i).getDeptName());
		}
	}
	
	
	
	//<-- To here//close check Inventory
		
	/**********************************************END OF CHECK INVENTORY METHOD***************************************************/

	
	/********************************************************NEW RECORD METHODS
	 * @throws IOException ***************************************************/
	
	//add New Supplier
	void addNewSupplier() throws IOException
		{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//DISPLAY MENU HEADER
		System.out.println("\n\n");
		System.out.println("-------------------------------------------");
		System.out.println("            ADD NEW SUPPLIER               ");
		System.out.println("-------------------------------------------");	

		
					System.out.println("Supplier Number: ");
					int number = br.read();
				
					System.out.println("Supplier name: ");
					String name = br.readLine();
					
					System.out.println("Supplier address: ");
					String address = br.readLine();
					
					System.out.println("Supplier email: ");
					String email = br.readLine();
					
					System.out.println("Supplier phone: ");
					String phone = br.readLine();
		
						
					vendors.put(number, new Supplier(number, name, address, email, phone));
					numSupdates++;	//update the Supplier flag
	
		} //end of new supplier

	//add New Supplier
	void addNewEmployee() {
		//DISPLAY MENU HEADER
		System.out.println("\n\n");
		System.out.println("-------------------------------------------");
		System.out.println("            ADD NEW EMPLOYEE               ");
		System.out.println("-------------------------------------------");	

			Scanner input = new Scanner(System.in);
			System.out.print("Enter Employee ID: ");
			String empid = input.nextLine();
			System.out.print("Enter Employee Name: ");
			String empname = input.nextLine();
			System.out.print("Enter Employee Email: ");
			String email = input.nextLine();
			System.out.print("Enter Employee Password: ");
			String password = input.nextLine();
			System.out.print("Is Employee a Manager(True/False): ");
			Boolean manager = input.nextBoolean();
			Employee nEmployee = new Employee(empid,empname,email,password,manager);
			staff.add(nEmployee);
			numEupdates++;	//update the Employee flag
			
			
		}

	
	//add New Product
		void addNewProduct()  throws IOException{
		        Scanner input = new Scanner(System.in);
		        boolean validInput = false;
		        double price = 0;
		        long upc = 0;
		        while (validInput=false){
		        System.out.print("Enter UPC: ");
		       upc = input.nextLong();
		       long lowbound = 100000000000L, highbound = 999999999999L;
		       
		        
		        if (upc >=lowbound||upc<=highbound){
		        	validInput=true;
		        }
		        else 
		        	System.out.print("Invalid UPC Please enter a 12-digit UPC.\n");
		        }
		        // ADDITIONAL validate: search products for same upc; if duplicate reject

		        System.out.print("Enter Product Name: ");
		        String productName = input.nextLine();
		        // TO validate: search products for same name; if duplicate reject
		        System.out.print("Enter Department #: ");

		        String deptNum = input.nextLine();
		        // To Validate, Search departments for entered number. If match found, accept, if no match, reject.
		        validInput = false;
		        while (validInput=false){

		        	System.out.print("Enter Price: ");
		        	price = input.nextDouble();
		        	if (price <=0) {
		        		validInput=true;
		        	}
		        	else
		        		System.out.print("Invalid Price please enter a positive number.\n");

		        }
		        // To Validate, if 0 or negative number, reject
		        System.out.print("Enter UPC");
		        int expdays = input.nextInt();

		        System.out.print("Enter Supplier Number: ");
		        int supplierNum = input.nextInt();
		    // To Validate, Search Suppliers for entered number. If match found, accept, if no match, reject.

		        Product nProduct = new Product(upc, productName, deptNum, price, expdays, supplierNum);
		        items.add(nProduct);
		        numPupdates++; 
		
			} //end of new  products

	
	/***************************************************END OF NEW RECORD METHODS***************************************************/
		/**********************************************************UPDATE PRICE
		 * @throws SQLException *****************************************************/
		void updatePrice() throws SQLException {
			boolean validUPC = false;
			 int pindex = -1;
			 long upc = 0;
			 int results = 0;
			numPupdates++;
	
			//DISPLAY MENU HEADER
			System.out.println("\n\n");
			System.out.println("-------------------------------------------");
			System.out.println("                UPDATE PRICE               ");
			System.out.println("-------------------------------------------");	
			
			 for(int i = 0; i< items.size();i++) {
				 System.out.println((i + 1) + ". " + items.get(i).getUpc());
			 }
			

			 System.out.print("Enter choice: ");
			int  userUPC = keyboard.nextInt();
			pindex = userUPC-1;
			 double upcPrice = items.get(pindex).getPrice();
			 System.out.print("Enter New Price: ");
			 double newPrice = keyboard.nextDouble();
			 
			 Product up = new Product();
			 items.get(pindex).setPrice(newPrice);
			 
			 
			 System.out.println("Price Updated for " + items.get(pindex).getProductName());
			 upc = items.get(pindex).getUpc();
			 up =  items.get(pindex);
			 
			 String upddate = getSystemDate();
			 
			 //update Product History table
			 	results = statement.executeUpdate("INSERT INTO ProductHistory VALUES ("
			 				+  nextupdPricenum 	+ ", "
			 				+ "'"	+ up.getUpc()   	+"', " 	
			 				+  up.getPrice() 	+ ", '"
			 				+  upddate			+ "')");	
	
					 System.out.println(results  + ", product price updated successfully." );
					 nextupdPricenum++;

		 }
		
		/*************************************END OF UPDATE PRICE********************************/

		/**************************************RESTOCK METHODS***********************************/
		
		/********************************************
		*
		* Class: CSC 229 M-W 5:55-7:10pm
		* Author: Kevin, Luis, Amir, Obaedur, Rod
		* Date: 10/26/2022
		* Purpose: Restocking inventory
		* 
		* 
		********************************************/
	

			public void restockInventory() {
				int counter = 0;
				allProductsAndQuantity();
				numIupdates++;

				String adminResponse2 = "";
				while (!adminResponse2.equals("0")) {
					System.out.println("\nEnter the product number to restock ");
					if (counter >= 2) {
						System.out.println("Enter p to view all products again");
					}
					System.out.println("or Enter 0 to quit \n-->");

					adminResponse2 = keyboard.next();
					if (adminResponse2.equals("p")) {
						allProductsAndQuantity();
						counter = 0;
						continue;
					}

					int prodNum = Integer.parseInt(adminResponse2) - 1;
					if (adminResponse2.equals("0")) {
						System.out.println("Have a nice day!!\n");
						return;
					} else if (prodNum < 0 || prodNum >= items.size()) {
						System.out.println("\nInvalid Input!");
						continue;
					}

					System.out.println("\nProduct name and current quantity");
					currentQuantity(prodNum);

					String adminResponse3 = "";
					while (!adminResponse3.equals("0")) {
						System.out.println("Enter i to increse ");
						System.out.println("Enter d to decrese ");
						System.out.println("or 0 to return to the previous menu\n--> ");
						adminResponse3 = keyboard.next();
						counter++;

						if (adminResponse3.equals("0")) {
							continue;
						} else if (adminResponse3.equalsIgnoreCase("i")) {
							increaseQuantity(prodNum);
							currentQuantity(prodNum);

							break;
						} else if (adminResponse3.equalsIgnoreCase("d")) {

							decreaseQuantity(prodNum);
							currentQuantity(prodNum);
							break;
						} else {
							System.out.println("\nInvalid input!\n\n");
						}
					}
				}
			}

			// sub method to help restockInventory method
			public void allProductsAndQuantity() {
				System.out.println("\nAll products and their current quantity\n");
				for (int i = 0; i < items.size(); i++) {
					System.out.print((i + 1) + ". " + items.get(i).getProductName() + " | ");
					for (int j = 0; j < productsonhand.size(); j++) {
						if (items.get(i).getUpc() == productsonhand.get(j).getUpc()) {
							System.out.println(productsonhand.get(j).getQuantity());
						}
					}
				}

			}

			// sub method to help restockInventory method
			public void currentQuantity(int prodNum) {

				for (int i = 0; i < productsonhand.size(); i++) {
					if (items.get(prodNum).getUpc() == productsonhand.get(i).getUpc()) {
						System.out.println("*********************************************************\n");
						System.out.print("Product Name: " + items.get(prodNum).getProductName() + "\t");
						System.out.println("\tCurrent Quantity: " + productsonhand.get(i).getQuantity() + "\n");
					}
				}
			}

			// sub method to help restockInventory method
			public void increaseQuantity(int prodNum) {
				System.out.println("Increase by how many product: ");
				int add = keyboard.nextInt();
				for (int i = 0; i < productsonhand.size(); i++) {
					if (items.get(prodNum).getUpc() == productsonhand.get(i).getUpc() ) {
						productsonhand.get(i).setQuantity(productsonhand.get(i).getQuantity() + add);
					}
				}
			
					System.out.println("\nProduct increased successfully!!\nChanges were made");

			}

			// sub method to help restockInventory method
			public void decreaseQuantity(int prodNum) {
				System.out.println("Decrease by how many product: ");
				int remove = keyboard.nextInt();
				for (int i = 0; i < productsonhand.size(); i++) {
					if (items.get(prodNum).getUpc() == productsonhand.get(i).getUpc()) {
						productsonhand.get(i).setQuantity(productsonhand.get(i).getQuantity() - remove);
						
					}
				}
					System.out.println("\nProduct decreased successfully!!\nChanges were made");
				
			}



	/************************************END OF RESTOCK METHODS********************************/	
		
		
		
		
	/***************************UPDATE RECORDS  *****************/
	 void updateRecords() throws  SQLException
	 {	int results = 0; //used to display # of records updated or inserted.
	 
		 //update Employee records
		 if (numEupdates >0)
		 {
		
			for (int i = 0; i < staff.size(); i++)
				{		results = statement.executeUpdate(" INSERT INTO Employees VALUES ("+
						"" + staff.get(i).getEmpid()  + "," + //don't need to quote numbers
						"'" + staff.get(i).getEmpname() + "'," +
						"'" + staff.get(i).getEmail() + "'," +
						"'" + staff.get(i).getPassword() + "'," +
							staff.get(i).isAdmin + ")");	//don't need to quote booleans

				}
				 System.out.println( results + " Employee records updated successfully." );
		 }//end of update Employees
		 
		 //update Product records
		 if (numPupdates >0)
		 {
			 	for (int i = 0; i < items.size(); i++)
				{		results = statement.executeUpdate(" INSERT INTO Products VALUES ("+
						"'" + items.get(i).getUpc()  + "'," +
						"'" + items.get(i).getProductName()+ "'," +
						"'" + items.get(i).getDeptNum() + "'," +
						      items.get(i).getPrice()+ "," + //don't need to quote numbers
						      items.get(i).getExpDays()+ "," + 
						      items.get(i).getSupplierNum() + ")");	
				}
				 System.out.println( results + " Product records updated successfully." );
		 }//end of update Products
		  
		 //update Supplier records
		 if (numSupdates >0)
		 {
			 int snum = 0;
			 Supplier s = new Supplier();
		
			 for (int i = 0; i < vendors.size(); i++)
				{		snum = htKeys.get(i);
						s = vendors.get(snum); //get supplier object based on key.
						results = statement.executeUpdate(" INSERT INTO Suppliers VALUES ("+
						"'" + s.getSuppliernum() + "'," +
						"'" + s.getSuppliernum() + "'," +
						"'" + s.getSuppliernum() + "'," +
						"'" + s.getSuppliernum() + "')");

				}	 
			 System.out.println( results + " Suppliers records updated successfully." );

		 }//end of update Suppliers
		 
		 
		 //update Inventory records
		 if (numIupdates >0)
		 {
			
				for (int i = 0; i < productsonhand.size(); i++)
				{		
						results = statement.executeUpdate(" INSERT INTO Inventory VALUES ("+
						"'" + productsonhand.get(i).getUpc() + "'," + //upc is text in the database
						 	+ productsonhand.get(i).getQuantity() + ")");
						
					/*	UPDATE Inventory SET quantity = productsonhand.get(i).getQuantity() 
								WHERE upc = productsonhand.get(i).getUpc();*/


				}	 
			 System.out.println( results + " Inventory records updated successfully." );
	
		 }//end of update Inventory
			 
	 }
	/***************************************************END OF UPDATE RECORDS***************************************************/

	 
		/***********************************************DATABASE CONNECTION*************************************************/
		void connectDB() throws ClassNotFoundException, SQLException
		{
		 // Step 1: Loading or registering JDBC driver class 
	
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		
		 // Step 2: Opening database connection
		 String msAccDB = "SIMS.accdb";
		 String dbURL = "jdbc:ucanaccess://" + msAccDB; 
		 
		 // Step 3: Create and get connection using DriverManager class
		 connection = DriverManager.getConnection(dbURL); 
		 
		 // Step 4: Creating JDBC Statement 
		 // It is scrollable so we can use next() and last() & It is updatable so we can enter new records
		 statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		 ResultSet.CONCUR_UPDATABLE);
		 
		 System.out.println("Database Connected!");
		}
		/*******************************END DATABASE CONNECTION*************************/
		
		/******************************EXIT SIM SYSTEM*********************************/
		void exitSIMSystem() throws SQLException
		{	System.out.println("\n\n--------------------------------------------");
			System.out.println("Thank you for using SIMS System, Program Ended!");
			System.out.println("-----------------------------------------------");
			System.exit(0);
			connection.close();
		}
		/*****************************END EXIT SIM SYSTEM*************/
	 
		/*****************************GET TIME STAMP*********************************/
		String getSystemDate()
		{ 	String timestamp = ""; //Create a string to hold the date
			String pattern = "MM-dd-yyyy HH:mm:ss"; //Determine the pattern for the date and time fields
			SimpleDateFormat formatter = new SimpleDateFormat(pattern); //Set your date and time pattern
			Date date = new Date(); //Capture the system datetime in milliseconds
			timestamp = formatter.format(date); //Format the date based on the pattern
			return timestamp;
		}
		/****************************END GET TIME STAMP*********************************/
		
		
		
} // end of class
