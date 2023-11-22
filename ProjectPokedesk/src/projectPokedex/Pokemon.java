package projectPokedex;

/****************************
 * *
 * 
 * @author Kevin Sanchez *
 * @Date: 11-15-2022 *
 * @Class Pokemon.java * *
 ***************************/

public class Pokemon extends PokeType {

	/************
	 * Field *
	 ***********/

	String name;
	int nationalId;

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
	 * @param name *
	 * @param nationalId *
	 ***************************/

	public Pokemon(String gender, int exp, String region, String evolve, String color, double mass, String generation,
			int hp, int attack, int spattack, int defense, int spdefense, int speed, int total, String ability1,
			String ability2, String hiddenAbility, int type1, int type2, String name, int nationalId) {

		super(gender, exp, region, evolve, color, mass, generation, hp, attack, spattack, defense, spdefense, speed,
				total, ability1, ability2, hiddenAbility, type1, type2);
		this.name = name;
		this.nationalId = nationalId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nationalId
	 */
	public int getNationalId() {
		return nationalId;
	}

	/**
	 * @param nationalId the nationalId to set
	 */
	public void setNationalId(int nationalId) {
		this.nationalId = nationalId;
	}

	@Override
	public String toString() {
		return "\nPokemon" + "\nName:" + getName() + "\nNationalId: " + getNationalId() + "\n" + super.toString() + "\n";
	}

}
