package users.classes;

import java.util.LinkedList;

import classes.Date;
import classes.Trip;

public class Driver extends Employee{
	
	/*
	 * Attributes
	 */
	LinkedList<Trip> tripsList; 



	/*
	 * Constructor
	 */
	
	public Driver(String firstName, String lastName, String userName, String password, double salary) {
		super(firstName, lastName, userName,password, salary);
		tripsList = new LinkedList<Trip>();
		this.job = "Driver";
	}



	public LinkedList<Trip> getTripsList() {
		return tripsList;
	}



	public void setTripsList(LinkedList<Trip> tripsList) {
		this.tripsList = tripsList;
	}


	/*
	 * Getters And Setters
	 */


	/*
	 * toString uses " " as delimiter
	 */

	/*
	 * Behavior
	 */
	
	
	/*
	 * Adders
	 */

	public void addTrip (Trip trip) {
		tripsList.add(0,trip);
	}


	

}
