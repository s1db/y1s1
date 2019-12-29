package planning;

import java.util.Random;
import java.util.Set;

public class Agent {
	Thing o1;

	public Agent() {
		this.o1 = null;
	}
	
	public boolean pickUp(Thing thing) {
		//returns false if the given thing is null
		if(thing == null) {
			return false;
		}
		//sets placeholder for o1 if it is null
		if(this.o1 == null) {
			//Placeholder for Thing which will eventually changed.
			this.o1 = new Thing("placeholder", Location.TABLE);
		}
		//returns false if thing is already being held.
		if(this.o1.location == Location.HOLDING) {
			return false;
		}
		//attempts to pick up object
		else {
			Random rand = new Random();
			int rand_int1 = rand.nextInt(2);
			if(rand_int1 == 0) {
				o1 = thing;
				o1.setLocation(Location.HOLDING);
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean putDown(Location place) {
		//if Agent has never picked up an object.
		if(this.o1 == null) {
			return false;
		}
		//if Agent isn't holding an object.
		if(this.o1.location != Location.HOLDING) {
			return false;
		}
		//attempts to pick up an object.
		else {
			Random rand = new Random();
			int rand_int1 = rand.nextInt(2);
			if(rand_int1==0) {
				this.o1.setLocation(place);
				return true;
			}
			else {
				return false;
			}
		}
	}
	public void putOnTable(Set<Thing> things) {
		//loops through given things.
		for(Thing thing : things) {
			boolean ifPickedUp = pickUp(thing);
			while(ifPickedUp != true) {
				ifPickedUp = pickUp(thing);
			}
			o1.setLocation(Location.TABLE);
		}
	}
}
