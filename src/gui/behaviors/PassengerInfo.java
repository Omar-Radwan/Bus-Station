package gui.behaviors;

import actors.classes.Passenger;
import actors.classes.User;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PassengerInfo implements DrawableInformation {

	Passenger passenger;

	public PassengerInfo(User passenger) {
		super();
		this.passenger = (Passenger) passenger;
	}

	@Override
	public void drawExtraInfo(GridPane gridpane) {
		Label balanceLabel = new Label("Balance:");
		Label balanceValueLabel = new Label(Double.toString(passenger.getBalance()) + " ");
		Label egpLabel = new Label("Egp");

		gridpane.add(balanceLabel, 0, 3);
		gridpane.add(balanceValueLabel, 1, 3);
		gridpane.add(egpLabel, 2, 3);
	}

}
