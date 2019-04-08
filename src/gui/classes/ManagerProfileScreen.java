package gui.classes;

import java.util.ArrayList;

import classes.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import users.classes.Passenger;
import users.classes.User;

public class ManagerProfileScreen extends ProfileScreen {
	/*
	 * Attributes
	 */

	Hyperlink addTripLink;
	Hyperlink removeTripLink;
	Hyperlink assignDriversLink;

	/*
	 * Constructor
	 */

	ManagerProfileScreen(double width, double height, Stage stage, Database database, User user) {
		super(width, height, stage, database, user);
		addTripLink = new Hyperlink("Add new trip");
		removeTripLink = new Hyperlink("Remove trip");
		assignDriversLink = new Hyperlink("Assign driver to trip");

		for (Passenger x : database.getPassengersList()) {
			userComboBox.getItems().add("Passenger" + ": " + x.getFirstName() + " " + x.getLastName());
		}
	}

	/*
	 * Behavior
	 */

	public void setActions() {
		addTripLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				addTripLink.setVisited(false);
				gridpane = new GridPane();
				gridpane.setAlignment(Pos.CENTER);
				gridpane.setVgap(10);

				Label vehicleLabel = new Label("Vehicle: ");
				Label sourceLabel = new Label("Source: ");
				Label destinationLabel = new Label("Destionation: ");
				Label distanceLabel = new Label("Distance: ");
				Label typeLabel = new Label("Type: ");
				Label numberOfStopsLabel = new Label("Number of stops: ");
				Label dateLabel = new Label("Date: ");
				Label timeLabel = new Label("Time: ");

				TextField vehicleField = new TextField();
				TextField sourceField = new TextField();
				TextField destinationField = new TextField();
				TextField distanceField = new TextField();
				TextField typeField = new TextField();
				TextField numberOfStopsField = new TextField();

				TextField[] dateFields = { new TextField(), new TextField(), new TextField() };
				TextField[] timeFields = { new TextField(), new TextField() };
				ComboBox<String> amOrPmComboBox = new ComboBox<String>();
				amOrPmComboBox.getItems().addAll("am", "pm");
				amOrPmComboBox.getSelectionModel().select(0);

				HBox dateHBox = new HBox();
				dateHBox.getChildren().addAll(dateFields[0],new Text("/"), dateFields[1],new Text("/"), dateFields[2]);
				for (int i = 0 ; i <2 ; i++) dateFields[i].setPrefSize(30, 20);
				dateFields[2].setPrefSize(70, 20);
				HBox timeHBox = new HBox();
			
				timeHBox.getChildren().addAll(timeFields[0],new Text(":"), timeFields[1], amOrPmComboBox);
				for (int i = 0 ; i <2 ; i++) timeFields[i].setPrefSize(30, 20);
				
				Button saveButton = new Button("Save");
				Button discardChangesButton = new Button("Discard changes");

				gridpane.add(vehicleLabel, 0, 0);
				gridpane.add(sourceLabel, 0, 1);
				gridpane.add(destinationLabel, 0, 2);
				gridpane.add(distanceLabel, 0, 3);
				gridpane.add(typeLabel, 0, 4);
				gridpane.add(numberOfStopsLabel, 0, 5);
				gridpane.add(dateLabel, 0, 6);
				gridpane.add(timeLabel, 0, 7);
				gridpane.add(saveButton, 0, 8);

				gridpane.add(vehicleField, 1, 0);
				gridpane.add(sourceField, 1, 1);
				gridpane.add(destinationField, 1, 2);
				gridpane.add(distanceField, 1, 3);
				gridpane.add(typeField, 1, 4);
				gridpane.add(numberOfStopsField, 1, 5);
				gridpane.add(dateHBox, 1, 6);
				gridpane.add(timeHBox, 1, 7);
				gridpane.add(discardChangesButton, 1, 8);

				borderpane.setCenter(gridpane);
			}
		});
		
		
	}

	public void draw() {
		super.drawAboveChild();

		vBox.getChildren().add(addTripLink);
		vBox.getChildren().add(removeTripLink);
		vBox.getChildren().add(assignDriversLink);
		setActions();
		
		super.drawBelowChild();
	}

}
