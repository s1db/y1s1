package hide_seek;

public class HideAndSeekTester {

	public static void main(String[] args) {
		Player p1 = new Player("naman", true);
		Player p2 = new Player("jhapnit", false);
		Player p3 = new Player("anish", false);
		Player p4 = new Player("aryaman", false);
		Player p5 = new Player("sila", false);
		Player p6 = new Player("gayneesh", false);
		Player[] players = {p1,p2,p3,p4,p5,p6,};
		HideAndSeekGame mis = new HideAndSeekGame(players);
		mis.playGame(20);
	}

}
