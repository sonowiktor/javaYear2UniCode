package lib;

/** @author P2602600 Wiktor Kumor
 * 
 * Implementing the comparable interface for Player class
 */
public class Player implements Comparable<Player> {
	
	//fields
	/**
	 * name Field of type Name
	 */
	private Name name;
	/**
	 * pairOfDice Field of type Rollable
	 */
	private Rollable pairOfDice;
	/**
	 * gamerTag field of type String storing a hypothetical gamertag
	 */
	private String gamerTag = new String();
	
	//constructors
	
	/**
	 * Default constructor assigning default values to each field
	 */
	public Player() {
		name = new Name();
		pairOfDice = new Die();
		gamerTag = "";
	}
	
	/** First custom constructor accepting Name object and a gamertag,
	 * but assigning default value for the Die
	 * @param name value to be accepted
	 * @param gamerTag value to be accepted
	 */
	public Player(Name name, String gamerTag) {
		this.name = name;
		pairOfDice = new Die();
		this.gamerTag = gamerTag;
	}
	
	/** Second custom constructor accepting values for all three fields
	 * @param name
	 * @param gamerTag
	 * @param pairOfDice
	 */
	public Player(Name name, String gamerTag, Rollable pairOfDice) {
		this.name = name;
		this.pairOfDice = pairOfDice;
		this.gamerTag = gamerTag;
	}
	
	//methods
	
	/** Method to set name to Name object
	 * @param name The name to be set
	 */
	public void setName(Name name) {
		this.name = name;
	}
	
	/** Method to get/return the name value
	 * @return name to be returned
	 */
	public Name getName() {
		return name;
	}
	
	/** Method to get/return the pairOfDice value
	 * @return pairOfDice to be returned
	 */
	public Rollable getRollable() {
		return pairOfDice;
	}
	
	/**
	 *  The method to roll the dice 
	 */
	public void rollDice() {
		pairOfDice.roll();
	}
	
	/** The method to return the dice score
	 * @return the dice score
	 */
	public int getDiceScore() {
		return pairOfDice.getScore();
	}
	
	/** The method to set player's gamertag
	 * @param gamerTag gamertag to be set
	 */
	public void setGamerTag(String gamerTag) {
		this.gamerTag = gamerTag;
	}
	
	/** The method to return player's gamertag
	 * @return The gamertag to be returned
	 */
	public String getGamerTag() {
		return gamerTag;
	}
	
	/** The method to set full name of the player that accepts
	 * a single String argument then uses this to set the first and family name
     * individually by extracting the relevant information and then calling the respective setter
     * methods of the Name class
	 * @param fullName full name to be set 
	 */
    void setFullPlayerName(String fullName)  {
		String[] splitted = fullName.split(" "); // splitting the full name 
		
		String n1 = splitted[0].substring(0,1).toUpperCase() + splitted[0].substring(1).toLowerCase(); //providing the capitalised first name
		String n2 = splitted[1].substring(0,1).toUpperCase() + splitted[1].substring(1).toLowerCase(); //providing the capitalised family name
		
		this.name.setFirstName(n1); // setting the first name
		this.name.setFamilyName(n2); // setting the second name
	}
    
    /**
     * @return
     */
    public String getFullPlayerName() {
    	String empty = " No name set ";
    	if (name.equals("")) {
    		System.out.println(empty);
    		return empty;
    	} else {
    		return name.getFamilyName() + ", " + name.getFirstName().toUpperCase();
    	}
    	
    }
    	
    
  
	
	/** The method that accepts an int argument and
     * then uses this to generate a gamertag with number between
     * 1 and 100 and with the reversed full name in lower case
     * and no whitespace
	 * @param num number needed to generate the gamertag
	 */
	public void generateGamerTag(int num) {
		if (num > 0 && num < 100) { // ensuring the number is between 1 and 100
			String namee = name.getFirstName().toLowerCase() + name.getFamilyName().toLowerCase(); // providing the name in lower case
			String reversedName = new StringBuilder(namee).reverse().toString(); // providing the name in reversed order
			
			this.gamerTag = reversedName + num; // generating the gamertag 
		}
    }
	

	/**
	 * The simple toString() method in the standard convention format
	 */
	public String toString() {
		return "Player:[Name=" + name + ", GamerTag=" + gamerTag + ", Rollable=" + pairOfDice + "]";
	}

	
	/**
	 * @param other The player
	 * @return the result value
	 */
	@Override
	public int compareTo(Player other) {
		int result = this.name.compareTo(other.name);
        
        if (result == 0) {
            result = this.gamerTag.compareTo(other.gamerTag);
        }
        
        return result;
	}
	
	
	
}
