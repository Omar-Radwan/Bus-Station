package vehicles.classes;

import users.classes.Driver;

public class MiniBus extends Vehicle {

	
	public MiniBus() {
		super();
		this.maxNumberOfSeats = 14; 
		this.currentNumberOfSeats = maxNumberOfSeats;
		this.type  = "MiniBus";
	}
	
}
