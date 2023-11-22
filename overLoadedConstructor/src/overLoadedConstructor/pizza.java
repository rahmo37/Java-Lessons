package overLoadedConstructor;

public class pizza {

	String dough;
	String sauce;
	String topping;
	String cheese;

	pizza() {

	}

	pizza(String dough) {
		this.dough = dough;
	}

	pizza(String dough, String sauce) {
		this.dough = dough;
		this.sauce = sauce;
	}

	pizza(String dough, String sauce, String topping) {
		this.dough = dough;
		this.sauce = sauce;
		this.topping = topping;
	}

	pizza(String dough, String sauce, String topping, String cheese) {
		this.dough = dough;
		this.sauce = sauce;
		this.topping = topping;
		this.cheese = cheese;
	}
	//overloaded constructor

}
