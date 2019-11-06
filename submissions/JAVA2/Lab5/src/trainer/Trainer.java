package trainer;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import monster.*;

public class Trainer {
	/** Name of trainer. */
	private String name;
	/** ArrayList of Monsters called Monsters */
	private ArrayList<Monster> Monsters = new ArrayList<Monster>();

	/** Constructor for defining a trainer */
	public Trainer(String name) {
		this.name = name;
	}

	/** Returns Name of Trainer */
	public String getName() {
		return name;
	}

	/** Method to add monster to Trainer, takes Monster as argument. */
	public boolean addMonster(Monster monster) {
		if (hasMonster(monster)) {
			return false;
		} else {
			Monsters.add(monster);
			return true;
		}
	}

	/** Method to remove monster from a Trainer, takes Monster as argument. */
	public boolean removeMonster(Monster monster) {
		if (hasMonster(monster)) {
			Monsters.remove(monster);
			return true;
		} else {
			return false;
		}
	}

	/** Checks if Trainer has a monster. */
	public boolean hasMonster(Monster monster) {
		for (Monster m : Monsters) {
			if (m == monster) {
				return true;
			}
		}
		return false;
	}

	/** Returns the number of Monsters of each type. */
	public Map<String, Integer> countMonstersByType() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int Fire = 0, Water = 0, Electric = 0;
		for (Monster m : Monsters) {
			if (m.getType() == "Fire") {
				Fire++;
			}
			if (m.getType() == "Water") {
				Water++;
			}
			if (m.getType() == "Electric") {
				Electric++;
			}
		}
		map.put("Fire", Fire);
		map.put("Water", Water);
		map.put("Electric", Electric);
		return map;
	}

	/** Returns a well formatted string of all attributes of a Trainer. */
	public String toString() {
		return ("Trainer Name: " + name + "\n Monsters:" + Monsters.toString());

	}
}
