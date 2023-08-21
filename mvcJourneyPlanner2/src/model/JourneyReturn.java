
package model;

import java.io.Serializable;

//A Journey return encapsulates an out and return journey
public class JourneyReturn implements Serializable {

	private JourneyDetails outJourney;
	private JourneyDetails returnJourney;
	
	public JourneyReturn() {
		outJourney = new JourneyDetails();
		returnJourney = new JourneyDetails();
	}
	
	public JourneyReturn(JourneyDetails outJourney, JourneyDetails returnJourney) {
		this.outJourney = outJourney;
		this.returnJourney = returnJourney;
	}

	public JourneyDetails getOutJourney() {
		return outJourney;
	}

	public void setOutJourney(JourneyDetails outJourney) {
		this.outJourney = outJourney;
	}

	public JourneyDetails getReturnJourney() {
		return returnJourney;
	}

	public void setReturnJourney(JourneyDetails returnJourney) {
		this.returnJourney = returnJourney;
	}
	
	public String getReturnInformation() {
		return "Out Journey:\n" + outJourney.getInformation() + 
				"\n\nReturn Journey:\n" + returnJourney.getInformation();
	}
	
	public String toString() {
		return "JourneyDetails:[outJourney=" + outJourney + ", returnJourney=" + returnJourney + "]";
	}
	
	
	
}
