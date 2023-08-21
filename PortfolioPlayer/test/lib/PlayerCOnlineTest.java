package lib;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.junit.Test;

import lib.Player;

public class PlayerCOnlineTest {
	@Test
	public void testGetFullPlayerName() {
		Player p = new Player();
	
		
		p.setName(new Name("Fred", "Jones"));
		
		assertEquals("Should return name in format: Jones, FRED", "Jones, FRED", p.getFullPlayerName());
		
		
		p.setName(new Name("Joe", "Bloggs"));
		
		assertEquals("Should return name in format: Bloggs, JOE", "Bloggs, JOE", p.getFullPlayerName());
	}
	
	
	@Test
	public void testGetFullPlayerName2() {
		Player p = new Player();
	
		/* EXTENSION */
		
		assertEquals("Should return name in format: No name set", "No name set", p.getFullPlayerName());
		
		/* -------- */
		
		
		p.setName(new Name("Fred", "Jones"));
		
		assertEquals("Should return name in format: Jones, FRED", "Jones, FRED", p.getFullPlayerName());
		
		
		p.setName(new Name("Joe", "Bloggs"));
		
		assertEquals("Should return name in format: Bloggs, JOE", "Bloggs, JOE", p.getFullPlayerName());
	}
	

	@Test
	public void testSetFullPlayerNameOverridden() {
		Player p = new Player();
		
		p.setFullPlayerName("Joe Bloggs");
		
		assertEquals("Name should have been set unchanged", new Name("Joe", "Bloggs"), p.getName());
		
		
		p = new PlayerC(); //create instance of subclass
		
		p.setFullPlayerName("Joe Bloggs"); //using overridden setFullPlayerName
		
		assertEquals("Name should have been set in uppercase", new Name("JOE", "BLOGGS"), p.getName());
		
		p.setFullPlayerName("Tim Toms"); //test with different value
		
		assertEquals("Name should have been set in uppercase again", new Name("TIM", "TOMS"), p.getName());
		
		
		p.setName(new Name("Fred", "Jones"));
		p.setFullPlayerName(""); //testing with an empty string
		
		assertEquals("Name should not have been set and remain unchanged", new Name("Fred", "Jones"), p.getName());
		
		
		//Other checks to ensure you have passed this test in the intended manner
		Field[] fields = Player.class.getDeclaredFields();
		assertTrue("All fields must remain private", Arrays.stream(fields).allMatch(f -> (Modifier.PRIVATE & f.getModifiers()) != 0));
		
		Field[] fieldsC = PlayerC.class.getDeclaredFields();
		assertEquals("The PlayerC class should not define any fields", 0, fieldsC.length);
				
		Method[] methodsC = PlayerC.class.getDeclaredMethods();
		assertTrue("The PlayerC class should only have 1 method called setFullPlayerName", 
				methodsC.length == 1 && methodsC[0].getName().equals("setFullPlayerName"));
		
	}

}
