package classes;

import vehicles.classes.Vehicle;

public class Trip {

	/*
	 * Attributes
	 */

	private Vehicle vehicle;
	private String source;
	private String destination;
	private double distance;
	private String type;
	private int numberOfStops;
	private Date date;
	private Time time;
	private double price;
	private static int firstFreeNumber = 0;
	private int number;
	private double duration;

	/*
	 * Constructor
	 */

	public Trip(Vehicle vehilce, String source, String destination, double distance, String type, int numberOfStops,
			Date date, Time time, double price,double duration) {
		super();
		this.vehicle= vehilce;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.type = type;
		this.numberOfStops = numberOfStops;
		this.date = date;
		this.time = time;
		this.price = price;
		changeFreeNumbers();
		this.number = firstFreeNumber;
		this.duration = duration;
	}

	
	/*
	 * Getters And Setters
	 */

	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	public double getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Vehicle getVehilce() {
		return vehicle;
	}

	public void setVehilce(Vehicle vehilce) {
		this.vehicle = vehilce;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

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

	 public static int getFirstFreeNumber() {
		return firstFreeNumber;
	}

	public static void setFirstFreeNumber(int firstFreeNumber) {
		Trip.firstFreeNumber = firstFreeNumber;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	/*
	 * toString uses "&" as delimiter
	 */
	
	@Override
	public String toString() {

		return number+"&"+vehicle.getNumber() + "&" + source + "&" + destination + "&" + distance + "&" + type + "&" + numberOfStops + "&"
				+ date + "&" + time + "&" + price + "&"+duration+"&";

	}

	public String data() {
		return "Vehicle: " + vehicle + "\nSource: " + source + "\nDestination: " + destination + "\nDistance: "
				+ distance + "\nType: " + type + "\nNumberOfStops: " + numberOfStops + "\nDate: " + date + "\nTime: "
				+ time+"\nDuration: "+duration;
	}

	/*
	 * Adders
	 */
	
	/*
	 * Behavior
	 */

	
	static void changeFreeNumbers() {
		firstFreeNumber++;
	}

}
