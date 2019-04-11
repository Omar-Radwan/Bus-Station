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

	
	public void addOneWayTicket(Trip trip) {
		Ticket t = new Ticket("One way", trip.getPrice(), trip);
		ticketList.add(t);
	}

	public void addRoundTicket(Trip trip) {
		Ticket t = new Ticket("Round",( trip.getPrice()*2)-((20/100)*trip.getPrice()) , trip);
		ticketList.add(t);
	}

	
	/*
	 * Behavior
	 */
	
	public void removeTicket(Ticket ticket) {
		int i = 0;
		for (Ticket x : ticketList) {
			if (x.equals(ticket)) {
				ticketList.remove(i);
			}
			i++;
		}
	}
	
}