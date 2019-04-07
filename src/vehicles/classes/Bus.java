package vehicles.classes;

import users.classes.Driver;

public class Bus extends Vehicle{
	static final int maxNumberOfSeats = 50; 
	
	public Bus(Driver driver) {
		super(driver);
		this.currentNumberOfSeats = maxNumberOfSeats;
	}
	
}
