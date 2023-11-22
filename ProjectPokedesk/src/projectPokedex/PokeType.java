package projectPokedex;

/**************************
 * *
 * 
 * @author Kevin Sanchez *
 * @Date: 11-15-2022 *
 * @Class PokeType.java * *
 *************************/

public abstract class PokeType extends PokeAbility {

	/************
	 * Field *
	 ***********/

	int type1;
	int type2;

	/****************************
	 * Constructors parameters * **************************
	 * 
	 * @param gender *
	 * @param exp *
	 * @param region *
	 * @param evolve *
	 * @param color *
	 * @param mass *
	 * @param generation *
	 * @param hp *
	 * @param attack *
	 * @param spattack *
	 * @param defense *
	 * @param spdefense *
	 * @param speed *
	 * @param total *
	 * @param ability1 *
	 * @param ability2 *
	 * @param hiddenAbility *
	 * @param type1 *
	 * @param type2 *
	 ***************************/

	public PokeType(String gender, int exp, String region, String evolve, String color, double mass, String generation,
			int hp, int attack, int spattack, int defense, int spdefense, int speed, int total, String ability1,
			String ability2, String hiddenAbility, int type1, int type2) {

		super(gender, exp, region, evolve, color, mass, generation, hp, attack, spattack, defense, spdefense, speed,
				total, ability1, ability2, hiddenAbility);
		this.type1 = type1;
		this.type2 = type2;
	}

	/**
	 * @return the type1
	 */
	public int getType1() {
		return type1;
	}

	/**
	 * @param type1 the type1 to set
	 */
	public void setType1(int type1) {
		this.type1 = type1;
	}

	/**
	 * @return the type2
	 */
	public int getType2() {
		return type2;
	}

	/**
	 * @param type2 the type2 to set
	 */
	public void setType2(int type2) {
		this.type2 = type2;
	}

	public String printTypes() {
		return "\nType 1: " + Pokedex.typeList.get(getType1()) + "\nType 2: " + Pokedex.typeList.get(getType2());
	}

	@Override
	public String toString() {
		return "\n\nPokemon Type" + "\nType 1: " + Pokedex.typeList.get(getType1()) + "\nType 2: "
				+ Pokedex.typeList.get(getType2()) + super.toString();
	}
}
