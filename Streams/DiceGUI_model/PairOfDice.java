package model;

public class PairOfDice implements Rollable{
	//Fields
	private Die red;
	private Die blue;
	
	//Constructors
	public PairOfDice() {
		red = new Die();
		blue = new Die();
	}
	
	public PairOfDice(Die red, Die blue) {
		this.red = red;
		this.blue = blue;
	}
	
	//Methods
	@Override
	public void roll() {
		red.roll();
		blue.roll();
	}
	
	@Override
	public int getScore() {
		return red.getScore() + blue.getScore();
	}
	
	public Die getRed() {
		return red;
	}

	public Die getBlue() {
		return blue;
	}
	
	@Override
	public String toString() {
		return "PairOfDice:[red=" + red + ", blue=" + blue + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		// test exceptional cases, i.e. obj is a PairOfDice, and not null
		if ((this.getClass() != obj.getClass()) || (obj == null) )
			return false;

		PairOfDice other = (PairOfDice) obj; // cast to a PairOfDice object

		//test the red and blue Die objects for equality using the Die's equals method
		return this.red.equals(other.red) && this.blue.equals(other.blue);
	}
}
