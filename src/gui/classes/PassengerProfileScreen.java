package gui.classes;

import java.util.Iterator;
import java.util.LinkedList;

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

		
		
		
		
		
		// done but needs testing

		bookTripLink.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				bookTripLink.setVisited(false);
				cleanScrollableGridPane(0);
				
				LinkedList<Trip> unbookedTrips = passenger.getUnbookedTrips(database.getTripList());
				
				if (!unbookedTrips.isEmpty()) {
					
					showList(unbookedTrips, 300, 200, "Hyperlink", "Blue");

					Iterator<Trip> tripIterator = unbookedTrips.iterator();

					for (Node x : gridpane.getChildren()) {

						Hyperlink hyperlink = (Hyperlink) x;

						hyperlink.setOnAction(new EventHandler<ActionEvent>() {

							Trip trip = tripIterator.next();

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

										int result = -5;

										if (choice.equals("One way")) {
											result = passenger.addOneWayTicket(trip);
										}

										else {
											result = passenger.addRoundTicket(trip);
										}

										if (result == 1) {
											addConfirmationText("Trip ticket has been booked successfully.");
										} else if (result == 0) {
											addConfirmationText("You don't have enough balance.");
										}

									}

								});
							}
						});
					}

				}

				else {
					addConfirmationText("No available trips.");
				}

			}

		});

		
		
		
		
		
		// done but needs testing
		cancelTripLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				cancelTripLink.setVisited(false);
				cleanScrollableGridPane(0);

				if (!passenger.getTicketList().isEmpty()) {

					Iterator<Ticket> tickIterator = passenger.getTicketList().iterator();

					showList(passenger.getTicketList(), 300, 200, "Hyperlink", "Green");

					for (Node x : gridpane.getChildren()) {

						Hyperlink hyperlink = (Hyperlink) x;

						hyperlink.setOnAction(new EventHandler<ActionEvent>() {

							Ticket ticket = tickIterator.next();

							@Override
							public void handle(ActionEvent event) {
								passenger.removeTicket(ticket);
								addConfirmationText("trip has been removed successfully.");
							}

						});

					}
				}

				else {
					addConfirmationText("No trips to show.");
				}

			}
		});

		
		
		
		// done
		viewTripsLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				viewTripsLink.setVisited(false);
				if (!passenger.getTicketList().isEmpty()) {
					showList(passenger.getTicketList(), 300, 250, "Label", "Black");
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
