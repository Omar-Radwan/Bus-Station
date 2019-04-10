package vehicles.classes;

public class Vehicle {

	/*
	 * Attributes
	 */

	int currentNumberOfSeats;
	String type;
	int maxNumberOfSeats;
	
	boolean isAssigned;
	static int firstFreeNumber = 0 ;
	int number;


	/*
	 * Constructor
	 */

	public Vehicle() {
		super();

		isAssigned = false;
		changeFreeNumbers();
		this.number = firstFreeNumber;
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

	public int getMaxNumberOfSeats() {
		return maxNumberOfSeats;
	}

	public void setMaxNumberOfSeats(int maxNumberOfSeats) {
		this.maxNumberOfSeats = maxNumberOfSeats;
	}


	public boolean isAssigned() {
		return isAssigned;
	}

	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	public int getCurrentNumberOfSeats() {
		return currentNumberOfSeats;
	}

	public void setCurrentNumberOfSeats(int currentNumberOfSeats) {
		this.currentNumberOfSeats = currentNumberOfSeats;
	}

	/*
	 * toString uses " " as delimiter
	 */

	@Override
	public String toString() {
		return number+" "+ type + " " + maxNumberOfSeats + " " + currentNumberOfSeats + " " + isAssigned + " ";
	}

	static void changeFreeNumbers() {
		firstFreeNumber++;
	}

	public static int getFirstFreeNumber() {
		return firstFreeNumber;
	}

	public static void setFirstFreeNumber(int firstFreeNumber) {
		Vehicle.firstFreeNumber = firstFreeNumber;
	}


	/*
	 * Behavior
	 */

}
