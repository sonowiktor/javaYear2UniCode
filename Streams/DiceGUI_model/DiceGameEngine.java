package model;

/** A simple game engine that holds two players (a human and opponent)
 * and allows a game to be played by rolling both of their dice.
 * 
 * Furthermore, the winning player can be retrieved and an overview of
 * the results generated.
 * 
 * @author la
 */
public class DiceGameEngine {

	private Player human;
	private Player opponent;
	
	public DiceGameEngine() {
		human = null;
		opponent = null;
	}
	
	public DiceGameEngine(Player human, Player opponent) {
		this.human = human;
		this.opponent = opponent;
	}

	public Player getHuman() {
		return human;
	}

	public void setHuman(Player human) {
		this.human = human;
	}

	public Player getOpponent() {
		return opponent;
	}

	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	
	public void playGame() {
		human.rollDice();
		opponent.rollDice();
	}
	
	public Player getWinner() {
		if (human.getDiceScore() > opponent.getDiceScore()) {
			return human;
		} else if (human.getDiceScore() < opponent.getDiceScore()) {
			return opponent;
		} else {
			return null;
		}
	}
	
	public String calculateResults() {
		String results = "Game result overview\n================\n";
		
		if (getWinner() == human) {
			results+= "\nCongratulations, you win! :)";
		} else if (getWinner() == opponent) {
			results+= "\nCommiserations, you lose! :(";
		} else {
			results+= "\nGame drawn! :s";
		}
		
		results += "\n================\n";
		
		results+= "\nYour combined score: " + human.getDiceScore();
		results+= "\nYour die scores were: " + human.getPlayerDice().getRed().getScore() +
				" and " + human.getPlayerDice().getBlue().getScore();
		
		results+= "\n\nYour opponent's score: " + opponent.getDiceScore();
		results+= "\nTheir die scores were: " + opponent.getPlayerDice().getRed().getScore() +
				" and " + opponent.getPlayerDice().getBlue().getScore();
		
		
		return results;
	}
	
	
}
