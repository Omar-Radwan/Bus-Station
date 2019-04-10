package users.classes;

import java.util.LinkedList;

import classes.Database;
import classes.Ticket;
import vehicles.classes.Vehicle;

public class Passenger extends User {

	/*
	 * Attributes
	 */

	double balance;
	LinkedList<Ticket> ticketList;
	Database database ;
	Vehicle vehicle;
	int seats[];
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
	

	public void BookingTicket ()
	{
		
		int x = vehicle.getCurrentNumberOfSeats();
		int i;
		
		for (i=0; i<x ; i++)
		{
			if (seats[i]==0)
			{
				seats[i]=1;
				x-- ;
			}
		}
}
	}