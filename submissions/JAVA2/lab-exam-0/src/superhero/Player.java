package superhero;

import java.util.Arrays;
import java.util.List;

public class Player {
	private List<GameCharacter> characters;

	public Player(List<GameCharacter> characters) {
		this.characters = characters;
	}

	public List<GameCharacter> getCharacters() {
		return characters;
	}

	public List<GameCharacter> chooseCharacters(Power[] neededPowers){
		for(GameCharacter c : characters) {
			
		}
		
		return characters;
		
	}
	
}
