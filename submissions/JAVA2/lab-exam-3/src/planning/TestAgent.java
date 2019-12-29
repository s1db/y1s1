package planning;

import java.util.HashSet;
import java.util.Set;

public class TestAgent {
	public static void main(String... args) {
		Set<Thing> setA = new HashSet<Thing>();
		Thing o1 = new Thing("bottle", Location.FLOOR);
		setA.add(o1);
		Thing o2 = new Thing("cap", Location.TABLE);
		setA.add(o2);
		Thing o3 = new Thing("hat", Location.TABLE);
		setA.add(o3);
		Agent a1 =  new Agent();
		for(Thing thing: setA) {
			System.out.println(thing.toString());
		}
		a1.putOnTable(setA);
		for(Thing thing: setA) {
			System.out.println(thing.toString());
		}
	}
}
