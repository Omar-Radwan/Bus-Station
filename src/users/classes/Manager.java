package users.classes;

import java.util.LinkedList;

import classes.Database;
import classes.Date;
import classes.Trip;
import classes.Message;


public class Manager extends Employee {

	/*
	 * Attributes
	 */
	
	static Database database ;
	LinkedList<Trip> tripsList; 
	Message message;
	Driver driver;

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
	


	@Override 
	public String toString() {
		return super.toString()+salary+"&";
	}
}





