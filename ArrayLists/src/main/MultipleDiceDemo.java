package main;

import java.util.ArrayList;
import java.util.List;

import lib.Die;
import lib.MultipleDice;
import lib.Rollable;

public class MultipleDiceDemo {

	public static void main(String[] args) {
		//create an instance of MultipleDice
		MultipleDice hand = new MultipleDice();
		
		//add two 5 sided and one 6 sided die
		hand.addDie(new Die(5));
		hand.addDie(new Die(5));
		hand.addDie(new Die(6));
		
		hand.roll(); //roll all of them
		
		System.out.println(hand.toString()); //output details
		
		//create a MultipleDice collection with 10 die added
		MultipleDice tenDice = new MultipleDice(10);
		
		System.out.println("Size? " + tenDice.getSize());
		
		tenDice.roll(); //roll all of them then get total score
		System.out.println("Total score of all dice? " + tenDice.getScore());
		
		tenDice.clear(); //clear and check
		System.out.println("Is empty now? " + tenDice.isEmpty() + "\n");
		
		
		//we can also create a list of type Rollable and add
		//any type that implements this common interface
		List<Rollable> rollables = new ArrayList<>();
		rollables.add(new Die());
		rollables.add(new MultipleDice(3));
		
		//processes each rollable type in a uniform way
		for (Rollable r : rollables) {
			r.roll();
			System.out.println("Score is: " + r.getScore());
		}

	}

}
