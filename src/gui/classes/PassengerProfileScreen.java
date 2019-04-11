package gui.classes;

import classes.Database;
import classes.Ticket;
import classes.Trip;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import users.classes.Passenger;
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

	public void setActions() {

		Passenger passenger = (Passenger) user;

		bookTripLink.setOnAction(new EventHandler<ActionEvent>() {
			int i = 0;

			@Override
			public void handle(ActionEvent event) {
				bookTripLink.setVisited(false);
				cleanScrollableGridPane(0);

				if (!database.getTripList().isEmpty()) {
					showList(database.getTripList(), 300, 150, "Hyperlink", "Blue");

					for (Node x : gridpane.getChildren()) {

						Hyperlink hyperlink = (Hyperlink) x;

						hyperlink.setOnAction(new EventHandler<ActionEvent>() {

							Trip trip = database.getTripList().get(i);

							@Override
							public void handle(ActionEvent event) {
								cleanGridPane(0);

								Label ticketTypeLabel = new Label("Ticket type:   ");

								ComboBox<String> ticketComboBox = new ComboBox<String>();
								ticketComboBox.getItems().addAll("One way", "Round");
								ticketComboBox.getSelectionModel().select(0);

								Button okButton = new Button("Ok");

								gridpane.add(ticketTypeLabel, 0, 0);
								gridpane.add(ticketComboBox, 1, 0);
								gridpane.add(okButton, 2, 0);

								okButton.setOnAction(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {

										String choice = ticketComboBox.getValue();

										if (choice.equals("One way")) {
											passenger.addOneWayTicket(trip);
										}

										else {
											passenger.addRoundTicket(trip);
										}

									}

								});
							}
						});

						i++;
					}

				}

				else {
					addConfirmationText("No trips to show.");
				}

			}

		});

		cancelTripLink.setOnAction(new EventHandler<ActionEvent>() {

			int i = 0;

			@Override
			public void handle(ActionEvent event) {

				cancelTripLink.setVisited(false);
				cleanScrollableGridPane(0);

				if (!passenger.getTicketList().isEmpty()) {

					showList(passenger.getTicketList(), 300, 200, "Hyperlink", "Green");

					for (Node x : gridpane.getChildren()) {

						Hyperlink hyperlink = (Hyperlink) x;

						hyperlink.setOnAction(new EventHandler<ActionEvent>() {

							Ticket ticket = passenger.getTicketList().get(i);

							@Override
							public void handle(ActionEvent event) {
								passenger.removeTicket(ticket);
								addConfirmationText("trip has been removed successfully.");
							}

						});

						i++;
					}

				}

				else {
					addConfirmationText("No trips to show.");
				}

			}
		});

		viewTripsLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				viewTripsLink.setVisited(false);
				if (!passenger.getTicketList().isEmpty()) {
					showList(passenger.getTicketList(), 300, 200, "Label", "Black");
				} else {
					addConfirmationText("No trips to show.");
				}
			}
		});

	}

	@Override
	public void draw() {
		drawAboveChild();
		setActions();
		vBox.getChildren().addAll(bookTripLink, cancelTripLink, viewTripsLink);

		drawBelowChild();

	}

}
