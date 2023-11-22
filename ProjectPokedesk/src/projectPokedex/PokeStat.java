package projectPokedex;

/***************************
 * *
 * 
 * @author Kevin Sanchez *
 * @Date: 11-15-2022 *
 * @Class PokeStat.java * *
 **************************/

public abstract class PokeStat extends PokeGenInfo {

	/************
	 * Field *
	 ***********/

	int hp;
	int attack;
	int spAttack;
	int defense;
	int spDefense;
	int speed;
	int total;

	/***************************
	 * Constructors parameters * *************************
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
	 **************************/

	public PokeStat(String gender, int exp, String region, String evolve, String color, double mass, String generation,
			int hp, int attack, int spAttack, int defense, int spDefense, int speed, int total) {

		super(gender, exp, region, evolve, color, mass, generation);
		this.hp = hp;
		this.attack = attack;
		this.spAttack = spAttack;
		this.defense = defense;
		this.spDefense = spDefense;
		this.speed = speed;
		this.total = total;

	}

	/**
	 * @return the hP
	 */
	public int getHP() {
		return hp;
	}

	/**
	 * @param hP
	 * @purpose to set the hp
	 */
	public void setHP(int hp) {
		this.hp = hp;
	}

	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * @param attack
	 * @purpose to set the attack
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * @return the sPAttack
	 */
	public int getSpAttack() {
		return spAttack;
	}

	/**
	 * @param sPAttack
	 * @purpose to set the sPAttack
	 */
	public void setSpAttack(int sPAttack) {
		this.spAttack = sPAttack;
	}

	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * @param defense
	 * @purpose to set the defense
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * @return the sPDefense
	 */
	public int getSpDefense() {
		return spDefense;
	}

	/**
	 * @param sPDefense
	 * @purpose to set the sPDefense
	 */
	public void setSpDefense(int spDefense) {
		this.spDefense = spDefense;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed
	 * @purpose to set the speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total
	 * @purpose to set the total
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	public String printStats() {
		return "\n1. HP: " + getHP() + "\n2. Attack: " + getAttack() + "\n3. SPAttack: " + getSpAttack()
				+ "\n4. Defense: " + getDefense() + "\n5. SPDefense: " + getSpDefense() + "\n6. Speed: " + getSpeed();
	}

	@Override
	public String toString() {
		return "\n\nPokemon Stats" + "\nHP: " + getHP() + "\nAttack: " + getAttack() + "\nSPAttack: " + getSpAttack()
				+ "\nDefense: " + getDefense() + "\nSPDefense: " + getSpDefense() + "\nSpeed: " + getSpeed()
				+ "\nTotal: " + getTotal() + super.toString();
	}
}
