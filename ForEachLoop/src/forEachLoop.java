import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class forEachLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> food = Arrays.asList("Birayni", "Kebab", "Halim", "Tehari", "Borhani");

		for (String f : food) {
			System.out.println("i love " + f);
		}
		System.out.println("\n");
		for (int i = 0; i < food.size(); i++) {
			System.out.println("I hate " + food.get(i));
		}
	}

}
