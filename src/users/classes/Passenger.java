package users.classes;

import java.util.LinkedList;

import classes.Ticket;
import classes.Trip;

public class Passenger extends User {

	/*
	 * Attributes
	 */

	double balance;
	LinkedList<Ticket> ticketList;

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

	/*
	 * toString uses " " as delimiter
	 */

	/*
	 * Behavior
	 */

	public boolean addTicket(Ticket ticket) {
		if (balance >= ticket.getPrice()) {
			balance -= ticket.getPrice();
			ticketList.add(0, ticket);
			return true;
		}
		return false;
	}

	public void removeTicket(Ticket ticket) {
		int i = 0;
		for (Ticket x : ticketList) {
			if (x.equals(ticket)) {
				ticketList.remove(i);
			}
			i++;
		}
	}

	public void addOneWayTicket(Trip trip) {
		Ticket t = new Ticket("One way", trip.getPrice(), trip);
		ticketList.add(t);
	}

	public void addRoundTicket(Trip trip) {
		Ticket t = new Ticket("Round",( trip.getPrice()*2)-((20/100)*trip.getPrice()) , trip);
		ticketList.add(t);
	}

}
