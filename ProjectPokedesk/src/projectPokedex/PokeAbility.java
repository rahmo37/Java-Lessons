package projectPokedex;

/*****************************
 * *
 * 
 * @author Kevin Sanchez *
 * @Date: 11-15-2022 *
 * @Class PokeAbility.java * *
 ****************************/

public abstract class PokeAbility extends PokeStat {

	/************
	 * Field *
	 ***********/

	String ability1;
	String ability2;
	String hiddenAbility;

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
	 ***************************/

	public PokeAbility(String gender, int exp, String region, String evolve, String color, double mass,
			String generation, int hp, int attack, int spattack, int defense, int spdefense, int speed, int total,
			String ability1, String ability2, String hiddenAbility) {

		super(gender, exp, region, evolve, color, mass, generation, hp, attack, spattack, defense, spdefense, speed,
				total);
		this.ability1 = ability1;
		this.ability2 = ability2;
		this.hiddenAbility = hiddenAbility;
	}

	/**
	 * @return the ability1
	 */
	public String getAbility1() {
		return ability1;
	}

	/**
	 * @param ability1 the ability1 to set
	 */
	public void setAbility1(String ability1) {
		this.ability1 = ability1;
	}

	/**
	 * @return the ability2
	 */
	public String getAbility2() {
		return ability2;
	}

	/**
	 * @param ability2 the ability2 to set
	 */
	public void setAbility2(String ability2) {
		this.ability2 = ability2;
	}

	/**
	 * @return the hiddenAbility
	 */
	public String getHiddenAbility() {
		return hiddenAbility;
	}

	/**
	 * @param hiddenAbility the hiddenAbility to set
	 */
	public void setHiddenAbility(String hiddenAbility) {
		this.hiddenAbility = hiddenAbility;
	}

	public String printAbility() {
		return "\n1. Ability1: " + getAbility1() + "\n2. Ability2: " + getAbility2() + "\n3. HiddenAbility: "
				+ getHiddenAbility();
	}

	@Override
	public String toString() {
		return "\n\nPokemon Abilities" + "\nAbility1: " + getAbility1() + "\nAbility2: " + getAbility2()
				+ "\nHiddenAbility: " + getHiddenAbility() + super.toString();
	}

}
