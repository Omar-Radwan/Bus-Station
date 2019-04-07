
import java.util.LinkedList;

import classes.Database;
import classes.Date;
import classes.Time;
import classes.Trip;
import gui.classes.HomeScreen;
import gui.classes.LoginScreen;
import gui.classes.Screen;
import javafx.application.Application;
import javafx.stage.Stage;
import users.classes.Driver;
import users.classes.Employee;

public class Main extends Application {

	static final double defaultWidth = 580;
	static final double defaultHeight = 450;

	public static void main(String[] args) {

		LinkedList<Trip> trips = new LinkedList<>();

		Employee[] d = new Employee[5];

		Database database = new Database("C:\\Users\\omare\\Desktop\\");

		database.addDriver("mayar", "adel", "mayar", "123", 100);
		database.addDriver("maram", "ghazal", "mrmr", "123", 100);
		database.addDriver("fady", "samy", "fozdo2a", "123", 100);
		database.addDriver("verginia", "ehab", "naugtyvergu", "123", 100);
		database.addDriver("mohamed", "ahmed", "tokyo", "123", 100);

		database.addManager("omar", "hisham", "mrmr", "123", 100);
		database.addManager("nadeen", "elgazar", "nadnod", "123", 100);
		database.addManager("hana", "magdy", "hanhoon", "123", 100);
		database.addManager("omar", "radwan", "rado", "123", 100);
		database.addManager("ahmed", "hamada", "hamada", "123", 100);

		database.addLimosine((Driver) database.getEmployeeList().get(0));
		database.addBus((Driver) database.getEmployeeList().get(1));
		database.addMiniBus((Driver) database.getEmployeeList().get(2));
		database.addMiniBus((Driver) database.getEmployeeList().get(3));
		database.addBus((Driver) database.getEmployeeList().get(4));

		database.addTrip(database.getVehicleList().get(0), "Alexandria", "Cairo", 100, "Internal", 0,
				new Date(12, 8, 2019), new Time(10, 0, "am"));
		database.addTrip(database.getVehicleList().get(0), "Egypt", "Libia", 30000, "External", 0,
				new Date(12, 8, 2019), new Time(10, 0, "am"));
		database.addTrip(database.getVehicleList().get(0), "Menia", "Sohag", 140, "Internal", 2, new Date(12, 8, 2019),
				new Time(10, 0, "am"));
		database.addTrip(database.getVehicleList().get(0), "Egypt", "Saudia", 5300, "External", 0, new Date(12, 8, 2019),
				new Time(10, 0, "am"));
		database.addTrip(database.getVehicleList().get(0), "Alexandria", "Matrouh", 300, "Internal", 1,
				new Date(12, 8, 2019), new Time(10, 0, "am"));

		
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Screen homeScreen = new HomeScreen(defaultWidth, defaultHeight, primaryStage);
		Screen logiScreen = new LoginScreen(defaultWidth, defaultHeight, primaryStage);

		primaryStage.setMinHeight(defaultHeight);
		primaryStage.setMinWidth(defaultWidth);
		primaryStage.setMaxHeight(defaultHeight);
		primaryStage.setMaxWidth(defaultWidth);

		homeScreen.draw();

		primaryStage.show();
	}

}
