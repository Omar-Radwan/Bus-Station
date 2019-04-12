package gui.classes;

import java.util.Iterator;
import java.util.LinkedList;

import actors.classes.Passenger;
import actors.classes.User;
import database.classes.Database;
import gui.behaviors.PassengerInfo;
import helping.classes.Ticket;
import helping.classes.Trip;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PassengerProfileScreen extends ProfileScreen {

	/*
	 * Attributes
	 */

	Hyperlink bookTripLink;
	Hyperlink cancelTripLink;
	Hyperlink viewTripsLink;
	Hyperlink addBalanceLink; 
	
	/*
	 * Constructor
	 */

	PassengerProfileScreen(double width, double height, Stage stage, Database database, User user) {
		super(width, height, stage, database, user);
		
		drawableInformation = new PassengerInfo(user);
		
		bookTripLink = new Hyperlink("Book a trip");
		cancelTripLink = new Hyperlink("Cancel a trip");
		viewTripsLink = new Hyperlink("View trips");
		addBalanceLink = new Hyperlink("Add balance");
		sendMessageLink.setText("Send feedback to manager");
	}

	/*
	 * Behavior
	 */

	public void setActions() {

		Passenger passenger = (Passenger) user;

		

		addBalanceLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				addBalanceLink.setVisited(false);
				
				cleanGridPane(0);
				
				Label balanceLabel = new Label("Top up amount: ");
				ComboBox<Integer> amountsComboBox = new ComboBox<Integer>();
				amountsComboBox.getItems().addAll(100,200,300,400,500,1000,1500,2000);
				Label egpLabel = new Label("Egp");
				Button okButton = new Button ("Ok");
				
				gridpane.setHgap(10);
				
				gridpane.add(balanceLabel, 0, 0);
				gridpane.add(amountsComboBox,1,0);
				gridpane.add(egpLabel, 2, 0);
				gridpane.add(okButton, 0,1);
				amountsComboBox.getSelectionModel().select(0);
				okButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						passenger.setBalance(passenger.getBalance()+amountsComboBox.getValue());
						addConfirmationText("Balance has been added successfully.");
					}
					
				});
				
			}
		});
		
		
		
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
								
								Label priceLabel = new Label ("Price: ");
								Label priceValueLabel = new Label ();
								Label egpLabel1 = new Label ("Egp") ;
								Label egpLabel2 = new Label ("Egp") ;
								Label balanceLabel = new Label ("Balance: ");
								Label balanceValueLabel = new Label ();
								
								balanceValueLabel.setText(Double.toString(passenger.getBalance()));
								ComboBox<String> ticketComboBox = new ComboBox<String>();
								ticketComboBox.getItems().addAll("One way", "Round");
								ticketComboBox.getSelectionModel().select(0);

								Button okButton = new Button("Ok");

								gridpane.add(ticketTypeLabel, 0, 0);
								gridpane.add(ticketComboBox, 1, 0);
								gridpane.add(okButton, 2, 0);
								gridpane.add(priceLabel, 0, 1);
								gridpane.add(priceValueLabel, 1, 1);
								gridpane.add(egpLabel1, 2, 1);
								gridpane.add(balanceLabel, 0, 2);
								gridpane.add(balanceValueLabel, 1, 2);
								gridpane.add(egpLabel2, 2, 2);
								
								priceValueLabel.setText(Double.toString(Ticket.priceInCaseOfOneWay(trip.getPrice())));
								
								ticketComboBox.setOnAction(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent event) {
										if (ticketComboBox.getValue().equals("One way")) {
											priceValueLabel.setText(Double.toString(Ticket.priceInCaseOfOneWay(trip.getPrice())));
										}
										else {
											priceValueLabel.setText(Double.toString(Ticket.priceInCaseOfRound(trip.getPrice())));

										}
										
									}
								});
								
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
		vBox.getChildren().addAll(bookTripLink, cancelTripLink, viewTripsLink,addBalanceLink);

		drawBelowChild();

	}

}
