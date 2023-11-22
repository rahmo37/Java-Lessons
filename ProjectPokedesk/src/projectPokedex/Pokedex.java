
package projectPokedex;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;
import java.io.*;

/*
 * Pokedex class
 * 
 * Name: Obaedur Rahman, Amir Mahmood, Kevin Scanchez, Luis Dejesus, Rodrigo Proano 
 * 
 */

public class Pokedex {

	/*******************************************************
	 * Variables and Data Structures
	 *****************************************************/

	ArrayList<Pokemon> pokeList;
	ArrayList<TypeAttribute> attributeList;
	static Hashtable<Integer, String> typeList;
	ArrayList<GymBadge> badgeList;
	Vector<User> userList;
	static ArrayList<String> colorList;
	ArrayList<String> resultList;
	Scanner scanner;
	Scanner scan;
	Connection connection;
	Statement statement;
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	/*******************************************************
	 * CONSTRUCTOR
	 *****************************************************/

	Pokedex() {
		pokeList = new ArrayList<>();
		attributeList = new ArrayList<>();
		typeList = new Hashtable<>();
		badgeList = new ArrayList<>();
		userList = new Vector<>();
		resultList = null;
		colorList = new ArrayList<>(Arrays.asList("", "Black", "Blue", "Brown", "Grey", "Green", "Pink", "Purple",
				"Red", "White", "Yellow"));
	}

	/*******************************************************
	 * Load All the data
	 *****************************************************/

	public void loadData() throws Exception {
		connection();
		loadPokemon();
		loadType();
		loadBadge();
		loadTrait();
		loadUser();
		System.out.println("\n");																									
	}

	/*******************************************************
	 * Load pokemon data
	 *****************************************************/
	/*
	 * Name: Obaedur Rahman
	 * 
	 */

