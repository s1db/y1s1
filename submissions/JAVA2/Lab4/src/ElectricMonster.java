public class ElectricMonster extends Monster {
	/**
	 * Creates a new Monster of electric type. It doesn't need a parameter for type
	 * since we already know that as it is a subclass.
	 * 
	 * @param hitPoints The initial hit points
	 * @param attacks   The list of attacks, and points
	 */
	public ElectricMonster(int hitPoints, Attack[] attacks) {
		super("Electric", hitPoints, attacks);
	}

	/**
	 * Returns the ability to dodge, which for electric monsters is always false.
	 * 
	 * @return false.
	 */
	public boolean dodge() {
		return false;
	}

}
