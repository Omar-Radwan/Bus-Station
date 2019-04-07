package classes;

import java.util.Scanner;

public class Ticket {
	
	/*
	 * Attributes
	 */
	
	String type;
	float price;
	Trip trip;

	/*
	 * Constructor
	 */
	
	public Ticket(String type, float price, Trip trip) {
		super();
		this.type = type;
		this.price = price;
		this.trip = trip;
	}
	
	/*
	 * Getters And Setters
	 */

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	/*
	 * toString uses " " as delimiter
	 */

	/*
	 * Behavior
	 */

}
