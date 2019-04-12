package gui.classes;

import java.util.Iterator;

import actors.classes.Driver;
import actors.classes.User;
import database.classes.Database;
import gui.behaviors.EmployeeInfo;
import helping.classes.Trip;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class DriverProfileScreen extends ProfileScreen {

	/*
	 * Attributes
	 */

	Hyperlink cancelTripLink;
	Hyperlink viewTripsLink;

	/*
	 * Constructor
	 */

	DriverProfileScreen(double width, double height, Stage stage, Database database, User user) {
		super(width, height, stage, database, user);
		cancelTripLink = new Hyperlink("Request trip cancelation");
		viewTripsLink = new Hyperlink("View your trips");

		sendMessageLink.setText("Send message to manager.");

		drawableInformation = new EmployeeInfo(user);
	}

	/*
	 * Behavior
	 */

	public void setActions() {
		Driver driver = (Driver) user;

		viewTripsLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				viewTripsLink.setVisited(false);

				if (!driver.getTripsList().isEmpty()) {
					cleanScrollableGridPane(0);
					showList(driver.getTripsList(), 300, 250, "Label", "Black");
				}

				else {

					addConfirmationText("You don't have any trips.");

				}

			}
		});

		cancelTripLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				cancelTripLink.setVisited(false);
				cleanScrollableGridPane(0);
				
				if (!driver.getTripsList().isEmpty()) {
					
					Iterator<Trip> tripIterator = driver.getTripsList().iterator();
					showList(driver.getTripsList(), 300, 250, "Hyperlink", "Blue");

					for (Node x : gridpane.getChildren()) {
					
						Hyperlink tripHyperlink = (Hyperlink) x;
						Trip trip = tripIterator.next();
						
						tripHyperlink.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent event) {
								String driverName = driver.getUserName();
								String managerName = database.getManagerList().get(0).getUserName();
								String subject = "Trip cancelation";
								String content = "unfortunately i won't be able to take trip number" + trip.getNumber();

								database.getManagerList().get(0).addMessage(driverName, managerName, subject, content);

								addConfirmationText("A message has been sent to the concerned manager");
							}

						});
					}

				} else {
					addConfirmationText("You don't have any trips.");
				}

			}
		});

	}

	@Override
	public void draw() {
		super.drawAboveChild();

		vBox.getChildren().add(cancelTripLink);
		vBox.getChildren().add(viewTripsLink);

		setActions();
		super.drawBelowChild();

	}

}
