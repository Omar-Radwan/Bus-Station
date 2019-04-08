package gui.classes;

import classes.Database;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import users.classes.User;

public class PassengerProfileScreen extends ProfileScreen {

	/*
	 * Attributes
	 */

	Hyperlink bookTripLink;
	Hyperlink cancelTripLink;
	Hyperlink viewTripsLink;

	/*
	 * Constructor
	 */

	PassengerProfileScreen(double width, double height, Stage stage, Database database, User user) {
		super(width, height, stage, database, user);
		bookTripLink = new Hyperlink("Book a trip");
		cancelTripLink = new Hyperlink("Cancel a trip");
		viewTripsLink = new Hyperlink("View trips");
		sendMessageLink.setText("Send message to an employee");
	}

	/*
	 * Behavior
	 */

	private void setProperties() {

	}

	@Override
	public void draw() {
		drawAboveChild();
		setProperties();
		vBox.getChildren().addAll(bookTripLink, cancelTripLink, viewTripsLink);

		drawBelowChild();

	}

}
