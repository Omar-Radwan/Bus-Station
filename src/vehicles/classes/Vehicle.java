package vehicles.classes;

import users.classes.Driver;

public class Vehicle extends Driver{

	String color;
	String number;
	String type;
	int numberOfSeats;
	Driver driver;
	
	//---------------------------------------------------------------------------

	
	public Vehicle(String color, String number, String type, int numberOfSeats, Driver driver) {
		super();
		this.color = color;
		this.number = number;
		this.type = type;
		this.numberOfSeats = numberOfSeats;
		this.driver = driver;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	//---------------------------------------------------------------------------
	
	
	
	
}
