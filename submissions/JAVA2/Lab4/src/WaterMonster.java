public class WaterMonster extends Monster{
	/**
	 * Creates a new Monster of water type. It doesn't need a parameter for type
	 * since we already know that as it is a subclass.
	 * 
	 * @param hitPoints The initial hit points
	 * @param attacks   The list of attacks, and points
	 */
	public WaterMonster(int hitPoints, Attack[] attacks) {
		super("Water", hitPoints, attacks);
	}
	/**
	 * Returns the ability to dodge, which for water monsters is always true
	 * when hitPoints of the Monster are greater than or equal to 100.
	 * 
	 * @return true whenever the attack number is even
	 */
	public boolean dodge(){
		if(this.getHitPoints()>=100) {
			return true;
		}
		else {
			return false;
		}
	}
}
