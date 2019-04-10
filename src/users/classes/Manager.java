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
	
	public Trip addTrip () {
		
		// code of adding trip
		
		
		return database.getTripList().getLast();
	}


	public void CancelTrip()
	{
		if (driver.RequestToCancelTrip()==1)
		{	
			for (Trip trip : tripsList){
			
			if(trip.equals(trip)) {
				
				tripsList.remove();				
			}
			
		}
		
		}
	}
	}	
	