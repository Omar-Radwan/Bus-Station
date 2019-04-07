package classes;

public class Time {

	/*
	 * Attributes
	 */
	
	int hours ; 
	int minutes;
	String amOrPM ;
	/*
	 * Constructor
	 */
	
	public Time(int hours, int minutes,String amOrPm) {
		super();
		this.hours = hours;
		this.minutes = minutes;
		this.amOrPM = amOrPm;
	}

	/*
	 * Getters and Setters
	 */

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}


	
	/*
	 * toString
	 */
	
	@Override
	public String toString() {
		return String.format("%2d:%2d", hours,minutes);
	}  
	
	
	/*
	 *  Behavior
	 */
	
	
	
	
	
}
