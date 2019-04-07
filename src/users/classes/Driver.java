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


	/*
	 * Getters And Setters
	 */


	/*
	 * toString uses " " as delimiter
	 */

	/*
	 * Behavior
	 */
	
	



	

}
