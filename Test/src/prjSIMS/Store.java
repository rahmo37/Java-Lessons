package prjSIMS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class Store {

	ArrayList<Inventory> productsonhand; // all of the products on hand
	Vector<Product> items;
	Vector<Employee> staff;
	ArrayList<Department> deptArray;
	Scanner keyboard = new Scanner(System.in);
	Business biz;
	Hashtable<Integer, Supplier> vendors;

	/*******************************************************
	 * CONSTRUCTOR
	 *****************************************************/
	Store() {
		productsonhand = new ArrayList<Inventory>();
		items = new Vector<Product>();
		staff = new Vector<Employee>();
		deptArray = new ArrayList<Department>();
		biz = new Business();
		vendors = new Hashtable<>();
	}

	/**************************************************
	 * END OF CONSTRUCTOR
	 *****************************************************/

	/*******************************************************
	 * LOAD METHODS
	 ******************************************************/

	void loadData() throws IOException {
		loadBusiness();
		loadInventory();
		loadDepartments();
		loadProducts();
		loadEmployees();
		loadSuppliers();
	}

	void loadBusiness() throws IOException {
		// create a File for reading from your data file � assuming the file is with the
		// .src folder
		FileReader fr = new FileReader("store.dat");
		BufferedReader br = new BufferedReader(fr);

		// create the variables for each field in the file
		int storenum;
		String storename, address, city, state, zip, phone, empid;

		// Create a string to read each line and a tokenizer to separate at the field at
		// the comma
		String eachLine = "";
		StringTokenizer st;
		eachLine = br.readLine(); // read the first line
		while (eachLine != null) // tests for the eof
		{
			st = new StringTokenizer(eachLine, ","); // read each line
			while (st.hasMoreTokens()) // read each field
			{ // remember the order of the text file
				storenum = Integer.parseInt(st.nextToken());
				storename = st.nextToken();
				address = st.nextToken();
				city = st.nextToken();
				state = st.nextToken();
				zip = st.nextToken();
				phone = st.nextToken();
				empid = st.nextToken();
				biz = new Business(storenum, storename, address, city, state, zip, phone, empid); // create the store
				eachLine = br.readLine(); // read the next line
			} // end of reading one line
		} // end of reading the file

		br.close(); // close the file
		System.out.println("Businesses Loaded");
	} // end of loadBusiness() method

	void loadInventory() throws IOException {
		// create a File for reading from your data file � assuming the file is with the
		// .src folder
		FileReader fr = new FileReader("inventory.dat");
		BufferedReader br = new BufferedReader(fr);

		// create the variables for each field in the file
		long u = 0;
		int q = 0;

		// Create a string to read each line and a tokenizer to separate at the field at
		// the comma
		String eachLine = "";
		StringTokenizer st;

		while (eachLine != null) // tests for the eof
		{
			st = new StringTokenizer(eachLine, ","); // read each line

			while (st.hasMoreTokens()) // read each field
			{ // remember the order of the text file
				u = Long.parseLong(st.nextToken());
				q = Integer.parseInt(st.nextToken());
				productsonhand.add(new Inventory(u, q)); // add the inventory to the ArrayList
				eachLine = br.readLine(); // read the next line
			} // end of reading one line
		} // end of reading the file

		br.close(); // close the file
		System.out.println("Inventory Loaded");
	} // end of loadInventory() method

	void loadDepartments() throws IOException {
		FileReader fr = new FileReader("departments.dat");
		BufferedReader br = new BufferedReader(fr);

		String d = "";
		String dn = "";
		String ei = "";

		String eachLine = "";
		StringTokenizer st;
		eachLine = br.readLine(); // read the first line

		while (eachLine != null) // tests for the eof
		{
			st = new StringTokenizer(eachLine, ","); // read each line
			while (st.hasMoreTokens()) // read each field
			{
				d = st.nextToken();
				dn = st.nextToken();
				ei = st.nextToken();
				deptArray.add(new Department(d, dn, ei)); // add the Department to the ArrayList
				eachLine = br.readLine(); // read the next line

			} // end of reading one line
		} // end of reading the file
		br.close(); // close the file
		System.out.println("Departments loaded");
	} // end of loadDepartments() method

	void loadProducts() throws IOException {
		// create a File for reading from your data file � assuming the file is with the
		// .src folder
		FileReader fr = new FileReader("products.dat");
		BufferedReader br = new BufferedReader(fr);
		// create the variables for each field in the file
		long up = 0;
		String pn = "";
		String dn = "";
		double pc = 0.00;
		int xd = 0;
		int sn = 0;
		// Create a string to read each line and a tokenizer to separate at the field at
		// the comma
		String eachLine = "";
		StringTokenizer st;
		eachLine = br.readLine(); // read the first line
		while (eachLine != null) // tests for the eof
		{
			st = new StringTokenizer(eachLine, ","); // read each line

			while (st.hasMoreTokens()) // read each field
			{ // remember the order of the text file
				up = Long.parseLong(st.nextToken());
				pn = st.nextToken();
				dn = st.nextToken();
				pc = Double.parseDouble(st.nextToken());
				xd = Integer.parseInt(st.nextToken());
				sn = Integer.parseInt(st.nextToken());
				items.add(new Product(up, pn, dn, pc, xd, sn)); // add the product to the Vector
				eachLine = br.readLine(); // read the next line
			} // end of reading one line
		} // end of reading the file

		br.close(); // close the file
		System.out.println("Products Loaded");
	} // end of loadProducts() method

	void loadEmployees() throws IOException {
		FileReader fr = new FileReader("employees.dat");

		BufferedReader br = new BufferedReader(fr);

		String i = "";
		String n = "";
		String e = "";
		String p = "";
		boolean m = false;
		String manager = "";

		String eachLine = "";
		StringTokenizer st;
		eachLine = br.readLine(); // read the first line
		while (eachLine != null) {
			st = new StringTokenizer(eachLine, ",");
			while (st.hasMoreTokens()) {
				i = st.nextToken();
				n = st.nextToken();
				e = st.nextToken();
				p = st.nextToken();
				manager = st.nextToken();
				if (manager.equals("True"))
					m = true;
				staff.add(new Employee(i, n, e, p, m)); // add the product to the Vector
				eachLine = br.readLine(); // read the next line
			} // end of reading a lime
		} // end of reading the file

		br.close(); // close the file
		System.out.println("Employees Loaded");
	} // end of loadEmployees method

	void loadSuppliers() throws IOException {
		FileReader fr = new FileReader("suppliers.dat");

		BufferedReader br = new BufferedReader(fr);

		int supplierNum;
		String supplierName;
		String supplierAddress;
		String supplierEmail;
		String supplierPhone;

		String eachLine = "";
		StringTokenizer st;
		eachLine = br.readLine(); // read the first line
		while (eachLine != null) {
			st = new StringTokenizer(eachLine, ",");

			while (st.hasMoreTokens()) {
				supplierNum = Integer.parseInt(st.nextToken());
				supplierName = st.nextToken();
				supplierAddress = st.nextToken();
				supplierEmail = st.nextToken();
				supplierPhone = st.nextToken();

				vendors.put(supplierNum,
						new Supplier(supplierNum, supplierName, supplierAddress, supplierEmail, supplierPhone));

				eachLine = br.readLine(); // read the next line
			} // end of reading a lime
		} // end of reading the file

		br.close(); // close the file
		System.out.println("Suppliers Loaded");
	} // end of loadEmployees method

	/*******************************************************
	 * END OF LOAD METHOD
	 ***************************************************/

	/*******************************************************
	 * WELCOME METHOD
	 ******************************************************/

	// Welcome Menu
	void welcome() {
		System.out.println("****************************************************************************");
		System.out.println("Welcome to " + biz.getStorename() + " System!");
		System.out.println("****************************************************************************\n\n");
	}

	/**************************************************
	 * END OF WELCOME METHOD
	 ******************************************************/

	/*******************************************************
	 * SHOW MENU METHOD
	 ******************************************************/

	// Display Menu
	void showMenu() {
		int option = -1;

		do {

			System.out.println("*********************************SYSTEM PROCESSES***************************");
			System.out.println("1. Check Inventory");
			System.out.println("2. Restock");
			System.out.println("3. Update Price");
			System.out.println("4. Add New Supplier");
			System.out.println("5. Add New Product");
			System.out.println("6. Add New Employee");
			System.out.println("7. Exit");
			System.out.print("Choose a system process (1-7): ");
			option = keyboard.nextInt();
			switch (option) {
			case (1): { // checkInventory()
				break;
			}
			case (2): { // restockkInventory()
				break;
			}
			case (3): { // updatePrice()
				break;
			}
			case (4): { // addNewSupplier()
				break;
			}
			case (5): { // addNewProduct()
				break;
			}
			case (6): { // //addNewemployee()
				break;
			}
			case (7): { // updateDatabase()
				System.out.println("Thank you for using " + biz.getStorename() + " System, Program Terminated!");
				System.out.println("****************************************************************************\n\n");
				System.exit(0);
			}
			default: {
				System.out.println("Invalid choice, please choose between 1-7");
			}

			} // end of switch
		} while (option != 7);

	}

	/************************************************
	 * END OF SHOW MENU METHOD
	 ******************************************************/

	/**************************************************
	 * CHECK INVENTORY METHOD
	 ******************************************************/

	// checkInventory
	int checkInventory() {
		// search by upc
//		System.out.println("Enter Product's UPC");
//		long findWithUpc = keyboard.nextLong();
//		for (int i = 0; i < items.size(); i++) {
//			if (items.get(i).getUpc() == findWithUpc) {
//				System.out.println(items.get(i).getProductName());
//			}
//		}
		

		// search by productname
		System.out.println("Enter Product's Name");
		//keyboard.nextLine();
		String findWithProdName = keyboard.nextLine();

		for (int i = 0; i < items.size(); i++) {
			if ((items.get(i).getProductName().equals(findWithProdName))) {
				//System.out.println(items.get(i).getProductName().toLowerCase());
				System.out.println(items.get(i).getUpc());
			}

		}
		return -1;

	}// close check Inventory

	/**********************************************
	 * END OF CHECK INVENTORY METHOD
	 ***************************************************/

	/********************************************************
	 * NEW RECORD METHODS
	 ***************************************************/

	// add New Supplier
	void addNewSupplier() {
		System.out.println("Supplier Number: ");
		int number = keyboard.nextInt();

		System.out.println("Supplier name: ");
		String name = keyboard.nextLine();

		System.out.println("Supplier address: ");
		String address = keyboard.nextLine();

		System.out.println("Supplier email: ");
		String email = keyboard.nextLine();

		System.out.println("Supplier phone: ");
		String phone = keyboard.nextLine();

		vendors.put(number, new Supplier(number, name, address, email, phone));

	} // end of new supplier

	// add New Supplier
	void addNewEmployee() throws IOException {
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
		Employee nEmployee = new Employee(empid, empname, email, password, manager);
		staff.add(nEmployee);
	}

	/***************************************************
	 * END OF NEW RECORD METHODS
	 ***************************************************/

} // end of class
