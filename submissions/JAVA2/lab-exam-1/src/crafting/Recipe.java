package crafting;

import java.util.Map;

public class Recipe {
	Resource result;
	Map<Resource, Integer> requirements;
	public Recipe(Resource result, Map<Resource, Integer> requirements) {
		super();
		this.result = result;
		this.requirements = requirements;
	}
	public Resource getResult() {
		return result;
	}
	public Map<Resource, Integer> getRequirements() {
		return requirements;
	}
	
}
