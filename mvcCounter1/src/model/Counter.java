package model;
/**
 * A Counter maintains a count value, which can be
 * incremented and decremented and reset to zero.
 * 
 *  @author LA
 */
public class Counter {

	//Fields
	private int count;
	
	//Constructors	
	public Counter() {
		count = 0;
	}
	
	public Counter(int count) {
		this.count = count;
	}
	
	//Methods
	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}
	
	public void increment() {
		count = count + 1;
	}
	
	public void decrement() {
		count = count - 1;
	}
	
	public void reset() {
		count = 0;
	}
	
	public String toString() {
		return "Counter:[count=" + count + "]";
	}
	
}
