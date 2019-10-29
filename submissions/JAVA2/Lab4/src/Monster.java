import java.util.Arrays;

/**
 * Lab 4 submission to JP2 2019. Represents a monster in a battling game.
 * 
 * @authors sbhavnani, mefoster
 *
 */
abstract public class Monster {

	/** The type */
	protected String type;
	/** Current hit points */
	private int hitPoints;
	/** List of attacks */
	private Attack[] attacks;

	/**
	 * Creates a new Monster with the given properties.
	 * 
	 * @param type      The type to use
	 * @param hitPoints The initial hit points
	 * @param attacks   The list of attacks, and points
	 */
	public Monster(String type, int hitPoints, Attack[] attacks) {
		this.type = type;
		this.hitPoints = hitPoints;
		this.attacks = attacks;
	}

	/**
	 * Returns the current hit points of this Monster.
	 * 
	 * @return The current hit points
	 */
	public int getHitPoints() {
		return hitPoints;
	}

	/**
	 * Returns the type of this Monster.
	 * 
	 * @return The monster type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Returns the list of attacks available to this Monster.
	 * 
	 * @return The list of attacks
	 */
	public Attack[] getAttacks() {
		return attacks;
	}

	/**
	 * Attacks the given other monster, and returns a Boolean value indicating
	 * whether the attack was successful. An attack fails if otherMonster is equal
	 * to this monster, if either this Monster or otherMonster is knocked out, or if
	 * the given attack name is not valid. If the attack succeeds, the corresponding
	 * hit points are removed from otherMonster; if it fails, no changes are made to
	 * either Monster.
	 * 
	 * @param attack       The attack to use
	 * @param otherMonster The Monster to attack
	 * @return True if the attack was successful, and raise an error if not.
	 */
	public void attack(String attack, Monster otherMonster) throws MonsterException {
		// A monster cannot attack itself
		if (otherMonster == this) {
			throw new MonsterException("A monster cannot attack itself.");
		}

		// A monster cannot attack or be attacked if it is knocked out
		if (this.hitPoints <= 0 || otherMonster.getHitPoints() <= 0) {
			throw new MonsterException("A monster cannot attack or be attacked if it is knocked out.");
		}

		// Find the attack -- if it exists, use it and return true, otherwise
		// do nothing and return false
		int attackPoints = 0;
		for (int i = 0; i < this.attacks.length; i++) {
			String nameOfAttack = this.attacks[i].getAttackName();
			if (nameOfAttack.equals(attack)) {
				attackPoints = this.attacks[i].getAttackPoints();
			}
		}
		if (attackPoints < 0) {
			throw new MonsterException("Not enough attack points.");
		}
		if (!otherMonster.dodge()) {
			otherMonster.removeHitPoints(attackPoints);
		} else {
			this.hitPoints -= 10;
			if (this.hitPoints < 0) {
				this.hitPoints = 0;
			}
		}
	}

	/**
	 * Abstract method dodge. It's the monster to dodge attacks.
	 */
	abstract protected boolean dodge();

	/**
	 * Removes the given hit points from the current monster. If the hit points
	 * would go below zero, it is set to zero.
	 * 
	 * @param points The number of points to remove
	 */
	public void removeHitPoints(int points) {
		this.hitPoints -= points;
		if (hitPoints <= 0) {
			// Monster is knocked out
			hitPoints = 0;
		}
	}

	@Override
	/**
	 * Returns a nice String representation of this Monster.
	 */
	public String toString() {
		return "Monster [type=" + type + ", hitPoints=" + hitPoints + ", attacks=" + Arrays.toString(attacks);
	}

	/**
	 * A main method to test the Monster class.
	 * 
	 * @param args
	 */
	/*
	 * public static void main(String[] args) { Attack fs = new Attack("Fire Spin",
	 * 14) Monster moltres = new Monster("Fire", 114, new Attack[] { "Fire Spin",
	 * "Overheat" }, new int[] { 14, 160 }); Monster articuno = new Monster("Ice",
	 * 112, new Attack[] { "Frost Breath", "Ice Beam" }, new int[] { 10, 90 });
	 * Monster zapdos = new Monster("Electric", 119, new Attack[] { "Charge Beam",
	 * "Thunder" }, new int[] { 8, 100 });
	 * 
	 * System.out.println(moltres); System.out.println(articuno);
	 * System.out.println(zapdos);
	 * 
	 * System.out.println(moltres.attack("Fire Spin", articuno)); // true
	 * System.out.println(moltres.getHitPoints()); // 114
	 * System.out.println(articuno.getHitPoints()); // 98
	 * 
	 * System.out.println(moltres.attack("Overheat", zapdos)); // true
	 * System.out.println(zapdos.getHitPoints()); // 0
	 * 
	 * System.out.println(moltres.attack("Bad Attack", articuno)); // false
	 * System.out.println(articuno.getHitPoints()); // 98
	 * 
	 * System.out.println(articuno.attack("Ice Beam", articuno)); // false
	 * System.out.println(articuno.getHitPoints()); // 98
	 * 
	 * System.out.println(zapdos.attack("Thunder", moltres)); // false }
	 */
}
