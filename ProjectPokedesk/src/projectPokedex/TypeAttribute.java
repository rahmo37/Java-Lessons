/*
 * TypeAttribute class
 * 
 * Name: Obaedur Rahman
 * 
 */

package projectPokedex;

import java.util.ArrayList;

public class TypeAttribute {
	String typeName;
	ArrayList<Integer> typeSup = new ArrayList<>();
	ArrayList<Integer> typeInf = new ArrayList<>();

	TypeAttribute(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void addSuperiority(int s) {
		typeSup.add(s);
	}

	public void addInferiority(int i) {
		typeInf.add(i);
	}

	public void printSuperiority() {
		System.out.println(typeSup);
	}

	public void printInferiority() {
		System.out.println(typeInf + "\n\n");
	}
}
