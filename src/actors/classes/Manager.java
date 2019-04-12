package actors.classes;

import database.classes.Database;
import helping.classes.Date;
import helping.classes.Ticket;
import helping.classes.Time;
import helping.classes.Trip;
import vehicles.classes.Vehicle;



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
			int numberOfStops, Date date, Time time,double price,double duration)
	{			
		Vehicle v = null;
		
		for(Vehicle x : database.getVehicleList())
			
		{
			if (x.getType().equals(vehicle)  && x.isAssigned()==false)
			{
				v=x;	
				x.setAssigned(true);
				break;
			}
	
		}
		if (v!=null)
		return database.addTrip(v, source, destination, distance, type, numberOfStops, date, time, price,duration);
		else return null;
	}
	

	
	/*
	 * Behavior
	 */
	
	
	public void removeTrip (Trip trip) {
		trip.getVehicle().setAssigned(false);
		// loop on all users and remove it from them
		for (Passenger x : database.getPassengersList()) {
			int i = 0 ; 
			for (Ticket t : x.getTicketList()) {
				if (t.getTrip().equals(trip)) {
					x.addMessage(this.userName,x.getUserName(),"Trip cancelation","Sorrily the trip with number "+t.getTrip().getNumber()+" has been cancelled and trip price has been added back to your balance, please review your trips, sorry for inconvinience.");
					x.setBalance(x.getBalance()+t.getPrice());
					x.getTicketList().remove(i);
				}
				i++;
			}
			
		}
		
		
		for (Driver x : database.getDriverList()) {
			System.out.println(x.getFirstName());
				
					x.addMessage(this.userName,x.getUserName(),"Trip cancelation","Sorrily the trip with number "+trip.getNumber()+" has been cancelled, please review your trips, sorry for inconvinience.");
					try {
						x.getTripsList().remove(trip);
					}
					catch (Exception e) {
					}
				
			
	
					
	
		}
		
		database.getTripList().remove(trip);
		
	}
	
	
	public Driver assignTrip(Trip trip,Driver driver) {
		for (Driver x :database.getDriverList()) {
			if (x.getTripsList().contains(trip)) return x;
		}
		driver.addMessage(this.userName, driver.userName, "Trip assign notification", "Trip number "+trip.getNumber()+" has been assigned to you");
		driver.addTrip(trip);
		return null;
	}
	
	public void removeDriverFromTrip (Driver driver,Trip trip) {
		driver.getTripsList().remove(trip);
		driver.addMessage(this.userName, driver.userName, "Trip unassign notification", "Trip number "+trip.getNumber()+" has been removed from you and might be added to another driver.");

	}
}