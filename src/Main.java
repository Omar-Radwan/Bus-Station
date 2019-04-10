
import java.util.LinkedList;

import classes.Database;
import classes.Date;
import classes.Message;
import classes.Ticket;
import classes.Time;
import classes.Trip;
import gui.classes.HomeScreen;
import gui.classes.LoginScreen;
import gui.classes.Screen;
import javafx.application.Application;
import javafx.stage.Stage;
import users.classes.Driver;
import users.classes.Employee;
import users.classes.Manager;

public class Main extends Application {

	static final double defaultWidth = 580;
	static final double defaultHeight = 450;

	static Database database = new Database("C:\\Users\\omare\\Desktop\\");

	public static void main(String[] args) {

		Manager.setDataBase(database);

		database.addDriver("mayar", "adel", "mayar", "123", 100);
		database.addDriver("maram", "ghazal", "mrmr", "123", 100);
		database.addDriver("fady", "samy", "fozdo2a", "123", 100);
		database.addDriver("verginia", "ehab", "naugtyvergu", "123", 100);
		database.addDriver("mohamed", "ahmed", "tokyo", "123", 100);

		database.addManager("omar", "hisham", "dada", "123", 100);
		database.addManager("nadeen", "elgazar", "nadnod", "123", 100);
		database.addManager("hana", "magdy", "hanhoon", "123", 100);
		database.addManager("omar", "radwan", "rado", "123", 100);
		database.addManager("ahmed", "hamada", "hamada", "123", 100);

		database.addPassenger("p", "1", "p1", "123", 100);
		database.addPassenger("p", "2", "p2", "123", 100);
		database.addPassenger("p", "3", "p3", "123", 100);
		database.addPassenger("p", "4", "p4", "123", 100);
		database.addPassenger("p", "5", "p5", "123", 100);
		database.addPassenger("p", "6", "p6", "123", 100);
		database.addPassenger("p", "7", "p7", "123", 100);
		database.addPassenger("p", "8", "p8", "123", 100);
		database.addPassenger("p", "9", "p9", "123", 100);
		database.addPassenger("p", "10", "p10", "123", 100);

		database.addLimosine((Driver) database.getEmployeeList().get(0));
		database.addBus((Driver) database.getEmployeeList().get(1));
		database.addMiniBus((Driver) database.getEmployeeList().get(2));
		database.addMiniBus((Driver) database.getEmployeeList().get(3));
		database.addBus((Driver) database.getEmployeeList().get(4));

		database.addTrip(database.getVehicleList().get(0), "Alexandria", "Cairo", 100, "Internal", 0,
				new Date(12, 8, 2019), new Time(10, 0, "am"),100);

		database.addTrip(database.getVehicleList().get(0), "Egypt", "Libia", 30000, "External", 0,
				new Date(12, 8, 2019), new Time(10, 0, "am"),100);

		database.addTrip(database.getVehicleList().get(0), "Menia", "Sohag", 140, "Internal", 2, new Date(12, 8, 2019),
				new Time(10, 0, "am"),100);

		database.addTrip(database.getVehicleList().get(0), "Egypt", "Saudia", 5300, "External", 0,
				new Date(12, 8, 2019), new Time(10, 0, "am"),100);

		database.addTrip(database.getVehicleList().get(0), "Alexandria", "Matrouh", 300, "Internal", 1,
				new Date(12, 8, 2019), new Time(10, 0, "am"),100);

		((Driver) (database.getEmployeeList().get(4))).addTrip(database.getTripList().get(0));
		((Driver) (database.getEmployeeList().get(4))).addTrip(database.getTripList().get(1));
		((Driver) (database.getEmployeeList().get(4))).addTrip(database.getTripList().get(2));
		((Driver) (database.getEmployeeList().get(4))).addTrip(database.getTripList().get(3));
		((Driver) (database.getEmployeeList().get(4))).addTrip(database.getTripList().get(4));

		database.getEmployeeList().get(4).addMessage("Omar Radwan", "Tokyo", "enta fen yasta .. yasta rod argook",
				"bla bla bla");
		database.getEmployeeList().get(4).addMessage("Omar Radwan", "Tokyo", "hi", "bla bla bla");
		database.getEmployeeList().get(4).addMessage("Omar Radwan", "Tokyo", "hi", "bla bla bla");
		database.getEmployeeList().get(4).addMessage("Omar Radwan", "Tokyo", "hi", "bla bla bla");
		database.getEmployeeList().get(4).addMessage("Omar Radwan", "Tokyo", "hi", "bla bla bla");
		database.getEmployeeList().get(4).addMessage("Omar Radwan", "Tokyo", "hi", "bla bla bla");
		database.getEmployeeList().get(4).addMessage("Omar Radwan", "Tokyo", "hi", "bla bla bla");
		database.getEmployeeList().get(4).addMessage("Omar Radwan", "Tokyo", "hi", "bla bla bla");
		database.getEmployeeList().get(4).addMessage("Omar Radwan", "Tokyo", "hi", "bla bla bla");
		database.getEmployeeList().get(4).addMessage("Omar Radwan", "Tokyo", "hi", "bla bla bla");
		
		Ticket ticket  = new Ticket("OneWay",10, database.getTripList().get(0));
	
		database.getPassengersList().get(0).addTicket(ticket);
		System.out.println(database.getPassengersList().get(0).getTicketList().get(0).data());
		System.out.println(database.getTripList().get(0));

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Screen homeScreen = new HomeScreen(defaultWidth, defaultHeight, primaryStage, database);
		Screen logiScreen = new LoginScreen(defaultWidth, defaultHeight, primaryStage, database);

		primaryStage.setMinHeight(defaultHeight);
		primaryStage.setMinWidth(defaultWidth);
		primaryStage.setMaxHeight(defaultHeight);
		primaryStage.setMaxWidth(defaultWidth);

		homeScreen.draw();

		primaryStage.show();
	}

}
