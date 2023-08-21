package main;

import java.util.ArrayList;
import lib.Player;

/**
 * @author Wiktor Kumor P2602600
 *
 */
public class PlayerApp {


	public static String execute(ArrayList<Player> participants, int number) {
		String output = "";
		
		for (Player i : participants) {
			if (i.getGamerTag().contains(i.getName().getFamilyName().toLowerCase() + number)) {
				output += i.getName().getFirstName().toUpperCase() + ", " + i.getName().getFamilyName().toLowerCase() + "\n";
			}
		}
		return output;
}
}
