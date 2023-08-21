package main;

import lib.dice.Die;
import lib.dice.PairOfDice;
import lib.dice.Rollable;

public class RollableDemo {

	public static void main(String[] args) {
		//two hypothetical players one with a 10 sided Die! the other with a pair of 5 sided dice..
		Rollable player1 = new Die(10);
		Rollable player2 = new PairOfDice(new Die(5), new Die(5));
		
		System.out.println("Player 1 - " + player1.toString());
		System.out.println("Player 2 - " + player2.toString());
		
		
		//playing a hypothetical game...
		System.out.println("\n... rolling both player's dice");
		player1.roll();
		player2.roll();
		
		System.out.println("Player 1 has rolled a score of: " + player1.getScore());
		System.out.println("Player 2 has rolled a score of: " + player2.getScore());
		
		if (player1.getScore() > player2.getScore()) {
			System.out.println("Player 1 wins!");
		} else if (player1.getScore() < player2.getScore()) {
			System.out.println("Player 2 wins!");
		} else {
			System.out.println("Draw!");
		}
		
		
	}

}
