package classes;

import java.util.Scanner;

//---------------------------------------------------------------------------	

public class Ticket {
	private static int []seats = new int [12];
	String type;
	float price;
	
	//---------------------------------------------------------------------------

	
	public Ticket(String type, float price) {
		super();
		this.type = type;
		this.price = price;
	}
	//---------------------------------------------------------------------------

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
		}
	
	public void BookingTickets() 
	{
		for (int i =0 ; i<12 ; i++)
		{
			seats[i]=0;
			
		}
		
		int choice ;
		Scanner s = new Scanner (System.in);
		choice = s.nextInt();
		//window or aisle
		if (choice==1)
		{
			BookWindow();
		}
		else if (choice ==2)
		{
			BookAisle();
		}
		else 
			System.out.println("please enter a valid choice");
	}
	
	
	
	public static int BookWindow()
	{
		for ( int i =0; i<6 ; i++)
		{
			if (seats[i]==0)
			{
				seats[i]=1;
				return i+1;
			
			}
		}
		return -1;
	}

	public static int BookAisle()
	{
		
		for (int i=6 ; i<12 ; i++)
		{
			if (seats[i]==0)
			{
				seats[i]=1;
				return i+1;
				
			}
		}
		return -1;
	}
	

	
	
	
}
	