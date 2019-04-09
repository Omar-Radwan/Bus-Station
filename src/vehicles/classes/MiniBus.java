package vehicles.classes;

import users.classes.Driver;

public class MiniBus extends Vehicle {

	
	public MiniBus(Driver driver) {
		super(driver);
		this.maxNumberOfSeats = 14; 
		this.currentNumberOfSeats = maxNumberOfSeats;
	}
	
}
