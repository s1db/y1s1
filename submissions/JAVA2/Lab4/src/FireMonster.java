
public class FireMonster extends Monster {
	private int numberOfAttacks = 0;

	/**
	 * Creates a new Monster of fire type. It doesn't need a parameter for type
	 * since we already know that as it is a subclass.
	 * 
	 * @param hitPoints The initial hit points
	 * @param attacks   The list of attacks, and points
	 */
	public FireMonster(int hitPoints, Attack[] attacks) {
		super("Fire", hitPoints, attacks);
	}

	/**
	 * Returns the ability to dodge, which for fire monsters is always true for
	 * every even number of attack.
	 * 
	 * @return true whenever the attack number is even
	 */
	public boolean dodge() {
		numberOfAttacks = numberOfAttacks + 1; // incrementing attack number before returning value.
		if (numberOfAttacks % 2 == 0) {
			return false;
		} else {
			return true;
		}
	}

}
