package classes;

public class Date {

	/*
	 * Attributes
	 */

	int day;
	int month;
	int year;

	/*
	 * Constructor
	 */

	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/*
	 * Getters And Setters
	 */

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	/*
	 * toString function to save date in file
	 */

	@Override
	public String toString() {
		return String.format("%02d/%02d/%d", day , month , year);
	}

	/*
	 * Behaviors
	 */


}
