package main;

import lib.Die;
import lib.Rollable;

public class DieApp {

	public static void main(String[] args) {
		//two hypothetical players have 5 sided die
		Die player1 = new Die(5);
		Die player2 = new Die(5);
		
		System.out.println("Player 1 - " + player1.toString());
		System.out.println("Player 2 - " + player2.toString());
		
		/*if you run this program several times, the output of
			the conditional statement below may differ - do you know why? 
			..Look at the constructor inside the Die class. */
		if (player1.equals(player2)) {
			System.out.println("Players are equal");
		} else {
			System.out.println("Players are not equal");
		}
		
		//playing a hypothetical game...
		System.out.println("\n... rolling both player's die");
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
		
		
		/* You will learn more about the use of Interface types later in the module
		 * for now you should observe the following: */
		
		//we can substitute (upcast) a Die object into a variable
		//of the Rollable interface type that it implements
		Rollable r = new Die();
		
		//in doing so we can safely invoke the roll and getScore methods defined in the interface
		r.roll();
		System.out.println(r.getScore());
		
		//we cannot however invoke other methods that are not specified in Rollable
		//e.g. temporarily uncomment the System.out.println below
		//System.out.println(r.getSides()); //compilation error
		
	}

}
