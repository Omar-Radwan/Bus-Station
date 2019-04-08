package users.classes;

import classes.Database;
import classes.Date;
import classes.Trip;

public class Manager extends Employee {

	/*
	 * Attributes
	 */
	
	static Database database ;

	/*
	 * Constructor
	 */

	public Manager(String firstName, String lastName, String userName, String password, double salary) {
		super( firstName, lastName, userName, password, salary);
		this.job = "Manager";
	}

	/*
	 * Getters And Setters
	 */
	public static void setDataBase (Database database) {
		Manager.database = database;
	}
	/*
	 * toString uses " " as delimiter
	 */

	/*
	 * Behavior
	 */
	
	public Trip addTrip () {
		
		// code of adding trip
		//database.addTrip(vehicle, source, destination, distance, type, numberOfStops, date, time);\
		return database.getTripList().getLast();
	}

}
