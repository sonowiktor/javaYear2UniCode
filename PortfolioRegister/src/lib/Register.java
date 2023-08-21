package lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author Wiktor Kumor P2602600
 *
 * Implementing the Iterable interface of the Name type
 */
public class Register implements Iterable<Name> {
	//fields
	
	/**
	 * Our first field. The ArrayList of type Name
	 */
	private ArrayList<Name> name;
	/**
	 * roomCapacity field of type int
	 */
	private int roomCapacity;
	
	//constructors
	
	/**
	 * Default constructor. ArrayList assigns default values,
	 * but the room capacity is set to 20
	 */
	public Register() {
		name = new ArrayList<>();
		roomCapacity = 20;
	}
	
	/** Custom constructor accepting values to room capacity and 
	 * creating the ArrayList for the type Name
	 * @param roomCapacity value to be accepted
	 */
	public Register(int roomCapacity) {
		name = new ArrayList<Name>();
		this.roomCapacity = roomCapacity;
	}
	
	//methods
	
	/** The method to get/return the roomCapacity value
	 * @return The room capacity
	 */
	public int getRoomCapacity() {
		return roomCapacity;
	}
	
	/** The method to add the name to Name object
	 * ensuring the room capacity is not exceeded
	 * @param n The name to be added
	 */
	public void addName(Name n) {
		if (sizeOfRegister() < roomCapacity)  { //ensuring the room room capacity is not exceeded
			name.add(n); // Adding the name
		}
	}
	
	/** The method to remove the name at the given index
	 * @param pos the index of the name to be removed
	 * @return Returning the name object without the name at the given index
	 */
	public Name removeName(int pos) {
		return name.remove(pos);
	}
	
	/** The method to get the name at the given index
	 * @param pos the index of the name to be returned
	 * @return the name at the given index
	 */
	public Name getName(int pos) {
		return name.get(pos);
	}
	
	/**
	 * The method to clear the name from the Register
	 */
	public void clearName() {
		name.clear();
	}
	
	/**
	 *  The method to sort all the elements in the Register
	 */
	public void sortRegister() {
		Collections.sort(name);
	}
	
	/**
	 * The method to clear all entries in the Register
	 */
	public void clearRegister() {
		name.clear();
	}
	
	/** The method checking if the Register is empty returning
	 * @return returning true or false. It depends of the situation 
	 */
	public boolean isRegisterEmpty() {
		return name.isEmpty();
	}
	
	/** The method to add names that accepting the ArrayList<Name>
	 * and adding each of these names to the Register without exceeding
	 * the capacity
	 * @param names the ArrayList of names to be added
	 */
	public void addNames(ArrayList<Name> names) {
		if (sizeOfRegister() + names.size() <= roomCapacity) { // checking if the sum of Register and Arraylist will not exceed the room capacity
		name.addAll(names); // adding the names from the ArrayList
		}
	}
	
	/** The method to return the number of names in the Register
	 * @return Number of names 
	 */
	public int sizeOfRegister() {
		return name.size();
	}
	
	
	
	/** The method to search the full name whether the Register has the given initial
	 * @param initial the first name initial 
	 * @return true or false
	 */
	public boolean searchRegisterByFirstNameInitial(char initial) {
		boolean isInitial = false; // the boolean value of isInitial
		for(Name i : name) { // going through the whole ArrayList
			if (initial == (i.getFirstName().charAt(0))) { // Checking the situation when the ArrayList contains the given initial 
				isInitial = true;
			}
		}
		return isInitial; // returning the result
	}
	
	/** The method to count the number of the given first name 
	 * @param s The string value for a given first name
	 * @return The int value signaling the number of occurrences of first names in the Register
	 */
	public int countFirstNameOccurrences(String s) {
		int nameOcc = 0; // the int value to return the number of name occurrences later
		for (Name i : name) { //going through the whole array
			if (s.toLowerCase().equals(i.getFirstName().toLowerCase())) { //matching the given name with the Register
				nameOcc++; // counting the first name occurrences
			}
		}
		return nameOcc; // returning the number of occurrences
	}
	
	/**
	 * The method to return the iterator for the Register
	 */
	@Override
    public Iterator<Name> iterator() {
        return name.iterator();
    }


	/**
	 * The simple toString() method in the standard convention format
	 */
	public String toString() {
		return "Register:[name=" + name + ", roomCapacity=" + roomCapacity + "]";
	}
	
}
		
	

	
	
	


