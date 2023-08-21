
package model;

import java.io.Serializable;

 
//Journey Details encapsulates a time and arrive/depart flag for a single journey
public class JourneyDetails implements Serializable {
    
    private int hour;
    private int minute;
    private boolean departure;
    
    public JourneyDetails() {
       this(0, 0, true); 
    }
    
    public JourneyDetails(int hour, int minute, boolean departure) {
        this.hour = hour;
        this.minute = minute;
        this.departure = departure;
    }
    
    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }
    
    public boolean isDeparture() {
        return departure;
    }
    
    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setDeparture(boolean departure) {
        this.departure = departure;
    }
    
    public String getInformation() {
        java.text.DecimalFormat formatter = new java.text.DecimalFormat("00");
        return (departure ? "Depart " : "Arrive ") 
                + formatter.format(hour) + ":" + formatter.format(minute);
    }
    
    public String toString() {
    	return "JourneyDetails:[hour=" + hour + ", minute=" + minute + ", departure=" + departure + "]";
    }
}
