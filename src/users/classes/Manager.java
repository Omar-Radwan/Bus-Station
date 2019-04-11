package users.classes;

import classes.Database;
import classes.Date;
import classes.Trip;
import vehicles.classes.Vehicle;
import classes.Time;



public class Manager extends Employee {

	/*
	 * Attributes
	 */
	
	private static Database database ;
	
	
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
	 * toString uses "&" as delimiter
	 */

	@Override 
	public String toString() {
		return super.toString()+salary+"&";

}
	
	
	/*
	 * Adders
	 */

	public Trip addTrip(String vehicle, String source, String destination, double distance, String type,
			int numberOfStops, Date date, Time time,double price)
	{		
				
		Vehicle v = null;
		
		for(Vehicle x : database.getVehicleList())
			
		{
			if (x.getType().equals(vehicle)  && x.isAssigned()==false)
			{
				v=x;	
			}
			break;
		
		}
		
		database.addTrip(v, source, destination, distance, type, numberOfStops, date, time, price);
		return database.getTripList().getLast();
	}
	
	
	/*
	 * Behavior
	 */
}