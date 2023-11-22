package Constructor;

public class Pokemon {
	int x = 0;
	String name;
	String type;
	String color;
	int level;
	
	Pokemon(String name, String type, String color, int level) {
		this.name = name;
		this.type = type;
		this.color = color;
		this.level = level; 
	}
	
	public void print() {
		System.out.println("Pokemon Name: " + this.name);
		System.out.println("Pokemon Type: " + this.type);
		System.out.println("Pokemon Color: " + this.color);
		System.out.println("Pokemon Level: " + this.level);
	}
}
