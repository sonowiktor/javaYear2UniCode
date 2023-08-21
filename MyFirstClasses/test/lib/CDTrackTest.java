package lib;

import static org.junit.Assert.*;

import org.junit.Test;

public class CDTrackTest {

	@Test
	public void testDefaultConstructor() {
		CDTrack cd = new CDTrack();
		
		assertEquals("Title field should be initialised with an empty string", "", cd.getTitle());
		assertEquals("Artist field should be initialised with an empty string", "", cd.getArtist());
		
		//ensure your duration field is initialised to a non-negative number of the designer's choice
		assertTrue("Duration field should be initialised to a non-negative integer", cd.getDuration() >= 0);
	}

	@Test
	public void testCustomConstructor() {
		CDTrack cd = new CDTrack("We Are the Champions", "Queen", 218);

		assertEquals("Title field should be initialised with We Are the Champions", "We Are the Champions", cd.getTitle());
		assertEquals("Artist field should be initialised with Queen", "Queen", cd.getArtist());
		assertEquals("Duration field should be initialised to 218", 218, cd.getDuration());
	} 
	
	/*
	 * This is an additional test to ensure the constructor ignores negative durations
	 * and instead sets it to a default of zero.
	 */
	@Test
	public void testCustomConstructorNegativeDuration() {
		CDTrack cd = new CDTrack("We Are the Champions", "Queen", -5);

		assertEquals("Title field should be initialised with We Are the Champions", "We Are the Champions", cd.getTitle());
		assertEquals("Artist field should be initialised with Queen", "Queen", cd.getArtist());
		assertEquals("Duration field should be initialised to 0", 0, cd.getDuration());
	} 
	
	@Test
	public void testSetAndGetTitle() {
		CDTrack cd = new CDTrack();
		cd.setTitle("We Are the Champions");
		
		assertEquals("Title field should be set to and return We Are the Champions", "We Are the Champions", cd.getTitle());
	}
	
	@Test
	public void testSetAndGetArtist() {
		CDTrack cd = new CDTrack();
		cd.setArtist("Queen");
		
		assertEquals("Artist field should be set to and return Queen", "Queen", cd.getArtist());
	}

	@Test
	public void testSetAndGetDuration() {
		CDTrack cd = new CDTrack();
		cd.setDuration(100);
		
		assertEquals("Duration field should be set to and return 100", 100, cd.getDuration());
	}
	
	/*
	 * This is an additional test to ensure the set method ignores negative durations,
	 * i.e. the state of the duration field should remain unchanged
	 */
	@Test
	public void testSetDurationNegative() {
		CDTrack cd = new CDTrack();
		cd.setDuration(-5);
		
		assertEquals("Duration field should remain at 0", 0, cd.getDuration());
	}
		
	@Test
	public void testToString() {
		CDTrack cd = new CDTrack("We Are the Champions", "Queen", 218);
		String toStr = cd.toString();
		
		assertTrue("The toString method should be in the standard convention format", 
				toStr.startsWith("CDTrack:[") && 
				toStr.contains("=" + cd.getTitle() + ", ") &&
				toStr.contains("=" + cd.getArtist() + ", ") &&
				toStr.endsWith("=" + cd.getDuration() + "]"));
	}

}
