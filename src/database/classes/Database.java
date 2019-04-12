package database.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

import actors.classes.Driver;
import actors.classes.Employee;
import actors.classes.Manager;
import actors.classes.Passenger;
import actors.classes.User;
import helping.classes.Date;
import helping.classes.Message;
import helping.classes.Ticket;
import helping.classes.Time;
import helping.classes.Trip;
import vehicles.classes.Bus;
import vehicles.classes.Limosine;
import vehicles.classes.MiniBus;
import vehicles.classes.Vehicle;

public class Database {

	/*
	 * Attributes
	 */

	LinkedList<Passenger> passengersList;
	LinkedList<Driver> driverList;
	LinkedList<Manager> managerList;
	LinkedList<Vehicle> vehicleList;
	LinkedList<Trip> tripList;

	private File file;
	private FileReader filereader;
	private FileWriter filewriter;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;

	/*
	 * Constructor
	 */

	public Database(String pathname) {
		super();

		this.passengersList = new LinkedList<Passenger>();
		this.driverList = new LinkedList<Driver>();
		this.managerList = new LinkedList<Manager>();
		this.vehicleList = new LinkedList<Vehicle>();
		this.tripList = new LinkedList<Trip>();

	}

	/*
	 * Getters And Setters
	 */

	public LinkedList<Passenger> getPassengersList() {
		return passengersList;
	}

