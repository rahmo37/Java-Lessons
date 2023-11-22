import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Pokemon> pokemon = new ArrayList<>();
		pokemon.add(new Rayquaza("Sky High pokemon", "Legendary", 100, 25.5, "Green"));
		pokemon.add(new Genger("Shadow pokemon", "Regular", 50, 5.5, "Violet"));
		pokemon.add(new Heracross("Cross horn", "Regular", 50, 6.5, "Ocean Blue"));
		pokemon.add(new Mewtwo("Mind Flyer", "Legendary", 100, 10.5, "White"));

		List<Pokemon> legendary = new ArrayList<>();
		List<String> s = new ArrayList<>();

		for (Pokemon p : pokemon) {

			s.add(p.getName());
			Collections.sort(s);
			System.out.println(s);

			if (p.getCatagory() == "Legendary") {
				legendary.add(p);

				System.out.println(p.getClass());
			}
		}

	}

}
