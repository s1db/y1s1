package crafting;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Player {
	String name;
	ConcurrentHashMap<Resource, Integer> inventory;
	
	public Player(String name, ConcurrentHashMap<Resource, Integer> inventory) {
		this.name = name;
		this.inventory = inventory;
	}

	public String getName() {
		return name;
	}

	public Map<Resource, Integer> getInventory() {
		return inventory;
	}
	
	public boolean craft(Resource resource, Set<Recipe> recipes) {
		
		for(Recipe r: recipes) {
			if(r.result == resource) {
				//checks if requirements are met and if they aren't returns false
				for (Map.Entry req : r.requirements.entrySet()) {
					 Resource reqResource = (Resource)req.getKey();
					 int reqNumber = (int)req.getValue();
					 if(this.inventory.containsKey(reqResource)) {
						 if(!(reqNumber<=this.inventory.get(reqResource))) {
							return false; 
						 }
					 }
					 else {
						 return false;
					 }
				 }
				//updates inventory
				for(Map.Entry req : r.requirements.entrySet()) {
					Resource reqResource = (Resource)req.getKey();
					int newQuantitiy = this.inventory.get(reqResource) - (int)req.getValue();
					if(newQuantitiy > 0) {
						this.inventory.put(reqResource, newQuantitiy);
						}
					else {
						this.inventory.remove(reqResource);
						}
					
				}
			}
		}
		//adds new item to inventory
		this.inventory.put(resource, 1);
		return true;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", inventory=" + inventory + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(inventory, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(inventory, other.inventory) && Objects.equals(name, other.name);
	}
	
	
	
	
}