	public void setPassengersList(LinkedList<Passenger> passengersList) {
		this.passengersList = passengersList;
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

	public LinkedList<Driver> getDriverList() {
		return driverList;
	}

	public void setDriverList(LinkedList<Driver> driverList) {
		this.driverList = driverList;
	}

	public LinkedList<Manager> getManagerList() {
		return managerList;
	}

	public void setManagerList(LinkedList<Manager> managerList) {
		this.managerList = managerList;
	}

	/*
	 * Behavior
	 */

	/*
	 * Adds new user to the file and to the database
	 */



	/*
	 * 
	 * Function that checks if there exists a user with user name and password given
	 */

	public User authenticate(String userName, String password, String type) {

		if (type.equals("Passenger")) {
			for (Passenger x : passengersList)
				if (x.getUserName().equals(userName) && x.getPassword().equals(password))
					return x;
		}

		else {
			for (Driver x : driverList)
				if (x.getUserName().equals(userName) && x.getPassword().equals(password))
					return x;

			for (Manager x : managerList)
				if (x.getUserName().equals(userName) && x.getPassword().equals(password))
					return x;
		}

		return null;
	}

	public User getUser(String userName) {
		for (Passenger x : passengersList)
			if (x.getUserName().equals(userName))
				return x;

		for (Driver x : driverList)
			if (x.getUserName().equals(userName))
				return x;

		for (Manager x : managerList)
			if (x.getUserName().equals(userName))
				return x;
		return null;
	}

	/*
	 * 
	 * Adders
	 */

	public Vehicle addLimosine() {

		vehicleList.add(new Limosine());
		return vehicleList.getLast();
	}

	public Vehicle addMiniBus() {

		vehicleList.add(new MiniBus());
		return vehicleList.getLast();
	}

	public Vehicle addBus() {

		vehicleList.add(new Bus());
		return vehicleList.getLast();
	}

	public Passenger addPassenger(String firstName, String lastName, String userName, String password, double balance) {

		passengersList.add(new Passenger(firstName, lastName, userName, password, balance));

		return passengersList.getLast();
	}

	public Driver addDriver(String firstName, String lastName, String userName, String password, double salary) {

		driverList.add(new Driver(firstName, lastName, userName, password, salary));

		return (driverList.getLast());
	}

	public Manager addManager(String firstName, String lastName, String userName, String password, double salary) {

		managerList.add(new Manager(firstName, lastName, userName, password, salary));

		return managerList.getLast();
	}

	public Trip addTrip(Vehicle vehicle, String source, String destination, double distance, String type,
			int numberOfStops, Date date, Time time, double price, double duration) {

		tripList.add(
				new Trip(vehicle, source, destination, distance, type, numberOfStops, date, time, price, duration));

		return tripList.getLast();
	}

	/*
	 * Functions
	 */

	/*
	 * Function that checks if there exists a user with user name and password given
	 */

	public int changeUserAttributes(User user, String firstName, String lastName, String userName, String password) {

		if (user.getUserName().equals(userName)||getUser(userName)==null) {
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setUserName(userName);
			user.setPassword(password);
			return 1;
		}
		else {
			return -1;
		}

	}

	public int RegisterNew(String firstName, String lastName, String userName, String password, double balance) {
		if (getUser(userName) == null) {

			addPassenger(firstName, lastName, userName, password, balance);
			return 1;

		}

		else
			return -1;

	}

	// writing functions

	public <T> void writeList(LinkedList<T> list, String fileName) throws IOException {
		setBufferedWriter(fileName);
		for (T x : list) {
			bufferedWriter.write(x.toString());
			bufferedWriter.newLine();
		}
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	private void setBufferedWriter(String fileName) {
		file = new File(fileName);
		try {
			filewriter = new FileWriter(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufferedWriter = new BufferedWriter(filewriter);
	}

	public void loadVehicles() throws IOException {
		setBufferedReader("Vehicles.txt");
		while (bufferedReader.ready()) {

			loadVehicle(bufferedReader.readLine());
		}
	}

	public void loadVehicle(String line) {
		String[] tokens = line.split("&");
		
		Vehicle v = null;
		if (tokens[1].equals("Limosine")) {
			v = addLimosine();
		}

		else if (tokens[1].equals("MiniBus")) {
			v = addMiniBus();
		}

		else if (tokens[1].equals("Bus")) {
			v = addBus();
		}
		v.setNumber(Integer.parseInt(tokens[0]));
		
		v.setMaxNumberOfSeats(Integer.parseInt(tokens[2]));
		v.setCurrentNumberOfSeats(Integer.parseInt(tokens[3]));
		v.setAssigned(Boolean.parseBoolean(tokens[4]));
		
		Vehicle.setFirstFreeNumber(Math.max(Vehicle.getFirstFreeNumber(), Integer.parseInt(tokens[0])));
	}

	public void loadTrips() throws IOException {
		setBufferedReader("Trips.txt");
		while (bufferedReader.ready()) {
			loadTrip(bufferedReader.readLine());
		}
	}

	public void loadTrip(String line) {
		String[] tokens = line.split("&");
		Trip trip = null;
		int vehicleNumber = Integer.parseInt(tokens[1]);
		Vehicle v = null;

		for (Vehicle x : vehicleList) {
			if (x.getNumber() == vehicleNumber) {
				v = x;
			}
		}

		trip = addTrip(v, tokens[2], tokens[3], Double.parseDouble(tokens[4]), tokens[5], Integer.parseInt(tokens[6]),
				stringToDate(tokens[7]), stringToTime(tokens[8]), Double.parseDouble(tokens[9]),
				Double.parseDouble(tokens[10]));

		trip.setNumber(Integer.parseInt(tokens[0]));
		Trip.setFirstFreeNumber(Math.max(Trip.getFirstFreeNumber(), Integer.parseInt(tokens[0])));

	}

	public void loadDrivers() throws IOException {
		setBufferedReader("Drivers.txt");
		while (bufferedReader.ready()) {

			loadDriver(bufferedReader.readLine());
		}
	}

	public void loadDriver(String line) {

		String[] tokens = line.split("&");
		int messageSize = Integer.parseInt(tokens[4]);
		Driver d = addDriver(tokens[0], tokens[1], tokens[2], tokens[3], Double.parseDouble(tokens[5 + messageSize]));

		int i = 5;

		for (; i < 5 + messageSize; i++) {
			d.getMessageList().add(stringToMessage(tokens[i]));
		}
		i++; // salary
		int tripsSize = Integer.parseInt(tokens[i]);
		i++; // tripsSize
		int offset = i;
		for (; i < offset + tripsSize; i++) {
			int tripNumber = Integer.parseInt(tokens[i]);
			for (Trip x : tripList) {
				if (x.getNumber() == tripNumber) {
					d.addTrip(x);
					break;
				}
			}
		}

	}

	public void loadPassengers() throws IOException {
		setBufferedReader("Passengers.txt");
		while (bufferedReader.ready()) {

			loadPassenger(bufferedReader.readLine());
		}
	}

	public void loadPassenger(String line) {
		String[] tokens = line.split("&");
		int messageSize = Integer.parseInt(tokens[4]);

		Passenger p = addPassenger(tokens[0], tokens[1], tokens[2], tokens[3],
				Double.parseDouble(tokens[5 + messageSize]));

		int i = 5;

		for (; i < 5 + messageSize; i++) {
			p.getMessageList().add(stringToMessage(tokens[i]));
		}
		i++; // salary
		int ticketsSize = Integer.parseInt(tokens[i]);
		i++; // ticketSize

		int offset = i;

		for (; i < offset + ticketsSize; i++) {
			StringTokenizer st = new StringTokenizer(tokens[i], "$");

			String type = st.nextToken();
			double price = Double.parseDouble(st.nextToken());
			int tripNumber = Integer.parseInt(st.nextToken());
			Trip trip = null;

			for (Trip x : tripList) {
				if (x.getNumber() == tripNumber) {
					trip = x;
					break;
				}
			}

			p.getTicketList().add(new Ticket(type, price, trip));
		}

	}

	public void loadManagers() throws IOException {
		setBufferedReader("Managers.txt");
		while (bufferedReader.ready()) {
			loadManager(bufferedReader.readLine());
		}
	}

	public void loadManager(String line) {
		String[] tokens = line.split("&");
		int messageSize = Integer.parseInt(tokens[4]);

		Manager m = addManager(tokens[0], tokens[1], tokens[2], tokens[3], Double.parseDouble(tokens[5 + messageSize]));

		int i = 5;

		for (; i < 5 + messageSize; i++) {
			m.getMessageList().add(stringToMessage(tokens[i]));
		}
	}

	void setBufferedReader(String fileName) throws FileNotFoundException {
		file = new File(fileName);
		filereader = new FileReader(file);
		bufferedReader = new BufferedReader(filereader);
	}

	public Date stringToDate(String s) {
		StringTokenizer st = new StringTokenizer(s, "/");
		Date date = new Date(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		return date;
	}

	public Time stringToTime(String s) {
		StringTokenizer st = new StringTokenizer(s, ":,");
		Time time = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st.nextToken());
		return time;
	}

	public Message stringToMessage(String s) {
		StringTokenizer st = new StringTokenizer(s, "$");
		Message message = new Message(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
		message.setOpened(Boolean.parseBoolean(st.nextToken()));
		return message;
	}

	public void load() throws IOException {
		loadVehicles();
		loadTrips();
		loadDrivers();
		loadPassengers();
		loadManagers();
	}

	public void write() throws IOException {
		writeList(tripList, "Trips.txt");
		writeUsers();
		writeList(vehicleList, "Vehicles.txt");
	}
	
	public void writeUsers () throws IOException{
		writeList(passengersList, "Passengers.txt");
		writeList(driverList, "Drivers.txt");
		writeList(managerList, "Managers.txt");
	}
}
