package vehicles.classes;

import users.classes.Driver;

public class Bus extends Vehicle {

	public Bus() {
		super();
		this.maxNumberOfSeats = 50;
		this.currentNumberOfSeats = maxNumberOfSeats;
		this.type = "Bus";
	}

}
