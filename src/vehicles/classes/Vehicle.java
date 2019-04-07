package vehicles.classes;

import users.classes.Driver;

public class Vehicle {

	/*
	 * Attributes
	 */
	
	Driver driver;
	int maxNumberOfSeats;
	int currentNumberOfSeats;
	
	// commented attributes
	/*String color;
	String number;
	String type;*/

	/*
	 * Constructor
	 */

	public Vehicle(Driver driver) {
		super();
		this.driver = driver;
	}

	/*
	 * Getters And Setters
	 */




	public Driver getDriver() {
		return driver;
	}

	public int getMaxNumberOfSeats() {
		return maxNumberOfSeats;
	}

	public void setMaxNumberOfSeats(int maxNumberOfSeats) {
		this.maxNumberOfSeats = maxNumberOfSeats;
	}

	public int getCurrentNumberOfSeats() {
		return currentNumberOfSeats;
	}

	public void setCurrentNumberOfSeats(int currentNumberOfSeats) {
		this.currentNumberOfSeats = currentNumberOfSeats;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	/*
	 * toString uses " " as delimiter
	 */

	@Override
	public String toString() {
		return "" ;
	}

	/*
	 * Behavior
	 */

}
