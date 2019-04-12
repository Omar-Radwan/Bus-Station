package actors.classes;

import java.util.LinkedList;

import helping.classes.Message;
import helping.classes.Time;
import helping.classes.Trip;

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

	public String data() {
		return userName;
	}
	/*
	 * Adders
	 */

	public void addTrip(Trip trip) {


		if (!tripsList.contains(trip))
			tripsList.add(0, trip);

	}

	/*
	 * Behavior
	 */

	public LinkedList<Trip> tripsCanTake(LinkedList<Trip> allTrips) {
		LinkedList<Trip> canTakeTrip = new LinkedList<Trip>();
		for (Trip x : allTrips) {
			boolean canTake = true;
			for (Trip y : tripsList) {
				if (x.getDate().toString().equals((y.getDate().toString()))) {
						canTake = false;
						break;
					
				}
		
			}
			if (canTake) {
				canTakeTrip.add(x);
			}
		}
		return canTakeTrip;
	}
}