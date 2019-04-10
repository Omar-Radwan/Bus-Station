package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

import users.classes.Driver;
import users.classes.Employee;
import users.classes.Manager;
import users.classes.Passenger;
import users.classes.User;
import vehicles.classes.Bus;
import vehicles.classes.Limosine;
import vehicles.classes.MiniBus;
import vehicles.classes.Vehicle;

public class Database {

	/*
	 * Attributes
	 */

	String pathname;

	LinkedList<Passenger> passengersList;
	LinkedList<Employee> employeeList;
	LinkedList<Vehicle> vehicleList;
	LinkedList<Trip> tripList;
	LinkedList<Ticket> ticketList;

	/*
	 * Constructor
	 */

	public Database(String pathname) {
		super();

		this.pathname = pathname;
		this.passengersList = new LinkedList<Passenger>();
		this.employeeList = new LinkedList<Employee>();
		this.vehicleList = new LinkedList<Vehicle>();
		this.tripList = new LinkedList<Trip>();
		this.ticketList = new LinkedList<Ticket>();
	}

	/*
	 * Getters And Setters
	 */

	public String getPathname() {
		return pathname;
	}

	public void setPathname(String pathname) {
		this.pathname = pathname;
	}

	public LinkedList<Passenger> getPassengersList() {
		return passengersList;
	}

	public void setPassengersList(LinkedList<Passenger> passengersList) {
		this.passengersList = passengersList;
	}

	public LinkedList<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(LinkedList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public LinkedList<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(LinkedList<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	public LinkedList<Trip> getTripList() {
		return tripList;
	}

	public void setTripList(LinkedList<Trip> tripList) {
		this.tripList = tripList;
	}

	public LinkedList<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(LinkedList<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public String getFilePath() {
		return pathname;
	}

	public void setFilePath(String filePath) {
		this.pathname = filePath;
	}

	/*
	 * Behavior
	 */

	/*
	 * Loads users from file to database
	 */

	public void loadAllUsers() throws IOException {

		File file = new File(pathname);
		FileReader fileReader = new FileReader(file);

		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while (bufferedReader.ready()) {
			String line = bufferedReader.readLine();

			loadUser(line);
		}
	}

	/*
	 * Initializes one user by fields read from file and adds it to database
	 */

	public User loadUser(String line) {

		StringTokenizer st = new StringTokenizer(line);

		String[] userFields = new String[4];

		userFields[0] = st.nextToken();
		userFields[1] = st.nextToken();
		userFields[2] = st.nextToken();
		userFields[3] = st.nextToken();

		return null;

	}

	/*
	 * Adds new user to the file and to the database
	 */

	public void registerUser(User x) throws IOException {

		File file = new File(pathname);
		PrintWriter pW = new PrintWriter(file);

	}

	/*
	 * Function that checks if there exists a user with user name and password given
	 */

	/*
	 * Adders
	 */

	public Vehicle addLimosine(Driver driver) {

		vehicleList.add(new Limosine(driver));
		return vehicleList.getLast();
	}

	public Vehicle addMiniBus(Driver driver) {

		vehicleList.add(new MiniBus(driver));
		return vehicleList.getLast();
	}

	public Vehicle addBus(Driver driver) {

		vehicleList.add(new Bus(driver));
		return vehicleList.getLast();
	}

	public Passenger addPassenger(String firstName, String lastName, String userName, String password, double balance) {
		
		passengersList.add(new Passenger(firstName, lastName, userName, password, balance));

		return passengersList.getLast();
	}

	public Employee addDriver(String firstName, String lastName, String userName, String password, double salary) {

		employeeList.add(new Driver(firstName, lastName, userName, password, salary));

		return (employeeList.getLast());
	}

	public Employee addManager(String firstName, String lastName, String userName, String password, double salary) {

		employeeList.add(new Manager(firstName, lastName, userName, password, salary));

		return employeeList.getLast();
	}

	public Trip addTrip(Vehicle vehicle, String source, String destination, double distance, String type,
			int numberOfStops, Date date, Time time) {

		tripList.add(new Trip(vehicle, source, destination, distance, type, numberOfStops, date, time));

		return tripList.getLast();
	}

	/*
	 * Functions
	 */


	public boolean isExist(String userName) {
		for (Passenger x : passengersList)
			if (x.getUserName().equals(userName))
				return true;

		for (Employee x : employeeList)
			if (x.getUserName().equals(userName))
				return true;

		return false;
	}	
	
	public int changeUserAttributes(User user, String firstName, String lastName, String userName, String password) {
		// check if the user name already exist

		return 1;
	}
	

}
