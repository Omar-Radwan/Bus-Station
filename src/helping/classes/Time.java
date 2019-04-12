package helping.classes;

public class Time {

	/*
	 * Attributes
	 */

	private int hours;
	private int minutes;
	private String amOrPM;

	/*
	 * Constructor
	 */

	public Time(int hours, int minutes, String amOrPm) {
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
		return String.format("%02d:%02d,%s", hours, minutes, amOrPM);
	}

	/*
	 * Adders
	 */

	/*
	 * Behavior
	 */

	public static double timeToValue(Time t, double duration) {
		double increaseValue = t.getAmOrPM().equals("am") ? 0 : 12 * 60;
		return t.getHours() * 60 + t.getMinutes() + increaseValue + duration * 60;
	}

}
