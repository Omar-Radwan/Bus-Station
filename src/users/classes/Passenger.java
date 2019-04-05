package users.classes;

import java.util.ArrayList;

import classes.Trip;

public class Passenger extends User{

	public Passenger(String userName, String firstName, String lastName, String password, String type) {
		super(userName, firstName, lastName, password, type);
		// TODO Auto-generated constructor stub
	}
	ArrayList<Trip>trip;
	//pastAndUpcoming
	String membershipType; 
	int counter = 100;
	
	public void BuyTicket()
	{
		
		
	}
	
	
	
}
