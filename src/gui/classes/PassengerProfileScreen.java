package gui.classes;

import classes.Database;
import classes.Ticket;
import classes.Trip;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
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

			@Override
			public void handle(ActionEvent event) {
				bookTripLink.setVisited(false);
				gridpane = new GridPane();
				gridpane.setAlignment(Pos.CENTER);

				ScrollPane scrollPane = new ScrollPane();
				scrollPane.setContent(gridpane);
				borderpane.setCenter(scrollPane);

				int i = 1;

				for (Trip x : database.getTripList()) {
					Hyperlink tripLink = new Hyperlink();

					tripLink.setPrefSize(400, 150);
					tripLink.setBorder(Border.EMPTY);
					tripLink.setTextFill(Paint.valueOf("blue"));
					tripLink.setFont(Font.font(12));

					gridpane.add(tripLink, 0, i);

					tripLink.setText(i + x.data());

					tripLink.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							gridpane = new GridPane();

							Label ticketTypeLabel = new Label("Ticket type:   ");

							ComboBox<String> ticketComboBox = new ComboBox<String>();
							ticketComboBox.getItems().addAll("One way", "Round");
							ticketComboBox.getSelectionModel().select(0);

							Button okButton = new Button("Ok");

							gridpane.add(ticketTypeLabel, 0, 0);
							gridpane.add(ticketComboBox, 1, 0);
							gridpane.add(okButton, 2, 0);

							gridpane.setAlignment(Pos.CENTER);
							borderpane.setCenter(gridpane);

							okButton.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									
									String choice = ticketComboBox.getValue();

									if (choice.equals("One way")) {
										passenger.addOneWayTicket(x);
									}

									else {
										passenger.addRoundTicket(x);	
									}

								}

							});
						}
					});

					i++;
				}

			}

		});

		cancelTripLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				cancelTripLink.setVisited(false);

				gridpane = new GridPane();
				gridpane.setAlignment(Pos.CENTER);

				ScrollPane scrollPane = new ScrollPane();
				scrollPane.setContent(gridpane);
				borderpane.setCenter(scrollPane);

				int i = 1;
				for (Ticket x : passenger.getTicketList()) {
					Hyperlink ticketLink = new Hyperlink();

					ticketLink.setPrefSize(400, 200);
					ticketLink.setBorder(Border.EMPTY);
					ticketLink.setTextFill(Paint.valueOf("blue"));
					ticketLink.setFont(Font.font(12));

					gridpane.add(ticketLink, 0, i);

					ticketLink.setText(i + x.data());

					ticketLink.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							passenger.removeTicket(x);
							showTrips(passenger);
						}

					});

					i++;
				}

			}
		});

		viewTripsLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				viewTripsLink.setVisited(false);
				showTrips(passenger);
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

	private void showTrips(Passenger passenger) {
		gridpane = new GridPane();
		gridpane.setAlignment(Pos.CENTER);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(gridpane);
		borderpane.setCenter(scrollPane);

		int i = 1;

		for (Ticket x : passenger.getTicketList()) {
			Label ticketLink = new Label();

			ticketLink.setPrefSize(400, 200);
			ticketLink.setBorder(Border.EMPTY);
			ticketLink.setFont(Font.font(12));

			gridpane.add(ticketLink, 0, i);

			ticketLink.setText(i + x.data());

			i++;
		}
	}

}
