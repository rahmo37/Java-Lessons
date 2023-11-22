package projectPokedex;

/****************************
 *	@author Kevin Sanchez	*
 *	@Date 11-15-2022 		*
 *	@Class PokeBadge.Java   *
 ***************************/

public class GymBadge {

	/************
	 *  Field	*
	 ***********/
	
	String badgeName;
	String gymLocation;
	String gymLeader;
	String badgeRegion;
	String badgeAffect;

	/****************************
	 * Constructors parameters  *
	 * **************************
	 * @param badgeName			*
	 * @param gymLocation		*
	 * @param gymLeader			*	
	 * @param badgeRegion		*
	 * @param badgeAffect		*
	 ***************************/
	
	public GymBadge(String badgeName, String gymLocation, String gymLeader, String badgeRegion, String badgeAffect) {
		this.badgeName = badgeName;
		this.gymLocation = gymLocation;
		this.gymLeader = gymLeader;
		this.badgeRegion = badgeRegion;
		this.badgeAffect = badgeAffect;
	}
	/**
	 * @return the badge Name
	 */
	public String getBadgeName() {
		return badgeName;
	}
	/**
	 * @param badge Name
	 * @purpose to set the name of badge
	 */
	public void setBadgeName(String badgeName) {
		this.badgeName = badgeName;
	}
	/**
	 * @return the gym Location
	 */
	public String getGymLocation() {
		return gymLocation;
	}
	/**
	 * @param gym Location 
	 * @purpose to set the location of gym
	 */
	public void setgymLocation(String gymLocation) {
		this.gymLocation = gymLocation;
	}
	/**
	 * @return the gym Leader
	 */
	public String getGymLeader() {
		return gymLeader;
	}
	/**
	 * @param gym Leader
	 * @purpose to set the name of gym leader
	 */
	public void setGymLeader(String gymLeader) {
		this.gymLeader = gymLeader;
	}
	
	/**
	 * @return the badge Region
	 */
	public String getBadgeRegion() {
		return badgeRegion;
	}
	/**
	 * @param badge Region 
	 * @purpose to set the badge region
	 */
	public void setBadgeRegion(String badgeRegion) {
		this.badgeRegion = badgeRegion;
	}
	
	
	/**
	 * @return the badge Affect
	 */
	public String getBadgeAffect() {
		return badgeAffect;
	}
	
	/**
	 * @param badge Affect 
	 * @purpose to set the badge affect
	 */
	
	public void setBadgeAffect(String badgeAffect) {
		this.badgeAffect = badgeAffect;
	}
	
	/*******************
	 * toString method *
	 *******************/
	
	@Override
	public String toString() {
		return "\nBadge: " + getBadgeName() +"\n*******************"+ "\nLocation of gym: " + getGymLocation() + "\nGym leader: " + getGymLeader() + "\nRegion: " + getBadgeRegion() + "\nBadge Affect: " + getBadgeAffect() +"\n";
	}
	
}