	public void loadPokemon() {
		// An Object type array to load all data in one ArrayList
		ArrayList<Object> valueList;
		// int j = 0;

		// We need a join query to join multiple tables together from our data base
		String joinQuery = "SELECT PokeGenInfo.Gender, PokeGenInfo.Exp, PokeGenInfo.Region, PokeGenInfo.EvolveAt, PokeGenInfo.Color,"
				+ " PokeGenInfo.Mass, PokeGenInfo.Generation, PokeStats.HP, PokeStats.Atk, PokeStats.SpA, PokeStats.Def, PokeStats.SpD,"
				+ " PokeStats.Spe, PokeStats.Total, PokeAbility.[Ability1], PokeAbility.[Ability2],PokeAbility.[HiddenAbility], PokeTypeKeys.Type1,"
				+ " PokeTypeKeys.Type2, Pokemon.Name, Pokemon.ID FROM PokeStats INNER JOIN (((PokeGenInfo INNER JOIN Pokemon ON PokeGenInfo.ID = Pokemon.ID)"
				+ " INNER JOIN PokeAbility ON Pokemon.ID = PokeAbility.ID) INNER JOIN PokeTypeKeys ON Pokemon.ID = PokeTypeKeys.ID) "
				+ "ON PokeStats.ID = Pokemon.ID";
		try {
			ResultSet resultSet = statement.executeQuery(joinQuery);

			while (resultSet.next()) {
				valueList = new ArrayList<>();
				/*
				 * Since the OBJECT class is the parent of all class, we are using the OBJECT
				 * type ArrayList to load all(Different Types of) data into one DataStructure.
				 * It is done this way so we don't have to declare temporary variables for all
				 * 21 fields. the code would get too long
				 */
				for (int i = 1; i < 22; i++) {
					/*
					 * Looping 21 times to add all data in one ArrayList Where i will represent the
					 * field number in our result set i = 1 - 21
					 */
					valueList.add(resultSet.getObject(i));
				}
				/*
				 * we do need to cast the data in our ArrayList. We need to cast each field when
				 * we are passing them as an argument in the constructor
				 */
				pokeList.add(new Pokemon(((String) valueList.get(0)), (int) valueList.get(1), (String) valueList.get(2),
						(String) valueList.get(3), (String) valueList.get(4), (double) valueList.get(5),
						(String) valueList.get(6), (int) valueList.get(7), (int) valueList.get(8),
						(int) valueList.get(9), (int) valueList.get(10), (int) valueList.get(11),
						(int) valueList.get(12), (int) valueList.get(13), (String) valueList.get(14),
						(String) valueList.get(15), (String) valueList.get(16), (int) valueList.get(17),
						(int) valueList.get(18), (String) valueList.get(19), (int) valueList.get(20)));
				// System.out.println(pokeList.get(j));
				// j++;
			}
			resultSet.close();
			Thread.sleep(250);
			System.out.print(ANSI_YELLOW + "." + ANSI_RESET);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/*******************************************************
	 * Load Types data
	 *****************************************************/
	/*
	 * Name: Obaedur Rahman
	 * 
	 */

	public void loadType() {
		String query = "SELECT * FROM AllTypes";
		try {
			// int i = 0;
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				typeList.put(resultSet.getInt("Id"), resultSet.getString("Type"));
				// i++;

			}
			resultSet.close();
			Thread.sleep(250);
			System.out.print(ANSI_YELLOW + "." + ANSI_RESET);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*******************************************************
	 * Load Badge data
	 *****************************************************/
	/*
	 * Name: Obaedur Rahman
	 * 
	 */

	public void loadBadge() {
		String badgeName, gymLocation, gymLeader, badgeRegion, badgeAffect = "";
		String query = "SELECT * FROM GymBadges";
		try {
			int i = 0;
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				badgeName = resultSet.getString("badgeName");
				gymLocation = resultSet.getString("gymLocation");
				gymLeader = resultSet.getString("gymLeader");
				badgeRegion = resultSet.getString("badgeRegion");
				badgeAffect = resultSet.getString("badgeAffect");
				badgeList.add(new GymBadge(badgeName, gymLocation, gymLeader, badgeRegion, badgeAffect));
			}
			resultSet.close();
			Thread.sleep(250);
			System.out.print(ANSI_YELLOW + "." + ANSI_RESET);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*******************************************************
	 * Load Trait data
	 *****************************************************/
	/*
	 * Name: Obaedur Rahman
	 * 
	 */

	public void loadTrait() throws Exception {
		int i;
		ResultSet resultSet;

		/*
		 * we need two queries to retrieve data from two different table
		 */
		String queryS = "SELECT * FROM TypeSuperiorTo";
		String queryI = "SELECT * FROM TypeInferiorTo";

		try {
			/*
			 * at first we are retrieving data from out hash table called typeList, which
			 * has all the type (N/A to Fairy). we are going to load all the type (Normal to
			 * Fairy(Excluding N/A)) from our hash table to our TypeAttribute class
			 */
			i = 1;
			/*
			 * i is initialized to 1 because we don't need the N/A in our TypeAttribute
			 * class
			 */
			resultSet = statement.executeQuery(queryS);
			while (resultSet.next()) {
				/*
				 * Creating TypeAttribute objects for all the types (Normal to Fairy)
				 * Transferring all data from hash table to TypeAttribute class, passing them
				 * directly in the constructor so the "typeName" variable could get instantiated
				 */
				attributeList.add(new TypeAttribute(typeList.get(i)));

				/*
				 * In TypeAttribute class we have two arrayList addSuperiority and
				 * addInferiority. Which needs to hold the keys that will be passed onto the
				 * hash table. Ex. for "typeName" Fire, when you pass [4 , 6, 12] the keys will
				 * yield grass , ice and bug so in our method, the output will be
				 * "fire is superior against grass , ice and bug"
				 * 
				 * 
				 * therefore, we are loading the the keys from our access data table to our
				 * arrayList(addSuperiority, addInferiority)
				 */

				/*
				 * in the for loops below, we are loading every key associated with the object
				 * we created above. Ex. for object in index 1 has "typeName = fire"
				 * addSuperiority(ArrayList) = [4 ,6 ,12] addInferiority(ArrayList) = [3 ,9 ,13]
				 * 
				 * 
				 * j is starting from 2 because we don't need the first column "Type", we
				 * already loaded the "Type names" from our hash table when we created the
				 * object above
				 * 
				 * if the result set yields a -1 the loop will break. means the there is no more
				 * record (Plz check the DB table). attributeList.get(i - 1) is because the the
				 * object index started from 0 ex. attributeList.get(0) = Normal
				 * attributeList.get(1) = Fire attributeList.get(2) = Water and so on
				 * 
				 */
				for (int j = 2; j < 7; j++) {
					if (resultSet.getInt(j) == -1) {
						break;
					} else {
						attributeList.get(i - 1).addSuperiority(resultSet.getInt(j));
					}
				}

				i++;
			}

			i = 1;
			resultSet = statement.executeQuery(queryI);
			while (resultSet.next()) {
				for (int j = 2; j < 7; j++) {
					if (resultSet.getInt(j) == -1) {
						break;
					} else {
						attributeList.get(i - 1).addInferiority(resultSet.getInt(j));
					}
				}

				i++;
			}

			resultSet.close();
			Thread.sleep(250);
			System.out.print(ANSI_YELLOW + "." + ANSI_RESET);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/*******************************************************
	 * Load user data
	 *****************************************************/
	/*
	 * Name: Obaedur Rahman
	 * 
	 */

	public void loadUser() {
//		int i = 0;
		String query = "SELECT * FROM User";
		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				userList.add(new User(resultSet.getString("FirstName"), resultSet.getString("LastName"),
						resultSet.getString("Email"), resultSet.getString("Phone"), resultSet.getString("Pass"),
						resultSet.getBoolean("isAdmin"), resultSet.getString("DateAdded")));
//				System.out.println(userList.get(i).toString());
//				i++;
			}
			resultSet.close();
			Thread.sleep(250);
			System.out.print(ANSI_YELLOW + "." + ANSI_RESET);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/*******************************************************
	 * Connection Method
	 *****************************************************/
	/*
	 * Name: Obaedur Rahman
	 * 
	 */

	public void connection() throws Exception {
		String databaseUrl = "jdbc:ucanaccess://PokemonDatabase.accdb";
		connection = DriverManager.getConnection(databaseUrl);
		System.out.println(ANSI_YELLOW);
		System.out.println("Database connected... \n");
		statement = connection.createStatement();
	}

	/*******************************************************
	 * End of connection method
	 *****************************************************/

	/*******************************************************
	 * Search Method
	 *****************************************************/

	/*
	 * Name: Luis Dejesus
	 * 
	 * The search method and its sub-methods are helper methods that is used to
	 * implement other methods
	 * 
	 */

	public ArrayList<String> search() {
		resultList = new ArrayList<>();
		scanner = new Scanner(System.in);
		String userResponse = "";

		System.out.println("\nHow do you want to search: ");
		System.out.println("\nPress 1 to search by name\npress 2 to search with multiple attributes");
		userResponse = scanner.nextLine();
		if (userResponse.equals("1")) {
			return resultList = searchByName();
		} else if (userResponse.equals("2")) {
			return resultList = searchByMultiple();
		} else {
			System.out.println("Invalid Response!");
		}
		return null;
	}

	// sub method of search method
	public ArrayList<String> searchByName() {
		resultList = new ArrayList<>();
		scanner = new Scanner(System.in);
		int counter = 0;
		boolean isFound = true;
		String userResponse = "";
		do {
			System.out.println("\nEnter partial or full name of a pokemon");
			if (counter > 0) {
				System.out.println("Or press 0 to return to previous menu");
			}
			userResponse = scanner.nextLine();
			if (userResponse.equals("0")) {
				return null;
			}
			for (int i = 0; i < pokeList.size(); i++) {
				isFound = true;
				for (int j = 0; j < userResponse.length(); j++) {
					if (userResponse.toLowerCase().charAt(j) == pokeList.get(i).getName().toLowerCase().charAt(j)) {
						continue;
					} else {
						isFound = false;
						break;
					}
				}
				if (isFound) {
					resultList.add(pokeList.get(i).getName());
				}
			}
			if (resultList.isEmpty()) {
				System.out.println("No pokemon exist with the provided name!\n");
			}
			counter++;
		} while (resultList.isEmpty());
		HelperMethod.insertionSort(resultList);
		return resultList;
	}

	// sub method of search method
	public ArrayList<String> searchByMultiple() {
		ArrayList<String> resultListFiltered = new ArrayList<>();
		resultList = new ArrayList<>();

		scanner = new Scanner(System.in);
		int color = 0;
		int type1 = 0;
		int type2 = 0;
		String userResponse = "";
		resultList = searchByName();
		if (resultList == null) {
			return null;
		}
		while (true) {

			System.out.println("Do you know the Color of the pokemon? (y/n)");
			userResponse = scanner.nextLine();
			if (userResponse.equals("y")) {
				for (int i = 1; i < colorList.size(); i++) {
					System.out.println(i + ". " + colorList.get(i));
				}
				System.out.println("Enter a Color number: ");
				color = Integer.parseInt(scanner.nextLine());
				break;
			} else if (userResponse.equals("n")) {
				break;
			} else {
				System.out.println("Invalid response!\n");
				continue;
			}
		}
		while (true) {
			System.out.println("Do you know the Type of the pokemon? (y/n)");
			userResponse = scanner.nextLine();
			if (userResponse.equals("y")) {
				for (int i = 0; i < typeList.size(); i++) {
					System.out.println(i + 1 + ". " + typeList.get(i));
				}
				System.out.println("Enter a type number for Type1: ");
				type1 = Integer.parseInt(scanner.nextLine()) - 1;
				System.out.println("Enter a type number for Type2: ");
				type2 = Integer.parseInt(scanner.nextLine()) - 1;
				break;
			} else if (userResponse.equals("n")) {
				break;
			} else {
				System.out.println("Invalid response!\n");
				continue;
			}
		}
		for (int i = 0; i < resultList.size(); i++) {
			for (int j = 0; j < pokeList.size(); j++) {
				if (resultList.get(i).equals(pokeList.get(j).getName())) {
					if (colorList.get(color).equals(pokeList.get(j).getColor()) && type1 == pokeList.get(j).getType1()
							&& type2 == pokeList.get(j).getType2()) {
						resultListFiltered.add(pokeList.get(j).getName());
					}
				}
			}
		}
		if (resultListFiltered.isEmpty()) {
			System.out.println("\nNo specific pokemon found with the provided information."
					+ " \nBelow is some suggetions you can choose from");
			return resultList;
		} else {
			return resultListFiltered;
		}

	}

	// sub method of search method
	public String selectPokemon() {
		scanner = new Scanner(System.in);
		boolean isFound;
		String userResponse = "";
		String selectedPokemon = "";
		int pokeNum = 0;

		while (!userResponse.equals("m")) {
			isFound = false;
			System.out.println("\npress 1 to enter a pokemon name\npress 2 to search for a pokemon"
					+ "\nOr press m to return to main menu");
			userResponse = scanner.nextLine();
			if (userResponse.equals("1")) {
				System.out.println("\nEnter full name of a pokemon name: ");
				userResponse = scanner.nextLine();
				for (int i = 0; i < pokeList.size(); i++) {
					if (pokeList.get(i).getName().equalsIgnoreCase(userResponse)) {
						return selectedPokemon = pokeList.get(i).getName();
					}
				}
				if (!isFound) {
					System.out.println("No pokemon exist with the provided name!");
					System.out.println("\nSelect again (y/n)");
					userResponse = scanner.nextLine();
					if (userResponse.equals("y")) {
						continue;
					} else if (userResponse.equals("n")) {
						return null;
					} else {
						System.out.println("Invalid response!");
					}

				}

			} else if (userResponse.equals("2")) {
				while (!userResponse.equals("n")) {
					resultList = search();
					if (resultList == null) {
						break;
					}
					for (int i = 0; i < resultList.size(); i++) {
						System.out.println(i + 1 + ". " + resultList.get(i));
					}
					System.out.println("\nEnter a pokemon number from the list");
					pokeNum = Integer.parseInt(userResponse = scanner.nextLine()) - 1;
					for (int i = 0; i < pokeList.size(); i++) {
						if (resultList.get(pokeNum).equals(pokeList.get(i).getName())) {
							return selectedPokemon = pokeList.get(i).getName();
						}
					}
				}
			} else if (userResponse.equals("m")) {
				break;
			} else {
				System.out.println("Invalid response!");
			}
		}
		return null;
	}

	// sub method of search method
	public int returnPokeID() {
		String selectedPokemon = "";
		int pokeId = 0;
		selectedPokemon = selectPokemon();
		if (selectedPokemon == null) {
			return 0;
		}
		for (int i = 0; i < pokeList.size(); i++) {
			if (selectedPokemon.equals(pokeList.get(i).getName())) {
				pokeId = i;
			}
		}
		return pokeId;
	}

	/*******************************************************
	 * End of search Method
	 *****************************************************/

	/*******************************************************
	 * Welcome Screen
	 *****************************************************/
	/*
	 * Name: Amir Mahmood
	 * 
	 */
	public void welcomeScreen() throws Exception {

		/************************************************************
		 * Start of POKEDEX SCREEN
		 ************************************************************
		 *
		 * Name: Kevin Sanchez Date:12/3/2022
		 * 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		int width = 110;
		int height = 16;

		// Create a program logo
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("SansSerif", Font.BOLD, 19));
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.drawString("POKEDEX", 5, 15);

		for (int y = 0; y < height; y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < width; x++) {
				sb.append(image.getRGB(x, y) == -16777216 ? "*" : " ");
			}

			if (sb.toString().trim().isEmpty()) {
				continue;
			}

			System.out.println(ANSI_RED + sb + ANSI_RESET + ANSI_YELLOW);

		}

		/************************************************************
		 * End of POKEDEX SCREEN
		 ************************************************************/

		scanner = new Scanner(System.in);
		String userResponse;
		System.out.println(ANSI_YELLOW
				+ "\n\n\t\t   Welcome to pokedex!\nYou can create an Account or Login to explore the pokemon world!");

		do {
			System.out.println("\nPress 1 to create an Account");
			System.out.println("Press 2 to Login\nPress q to quit");
			userResponse = scanner.nextLine();
			switch (userResponse) {
			case "1":
				createAccount();
				break;
			case "2":
				login();
				break;
			case "q":
				System.out.println("Thanks for using pokedex!!");
				System.exit(0);
				break;
			default:
				System.out.println("Not an valid response!");
			}
		} while (!userResponse.equals("2"));
	}

	/*******************************************************
	 * End of welcome screen
	 *****************************************************/

	/*******************************************************
	 * createAccount Method
	 *****************************************************/

	public void createAccount() {
		/*
		 * Name: Obaedur Rahman
		 * 
		 */
		String firstName, lastName, email, phone, pass = "";
		scanner = new Scanner(System.in);
		System.out.print("Enter First name: ");
		firstName = scanner.nextLine();
		System.out.print("Enter Last name: ");
		lastName = scanner.nextLine();
		while (true) {
			System.out.print("Enter Email address: ");
			if (HelperMethod.isValidEmail(email = scanner.nextLine())) {
				break;
			} else {
				System.out.println("Invalid Input! Enter a valid Email...");
				continue;
			}
		}
		while (true) {
			System.out.print("Enter Phone number: ");
			if (HelperMethod.isValidPhone(phone = scanner.nextLine())) {
				break;
			} else {
				System.out.println("Unexpected Character found! Enter a Valid Phone Number... ");
				continue;
			}
		}
		System.out.print("Create a Password: ");
		pass = scanner.nextLine();

		userList.add(new User(firstName, lastName, email, phone, pass, false, HelperMethod.timeStamp()));
		writeToUserTable();
	}

	// Sub method of createAccount
	public void writeToUserTable() {
		try {
			int tempId = User.id - 1;
			int rows = 0;
			String query = "INSERT INTO User (ID, FirstName, LastName, Email, Phone, Pass, isAdmin, DateAdded)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, User.id);
			preparedStatement.setString(2, userList.get(tempId).getFirstName());
			preparedStatement.setString(3, userList.get(tempId).getLastName());
			preparedStatement.setString(4, userList.get(tempId).getEmail());
			preparedStatement.setString(5, userList.get(tempId).getPhone());
			preparedStatement.setString(6, userList.get(tempId).getPassword());
			preparedStatement.setBoolean(7, userList.get(tempId).getIsAdmin());
			preparedStatement.setString(8, userList.get(tempId).getDateAndTimeAdded());
			rows += preparedStatement.executeUpdate();

			if (rows > 0) {
				System.out.println(
						"Account created successfully!!" + "\nYou can use your Email and Password to login...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*******************************************************
	 * End of create Account Method
	 *****************************************************/

	/*******************************************************
	 * Login Method
	 *****************************************************/
	/*
	 * Name: Obaedur Rahman
	 * 
	 */

	public void login() throws Exception {
		int attempt = 0;
		int userId = 0;
		String email, password;
		boolean isValidLogin = false;
		String userResponse = "";
		scanner = new Scanner(System.in);

		while (isValidLogin == false && attempt <= 3) {
			System.out.print("\nEnter Email: ");
			email = scanner.nextLine();
			System.out.print("Enter Password: ");
			password = scanner.nextLine();

			for (int i = 0; i < userList.size(); i++) {
				if (email.equalsIgnoreCase(userList.get(i).getEmail())
						&& password.equals(userList.get(i).getPassword())) {
					for (int j = 0; j < 3; j++) {
						System.out.print(".");
						Thread.sleep(250);
					}
					System.out.println();
					System.out.println("Login successful!\n");
					Thread.sleep(250);
					isValidLogin = true;
					userId = i;

				}
			}
			attempt++;
			if (isValidLogin == false && attempt < 3) {
				System.out
						.println("\nInvalid credentials!\nCheck the email or password you entered" + " and try again.");
			} else if (isValidLogin == false && attempt >= 3) {
				System.out.println("\nInvalid credentials!\nToo many attempts.Program terminated...");
				System.exit(0);
			}
		}
		if (userList.get(userId).getIsAdmin()) {
			System.out.println(
					"Welcome " + ANSI_CYAN + userList.get(userId).getFirstName() + "!" + ANSI_RESET + ANSI_YELLOW);
			while (!userResponse.equals("q")) {
				System.out.println("\nEnter your selection: \n");
				System.out.println("Press 1 to view Pokedex\nPress 2 to modify Pokedex\nor q to quit");
				userResponse = scanner.nextLine();

				if (userResponse.equals("1")) {
					viewPokedex(userId);
				} else if (userResponse.equals("2")) {
					modifyPokedex();
				} else if (userResponse.equals("q")) {
					System.out.println(ANSI_CYAN + "Thanks for using pokedex!" + ANSI_RESET);
					System.exit(1);
				} else {
					System.out.println("Invalid response!");
				}
			}
		} else {
			while (true) {
				System.out.println(
						"Welcome " + ANSI_CYAN + userList.get(userId).getFirstName() + "!" + ANSI_RESET + ANSI_YELLOW);
				viewPokedex(userId);
			}
		}

	}

	/*******************************************************
	 * End of login Method
	 *****************************************************/

	/*******************************************************
	 * Modify Pokedex
	 *****************************************************/
	/*
	 * Name: Obaedur Rahman
	 * 
	 */
	public void modifyPokedex() throws Exception {
		scanner = new Scanner(System.in);
		String selectedPokemon = "";
		String userResponse = "";
		int pokeNum = 0;
		while (true) {
			System.out.println("\nPress 1 to modify a pokemon's attributes\nPress 2 to add a new pokemon"
					+ "\npress p to return to previous menu\npress q to quit");
			userResponse = scanner.nextLine();
			if (userResponse.equals("1")) {
				System.out.println("\nSelect a pokemon to modify it's attributes");

				selectedPokemon = selectPokemon();
				if (selectedPokemon == null) {
					return;
				} else {
					for (int i = 0; i < pokeList.size(); i++) {
						if (selectedPokemon.equals(pokeList.get(i).getName())) {
							pokeNum = i;
						}
					}
				}
				modifyAttributes(pokeNum);
				return;
			} else if (userResponse.equals("2")) {
				addNewPokemon();
				return;
			} else if (userResponse.equals("p")) {
				return;
			} else if (userResponse.equals("q")) {
				System.out.println("Thanks for using pokedex!");
				System.exit(3);
			} else {
				System.out.println("Invalid Response!");
			}
		}
	}

	/*******************************************************
	 * End of modifyPokedex
	 *****************************************************/

	/*******************************************************
	 * Start of modifyAttributes
	 *****************************************************/
	/*
	 * Name: Obaedur Rahman
	 * 
	 */
	public void modifyAttributes(int pokeNum) {
		scanner = new Scanner(System.in);
		String userResponse = "";
		StringBuilder modifyMenu = new StringBuilder();
		modifyMenu.append("\n" + pokeList.get(pokeNum).getName() + "\n**********" + "\n");
		modifyMenu.append("Press 1 to modify its Stats\n");
		modifyMenu.append("Press 2 to modify its Ability\n");
		modifyMenu.append("Press 3 to modify its Type\n");
		modifyMenu.append("Press 4 to modify its General information\n");
		modifyMenu.append("\nPress m to return to the menu menu\n");
		modifyMenu.append("Press q to quit\n");
		while (true) {
			System.out.println(modifyMenu.toString());
			userResponse = scanner.nextLine();
			switch (userResponse) {
			case "1":
				modifyStats(pokeNum);
				break;
			case "2":
				modifyAbility(pokeNum);
				break;
			case "3":
				modifyType(pokeNum);
				break;
			case "4":
				modifyGenInfo(pokeNum);
				break;
			case "m":
				return;
			case "q":
				System.out.println("Thanks for using pokedex!!");
				System.exit(2);
			default:
				System.out.println("Not an valid response!");
				continue;
			}
		}
	}

	// sub method of modifyAttributes
	public void modifyStats(int pokeNum) {
		scanner = new Scanner(System.in);
		Object prev;
		String userResponse = "";
		String fieldName = "";
		String tableName = "PokeStats";
		System.out.println("\n" + pokeList.get(pokeNum).getName() + "'s current stats:");
		System.out.println(pokeList.get(pokeNum).printStats());
		while (true) {
			System.out.println("\nEnter a stat number from the list to modify: ");
			userResponse = scanner.nextLine();
			switch (userResponse) {
			case "1":
				System.out.println("Enter new HP: ");
				fieldName = "HP";
				prev = pokeList.get(pokeNum).getHP();
				pokeList.get(pokeNum).setHP(Integer.parseInt(userResponse = scanner.nextLine()));
				updateModification(pokeNum, tableName, fieldName, pokeList.get(pokeNum).getHP());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getHP());
				break;
			case "2":
				fieldName = "Atk";
				prev = pokeList.get(pokeNum).getAttack();
				System.out.println("Enter new Attack: ");
				pokeList.get(pokeNum).setAttack(Integer.parseInt(userResponse = scanner.nextLine()));
				updateModification(pokeNum, tableName, fieldName, pokeList.get(pokeNum).getAttack());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getAttack());
				break;
			case "3":
				fieldName = "SpA";
				prev = pokeList.get(pokeNum).getSpAttack();
				System.out.println("Enter new SPAttack: ");
				pokeList.get(pokeNum).setSpAttack(Integer.parseInt(userResponse = scanner.nextLine()));
				updateModification(pokeNum, tableName, fieldName, pokeList.get(pokeNum).getSpAttack());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getSpAttack());
				break;
			case "4":
				fieldName = "Def";
				prev = pokeList.get(pokeNum).getDefense();
				System.out.println("Enter new Defense: ");
				pokeList.get(pokeNum).setDefense(Integer.parseInt(userResponse = scanner.nextLine()));
				updateModification(pokeNum, tableName, fieldName, pokeList.get(pokeNum).getDefense());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getDefense());
				break;
			case "5":
				fieldName = "SpD";
				prev = pokeList.get(pokeNum).getSpDefense();
				System.out.println("Enter new SPDefense: ");
				pokeList.get(pokeNum).setSpDefense(Integer.parseInt(userResponse = scanner.nextLine()));
				updateModification(pokeNum, tableName, fieldName, pokeList.get(pokeNum).getSpDefense());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getSpDefense());
				break;
			case "6":
				fieldName = "Spe";
				prev = pokeList.get(pokeNum).getSpeed();
				System.out.println("Enter new Speed: ");
				pokeList.get(pokeNum).setSpeed(Integer.parseInt(userResponse = scanner.nextLine()));
				updateModification(pokeNum, tableName, fieldName = "Spe", pokeList.get(pokeNum).getSpeed());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getSpeed());
				break;
			default:
				System.out.println("Invalid Response!");
				continue;
			}
			while (true) {
				System.out.println("Modify another stat? (y/n)");
				userResponse = scanner.nextLine();
				if (userResponse.equals("y")) {
					break;
				} else if (userResponse.equals("n")) {
					pokeList.get(pokeNum)
							.setTotal(pokeList.get(pokeNum).getAttack() + pokeList.get(pokeNum).getSpAttack()
									+ pokeList.get(pokeNum).getDefense() + pokeList.get(pokeNum).getSpDefense()
									+ pokeList.get(pokeNum).getSpeed() + pokeList.get(pokeNum).getHP());
					updateModification(pokeNum, tableName, fieldName = "Total", pokeList.get(pokeNum).getTotal());
					return;
				} else {
					System.out.println("Invalid Response!");
				}
			}
		}

	}

	// Sub method for modifyAttributes
	public void modifyAbility(int pokeNum) {
		scanner = new Scanner(System.in);
		Object prev;
		String userResponse = "";
		String fieldName = "";
		String tableName = "PokeAbility";
		System.out.println("\n" + pokeList.get(pokeNum).getName() + "'s current abilities:");
		System.out.println(pokeList.get(pokeNum).printAbility());
		while (true) {
			System.out.println("\nEnter an ability number from the above list to modify it: ");
			userResponse = scanner.nextLine();
			switch (userResponse) {
			case "1":
				fieldName = "Ability1";
				prev = pokeList.get(pokeNum).getAbility1();
				System.out.println("Enter new Ability1: ");
				pokeList.get(pokeNum).setAbility1(userResponse = scanner.nextLine());
				updateModification(pokeNum, tableName, fieldName, pokeList.get(pokeNum).getAbility1());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getAbility1());
				break;
			case "2":
				fieldName = "Ability2";
				prev = pokeList.get(pokeNum).getAbility2();
				System.out.println("Enter new Ability2: ");
				pokeList.get(pokeNum).setAbility2(userResponse = scanner.nextLine());
				updateModification(pokeNum, tableName, fieldName, pokeList.get(pokeNum).getAbility2());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getAbility2());
				break;
			case "3":
				fieldName = "HiddenAbility";
				prev = pokeList.get(pokeNum).getHiddenAbility();
				System.out.println("Enter new HiddenAbility: ");
				pokeList.get(pokeNum).setHiddenAbility(userResponse = scanner.nextLine());
				updateModification(pokeNum, tableName, fieldName, pokeList.get(pokeNum).getHiddenAbility());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getHiddenAbility());
				break;
			default:
				System.out.println("Invalid Response!");
				continue;
			}
			while (true) {
				System.out.println("Modify another ability? (y/n)");
				userResponse = scanner.nextLine();
				if (userResponse.equals("y")) {
					break;
				} else if (userResponse.equals("n")) {
					return;
				} else {
					System.out.println("Invalid Response!");
				}
			}
		}
	}

	// Sub method for modifyAttributes
	public void modifyType(int pokeNum) {
		scanner = new Scanner(System.in);
		Object prev;
		String userResponse = "";
		String fieldName = "";
		String tableName = "PokeTypeKeys";
		System.out.println("\n" + pokeList.get(pokeNum).getName() + "'s current types:");
		System.out.println(pokeList.get(pokeNum).printTypes());
		while (true) {
			System.out.println("\nEnter 1 for type1 or 2 for type2 to modify: ");
			userResponse = scanner.nextLine();
			switch (userResponse) {
			case "1":
				fieldName = "Type1";
				prev = pokeList.get(pokeNum).getType1();
				for (int i = 1; i < typeList.size(); i++) {
					System.out.println(i + ". " + typeList.get(i));
				}
				System.out.println("Select a type number from the list for Type1: ");
				pokeList.get(pokeNum).setType1(Integer.parseInt(userResponse = scanner.nextLine()));
				updateModification(pokeNum, tableName, fieldName, pokeList.get(pokeNum).getType1());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getType1());
				break;
			case "2":
				fieldName = "Type2";
				prev = pokeList.get(pokeNum).getType2();
				for (int i = 0; i < typeList.size(); i++) {
					System.out.println(i + ". " + typeList.get(i));
				}
				System.out.println("Select a type number from the list for Type2: ");
				pokeList.get(pokeNum).setType2(Integer.parseInt(userResponse = scanner.nextLine()));
				updateModification(pokeNum, tableName, fieldName = "Type2", pokeList.get(pokeNum).getType2());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getType2());
				break;
			default:
				System.out.println("Invalid Response!");
				continue;
			}
			while (true) {
				System.out.println("Modify another type? (y/n)");
				userResponse = scanner.nextLine();
				if (userResponse.equals("y")) {
					break;
				} else if (userResponse.equals("n")) {
					return;
				} else {
					System.out.println("Invalid Response!");
				}
			}
		}

	}

	// sub method of modifyAttributes
	public void modifyGenInfo(int pokeNum) {
		scanner = new Scanner(System.in);
		Object prev;
		String userResponse = "";
		String fieldName = "";
		String tableName = "PokeGenInfo";
		System.out.println("\n" + pokeList.get(pokeNum).getName() + "'s current Information:");
		System.out.println(pokeList.get(pokeNum).printGenInfo());
		while (true) {
			System.out.println("\nEnter an info number from the list to modify: ");
			userResponse = scanner.nextLine();
			switch (userResponse) {
			case "1":
				fieldName = "Gender";
				prev = pokeList.get(pokeNum).getGender();
				System.out.println("Enter new gender: ");
				pokeList.get(pokeNum).setGender(userResponse = scanner.nextLine());
				updateModification(pokeNum, tableName, fieldName, pokeList.get(pokeNum).getGender());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getGender());
				break;
			case "2":
				fieldName = "Exp";
				prev = pokeList.get(pokeNum).getExp();
				System.out.println("Enter new exp: ");
				pokeList.get(pokeNum).setExp(Integer.parseInt(userResponse = scanner.nextLine()));
				updateModification(pokeNum, tableName, fieldName, pokeList.get(pokeNum).getExp());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getExp());
				break;
			case "3":
				fieldName = "Region";
				prev = pokeList.get(pokeNum).getRegion();
				System.out.println("Available regions: Kanto, Johto, Hoenn, Sinnoh, Unova, Kalos \n");
				System.out.println("Enter new region name: ");
				pokeList.get(pokeNum).setRegion(userResponse = scanner.nextLine());
				updateModification(pokeNum, tableName, fieldName, pokeList.get(pokeNum).getRegion());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getRegion());
				break;
			case "4":
				fieldName = "EvolveAt";
				prev = pokeList.get(pokeNum).getEvolveAt();
				System.out.println("Enter new evlove level: ");
				pokeList.get(pokeNum).setEvolveAt(userResponse = scanner.nextLine());
				updateModification(pokeNum, tableName, fieldName, pokeList.get(pokeNum).getEvolveAt());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getEvolveAt());
				break;
			case "5":
				System.out.println("Avaiable colors: ");
				fieldName = "Color";
				prev = pokeList.get(pokeNum).getColor();
				for (int i = 1; i < colorList.size(); i++) {
					System.out.println(i + ". " + colorList.get(i) + " ");
				}
				System.out.println("Enter a color number from the list: ");
				pokeList.get(pokeNum).setColor(colorList.get(Integer.parseInt(userResponse = scanner.nextLine())));
				updateModification(pokeNum, tableName, fieldName = "Color", pokeList.get(pokeNum).getColor());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getColor());
				break;
			case "6":
				fieldName = "Mass";
				prev = pokeList.get(pokeNum).getMass();
				System.out.println("Enter new mass: ");
				pokeList.get(pokeNum).setMass(Double.parseDouble(userResponse = scanner.nextLine()));
				updateModification(pokeNum, tableName, fieldName = "Mass", pokeList.get(pokeNum).getMass());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getMass());
				break;
			case "7":
				fieldName = "Generation";
				prev = pokeList.get(pokeNum).getGeneration();
				System.out.println("Available generation: Gen(1-6)");
				System.out.println("Enter new generation: ");
				pokeList.get(pokeNum).setGeneration(userResponse = scanner.nextLine());
				updateModification(pokeNum, tableName, fieldName = "Generation", pokeList.get(pokeNum).getGeneration());
				modificationRecords(pokeNum, fieldName, prev, pokeList.get(pokeNum).getGeneration());
				break;
			default:
				System.out.println("Invalid Response!");
				continue;
			}
			while (true) {
				System.out.println("Modify another info? (y/n)");
				userResponse = scanner.nextLine();
				if (userResponse.equals("y")) {
					break;
				} else if (userResponse.equals("n")) {
					return;
				} else {
					System.out.println("Invalid Response!");
				}
			}
		}

	}

	// sub method of modifyAttributes
	public void updateModification(int pokeNum, String table, String field, Object value) {
		// This method updates the modified data to the Database
		String updateQuery = "UPDATE " + table + " SET " + field + " = ? " + "WHERE ID = ?";
		try {
			int rows = 0;
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setObject(1, value);
			preparedStatement.setInt(2, pokeList.get(pokeNum).getNationalId());
			rows += preparedStatement.executeUpdate();

			if (rows > 0) {
				System.out.println("\n" + field + " field updated for " + pokeList.get(pokeNum).getName());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void modificationRecords(int pokeNum, String field, Object prev, Object cur) {
		String recQuery = "INSERT INTO ModificationRecords (Pokemon, FieldName, PrevValue, CurValue, DateAdded)"
				+ " VALUES (? ,?, ?, ?, ?)";
		try {
			int rows = 0;
			PreparedStatement preparedStatement = connection.prepareStatement(recQuery);
			preparedStatement.setString(1, pokeList.get(pokeNum).getName());
			preparedStatement.setString(2, field);
			preparedStatement.setObject(3, prev);
			preparedStatement.setObject(4, cur);
			preparedStatement.setString(5, HelperMethod.timeStamp());
			rows += preparedStatement.executeUpdate();

			if (rows > 0) {
				System.out.println("Record saved in the database" + "\n");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/************************************************************
	 * Start of Add new Pokemon Method
	 ************************************************************
	 *
	 * Name: Kevin Sanchez Date:11/27/2022 Purpose: Add a new Pokemon and its
	 * attributes to the data structure as well as database
	 */
	void addNewPokemon() throws Exception {

		scan = new Scanner(System.in);

		// DISPLAY MENU HEADER
		System.out.println("\n\n");
		System.out.println(ANSI_CYAN + "----------------------------------------------------------");
		System.out.println("            Welcome to the ADD NEW POKEMON MENU           ");
		System.out.println("----------------------------------------------------------" + ANSI_RESET + ANSI_YELLOW);

		/*
		 * Asking user if they'd like to create a new Pokemon
		 */

		System.out.println("Would you like to create a new Pokemon? (y/n) ");
		String userInput = scan.nextLine();

		/*
		 * If the user agrees to create a Pokemon ask the user to enter the name of
		 * Pokemon The name variable is updated with the userInput
		 * 
		 */
		if (userInput.equals("y")) {
			String name = "Coming soon", ability1 = "Coming soon", ability2 = "Coming soon",
					hiddenAbility = "Coming soon", generation = "Coming soon", color = "Coming soon",
					evolve = "Coming soon", region = "Coming soon", gender = "Coming soon";

			int ID = pokeList.size() + 1, type1 = 0, type2 = 0, total = 0, speed = 0, defense = 0, spDefense = 0,
					spAttack = 0, attack = 0, exp = 0, hp = 0;

			double mass = 0.0;

			/*
			 * While agreeing to create a new Pokemon prompt user to create name and ID will
			 * be implemented upon completion of name
			 */

			while (userInput.equals("y")) {

				/*
				 * accepting name from user and passing input to NAME variable
				 */

				System.out.println("\nPlease enter the name of the new Pokemon ");
				name = scan.nextLine();

				/*
				 * Displaying name and ID of the new Pokemon
				 */

				System.out.println("\n" + name + " was assigned to ID number " + ID + ".");

				/*
				 * Asking user if they'd like to add attributes to the new Pokemon
				 */

				System.out.println("\nWould you like to add attributes to " + name
						+ "? Please specify by entering y for yes or n for no. (Enter q to exit menu.) ");
				String choice = scan.nextLine();

				/*
				 * If yes, enter Pokemon Data Menu
				 */

				if (choice.equals("y")) {

					System.out.println(ANSI_CYAN + "----------------------------------------------------------");
					System.out.println("                    ENTERING POKEMON DATA                 ");
					System.out.println(
							"----------------------------------------------------------" + ANSI_RESET + ANSI_YELLOW);
					break;
					/*
					 * If n or q prompt user to save name and ID placement to database
					 */

				} else if (choice.equals("n") || (choice.equals("q"))) {

					System.out.println(
							"Would you like to save " + name + "'s ID placement in the database under the ID number "
									+ ID + " and update the attributes later?");
					String userInput1 = scan.nextLine();

					if (userInput1.equals("y")) {

						pokeList.add(new Pokemon(gender, exp, region, evolve, color, mass, generation, hp, attack,
								spAttack, defense, spDefense, speed, total, ability1, ability2, hiddenAbility, type1,
								type2, name, ID));

						System.out.print("\nUpdating dataBase");
						Thread.sleep(700);
						System.out.print(".");
						Thread.sleep(700);
						System.out.print(".");
						Thread.sleep(700);
						System.out.print(".");

						String query1 = "INSERT INTO Pokemon(ID, Name) VALUES('" + ID + "', '" + name + "')";
						statement.executeUpdate(query1);
						String query2 = "INSERT INTO PokeGenInfo(ID, Gender, Region, EvolveAt, Color, Mass, Generation, Exp) VALUES('"
								+ ID + "', '" + gender + "', '" + region + "', '" + evolve + "', '" + color + "', '"
								+ mass + "', '" + generation + "', '" + exp + "')";
						statement.executeUpdate(query2);
						String query3 = "INSERT INTO PokeStats(ID, HP, Atk, Def, SpA, SpD, Spe, total) VALUES('" + ID
								+ "', '" + hp + "', '" + attack + "', '" + defense + "' , '" + spAttack + "', '"
								+ spDefense + "', '" + speed + "','" + total + "')";
						statement.executeUpdate(query3);
						String query4 = "INSERT INTO PokeAbility(ID, Ability1, Ability2, HiddenAbility) VALUES('" + ID
								+ "', '" + ability1 + "', '" + ability2 + "', '" + hiddenAbility + "')";
						statement.executeUpdate(query4);
						String query5 = "INSERT INTO PokeTypeKeys(ID, Type1, Type2) VALUES('" + ID + "', '" + type1
								+ "','" + type2 + "')";
						statement.executeUpdate(query5);

						System.out.println("\n" + name + " was successfully added to the Pokemon database.");

						/*
						 * Prompt user if they'd like to create another Pokemon
						 */

						System.out.println("\nWould you like to create a new Pokemon? ");
						String userInput2 = scan.nextLine();

						/*
						 * If y, update ID# and repeat creating new Pokemon process
						 */

						if (userInput2.equals("y")) {

							ID++;
							continue;

							/*
							 * If n, exit menu
							 */

						} else if (userInput2.equals("n")) {

							System.out.println("Thank you for your recent entry. Exiting Menu.");
							return;

						}

						/*
						 * If user chooses not to save NAME and ID, do not upload to database and exit
						 * menu
						 */

					} else if (userInput1.equals("n")) {
						System.out.println(name + " was not uploaded to the Pokemon database. Exiting Menu.");
						return;

						/*
						 * If user inputs an invalid entry, exit menu
						 */

					} else if (!userInput1.equals("y") && (!userInput1.equals("n")) && (!userInput1.equals("q"))) {

						System.out.println("\nInvalid entry. Exiting Menu.");
						return;
					}

				} else
					System.out.println("Invalid entry, exiting menu.");
				return;
			}

			/**************************************
			 * START OF Data ENTRY FOR POKEMON ATTRIBUTES
			 ********************************************/
//GENDER
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a gender to the pokemon? y or n? Enter q to exit menu. ");

				String userChoice = scan.nextLine();

				if (userChoice.equals("y")) {

					System.out.print("Enter Gender: ");
					String userGender = scan.nextLine();
					gender = userGender;
					System.out.println("Gender updated successfully.");
					break;

				} else if (userChoice.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry.");

				}
			}
//EXP
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a exp to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice1 = scan.nextLine();

				if (userChoice1.equals("y")) {
					System.out.print("\nEnter Exp: ");
					int userExp = Integer.parseInt(scan.nextLine());
					exp = (int) userExp;
					System.out.println("Exp updated successfully.");
					break;

				} else if (userChoice1.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice1.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

//COLOR			
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a color to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice2 = scan.nextLine();

				if (userChoice2.equals("y")) {
					System.out.print("Enter Color: ");
					String userColor = scan.nextLine();
					color = userColor;
					System.out.println("Color updated successfully.");
					break;

				} else if (userChoice2.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice2.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

			// Mass
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a mass to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice3 = scan.nextLine();

				if (userChoice3.equals("y")) {
					System.out.print("Enter Mass: ");
					mass = Double.parseDouble(scan.nextLine());
					System.out.println("Mass updated successfully.");
					break;

				} else if (userChoice3.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice3.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

//EVOLVE		
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a evolve to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice4 = scan.nextLine();

				if (userChoice4.equals("y")) {
					System.out.print("Enter Evolve: ");
					String userEvolve = scan.nextLine();
					evolve = userEvolve;
					System.out.println("Evolve updated successfully.");
					break;

				} else if (userChoice4.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice4.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

//GENERATION	
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a generation to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice5 = scan.nextLine();

				if (userChoice5.equals("y")) {
					System.out.print("Enter Generation: ");
					String userGen = scan.nextLine();
					generation = userGen;
					System.out.println("Generation updated successfully.");
					break;

				} else if (userChoice5.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice5.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

//REGION	
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a region to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice6 = scan.nextLine();

				if (userChoice6.equals("y")) {
					System.out.print("Enter Region: ");
					String userRegion = scan.nextLine();
					region = userRegion;
					System.out.println("Region updated successfully.");
					break;

				} else if (userChoice6.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice6.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

//ABILITY 1		
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a Ability 1 to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice7 = scan.nextLine();

				if (userChoice7.equals("y")) {
					System.out.print("Enter Ability 1: ");
					String userAbility1 = scan.nextLine();
					ability1 = userAbility1;
					System.out.println("Ability 1 updated successfully.");
					break;

				} else if (userChoice7.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice7.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

//ABILITY 2		
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a ability 2 to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice8 = scan.nextLine();

				if (userChoice8.equals("y")) {
					System.out.print("Enter Ability 2: ");
					String userAbility2 = scan.nextLine();
					ability2 = userAbility2;
					System.out.println("Ability 2 updated successfully.");
					break;

				} else if (userChoice8.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice8.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

//HIDDEN ABILITY	
			while (userInput.equals("y")) {
				System.out.println(
						"\nDo you want to add a Hidden Ability to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice9 = scan.nextLine();

				if (userChoice9.equals("y")) {
					System.out.print("Enter Hidden Ability: ");
					String userHiddenAbility = scan.nextLine();
					hiddenAbility = userHiddenAbility;
					System.out.println("Hidden Ability updated successfully.");
					break;

				} else if (userChoice9.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice9.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

//HP
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a HP to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice10 = scan.nextLine();

				if (userChoice10.equals("y")) {
					System.out.print("Enter Hp: ");
					hp = Integer.parseInt(scan.nextLine());
					System.out.println("HP updated successfully.");
					break;

				} else if (userChoice10.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice10.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

//Attack
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a Attack to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice11 = scan.nextLine();

				if (userChoice11.equals("y")) {
					System.out.print("Enter Attack: ");
					attack = Integer.parseInt(scan.nextLine());
					System.out.println("Attack updated successfully.");
					break;

				} else if (userChoice11.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice11.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

//SPAttack
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a SPAttack to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice12 = scan.nextLine();

				if (userChoice12.equals("y")) {
					System.out.print("Enter SPAttack: ");
					spAttack = Integer.parseInt(scan.nextLine());
					System.out.println("SPAttack updated successfully.");
					break;

				} else if (userChoice12.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice12.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

//Defense
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a Defense to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice13 = scan.nextLine();

				if (userChoice13.equals("y")) {
					System.out.print("Enter Defense: ");
					defense = Integer.parseInt(scan.nextLine());
					System.out.println("Defense updated successfully.");
					break;

				} else if (userChoice13.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice13.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

//SPDefense
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a SPDefense to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice14 = scan.nextLine();

				if (userChoice14.equals("y")) {
					System.out.print("Enter SPDefense: ");
					spDefense = Integer.parseInt(scan.nextLine());
					System.out.println("SPDefense updated successfully.");
					break;

				} else if (userChoice14.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice14.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

//Speed
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a Speed to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice15 = scan.nextLine();

				if (userChoice15.equals("y")) {
					System.out.print("Enter Speed: ");
					speed = Integer.parseInt(scan.nextLine());
					System.out.println("Speed updated successfully.");
					break;

				} else if (userChoice15.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice15.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

//Total
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a Total to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice16 = scan.nextLine();

				if (userChoice16.equals("y")) {
					System.out.print("Enter Total: ");
					total = Integer.parseInt(scan.nextLine());
					System.out.println("Total updated successfully.");
					break;

				} else if (userChoice16.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice16.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

//Type 1
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a Type 1 to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice17 = scan.nextLine();

				for (int i = 0; i < typeList.size(); i++) {
					System.out.println(i + ". " + typeList.get(i));
				}

				if (userChoice17.equals("y")) {
					System.out.print("Enter a type number from the above list: ");
					type1 = Integer.parseInt(scan.nextLine());

					System.out.println("Type 1 updated successfully.");
					break;

				} else if (userChoice17.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice17.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

//Type 2
			while (userInput.equals("y")) {
				System.out.println("\nDo you want to add a Type 2 to the Pokemon? y or n? Enter q to exit menu. ");

				String userChoice18 = scan.nextLine();

				for (int i = 0; i < typeList.size(); i++) {
					System.out.println(i + ". " + typeList.get(i));
				}

				if (userChoice18.equals("y")) {
					System.out.print("Enter a second type number from the above list: ");
					type2 = Integer.parseInt(scan.nextLine());
					System.out.println("Type 2 updated successfully.");
					break;

				} else if (userChoice18.equals("n")) {

					System.out.println("No updates occurred.");
					break;

				} else if (userChoice18.equals("q")) {
					System.out.println("Exiting Menu");
					return;

				} else {
					System.out.println("Invalid entry!");

				}
			}

			/**************************************
			 * END OF Data ENTRY FOR POKEMON ATTRIBUTES
			 ********************************************/

			/*
			 * Instantiate a new Pokemon Object and add it to the pokeList Data structure
			 */
			pokeList.add(new Pokemon(gender, exp, region, evolve, color, mass, generation, hp, attack, spAttack,
					defense, spDefense, speed, total, ability1, ability2, hiddenAbility, type1, type2, name, ID));

			System.out.print("\nUpdating dataBase");
			Thread.sleep(700);
			System.out.print(".");
			Thread.sleep(700);
			System.out.print(".");
			Thread.sleep(700);
			System.out.print(".");

			/*
			 * Inserting the data to their appropriate tables inside the Pokemon Database.
			 * Table: Pokemon, PokeGenInfo, PokeStats, PokeAility, and PokeTypeKeys
			 */
			String query1 = "INSERT INTO Pokemon(ID, Name) VALUES('" + ID + "', '" + name + "')";

			String query2 = "INSERT INTO PokeGenInfo(ID, Gender, Region, EvolveAt, Color, Mass, Generation, Exp) VALUES('"
					+ ID + "', '" + gender + "', '" + region + "', '" + evolve + "', '" + color + "', '" + mass + "', '"
					+ generation + "', '" + exp + "')";

			String query3 = "INSERT INTO PokeStats(ID, HP, Atk, Def, SpA, SpD, Spe, total) VALUES('" + ID + "', '" + hp
					+ "', '" + attack + "', '" + defense + "' , '" + spAttack + "', '" + spDefense + "', '" + speed
					+ "','" + total + "')";

			String query4 = "INSERT INTO PokeAbility(ID, Ability1, Ability2, HiddenAbility) VALUES('" + ID + "', '"
					+ ability1 + "', '" + ability2 + "', '" + hiddenAbility + "')";

			String query5 = "INSERT INTO PokeTypeKeys(ID, Type1, Type2) VALUES('" + ID + "', '" + type1 + "','" + type2
					+ "')";

			/*
			 * Update messages to verify data update was completed
			 */
			statement.executeUpdate(query1);
			System.out.println("\nUpdate to Pokemon Table complete.");
			Thread.sleep(700);
			System.out.print(".");
			Thread.sleep(700);
			System.out.print(".");
			Thread.sleep(700);
			System.out.print(".");
			statement.executeUpdate(query2);
			System.out.println("\nUpdate to Pokemon General Info Table complete. ");
			Thread.sleep(700);
			System.out.print(".");
			Thread.sleep(700);
			System.out.print(".");
			Thread.sleep(700);
			System.out.print(".");
			statement.executeUpdate(query3);
			System.out.println("\nUpdate to Pokemon Stats Table complete.");
			Thread.sleep(700);
			System.out.print(".");
			Thread.sleep(700);
			System.out.print(".");
			Thread.sleep(700);
			System.out.print(".");
			statement.executeUpdate(query4);
			System.out.println("\nUpdate to Pokemon Ability Table complete.");
			Thread.sleep(700);
			System.out.print(".");
			Thread.sleep(700);
			System.out.print(".");
			Thread.sleep(700);
			System.out.print(".");
			statement.executeUpdate(query5);
			System.out.println("\nUpdate to Pokemon Type-Keys Table complete.");
			Thread.sleep(700);
			System.out.print(".");
			Thread.sleep(700);
			System.out.print(".");
			Thread.sleep(700);
			System.out.print(".");

			System.out.println("\n" + name + " was successfully added to the Pokemon Database. \n");

			/*
			 * Asking user if they'd like to create a new Pokemon, if so it will ask for the
			 * new Pokemon name and it will be given the next ID space
			 */

			System.out.println("Thank you for your recent entry. Exiting Menu.");
			return;

		} else if (userInput.equals("n")) {
			System.out.println("No updates to the Pokemon database occurred.\nExiting Menu");
			Thread.sleep(700);
			System.out.print(".");
			Thread.sleep(700);
			System.out.print(".");
			Thread.sleep(700);
			System.out.print(".");
		}
	}

	/************************************************
	 * End of Add new Pokemon Method
	 ************************************************************/

	/*******************************************************
	 * View Pokedex
	 *****************************************************/
	/*
	 * Name: Obaedur Rahman
	 * 
	 */
	public void viewPokedex(int id) {
		scanner = new Scanner(System.in);
		String userResponse = "";
		StringBuilder viewMenu = new StringBuilder();
		viewMenu.append("\nEnter your selection: \n");
		viewMenu.append("Press 1 to display a pokemon's attribute\n");
		viewMenu.append("Press 2 to view two pokemons and display their attribute\n");
		viewMenu.append("Press 3 to compare two pokemons based on stats and type\n");
		viewMenu.append("Press 4 to view a pokemon's evolution\n");
		viewMenu.append("Press 5 to view all pokemons from a region\n");
		viewMenu.append("Press 6 to compare pokemon types\n");
		viewMenu.append("Press 7 to view badge information\n");
		viewMenu.append("Press 8 to view a pokemon's moveset\n");
		if (userList.get(id).getIsAdmin()) {
			viewMenu.append("\nPress p to to retrun to the previous menu\n");
		}
		viewMenu.append("Press q to quit\n");
		System.out.println(viewMenu.toString());
		userResponse = scanner.nextLine();
		switch (userResponse) {
		case "1":
			attributeOfOnePokemon();
			break;
		case "2":
			attributesOfTwoPokemon();
			break;
		case "3":
			comparePokemon();
			break;
		case "4":
			viewEvolution();
			break;
		case "5":
			pokeRegion();
			break;
		case "6":
			compareType();
			break;
		case "7":
			viewBadgeInfo();
			break;
		case "8":
			viewMoveSet();
			break;
		case "p":
			break;
		case "q":
			System.out.println("Thanks for using pokedex!!");
			System.exit(2);
		}
	}

	/*******************************************************
	 * End of view Pokedex
	 *****************************************************/

	/*******************************************************
	 * Attributes of one pokemon Method
	 *****************************************************/
	/*
	 * Name: Amir Mahmood
	 * 
	 */

	public void attributeOfOnePokemon() {

		scanner = new Scanner(System.in);
		String selectedPokemon;
		String userResponse = "";
		while (true) {
			System.out.println("\nSelect a pokemon to see its attributes");
			selectedPokemon = selectPokemon();
			if (selectedPokemon == null) {
				return;
			}

			for (int i = 0; i < pokeList.size(); i++) {
				if (selectedPokemon.equals(pokeList.get(i).getName())) {
					System.out.println(pokeList.get(i));
				}
			}
			while (true) {
				System.out.println("Select another pokemon? (y/n)");
				userResponse = scanner.nextLine();
				if (userResponse.equals("y")) {
					break;
				} else if (userResponse.equals("n")) {
					return;
				} else {
					System.out.println("\nInvalid response!");
				}
			}
		}

	}

	/*******************************************************
	 * End of attributes of one pokemon Method
	 *****************************************************/

	/*******************************************************
	 * Attributes of two pokemon Method
	 *****************************************************/
	/*
	 * Name: Luis Dejesus
	 * 
	 */

	public void attributesOfTwoPokemon() {
		String userInput;
		String pokemon1, pokemon2;
		scanner = new Scanner(System.in);
		System.out.println();
		System.out.println("---Select two pokemeon to view their information and attributes---");
		do {
			System.out.println();
			System.out.println("Choose your First pokemon:");
			pokemon1 = selectPokemon();
			if (pokemon1 == null) {
				System.out.println("Returning to View two pokemon and display their attribute menu");
				System.out.println();
				return;
			}
			System.out.println();

			System.out.println("Choose your Second pokemon");
			pokemon2 = selectPokemon();
			if (pokemon2 == null) {
				System.out.println("Returning to View two pokemon and display their attribute menu");
				System.out.println();
				return;
			}

			for (int i = 0; i < 1; i++) {
				for (int j = 0; j < pokeList.size(); j++) {
					if (pokemon1.equals(pokeList.get(j).getName())) {
						System.out.println("");
						System.out.println("-------Your First Choice:-------");
						System.out.println(pokeList.get(j));
					}
				}
				for (int j = 0; j < pokeList.size(); j++) {
					if (pokemon2.equals(pokeList.get(j).getName())) {
						System.out.println("-------Your Second Choice:-------");
						System.out.println(pokeList.get(j));
					}
				}
			}
			userInput = "";
			while (!(userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("n"))) {
				System.out.println("Do you want to select 2 other pokemon to view? (y/n)");
				userInput = scanner.nextLine();
				if (!(userInput.equals("y") || userInput.equals("n"))) {
					System.out.println("Invalid Response!");
				}
			}
		} while (!userInput.equalsIgnoreCase("n"));
	}// end of method

	/*******************************************************
	 * End attributes of two pokemon Method
	 *****************************************************/

	/************************************************
	 * Start of View ComparePokemon Method
	 ***********************************************************/
	/*
	 * Name: Rodrigo Proano
	 * 
	 */
	public void comparePokemon() {
		String userResponse;
		int firstPokemon = 0;
		int secondPokemon = 0;
		int score1;
		int score2;
		int total1 = 0;
		int total2 = 0;

		scanner = new Scanner(System.in);

		System.out.println("\nSelect two pokemeon to compare them based on stats and types\n");

		while (true) {
			score1 = 0;
			score2 = 0;
			System.out.println("Select first pokemon");
			firstPokemon = returnPokeID();
			if (firstPokemon == 0) {
				return;
			}
			System.out.println("\nSelect second pokemon");
			secondPokemon = returnPokeID();
			if (secondPokemon == 0) {
				return;
			}
			total1 = pokeList.get(firstPokemon).getTotal();
			total2 = pokeList.get(secondPokemon).getTotal();

			for (int i = 0; i < attributeList.size(); i++) {
				if (pokeList.get(firstPokemon).getType1() == 1) {
					break;
				} else if (attributeList.get(i).getTypeName()
						.equals(typeList.get(pokeList.get(firstPokemon).getType1()))) {
					for (int j = 0; j < attributeList.get(i).typeSup.size(); j++) {
						if (attributeList.get(i).typeSup.get(j) == pokeList.get(secondPokemon).getType1()) {
							score1 += 1;
							System.out.println("\n" + pokeList.get(firstPokemon).getName() + "'s "
									+ typeList.get(pokeList.get(firstPokemon).getType1()) + " type is superior to "
									+ pokeList.get(secondPokemon).getName() + "'s "
									+ typeList.get(pokeList.get(secondPokemon).getType1()) + " type");
							System.out.println("Score goes up for " + pokeList.get(firstPokemon).getName() + "\n");
						}
						if (attributeList.get(i).typeSup.get(j) == pokeList.get(secondPokemon).getType2()) {
							score1 += 1;
							System.out.println("\n" + pokeList.get(firstPokemon).getName() + "'s "
									+ typeList.get(pokeList.get(firstPokemon).getType1()) + " type is superior to "
									+ pokeList.get(secondPokemon).getName() + "'s "
									+ typeList.get(pokeList.get(secondPokemon).getType2()) + " type");
							System.out.println("Score goes up for " + pokeList.get(firstPokemon).getName() + "\n");
						}
					}
				}
			}
			for (int i = 0; i < attributeList.size(); i++) {
				if (pokeList.get(firstPokemon).getType2() == 1) {
					break;
				} else if (attributeList.get(i).getTypeName()
						.equals(typeList.get(pokeList.get(firstPokemon).getType2()))) {
					for (int j = 0; j < attributeList.get(i).typeSup.size(); j++) {
						if (attributeList.get(i).typeSup.get(j) == pokeList.get(secondPokemon).getType1()) {
							score1 += 1;
							System.out.println("\n" + pokeList.get(firstPokemon).getName() + "'s "
									+ typeList.get(pokeList.get(firstPokemon).getType2()) + " type is superior to "
									+ pokeList.get(secondPokemon).getName() + "'s "
									+ typeList.get(pokeList.get(secondPokemon).getType1()) + " type");
							System.out.println("Score goes up for " + pokeList.get(firstPokemon).getName() + "\n");
						}
						if (attributeList.get(i).typeSup.get(j) == pokeList.get(secondPokemon).getType2()) {
							score1 += 1;
							System.out.println("\n" + pokeList.get(firstPokemon).getName() + "'s "
									+ typeList.get(pokeList.get(firstPokemon).getType2()) + " type is superior to "
									+ pokeList.get(secondPokemon).getName() + "'s "
									+ typeList.get(pokeList.get(secondPokemon).getType2()) + " type");
							System.out.println("Score goes up for " + pokeList.get(firstPokemon).getName() + "\n");
						}
					}
				}
			}
			for (int i = 0; i < attributeList.size(); i++) {
				if (attributeList.get(i).getTypeName().equals(typeList.get(pokeList.get(firstPokemon).getType1()))) {
					for (int j = 0; j < attributeList.get(i).typeInf.size(); j++) {
						if (attributeList.get(i).typeInf.get(j) == pokeList.get(secondPokemon).getType1()) {
							score2 += 1;
							System.out.println("\n" + pokeList.get(secondPokemon).getName() + "'s "
									+ typeList.get(pokeList.get(secondPokemon).getType1()) + " type is superior to "
									+ pokeList.get(firstPokemon).getName() + "'s "
									+ typeList.get(pokeList.get(firstPokemon).getType1()) + " type");
							System.out.println("Score goes up for " + pokeList.get(secondPokemon).getName() + "\n");
						}
						if (attributeList.get(i).typeInf.get(j) == pokeList.get(secondPokemon).getType2()) {
							score2 += 1;
							System.out.println("\n" + pokeList.get(secondPokemon).getName() + "'s "
									+ typeList.get(pokeList.get(secondPokemon).getType2()) + " type is superior to "
									+ pokeList.get(firstPokemon).getName() + "'s "
									+ typeList.get(pokeList.get(firstPokemon).getType1()) + " type");
							System.out.println("Score goes up for " + pokeList.get(secondPokemon).getName() + "\n");
						}
					}
				}
			}
			for (int i = 0; i < attributeList.size(); i++) {
				if (attributeList.get(i).getTypeName().equals(typeList.get(pokeList.get(firstPokemon).getType2()))) {
					for (int j = 0; j < attributeList.get(i).typeInf.size(); j++) {
						if (attributeList.get(i).typeInf.get(j) == pokeList.get(secondPokemon).getType1()) {
							score2 += 1;
							System.out.println("\n" + pokeList.get(secondPokemon).getName() + "'s "
									+ typeList.get(pokeList.get(secondPokemon).getType1()) + " type is superior to "
									+ pokeList.get(firstPokemon).getName() + "'s "
									+ typeList.get(pokeList.get(firstPokemon).getType2()) + " type");
							System.out.println("Score goes up for " + pokeList.get(secondPokemon).getName() + "\n");
						}
						if (attributeList.get(i).typeInf.get(j) == pokeList.get(secondPokemon).getType2()) {
							score2 += 1;
							System.out.println("\n" + pokeList.get(secondPokemon).getName() + "'s "
									+ typeList.get(pokeList.get(secondPokemon).getType2()) + " type is superior to "
									+ pokeList.get(firstPokemon).getName() + "'s "
									+ typeList.get(pokeList.get(firstPokemon).getType2()) + " type");
							System.out.println("Score goes up for " + pokeList.get(secondPokemon).getName() + "\n");
						}
					}
				}
			}

			System.out.println("\n" + pokeList.get(firstPokemon).getName() + "("
					+ typeList.get(pokeList.get(firstPokemon).getType1()) + "|"
					+ typeList.get(pokeList.get(firstPokemon).getType2()) + ")" + " score: " + score1);
			System.out.println(pokeList.get(secondPokemon).getName() + "("
					+ typeList.get(pokeList.get(secondPokemon).getType1()) + "|"
					+ typeList.get(pokeList.get(secondPokemon).getType2()) + ")" + " score: " + score2 + "\n");
			if (score1 > score2) {
				System.out.println(pokeList.get(firstPokemon).getName()
						+ " have the advantage based on type comparison. It will recieve a 20% bonus on it's total stat!");
			} else if (score2 > score1) {
				System.out.println(pokeList.get(secondPokemon).getName()
						+ " have the advantage on type comparison. It will recieve a 20% bonus on it's total stat!");
			} else {
				System.out.println("Scores are leveled! No pokemon have the advantage based on type comparison!");
			}
			System.out.println();
			System.out.printf("%-15s%5s%18s", pokeList.get(firstPokemon).getName(), "VS",
					pokeList.get(secondPokemon).getName() + "\n");
			System.out.printf("%-5s%15s%18s", pokeList.get(firstPokemon).getHP(), "HP",
					pokeList.get(secondPokemon).getHP() + "\n");
			System.out.printf("%-5s%17s%16s", pokeList.get(firstPokemon).getAttack(), "Attack",
					pokeList.get(secondPokemon).getAttack() + "\n");
			System.out.printf("%-5s%19s%14s", pokeList.get(firstPokemon).getSpAttack(), "SpAttackk",
					pokeList.get(secondPokemon).getSpAttack() + "\n");
			System.out.printf("%-5s%18s%15s", pokeList.get(firstPokemon).getDefense(), "Defense",
					pokeList.get(secondPokemon).getDefense() + "\n");
			System.out.printf("%-5s%19s%14s", pokeList.get(firstPokemon).getSpDefense(), "SpDefense",
					pokeList.get(secondPokemon).getSpDefense() + "\n");
			System.out.printf("%-5s%17s%16s", pokeList.get(firstPokemon).getSpeed(), "Speed",
					pokeList.get(secondPokemon).getSpeed() + "\n");
			if (score1 > score2) {
				total1 = total1 + (int) (total1 * 0.2);
				System.out.printf("%-5s%13s%16s", "\n" + total1 + "(20%^)", "Total", total2 + "\n");
			} else if (score2 > score1) {
				total2 = total2 + (int) (total2 * 0.2);
				System.out.printf("%-5s%18s%22s", "\n" + total1, "Total", total2 + "(20%^)" + "\n");
			} else {
				System.out.printf("%-5s%18s%16s", "\n" + total1, "Total", total2 + "\n");
			}

			if (total1 > total2) {
				System.out.println(
						"\nBased on total stats " + pokeList.get(firstPokemon).getName() + " is the WINNER!!!");
			} else if (total2 > total1) {
				System.out.println(
						"\nBased on total stats " + pokeList.get(secondPokemon).getName() + " is the WINNER!!!");
			} else {
				System.out.println("\nBased on total stats its a DRAW!!");
			}

			while (true) {
				System.out.println("\nCompare different pokemon? (y/n)");
				userResponse = scanner.nextLine();
				if (userResponse.equals("y")) {
					break;
				} else if (userResponse.equals("n")) {
					return;
				} else {
					System.out.println("Invalid response!");
				}
			}
		}
	}

	/************************************************
	 * End of View Evolution Method
	 ***********************************************************/

	/************************************************
	 * Start of View Evolution Method
	 ***********************************************************/
	/*
	 * Name: Obaedur Rahman
	 * 
	 */

	public void viewEvolution() {
		scanner = new Scanner(System.in);
		String selectedPokemon;
		String userResponse = "";
		while (true) {
			System.out.println("\nSelect a pokemon to see its evolution");
			selectedPokemon = selectPokemon();
			if (selectedPokemon == null) {
				return;
			}
			System.out.println("\nEvolution\n**********");
			for (int i = 0; i < pokeList.size(); i++) {
				if (selectedPokemon.equals(pokeList.get(i).getName())) {
					for (int j = i; j < pokeList.size(); j++) {
						if (pokeList.get(j).getEvolveAt().equals("N/A")) {
							System.out.println(pokeList.get(j).getName() + " does not evolve");
							break;
						} else if (pokeList.get(j).getEvolveAt().length() > 6) {
							System.out.println(
									pokeList.get(j).getName() + " Evolves with " + pokeList.get(j).getEvolveAt());
							break;
						} else {
							System.out.println(pokeList.get(j).getName() + " evloves into "
									+ pokeList.get(j + 1).getName() + " at " + pokeList.get(j).getEvolveAt());
						}
					}
				}
			}
			while (true) {
				System.out.println("\nView another evolution? (y/n)");
				userResponse = scanner.nextLine();
				if (userResponse.equals("y")) {
					break;
				} else if (userResponse.equals("n")) {
					return;
				} else {
					System.out.println("Invalid response!");
				}
			}

		}
	}

	/************************************************
	 * End of view Evolution Method
	 ***********************************************************/

	/************************************************
	 * Start of pokeRegion Method
	 ***********************************************************/
	/*
	 * Name: Rodrigo Proano
	 * 
	 */

	public void pokeRegion() {

		scanner = new Scanner(System.in);
		String regionN;
		String userResponse = "";
		System.out.println("You can view all pokemons from a specific region");

		while (true) {
			regionN = selectRegion();
			if (regionN == null) {
				System.out.println("Exit");
				return;
			}
			System.out.println(regionN + " region" + "\n**************");
			int j = 1;
			for (int i = 0; i < pokeList.size(); i++) {
				if (regionN.equals(pokeList.get(i).getRegion())) {
					System.out.println(j + ". " + pokeList.get(i).getName());
					j++;
				}
			}
			while (true) {
				System.out.println("\nView another region? (y/n)");
				userResponse = scanner.nextLine();
				if (userResponse.equals("y")) {
					break;
				} else if (userResponse.equals("n")) {
					return;
				} else {
					System.out.println("Invalid response!");
				}
			}
		}

	}

// sub method for pokeRegion
	public String selectRegion() {
		scanner = new Scanner(System.in);
		boolean isFound;
		String userResponse = "";
		String selectedRegion = "";
		int pokeNum = 0;

		while (!userResponse.equals("m")) {
			isFound = false;
			System.out.println("\npress 1 to enter Region Name" + "\nOr press m to return to main menu");
			userResponse = scanner.nextLine();
			if (userResponse.equals("1")) {
				System.out.println("\nEnter Region Name: ");
				System.out.println("Available regions: Kanto, Johto, Hoenn, Sinnoh, Unova, Kalos \n");
				userResponse = scanner.nextLine();
				for (int i = 0; i < pokeList.size(); i++) {
					if (pokeList.get(i).getRegion().equalsIgnoreCase(userResponse)) {
						return selectedRegion = pokeList.get(i).getRegion();
					}
				}
				if (!isFound) {
					System.out.println("No region exist with the provided name!");
					System.out.println("\nSelect again (y/n)");
					userResponse = scanner.nextLine();
					if (userResponse.equals("y")) {
						continue;
					} else if (userResponse.equals("n")) {
						return null;
					} else {
						System.out.println("Invalid response!");
					}

				}

			} else if (userResponse.equals("2")) {
				while (!userResponse.equals("n")) {
					resultList = search();
					if (resultList == null) {
						break;
					}
					for (int i = 0; i < resultList.size(); i++) {
						System.out.println(i + 1 + ". " + resultList.get(i));
					}
					System.out.println("\nEnter a pokemon number from the list");
					pokeNum = Integer.parseInt(userResponse = scanner.nextLine()) - 1;
					for (int i = 0; i < pokeList.size(); i++) {
						if (resultList.get(pokeNum).equals(pokeList.get(i).getName())) {
							return selectedRegion = pokeList.get(i).getName();
						}
					}
				}
			} else if (userResponse.equals("m")) {
				break;
			} else {
				System.out.println("Invalid response!");
			}
		}
		return null;
	}

	/**********************************************************
	 * End of pokeRegion Method
	 ***********************************************************/

	/***********************************************************
	 * Start of Comparing Type Method
	 * ************************************************************ Name: Kevin
	 * Sanchez Date: 11/22/2022 Purpose: Compare Pokemon type to its superior and
	 * inferior types
	 */

	public void compareType() {

		int userInput = 0;
		String userResponse = "";
		Scanner scan = new Scanner(System.in);

		System.out.println("\nAvailable Types: ");
		for (int i = 1; i < typeList.size(); i++) {
			System.out.println(i + ". " + typeList.get(i));
		}
		while (true) {
			System.out.print("\nEnter the type number from the list you'd like to compare: ");

			userInput = Integer.parseInt(scan.nextLine()) - 1;

			System.out.println("\n" + attributeList.get(userInput).getTypeName() + " type is superior to: ");

			for (int i = 0; i < attributeList.get(userInput).typeSup.size(); i++) {
				Integer type = (attributeList.get(userInput).typeSup.get(i));
				System.out.println(typeList.get(type));
			}

			System.out.println("\n" + attributeList.get(userInput).getTypeName() + " type is inferior to: ");

			for (int i = 0; i < attributeList.get(userInput).typeInf.size(); i++) {
				Integer type = (attributeList.get(userInput).typeInf.get(i));
				System.out.println(typeList.get(type));
			}

			while (true) {
				System.out.println("\nCompare another type? (y/n)");
				userResponse = scanner.nextLine();
				if (userResponse.equals("y")) {
					break;
				} else if (userResponse.equals("n")) {
					return;
				} else {
					System.out.println("Invalid response!");
				}
			}
		}
	}

	/*************************************************************
	 * End of Comparing Type Method
	 *************************************************************/

	/************************************************************
	 * View badge Method
	 *************************************************************/
	/*
	 * Name: Obaedur Rahman
	 * 
	 */

	public void viewBadgeInfo() {
		scanner = new Scanner(System.in);
		String userResponse = "";
		int badgeNum = 0;
		resultList = new ArrayList<>();

		while (true) {

			System.out.println("\nWhich Region's badges would you like to see ");
			System.out.println("press 1 for Kanto\npress 2 for Jhoto\npress 3 for Hoenn\npress 4 for Sinnoh\n"
					+ "Press 5 for Unova\nPress m to return to the main menu");
			userResponse = scanner.nextLine();
			switch (userResponse) {
			case "1":
				resultList = viewBadges("Kanto");
				break;
			case "2":
				resultList = viewBadges("Johto");
				break;
			case "3":
				resultList = viewBadges("Hoenn");
				break;
			case "4":
				resultList = viewBadges("Sinnoh");
				break;
			case "5":
				resultList = viewBadges("Unova");
				break;
			case "m":
				return;
			default:
				System.out.println("invalid response!");
				continue;
			}
			System.out.println("\nEnter a badge number from the list to see it's attributes");
			badgeNum = Integer.parseInt(userResponse = scanner.nextLine()) - 1;
			for (int i = 0; i < badgeList.size(); i++) {
				if (resultList.get(badgeNum).equals(badgeList.get(i).getBadgeName())) {
					System.out.println(badgeList.get(i));
				}
			}
			while (true) {
				System.out.println("\nView another badge? (y/n)");
				userResponse = scanner.nextLine();
				if (userResponse.equals("y")) {
					break;
				} else if (userResponse.equals("n")) {
					return;
				} else {
					System.out.println("Invalid response!");
				}
			}
		}

	}

	public ArrayList<String> viewBadges(String region) {
		resultList = new ArrayList<>();
		int count = 1;
		for (int i = 0; i < badgeList.size(); i++) {
			if (region.equals(badgeList.get(i).getBadgeRegion())) {
				System.out.println(count + ". " + badgeList.get(i).getBadgeName());
				resultList.add(badgeList.get(i).getBadgeName());
				count++;
			}
		}
		return resultList;
	}

	/************************************************************
	 * Start of View Pokemon Move Set Method
	 * ************************************************************
	 *
	 * Name: Kevin Sanchez Date:12/1/2022 Purpose: To view the Pokemon's set of
	 * moves it can obtain through leveling
	 */
	public void viewMoveSet() {
		while (true) {
			String selectedPokemon = "";
			selectedPokemon = selectPokemon();

			if (selectedPokemon == null) {
				return;
			}

			String queryMoveSet = "SELECT * FROM MoveSet WHERE Pokemon = '" + selectedPokemon + "'";
			ResultSet resultSet;

			try {
				resultSet = statement.executeQuery(queryMoveSet);
				if (resultSet.next() == false) {
					System.out
							.println(ANSI_CYAN + "\nMove set for " + selectedPokemon + " is coming soon." + ANSI_RESET);
				}

				resultSet = statement.executeQuery(queryMoveSet);

				while (resultSet.next()) {
					System.out.println(ANSI_CYAN + "\n" + selectedPokemon + "\n***************************");
					System.out.printf("%-22s%-22s\n", "Move", "Level");
					System.out.println("***************************");

					for (int i = 2;; i++) {
						if (resultSet.getString(i).equals("N/A")) {
							break;
						} else {
							System.out.printf(ANSI_CYAN + "%-22s", HelperMethod.returnWords(resultSet.getString(i)));
							System.out.printf(ANSI_CYAN + "%-22s", HelperMethod.returnNumbers(resultSet.getString(i)));
							System.out.println(ANSI_RESET + "");

						}
					}
				}
			} catch (Exception e) {
				System.out.println(e);

			}

			System.out.println(ANSI_CYAN + "\nView another Move set? (y/n)" + ANSI_RESET);
			String userResponse = scanner.nextLine();
			if (userResponse.equals("y")) {
				continue;
			} else if (userResponse.equals("n")) {
				System.out.println(ANSI_YELLOW);
				return;
			} else {
				System.out.println(ANSI_RED + "Invalid response!" + ANSI_RESET);
			}
		}

	}
	/************************************************************
	 * End of View Pokemon Move Set Method
	 ************************************************************/
}


/************************************************************
 * End of Pokedex class
 ************************************************************/