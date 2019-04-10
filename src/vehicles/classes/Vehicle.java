package vehicles.classes;

import users.classes.Driver;

public class Vehicle {

	/*
	 * Attributes
	 */
	
	int currentNumberOfSeats;
	String type;
	int maxNumberOfSeats;
	boolean isAssigned ; 
	// commented attributes
	/*String color;
	String number;
	*/

	/*
	 * Constructor
	 */

	public Vehicle(Driver driver) {
		super();
		isAssigned = false;
	}

	/*
	 * Getters And Setters
	 */






	public int getCurrentNumberOfSeats() {
		return currentNumberOfSeats;
	}

	public void setCurrentNumberOfSeats(int currentNumberOfSeats) {
		this.currentNumberOfSeats = currentNumberOfSeats;
	}


	/*
	 * toString uses " " as delimiter
	 */

	@Override
	public String toString() {
		return "";
	}

	/*
	 * Behavior
	 */

}
