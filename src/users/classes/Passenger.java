package users.classes;

import java.util.LinkedList;

import classes.Ticket;
import classes.Trip;

public class Passenger extends User {


	
	/*
	 * Attributes
	 */

	private double balance;
	private LinkedList<Ticket> ticketList;

	
	
	/*
	 * Constructor
	 */

	public Passenger(String firstName, String lastName, String userName, String password, double balance) {
		super(firstName, lastName, userName, password);
		this.balance = balance;
		ticketList = new LinkedList<Ticket>();
	}
	
	

	/*
	 * Getters And Setters
	 */

	public LinkedList<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(LinkedList<Ticket> tickets) {
		this.ticketList = tickets;
	}

	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	

	/*
	 * toString uses "&" as delimiter
	 */
	
	public String toString (){
		StringBuilder stringBuilder = new StringBuilder(super.toString());

		
		stringBuilder.append(balance+"&");
		stringBuilder.append(ticketList.size()+"&");
		
		for (Ticket x : ticketList) {
			stringBuilder.append(x.toString());
		}
		
		return stringBuilder.toString();
	}

		
	
	/*
	 * Adders
	 */


	public boolean addTicket(Ticket ticket) {
		if (balance >= ticket.getPrice()) {
			balance -= ticket.getPrice();
			ticketList.add(0, ticket);
			return true;
		}
		return false;
	}

	
	public int addOneWayTicket(Trip trip) {
	
		if (getTicketFromTrip(trip)==null) {
			Ticket t = new Ticket("One way", trip.getPrice(), trip);
			if (addTicket(t)) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else return -1;
	}

	public int addRoundTicket(Trip trip) {
		if (getTicketFromTrip(trip)==null) {
			Ticket t = new Ticket("Round",( trip.getPrice()*2)-((20/100)*trip.getPrice()) , trip);
			if (addTicket(t)) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else return -1;
	}

	public Ticket getTicketFromTrip(Trip trip) {
		for (Ticket x : ticketList) {
			if (x.getTrip().equals(trip)) {
				return x;
			}
		}
		return null;
	}
	
	
	
	public LinkedList<Trip> getUnbookedTrips(LinkedList<Trip> allTrips) {
		LinkedList<Trip> unbookedTrips = new LinkedList<Trip>();
		
		for (Trip x : allTrips) {
			boolean canTake = true;
			for (Ticket y : ticketList) {
				if (y.getTrip().equals(x)) {
						canTake = false;
						break;
				}
		
			}
			if (canTake) {
				unbookedTrips.add(x);
			}
		}
		return unbookedTrips;
	}
	
	
	
	/*
	 * Behavior
	 */
	
	public void removeTicket(Ticket ticket) {

				balance+=ticket.getPrice();
				ticketList.remove(ticket);
			
	}
	
}