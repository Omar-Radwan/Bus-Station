package users.classes;

import classes.Database;
import classes.Date;
import classes.Ticket;
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
			int numberOfStops, Date date, Time time,double price,int duration)
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
		// loop on all users and remove it from them
		for (Passenger x : database.getPassengersList()) {
			int i = 0 ; 
			for (Ticket t : x.getTicketList()) {
				if (t.getTrip().equals(trip)) {
					x.addMessage(this.userName,x.getUserName(),"Trip cancelation","Sorrily the trip with number "+t.getTrip().getNumber()+" has been removed from your trips and trip price has been added back to your balance, please review your trips, sorry for inconvinience."+"\ntrip data: \n"+t.getTrip().data()  );
					x.setBalance(x.getBalance()+t.getPrice());
					x.getTicketList().remove(i);
				}
				i++;
			}
			
		}
		
		
		for (Driver x : database.getDriverList()) {
			System.out.println(x.getFirstName());
				
					x.addMessage(this.userName,x.getUserName(),"Trip cancelation","Sorrily the trip with number "+trip.getNumber()+" has been removed from your trips and trip price has been added back to your balance, please review your trips, sorry for inconvinience."+"\ntrip data "+trip.data());
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
		driver.addTrip(trip);
		return null;
	}
}