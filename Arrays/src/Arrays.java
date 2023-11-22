
public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
			String[] pokemon = { "Rayquaza", "Mewtwo", "Zekrom", "Reshiram", "Tapu lele" };

			for (int i = 0; i < pokemon.length; i++) {
				System.out.println(pokemon[i]);
			}
			System.out.println();

		}

		{
			String[] pokemon = new String[5];

			pokemon[0] = "RAYQUAZA";
			pokemon[1] = "MEWTWO";
			pokemon[2] = "ZEKROM";
			pokemon[3] = "RESHIRAM";
			pokemon[4] = "TAPU LELE";

			for (int i = 0; i < pokemon.length; i++) {
				System.out.println(pokemon[i]);
			}
		}

		{
			int[] numbers = { 0, 5, 6, 7 };
			for (int i = 0; i < numbers.length; i++) {
				System.out.println(numbers[i]);
			}
		}
	}
}
