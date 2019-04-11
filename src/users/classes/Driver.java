package users.classes;

import java.util.LinkedList;

import classes.Message;
import classes.Trip;

public class Driver extends Employee {

	
	/*
	 * Attributes
	 */
	
	private LinkedList<Trip> tripsList;
	private Message message;

	
	
	/*
	 * Constructor
	 */

	public Driver(String firstName, String lastName, String userName, String password, double salary) {
		super(firstName, lastName, userName, password, salary);
		tripsList = new LinkedList<Trip>();
		this.job = "Driver";
	}


	
	/*
	 * Getters And Setters
	 */
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public LinkedList<Trip> getTripsList() {
		return tripsList;
	}

	public void setTripsList(LinkedList<Trip> tripsList) {
		this.tripsList = tripsList;
	}
	

	/*
	 * toString uses "&" as delimiter
	 */

	public String toString() {

		StringBuilder stringBuilder = new StringBuilder(super.toString());

		stringBuilder.append(salary + "&");
		stringBuilder.append(tripsList.size() + "&");

		for (Trip x : tripsList) {
			stringBuilder.append(x.getNumber() + "&");
		}

		return stringBuilder.toString();
	}
	
	

	/*
	 * Adders
	 */


	public void addTrip(Trip trip) {
		tripsList.add(0,trip);
		
	}
	
	
	/*
	 * Behavior
	 */

	public int RequestToCancelTrip() {
		{

			for (Trip trip : tripsList) {
				if (trip.equals(trip)) {
					return 1;
				}
			}
			return 0;
		}
	}
}