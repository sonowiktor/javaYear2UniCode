package main;

import lib.Name;

import lib.Register;


/**
 * @author Wiktor Kumor P2602600
 *
 */
public class RegisterApp {

	public static String execute(Name nm, Register regst) {	
        String output = "";
        regst.removeName(1);
        regst.addName(nm);
         
        
        
        for (Name i : regst) {
        	if (i.getFirstName().contains("a") ||  i.getFirstName().contains("e")) {
        		output += i.getFirstName().substring(0,1).toLowerCase() + "." + i.getFamilyName().substring(0,3).toLowerCase() + "@email.com" + "\n";
        		
        	}
		
	}
        return output;
}
}