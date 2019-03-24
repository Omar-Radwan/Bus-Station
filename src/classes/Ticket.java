package classes;

	//---------------------------------------------------------------------------	

public class Ticket {
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
	
}
	//---------------------------------------------------------------------------


