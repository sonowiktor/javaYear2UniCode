package lib;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModuleTest {

	/* Both the default and 2 argument custom constructor should initialise the coursework
	 * and exam weighting to 50.
	 */
	@Test
	public void testDefaultConstructor() {
		Module m = new Module("CTEC0000", "", 50, 50);
		
		//default modules should get a code of CTEC0000
		assertEquals("Code field should be initialised with CTEC0000", "CTEC0000", m.getCode());
		assertEquals("Name field should be initialised with an empty string", "", m.getName());
		assertEquals("Exam weight field should be initialised to 50", 50, m.getExamWeight());
		assertEquals("Cwk weight field should be initialised to 50", 50, m.getCwkWeight());
	}
	
	@Test
	public void testCustomConstructor2arg() {
		Module m = new Module("CTEC2602", "OO Development", 50, 50);

		assertEquals("Code field should be initialised with CTEC2602", "CTEC2602", m.getCode());
		assertEquals("Name field should be initialised with OO Development", "OO Development", m.getName());
		assertEquals("Exam weight field should be initialised to 50", 50, m.getExamWeight());
		assertEquals("Cwk weight field should be initialised to 50", 50, m.getCwkWeight());
	} 

	/* The 3 argument custom constructor should accept a value for the exam weighting and then ensure
	 * the coursework weighting is set so their combined total add up to 100. The following two tests check
	 * this works correctly. One test is not sufficient as the value could have been hardcoded.
	 */
	@Test
	public void testCustomConstructor3args_1() {
		Module m = new Module("CTEC2602", "OO Development", 60, 40);

		assertEquals("Code field should be initialised with CTEC2602", "CTEC2602", m.getCode());
		assertEquals("Name field should be initialised with OO Development", "OO Development", m.getName());
		assertEquals("Exam weight field should be initialised to 60", 60, m.getExamWeight());
		assertEquals("Cwk weight field should be initialised to 40", 40, m.getCwkWeight());
	} 
	
	@Test
	public void testCustomConstructor3args_2() {
		Module m = new Module("CTEC2901", "Data Structures", 70, 30);

		assertEquals("Code field should be initialised with CTEC2901", "CTEC2901", m.getCode());
		assertEquals("Name field should be initialised with Data Structures", "Data Structures", m.getName());
		assertEquals("Exam weight field should be initialised to 70", 70, m.getExamWeight());
		assertEquals("Cwk weight field should be initialised to 30", 30, m.getCwkWeight());
	} 
	
	@Test
	public void testSetAndGetCode() {
		Module m = new Module();
		m.setCode("CTEC2602");
		
		assertEquals("Code field should be set to and return CTEC2602", "CTEC2602", m.getCode());
	}
	
	@Test
	public void testSetAndGetName() {
		Module m = new Module();
		m.setName("OO Development");
		
		assertEquals("Name field should be set to and return OO Development", "OO Development", m.getName());
	}
	
	/* As well as testing the set/get methods for exam and cwk weight behave in a normal way, we also 
	 * need to ensure they check that the combined exam and cwk weighting adds up to 100.
	 */
	@Test
	public void testSetAndGetExamWeight() {
		Module m = new Module();
		m.setExamWeight(60);
		
		assertEquals("Exam weight field should be set to and return 60", 60, m.getExamWeight());
	}
	
	@Test
	public void testSetExamWeightUpdatingCwkWeight() {
		Module m = new Module();
		m.setExamWeight(60);
		
		assertEquals("Cwk weight field should be set to 40", 40, m.getCwkWeight());
	}
	
	@Test
	public void testSetAndGetCwkWeight() {
		Module m = new Module();
		m.setCwkWeight(70);
		
		assertEquals("Cwk weight field should be set to and return 70", 70, m.getCwkWeight());
	}
	
	@Test
	public void testSetCwkWeightUpdatingExamWeight() {
		Module m = new Module();
		m.setCwkWeight(70);
		
		assertEquals("Exam weight field should be set to 30", 30, m.getExamWeight());
	}
		
	@Test
	public void testToString() {
		Module m = new Module("CTEC2602", "OO Development");
		String toStr = m.toString();
		
		assertTrue("The toString method should be in the standard convention format", 
				toStr.startsWith("Module:[") && 
				toStr.contains("=" + m.getCode() + ", ") &&
				toStr.contains("=" + m.getName() + ", ") &&
				toStr.contains("=" + m.getExamWeight() + ", ") &&
				toStr.endsWith("=" + m.getCwkWeight() + "]"));
	}

}
