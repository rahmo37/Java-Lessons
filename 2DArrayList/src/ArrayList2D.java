import java.util.ArrayList;


public class ArrayList2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> legendary = new ArrayList<>();
		legendary.add("Lugia");
		legendary.add("Rayquaza");
		legendary.add("Zekrom");
		legendary.add("Kyogre");
		
		ArrayList<String> psudoLegendary = new ArrayList<>();
		psudoLegendary.add("Zapdos");
		psudoLegendary.add("Raiku");
		psudoLegendary.add("Thudarous");
		psudoLegendary.add("Moltres");
		
		ArrayList<String> Starter = new ArrayList<>();
		Starter.add("Mudkip");
		Starter.add("Charmedar");
		Starter.add("Treeko");
		Starter.add("Torchik");
		
		ArrayList<ArrayList<String>> pokemon = new ArrayList<>();
		
		pokemon.add(legendary);
		pokemon.add(Starter);
		pokemon.add(psudoLegendary);
		
		//System.out.println(pokemon);
		
		for(int i = 0; i < pokemon.size(); i++) {
			System.out.println();
			for(int j = 0; j < pokemon.get(i).size(); j++) {
				System.out.print(pokemon.get(i).get(j) + " ");
			}
		}
		

	}

}
