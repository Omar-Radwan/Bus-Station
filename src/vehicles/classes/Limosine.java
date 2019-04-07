package vehicles.classes;

import users.classes.Driver;

public class Limosine extends Vehicle {
	static final int maxNumberOfSeats = 5; 
	
	public Limosine(Driver driver) {
		super(driver);
		this.currentNumberOfSeats = maxNumberOfSeats;
	}
}
