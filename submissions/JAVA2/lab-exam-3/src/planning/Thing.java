package planning;

import java.util.Objects;

public class Thing {
	String name;
	Location location;
	
	public Thing(String name, Location location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(location, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thing other = (Thing) obj;
		return location == other.location && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Thing [name=" + name + ", location=" + location + "]";
	}
	
	

}
