/*
 * Main class
 * 
 */

package projectPokedex;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Pokedex pDex = new Pokedex();
		try {
			pDex.loadData();
			//pDex.viewMoveSet();
			pDex.welcomeScreen();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}