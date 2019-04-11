package classes;

public class Time {

	
	/*
	 * Attributes
	 */
	
	private int hours ; 
	private int minutes;
	private String amOrPM ;
	
	
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
	
	public String getAmOrPM() {
		return amOrPM;
	}


	public void setAmOrPM(String amOrPM) {
		this.amOrPM = amOrPM;
	}
	

	/*
	 * toString uses "&" as delimiter
	 */
	
	@Override
	public String toString() {
		return String.format("%02d:%02d,%s", hours,minutes,amOrPM);
	}  
	
	/*
	 * Adders
	 */
	
	/*
	 *  Behavior
	 */

	public boolean areOverlapping (double duration1,Time t2,double duration2) {
		
		double time1Start = this.hours*60+this.minutes+(amOrPM.equals("pm")? 12*60:0);
		double time2Start = t2.getHours()*60+t2.getMinutes()+(t2.getAmOrPM().equals("pm")? 12*60:0);
		double time1End = time1Start+duration1*60;
		double time2End = time2Start+duration2*60;
		
		if (time1Start>=time2End||time2Start>=time1End) {
			return true;
		}
		else return false;
		
	}


	
}
