package trainer;

import monster.*;

public class Trade {
	/** trainer 1 */
	private Trainer trainer1;
	/** monster 1 */
	private Monster monster1;
	/** trainer 2 */
	private Trainer trainer2;
	/** monster 2 */
	private Monster monster2;

	/**
	 * Creates a new Trade with the given properties.
	 * 
	 * @param trainer1 Trainer 1 with whom the trade is going to happen.
	 * @param monster1 Monster of trainer1 that is going to be traded.
	 * @param trainer2 Trainer 2 with whom the trade is going to happen.
	 * @param monster2 Monster of trainer2 that is going to be traded.
	 */
	public Trade(Trainer trainer1, Monster monster1, Trainer trainer2, Monster monster2) throws MonsterException {
		this.trainer1 = trainer1;
		this.trainer2 = trainer2;
		this.monster1 = monster1;
		this.monster2 = monster2;

		/* Checking for errors */
		if (!trainer1.hasMonster(monster1)) {
			throw new MonsterException(trainer1.getName() + " doesn't have this monster.");
		}
		if (!trainer2.hasMonster(monster2)) {
			throw new MonsterException(trainer2.getName() + " doesn't have this monster.");
		}
	}

	/**
	 * Performs trade between the two trainers.
	 * 
	 * @return nothing.
	 */
	public void doTrade() {
		trainer1.removeMonster(monster1);
		trainer2.addMonster(monster1);
		trainer2.removeMonster(monster2);
		trainer1.addMonster(monster2);
	}
}
