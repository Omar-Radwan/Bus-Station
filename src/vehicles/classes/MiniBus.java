package vehicles.classes;

import users.classes.Driver;

public class MiniBus extends Vehicle {
	static final int maxNumberOfSeats = 14; 
	
	public MiniBus(Driver driver) {
		super(driver);
		this.currentNumberOfSeats = maxNumberOfSeats;
	}
	
}
