public class Attack {
	private String attackName;
	private int attackPoints;

	/**
	 * 
	 * Creates a new attack with the given properties.
	 * 
	 * @param attackName   This is the name of the attack.
	 * @param attackPoints This is the number of points associated with the attack.
	 * 
	 **/
	public Attack(String attackName, int attackPoints) {
		this.attackName = attackName;
		this.attackPoints = attackPoints;
	}

	/**
	 * 
	 * Returns a formatted string giving the attack name and points.
	 * 
	 * @return String with attackName and attackPoints.
	 *
	 **/
	/**
	 * Returns a well formatted string with the name of attack and points.
	 *
	 * @return String with name of attack and its points.
	 **/
	public String toString() {
		return "Attack Name=" + attackName + "Points= " + attackPoints;
	}

	/**
	 * Returns attack name.
	 * 
	 * @return String of attack name.
	 */
	public String getAttackName() {
		return this.attackName;
	}

	/**
	 * Returns attack points.
	 * 
	 * @return Integer of attack points.
	 */
	public int getAttackPoints() {
		return this.attackPoints;
	}
}
