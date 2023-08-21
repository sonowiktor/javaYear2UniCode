package model;

import java.util.Observable;

/**
 * A Counter maintains a count value, which can be
 * incremented and decremented and reset to zero.
 * 
 *  @author LA
 */
public class Counter extends Observable {

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
		setChanged();
        notifyObservers(this.getCount());
	}

	public int getCount() {
		return count;
	}
	
	public void increment() {
		count = count + 1;
		setChanged();
        notifyObservers(this.getCount());
	}
	
	public void decrement() {
		count = count - 1;
		setChanged();
        notifyObservers(this.getCount());
	}
	
	public void reset() {
		count = 0;
		setChanged();
        notifyObservers(this.getCount());
	}
	
	public String toString() {
		return "Counter:[count=" + count + "]";
	}
	
}

