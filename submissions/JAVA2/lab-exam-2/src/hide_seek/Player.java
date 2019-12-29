package hide_seek;

import java.util.Objects;
import java.util.Random;

public class Player {
	private String name;
	private boolean active;
	private boolean seeker;
	private Location location;
	public Player(String name, boolean seeker) {
		this.name = name;
		this.seeker = seeker;
		this.active = true;
		int pick = new Random().nextInt(Location.values().length);
		this.location = Location.values()[pick];
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public boolean isSeeker() {
		return seeker;
	}
	@Override
	public int hashCode() {
		return Objects.hash(active, location, name, seeker);
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
		return active == other.active && location == other.location && Objects.equals(name, other.name)
				&& seeker == other.seeker;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", active=" + active + ", seeker=" + seeker + ", location=" + location + "]";
	}
	
	
}
