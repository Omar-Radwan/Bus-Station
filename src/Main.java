
import java.util.LinkedList;

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
import users.classes.Manager;
import vehicles.classes.Bus;
import vehicles.classes.Limosine;
import vehicles.classes.MiniBus;
import vehicles.classes.Vehicle;

public class Main extends Application {

	static final double defaultWidth = 580;
	static final double defaultHeight = 450;

	public static void main(String[] args) {
		
		LinkedList<Trip> trips = new LinkedList<>();

		Employee d1 = new Driver("mayar", "adel", "mayar", "123", 100);
		Employee d2 = new Driver("mohamed", "ahmed", "tokyo", "123", 100);
		Employee d3 = new Driver("verginia", "ehab", "naugtyvergu", "123", 100);
		Employee d4 = new Driver("fady", "samy", "fozdo2a", "123", 100);
		Employee d5 = new Driver("maram", "ghazal", "mrmr", "123", 100);

		Employee m1 = new Manager ("omar", "hisham", "mrmr", "123", 100);
		Employee m2 = new Manager("nadeen", "elgazar", "nadnod", "123", 100);
		Employee m3 = new Manager("hana", "magdy", "hanhoon", "123", 100);
		Employee m4 = new Manager("omar", "radwan", "rado", "123", 100);
		Employee m5 = new Manager("ahmed", "hamada", "hamada", "123", 100);
		

		
		Vehicle v1 = new Limosine((Driver)d1);
		Vehicle v2 = new Bus((Driver)d2);
		Vehicle v3 = new MiniBus((Driver)d3);
		Vehicle v4 = new MiniBus((Driver)d4);
		Vehicle v5 = new Bus((Driver)d5);
		
		Trip t1 = new Trip(v1,"Alexandria", "Cairo", 100 , "Internal",0, new Date(12,8 ,2019 ), new Time(10,0, "am"));
		Trip t2 = new Trip(v2,"Egypt", "Libia",30000, "External",0, new Date(12,8 ,2019 ), new Time(10,0, "am"));
		Trip t3 = new Trip(v3,"Menia", "Sohag",140 , "Internal", 2, new Date(12,8 ,2019 ), new Time(10,0, "am"));
		Trip t4 = new Trip(v4,"Egypt", "Sodia", 5300, "External",0 , new Date(12,8 ,2019 ), new Time(10,0, "am"));
		Trip t5 = new Trip(v5,"Alexandria", "Matrouh",300, "Internal",1 ,new Date(12,8 ,2019 ), new Time(10,0, "am"));
		
		trips.add(t1);
		trips.add(t2);
		trips.add(t3);
		trips.add(t4);
		trips.add(t5);
		
		
		
		
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
