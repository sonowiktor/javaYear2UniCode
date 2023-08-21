package lib;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderLineTest {

	@Test
	public void testDefaultConstructor() {
		OrderLine o = new OrderLine();
		
		assertEquals("Id field should be initialised with an empty string", "", o.getId());
		assertEquals("Unit price field should be initialised to zero", 0, o.getUnitPrice());
		assertEquals("Quantity field should be initialised to zero", 0, o.getQuantity());
	}

	@Test
	public void testCustomConstructor() {
		OrderLine o = new OrderLine("Baked Beans", 55, 7);

		assertEquals("Id field should be initialised with Baked Beans", "Baked Beans", o.getId());
		assertEquals("Unit price field should be initialised to 55", 55, o.getUnitPrice());
		assertEquals("Quantity field should be initialised to 7", 7, o.getQuantity());
	} 
	
	@Test
	public void testSetAndGetId() {
		OrderLine o = new OrderLine();
		o.setId("Milk");
		
		assertEquals("Id field should be set to and return Milk", "Milk", o.getId());
	}
	
	@Test
	public void testSetAndGetUnitPrice() {
		OrderLine o = new OrderLine();
		o.setUnitPrice(99);
		
		assertEquals("Unit price field should be set to and return 99", 99, o.getUnitPrice());
	}
	
	@Test
	public void testSetAndGetQuantity() {
		OrderLine o = new OrderLine();
		o.setQuantity(3);
		
		assertEquals("Quantity field should be set to and return 3", 3, o.getQuantity());
	}
	
	@Test
	public void testGetCost() {
		OrderLine o = new OrderLine();
		o.setQuantity(4);
		o.setUnitPrice(50);
		
		assertEquals("Cost method should return 4*50 i.e. 200", 200, o.getCost());
	}
		
	@Test
	public void testToString() {
		OrderLine o = new OrderLine("Tuna 4 pack", 399 , 2);
		String toStr = o.toString();
		
		assertTrue("The toString method should be in the standard convention format", 
				toStr.startsWith("OrderLine:[") && 
				toStr.contains("=" + o.getId() + ", ") &&
				toStr.contains("=" + o.getUnitPrice() + ", ") &&
				toStr.endsWith("=" + o.getQuantity() + "]"));
	}
	
	/* This test will only pass once you have overridden the equals method to ensure
	 * two OrderLine objects are equal only if they share the same state.
	 */
	@Test
	public void testEqualsTrue() {
		OrderLine o1 = new OrderLine("Tuna 4 pack", 399 , 2);
		OrderLine o2 = new OrderLine("Tuna 4 pack", 399 , 2);
		
		assertTrue("The equals method should return true for two objects with the same state", o1.equals(o2));
	}
	
	/* This test will pass before you have overridden the equals method. This is because the equals
	 * method you inherit from class Object compares object references for equality, and o1 and o2
	 * indeed hold different object references.
	 * 
	 * A correct equals implementation however would return false because the state of the two objects
	 * was different, not because their object references (i.e. memory addresses) differ.
	 * 
	 * We can ensure that differing state in any field causes false to be returned.
	 */
	@Test
	public void testEqualsFalse() {
		OrderLine o1 = new OrderLine("Tuna 4 pack", 399 , 2);
		
		OrderLine o2 = new OrderLine("Tinned Tomatoes", 399 , 2);
		assertFalse("The equals method should return false for two objects with different ids", o1.equals(o2));
		
		o2 = new OrderLine("Tuna 4 pack", 200 , 2);
		assertFalse("The equals method should return false for two objects with different unit prices", o1.equals(o2));
		
		o2 = new OrderLine("Tuna 4 pack", 399 , 5);
		assertFalse("The equals method should return false for two objects with different quantites", o1.equals(o2));
		
	}
	
	/* We could also write the following two unit tests to ensure the exceptional cases of the equals
	 * method receiving null or a variable of a different class type are handled safely and return false.
	 */
	@Test
	public void testEqualsNull() {
		OrderLine o1 = new OrderLine("Tuna 4 pack", 399 , 2);
		OrderLine o2 = null;
		
		assertFalse("The equals method should safely return false as the argument is null", o1.equals(o2));
	}
	
	@Test
	public void testEqualsClassType() {
		OrderLine o1 = new OrderLine("Tuna 4 pack", 399 , 2);
		String s = "food";
		
		assertFalse("The equals method should safely return false as the argument is of a different class type", o1.equals(s));
	}

}
