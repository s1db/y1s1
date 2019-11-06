package trainer;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import monster.Attack;
import monster.FireMonster;
import monster.Monster;
import monster.WaterMonster;
import monster.ElectricMonster;
import monster.MonsterException;

public class Trainer {

	private String name;
	private Set<Monster> monsters;

	public Trainer(String name) {
		this.name = name;
		this.monsters = new HashSet<>();
	}

	public Map<String, Integer> countMonstersByType() {
		Map<String, Integer> monsterMap = new HashMap<>();
		for (Monster m : monsters) {
			if (monsterMap.get(m.getType()) == null) {
				monsterMap.put(m.getType(), 1);
			} else {
				monsterMap.put(m.getType(), monsterMap.get(m.getType()) + 1);
			}
		}
		return monsterMap;
	}

	public boolean hasMonster(Monster monster) {
		return monsters.contains(monster);
	}

	public String getName() {
		return name;
	}

	public boolean removeMonster(Monster monster) {
		return monsters.remove(monster);
	}

	public boolean addMonster(Monster monster) {
		return monsters.add(monster);
	}

	public void saveToFile(String filename) throws IOException {
		Path pathOfFile = Paths.get(filename);
		PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(pathOfFile));
		String returnString = name;
		for (Monster monster : monsters) {
			returnString += "^" + monster;
		}
		printWriter.println(returnString);
		printWriter.close();
//		System.out.println(returnString);
	}

	public static Trainer loadFromFile(String filename) throws IOException {
		try {
			List<String> lines = Files.readAllLines(Paths.get(filename));
			// looping through lines of file
			for (String line : lines) {
				// splitting all the properties of trainer.
				String[] trainerFields = line.split("\\^");
				String name = trainerFields[0];
				Set<Monster> monsters = new HashSet<Monster>();
				// initalizing new trainer
				Trainer trainer = new Trainer(name);
				// initalizing attacks of monster
				Attack[] attacksOfMonster = null;
				// looping though all monsters of trainer
				for (String strMonster : Arrays.copyOfRange(trainerFields, 1, trainerFields.length)) {
					// splitting properties of monster
					String[] monsterFields = strMonster.split("\\?");
					// taking the type and hit points of the monster
					String type = monsterFields[0];
					int hitPoints = Integer.parseInt(monsterFields[1]);
					// looping through attacks of monster
					for (String strAttacks : Arrays.copyOfRange(monsterFields, 2, monsterFields.length)) {
						// spliting attacks of monster
						String[] attacksFields = strAttacks.split("#");
						// creating a list of all attacks
						List<Attack> monsterAttacksList = new ArrayList<Attack>();
						for (String strAttack : attacksFields) {
							// extracting Attack name and points.
							String[] attackFields = strAttack.split("\\*");
							String attackName = attackFields[0];
							int attackPoints = Integer.parseInt(attackFields[1]);
							// Creating an Attack.
							Attack monsterAttack = new Attack(attackName, attackPoints);

							// Adding attack to the list
							monsterAttacksList.add(monsterAttack);
						}
						// converting list to array
						Attack[] attacksofMonster = new Attack[monsterAttacksList.size()];
						attacksOfMonster = monsterAttacksList.toArray(attacksofMonster);
					}
					// Creating the monster with the attacks and adding to the trainer
					if (type.compareTo("Fire") == 0) {
						Monster monster = new FireMonster(hitPoints, attacksOfMonster);
						trainer.addMonster(monster);
					}
					if (type.compareTo("Water") == 0) {
						Monster monster = new WaterMonster(hitPoints, attacksOfMonster);
						trainer.addMonster(monster);
					}
					if (type.compareTo("Electric") == 0) {
						Monster monster = new ElectricMonster(hitPoints, attacksOfMonster);
						trainer.addMonster(monster);
					}
				}
				// returning trainer
				return trainer;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		// In the file isn't read
		return null;
	}

	public static void main(String[] args) {
		Monster charizard, gyarados, magikarp;
		charizard = new FireMonster(130, new Attack[] { new Attack("Fire Spin", 14), new Attack("Blast Burn", 110),
				new Attack("Overheat", 160) });
		gyarados = new WaterMonster(169, new Attack[] { new Attack("Waterfall", 16), new Attack("Outrage", 110),
				new Attack("Hydro Pump", 130) });
		magikarp = new WaterMonster(58, new Attack[] { new Attack("Splash", 0), new Attack("Struggle", 35) });
		Trainer sidhant = new Trainer("sidhant");
		sidhant.addMonster(charizard);
		sidhant.addMonster(gyarados);
		sidhant.addMonster(magikarp);

		try {
			sidhant.saveToFile("out.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			loadFromFile("out.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String toString() {
		return name + ": " + monsters;
	}

	public Collection<Monster> getMonsters() {
		return monsters;
	}

}
