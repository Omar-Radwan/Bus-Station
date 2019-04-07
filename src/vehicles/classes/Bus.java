package vehicles.classes;

import users.classes.Driver;

public class Bus extends Vehicle{
	
	public Bus(Driver driver) {
		super(driver);
		this.maxNumberOfSeats = 50;
		this.currentNumberOfSeats = 50;
	}
	
}
