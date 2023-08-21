package model;

public class Player {

	private Name playerName;
	private PairOfDice playerDice;
	
	public Player(Name n, PairOfDice p) {
		playerName = n;
		playerDice = p;
		
	}
	
	public Name getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(Name playerName) {
		this.playerName = playerName;
	}
	
	public PairOfDice getPlayerDice() {
		return playerDice;
	}
	
	public void setPlayerDice(PairOfDice playerDice) {
		this.playerDice = playerDice;
	}
	
	public int getDiceScore() {
		return playerDice.getScore();
	}
	
	public void rollDice() {
		playerDice.roll();
	}

	@Override
	public String toString() {
		//non-standard toString as it will be output in the combobox in view
		return playerName.getFullName() + " - Die sides: " + playerDice.getRed().getSides();
	}
	
		
}
