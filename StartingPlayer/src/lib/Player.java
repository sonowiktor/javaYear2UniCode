package lib;

public class Player {
	
	//Fields
	private Name name;
	private PairOfDice pairOfDice;
	private String gamerTag;
	
	//Constructors
	public Player() {
		name = new Name();
		pairOfDice = new PairOfDice();
		gamerTag = "";
		
	}
	
	//Methods
	public Player(Name name, PairOfDice pairOfDice, String gamerTag) {
		this.name = name;
		this.pairOfDice = pairOfDice;
		this.gamerTag = gamerTag;
	}
	
	public void setName(Name name) {
		this.name = name;
	}
	
	public Name getName() {
		return name;
	}
	
	public void rollDice() {
		pairOfDice.roll();
	}
	
	public int getDiceScore() {
		return pairOfDice.getScore();
	}
	
	public PairOfDice getPairOfDice() {
		return pairOfDice;
	}
	
	public void setGamerTag(String gamerTag) {
		this.gamerTag = gamerTag;
	}
	
	public String getGamerTag() {
		return gamerTag;
	}
	
	public String toString() {
		return "Employee:[name=" + name + ", pairOfDice=" + pairOfDice + ", gamerTag="+ gamerTag + "]";
	}
	
	
	
	

}
