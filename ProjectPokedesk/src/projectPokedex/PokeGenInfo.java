package projectPokedex;

/****************************
 * *
 * 
 * @author Kevin Sanchez *
 * @Date: 11-15-2022 *
 * @Class PokeGenInfo * *
 ***************************/

public abstract class PokeGenInfo {

	/************
	 * Field *
	 ***********/

	String gender;
	int exp;
	String region;
	String evolveAt;
	String color;
	double mass;
	String generation;

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
	 **************************/

	public PokeGenInfo(String gender, int exp, String region, String evolveAt, String color, double mass,
			String generation) {
		this.gender = gender;
		this.exp = exp;
		this.region = region;
		this.evolveAt = evolveAt;
		this.color = color;
		this.mass = mass;
		this.generation = generation;

	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 * @purpose to set the gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the exp
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * @param exp
	 * @purpose to set the exp
	 */
	public void setExp(int exp) {
		this.exp = exp;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region
	 * @purpose to set the region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the evolveAt
	 */
	public String getEvolveAt() {
		return evolveAt;
	}

	/**
	 * @param evolveAt
	 * @purpose to set the evolution
	 */
	public void setEvolveAt(String evolveAt) {
		this.evolveAt = evolveAt;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 * @purpose to set the color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the mass
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * @param mass
	 * @purpose to set the mass
	 */
	public void setMass(double mass) {
		this.mass = mass;
	}

	/**
	 * @return the generation
	 */
	public String getGeneration() {
		return generation;
	}

	/**
	 * @param generation
	 * @purpose to set the generation
	 */
	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public String printGenInfo() {
		return "\n1. Gender: " + getGender() + "\n2. Exp: " + getExp() + "\n3. Region: " + getRegion()
				+ "\n4. EvolveAt: " + getEvolveAt() + "\n5. Color: " + getColor() + "\n6. Mass: " + getMass()
				+ "\n7. Generation: " + getGeneration();
	}

	@Override
	public String toString() {
		return "\n\nPokemon General Information" + "\nGender: " + getGender() + "\nExp: " + getExp() + "\nRegion: "
				+ getRegion() + "\nEvolveAt: " + getEvolveAt() + "\nColor: " + getColor() + "\nMass: " + getMass()
				+ "\nGeneration: " + getGeneration();
	}

}
