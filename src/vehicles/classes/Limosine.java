package vehicles.classes;

import users.classes.Driver;

public class Limosine extends Vehicle {

	
	public Limosine(Driver driver) {
		super(driver);
		this.maxNumberOfSeats = 5;
		this.currentNumberOfSeats = maxNumberOfSeats;
	}
}
