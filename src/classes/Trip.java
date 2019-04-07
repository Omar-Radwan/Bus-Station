package classes;

import users.classes.Driver;
import vehicles.classes.Vehicle;
import classes.*;
public class Trip {
	
	/*
	 * Attributes
	 */
	Vehicle vehilce;
	String source;
	String destination;
	
	double distance;
	
	String type;
	int numberOfStops;

	Date date;
	Time time;
	
	
	/*
	 * Constructor
	 */
	
	public Trip(Vehicle vehicle ,String source, String destination, double distance, String type, int numberOfStops,Date date,Time time) {
		super();
		this.vehilce = vehicle;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.type = type;
		this.numberOfStops = numberOfStops;
		this.date = date;
		this.time = time;
	}

	/*
	 * Getters And Setters
	 */
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumberOfStops() {
		return numberOfStops;
	}

	public void setNumberOfStops(int numberOfStops) {
		this.numberOfStops = numberOfStops;
	}


	/*
	 * toString uses " " as delimiter
	 */

	/*
	 * Behavior
	 */
	
	public void AddTrips() {
		
	
	
		
		
	}
	
	
	public void AvailableTrips()
	{
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
