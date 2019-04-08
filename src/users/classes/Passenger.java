package users.classes;

import java.util.LinkedList;

import classes.Ticket;

public class Passenger extends User {

	/*
	 * Attributes
	 */

	double balance;
	LinkedList<Ticket> ticketList;
	
	/*
	 * Constructor
	 */

	public Passenger( String firstName, String lastName, String userName, String password, double balance) {
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
	
	public boolean addTicket(double tripPrice, Ticket ticket) {
		if (balance >= tripPrice) {
			balance -= tripPrice;
			ticketList.add(0, ticket);
			return true;
		}
		return false;
	}
	
	

}
