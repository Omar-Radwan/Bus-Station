package vehicles.classes;

import users.classes.Driver;

public class Limosine extends Vehicle {

	
	public Limosine() {
		super();
		this.maxNumberOfSeats = 5;
		this.currentNumberOfSeats = maxNumberOfSeats;
		this.type = "Limosine";
	}


}
