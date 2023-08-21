package binaryio;

import java.io.Serializable;

/**
 * A name has a first name and a family name.
 * There is an option to produce a full name by combining these.
 * 
 * @author Luke
 */

public class Name implements Serializable, Comparable<Name> {

	//Fields
	private String firstName;
	private String familyName;


	//Constructors
	public Name() {
		firstName = "";
		familyName = "";
	}

	public Name(String firstName, String familyName) {
		this.firstName = firstName;
		this.familyName = familyName;
	}


	//Methods
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public String getFullName() {
		if (firstName.equals("") && familyName.equals("")) {
			return "";
		} else {
			return firstName + " " + familyName;
		}
	}

	@Override
	public String toString() {
		return "Name:[firstName=" + firstName + ", familyName=" + familyName + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass())
			return false;

		Name other = (Name) obj;

		return this.firstName.equals(other.firstName) && this.familyName.equals(other.familyName);
	}

	@Override
	public int hashCode() {
		final int HASH_MULTIPLIER = 29; 
		return HASH_MULTIPLIER * firstName.hashCode() + familyName.hashCode();
	}

	@Override
	public int compareTo(Name other) {
		int result = this.familyName.compareTo(other.familyName);

		if (result==0) {
			result = this.firstName.compareTo(other.firstName);
		}

		return result;
	}
}

