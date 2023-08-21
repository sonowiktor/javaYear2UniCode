package main; //the package of this Test Case mirrors the package structure of the Counter class under test

import static org.junit.Assert.*;

import org.junit.Test;

import lib.Counter;

/**
 * This class contains a number of tests to test the Counter class.
 * It is convention to place the test class under a separate src tree
 * with the same package 'mirrored' structure. 
 * Also you should append the word 'Test' after the class name as a suffix.
 * 
 * There are many unit testing frameworks available; however, JUnit is
 * the industry standard. This class only shows some basic features of 
 * JUnit testing.
 * 
 * Ideally each test is carried out in isolation from the other tests - a unit
 * of testing; and hence the name unit testing.
 */
public class CounterTest {
	
	/*
	 * Each test must be a public void method which has a name in the style
	 * of 'testNameOfTest'. The test must also have the @Test annotation to
	 * allow the test runner to know that we want to run it.
	 */
	@Test
	public void testDefaultConstructor() {
		Counter c = new Counter();
		
		//The assertEquals methods allow us to assert that two values are the same.
		//We can provide a message that is output in the event of the test failing.
		assertEquals("Count field should be initialised to 0", 0, c.getCount());
	}
	
	@Test
	public void testCustomConstructor() {
		Counter c = new Counter(10);
		
		assertEquals("Count field should be initialised to 10", 10, c.getCount());
	}
	
	/* Whilst this is slightly subjective, a set and get method (that simply assign and
	 * return a value respectively) can be tested in the same unit test.
	 */
	@Test
	public void testSetAndGetCount() {
		Counter c = new Counter();
		c.setCount(50);
		
		assertEquals("Count field should be set to and return 50", 50, c.getCount());
	}
	
	@Test
	public void testIncrement() {
		Counter c = new Counter();
		c.increment();
		
		assertEquals("Increment should increase value to 1", 1, c.getCount());
	}
	
	@Test
	public void testIncrementBy() {
		Counter c = new Counter();
		c.incrementBy(5);
		
		assertEquals("IncrementBy should increase value to 5",5, c.getCount());
	}
	
	@Test
	public void testReset() {
		Counter c = new Counter();
		c.increment();
		c.increment();
		c.reset();
		
		assertEquals("Reset should set the counter to 0", 0, c.getCount());
	}
	
	@Test
	public void testIsZeroTrue() {
		Counter c = new Counter();
		
		//There are numerous different types of assertions tests depending on what
		//you need. These can be found on the JUnit website, e.g. https://github.com/junit-team/junit4/wiki/Assertions
		assertTrue("IsZero should return true", c.isZero());
	}
	
	/* We can test the isZero method returns both true and false when we
	 * would expect it to. The latter of which is assessed in this unit test.
	 */
	@Test
	public void testIsZeroFalse() {
		Counter c = new Counter(5);
		
		assertFalse("IsZero should return false", c.isZero());
	}
	
	
	/* We can assess that the toString is in the standard convention format. 
	 * This could also be achieved using regular expressions.
	 */
	@Test
	public void testToString() {
		Counter c = new Counter(5);
		String toStr = c.toString();
		
		
		assertTrue("The toString method should be in the standard convention format", 
				toStr.startsWith("Counter:[") && 
				toStr.endsWith("=" + c.getCount() + "]"));
	}
}
