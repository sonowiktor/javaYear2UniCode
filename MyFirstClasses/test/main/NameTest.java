package main;

import static org.junit.Assert.*;


import org.junit.Test;

import lib.Name;

public class NameTest {

	@Test
	public void testDefaultConstructor() {
		Name n = new Name();
		
		assertEquals("First name field should be initialised with an empty string", "", n.getFirstName());
		assertEquals("Family name field should be initialised with an empty string", "", n.getFamilyName());
	}

	@Test
	public void testCustomConstructor() {
		Name n = new Name("Joe", "Bloggs");

		assertEquals("First name field should be initialised with Joe", "Joe", n.getFirstName());
		assertEquals("Family name field should be initialised with Bloggs", "Bloggs", n.getFamilyName());
	} 
	
	/* By testing the custom constructor with more than one set of arguments, you can ensure
	 * that the values cannot be hardcoded just to pass a given unit test. 
	 * 
	 * Running a test like this may however depend on the context and purpose of the tests.
	 */
	@Test
	public void testCustomConstructor2() {
		Name n = new Name("Tim", "Jones");

		assertEquals("First name field should be initialised with Tim", "Tim", n.getFirstName());
		assertEquals("Family name field should be initialised with Jones", "Jones", n.getFamilyName());
	} 
	
	/* An alternative approach to ensure hardcoded values are not returned is to keep an external reference
	 * to the object passed into the class and then ensure the exact same object reference is returned.
	 * 
	 * By doing this you do not need to test a method with more than one set of arguments as was shown in
	 * the previous unit test. This however will not work for primitive types.
	 */
	@Test
	public void testSetAndGetFirstName() {
		String s = new String("Tim");
		Name n = new Name();
		n.setFirstName(s);
		
		//whereas assertEquals uses the equals(...) method, assertSame uses the == operator, so this is
		//the same as saying s == n.getFirstName(), which would only return true if it is the same object
		//reference is returned
		assertSame("First name field should be set to and return the same object", s, n.getFirstName());
	}

	@Test
	public void testSetAndGetFamilyName() {
		Name n = new Name();
		n.setFamilyName("Jones");
		
		assertEquals("Family name field should be set to and return Jones", "Jones", n.getFamilyName());
	}
	
	@Test
	public void testGetFullName() {
		Name n = new Name("Joe", "Bloggs");
		
		assertEquals("Full name should be returned in the format: Joe Bloggs", "Joe Bloggs", n.getFullName());
	}
	
	/* When both first and family names are set to empty strings, e.g. by the default constructor
	 * the getFullName method should return an empty string itself.
	 */
	@Test
	public void testGetFullNameEmpty() {
		Name n = new Name();
		
		assertEquals("Full name (when empty) should be returned as an empty string", "", n.getFullName());
	}
	
	@Test
	public void testToString() {
		Name n = new Name("Joe", "Bloggs");
		String toStr = n.toString();
		
		assertTrue("The toString method should be in the standard convention format", 
				toStr.startsWith("Name:[") && 
				toStr.contains("=" + n.getFirstName() + ", ") &&
				toStr.endsWith("=" + n.getFamilyName() + "]"));
	}
	
}
