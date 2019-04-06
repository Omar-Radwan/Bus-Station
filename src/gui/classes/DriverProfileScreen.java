package gui.classes;

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

	DriverProfileScreen(double width, double height, Stage stage) {
		super(width, height, stage);
		cancelTripLink = new Hyperlink("Request trip cancelation");
		viewTripsLink = new Hyperlink("View your trips");
	}

	/*
	 * Behavior
	 */

	@Override
	public void draw() {
		super.drawAboveChild();
		
		vBox.getChildren().add(cancelTripLink);
		vBox.getChildren().add(viewTripsLink);
		
		super.drawBelowChild();

	}

}
