package classes;


public class Ticket {
	
	/*
	 * Attributes
	 */
	
	private String type;
	private double price;
	private Trip trip;
	

	/*
	 * Constructor
	 */
	
	public Ticket(String type, double price, Trip trip) {
		super();
		this.type = type;
		this.price = price;
		this.trip = trip;
	}
	
	
	/*
	 * Getters And Setters
	 */

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	/*
	 * toString uses "&" as delimiter
	 */

	public String data () {
		return trip.data()+"\nType: "+type+"\nPrice: "+price;
	}
	
	@Override 
	public String toString() {
		return type+"$"+price+"$"+trip.getNumber()+"&";
	}

	/*
	 * Adders
	 */
	
	/*
	 * Behavior
	 */
	
	}
