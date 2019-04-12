package vehicles.classes;

public class Vehicle {

	/*
	 * Attributes
	 */

	protected int currentNumberOfSeats;
	protected String type;
	protected int maxNumberOfSeats;

	protected boolean isAssigned;
	protected static int firstFreeNumber = 0;
	protected int number;

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
		this.currentNumberOfSeats = Math.max(currentNumberOfSeats, currentNumberOfSeats);
	}

	/*
	 * toString uses " " as delimiter
	 */

	@Override
	public String toString() {
		return number + "&" + type + "&" + maxNumberOfSeats + "&" + currentNumberOfSeats + "&" + isAssigned + "&";
	}

	public String data() {
		return "Vehicle number: " + number + ", available Seats: " + currentNumberOfSeats + ", type: " + type;
	}

	public static int getFirstFreeNumber() {
		return firstFreeNumber;
	}

	public static void setFirstFreeNumber(int firstFreeNumber) {
		Vehicle.firstFreeNumber = firstFreeNumber;
	}

	/*
	 * Adders
	 */

	/*
	 * Behavior
	 */
	static void changeFreeNumbers() {
		firstFreeNumber++;
	}

}
