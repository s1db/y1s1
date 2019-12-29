package superhero;

import java.util.Arrays;

public class GameCharacter {
	private String name;
	private Power[] powers;
	public GameCharacter(String name, Power[] powers) {
		this.name = name;
		this.powers = powers;
	}
	public String getName() {
		return name;
	}
	public Power[] getPowers() {
		return powers;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(powers);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameCharacter other = (GameCharacter) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(powers, other.powers))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GameCharacter [name=" + name + ", powers=" + Arrays.toString(powers) + "]";
	}
	
}
