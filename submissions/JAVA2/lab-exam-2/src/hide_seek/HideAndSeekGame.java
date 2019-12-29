package hide_seek;

import java.util.Random;

public class HideAndSeekGame {
	private Player[] players;

	public HideAndSeekGame(Player[] players) {
		this.players = players;
		boolean noseeker = true;
		for(Player player: players) {
			if(player.isSeeker())
				noseeker = false;
		}
		if(noseeker)
			throw new IllegalArgumentException("No seeker provided in players.");
	}
	public void playGame(int numRounds) {
		for(int i=0; i<numRounds; i++) {
			int seekerid = 0;
			for(int j=0; j<players.length;j++) {
				Player player = players[j];
				if(player.isSeeker())
					seekerid = j;
			}
			Player seeker = players[seekerid];
			for(Player player: players) {
				if((!player.equals(seeker))&&(player.getLocation().equals(seeker.getLocation())&&(player.isActive())))
					player.setActive(false);
			}
			for(Player player: players) {
				int pick = new Random().nextInt(Location.values().length);
				player.setLocation(Location.values()[pick]);
			}
			boolean hasActivePlayers = false;
			for(Player player: players) {
				if((player.isActive())&&(!player.equals(seeker))) {
					hasActivePlayers = true;
				}
			}
			if(!hasActivePlayers) {
				break;
			}
		}
	}
	public Player[] getPlayers() {
		return players;
	}
}
