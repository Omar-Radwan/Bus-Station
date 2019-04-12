package actors.classes;

import java.util.LinkedList;

import helping.classes.Ticket;
import helping.classes.Trip;

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
			Ticket t = new Ticket("One way",Ticket.priceInCaseOfOneWay(trip.getPrice()), trip);
			if (addTicket(t)) {
				trip.getVehicle().setCurrentNumberOfSeats(trip.getVehicle().getCurrentNumberOfSeats()-1);
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
			Ticket t = new Ticket("Round",(Ticket.priceInCaseOfRound(trip.getPrice())) , trip);
			
			if (addTicket(t)) {
				trip.getVehicle().setCurrentNumberOfSeats(trip.getVehicle().getCurrentNumberOfSeats()-1);
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
			if (canTake&&(x.getVehicle().getCurrentNumberOfSeats()>0)) {
				unbookedTrips.add(x);
			}
		}
		return unbookedTrips;
	}
	
	
	
	/*
	 * Behavior
	 */
	
	public void removeTicket(Ticket ticket) {
				ticket.getTrip().getVehicle().setCurrentNumberOfSeats(ticket.getTrip().getVehicle().getCurrentNumberOfSeats()+1);
				balance+=ticket.getPrice();
				ticketList.remove(ticket);
			
	}
	
}