package model;

/**
 * A ModuloCounter maintains a count value, which can be
 * incremented and decremented and reset to zero. It also
 * has a maximum value (i.e. its modulo) ensuring the count 
 * stays within the range 0..modulo-1 by wrapping appropriately.
 * 
 *  @author la/lz
 */
public class ModuloCounter extends Counter {
	
	final private int modulo;
	
	/** Creates a counter with initial value 0 and 
	 * a default modulo of 10.*/
	public ModuloCounter() {
		super();
		modulo = 10;
	}
	
	/** Creates a counter with initial value 0 
	 * and the given modulo.*/
	public ModuloCounter(int modulo) {
		super(); 
		this.modulo = modulo;
	}

	/** Creates a counter with the given initial 
	 * value and modulo.*/
	public ModuloCounter(int modulo, int initialCount) {
		super();
		this.modulo = modulo;
		this.setCount(initialCount);
	}
	
	/** Increments the counter with wrapping to the modulo. */
	@Override
	public void increment() {
		super.increment();
		this.setCount(super.getCount());	
	}

	/** Decrements the counter with wrapping to the modulo. */
	@Override
	public void decrement() {
		super.decrement();
		this.setCount(super.getCount());	
	}
	
	/** Sets the count using modulo. */
	@Override
	public void setCount(int count) {
		super.setCount(Math.floorMod(count, modulo));
	}
	
	/** Returns the modulo of this counter. */
	public int getModulo() {
		return modulo;
	}
	
	@Override
	public String toString() {
		return super.toString() + " [modulo=" + modulo +"]";
	}

}


