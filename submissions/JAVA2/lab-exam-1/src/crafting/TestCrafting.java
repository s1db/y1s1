package crafting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TestCrafting {
	
	
	public static void main(String... args) {
		ConcurrentHashMap<Resource, Integer> inventory = new ConcurrentHashMap<Resource, Integer>();
		HashMap<Resource, Integer> recinventory = new HashMap<Resource, Integer>();
		inventory.put(Resource.WOOD, 100);
		inventory.put(Resource.STONE, 100);
		recinventory.put(Resource.WOOD, 100);
		recinventory.put(Resource.STONE, 100);
		recinventory.put(Resource.DIAMOND, 100);
		Player p1 = new Player("sid", inventory);
		Recipe r1 = new Recipe(Resource.HELMET, inventory);
		Set<Recipe> r1Set = new HashSet<Recipe>();
		r1Set.add(r1);
		System.out.println(p1.toString());
		p1.craft(Resource.HELMET, r1Set);
		System.out.println(p1.toString());
		
	}
}
