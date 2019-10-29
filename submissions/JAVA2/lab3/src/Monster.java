import java.util.Arrays;

public class Monster {
	// properties of Monster
	private String type;
	private int hitPoints;
	private String[] attacks;
	private int[] attackPoints;

	// constructor initialising Monster
	public Monster(String type, int hitPoints, String[] attacks, int[] attackPoints) {
		this.type = type;
		this.hitPoints = hitPoints;
		this.attacks = attacks;
		this.attackPoints = attackPoints;
	}

	// method to remove points from a monster
	public void removeHitPoints(int pointsToRemove, Monster otherMonster) {
		otherMonster.hitPoints -= pointsToRemove; // subtracting points
		if (otherMonster.hitPoints < 0) { // initialising points back to 0 if they're less than 0.
			otherMonster.hitPoints = 0;
		}
	}

	// method to attack another monster
	public boolean attack(String attack, Monster otherMonster) {
		if (otherMonster == this) { // if the monster is the same
			return false;
		} else if (this.hitPoints == 0 || otherMonster.hitPoints == 0) { // if either monster has no health left
			return false;
		} else if (!(Arrays.asList(this.attacks).contains(attack))) {// if it's a valid attack or not
			return false;
		} else {
			int attackType = Arrays.asList(this.attacks).indexOf(attack); // calculating attack points
			removeHitPoints(this.attackPoints[attackType], otherMonster); // removing said attack points from the other
																			// monster
			return true;
		}

	}

	// Getters and setters
	public String getType() {
		return this.type;
	}

	public int getHitPoints() {
		return this.hitPoints;
	}

	public String[] getAttacks() {
		return this.attacks;
	}

	public int[] getAttackPoints() {
		return this.attackPoints;
	}

}
