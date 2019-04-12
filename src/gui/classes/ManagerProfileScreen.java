package gui.classes;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import actors.classes.Driver;
import actors.classes.Manager;
import actors.classes.User;
import database.classes.Database;
import gui.behaviors.EmployeeInfo;
import helping.classes.Trip;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ManagerProfileScreen extends ProfileScreen {
	/*
	 * Attributes
	 */

	Hyperlink addTripLink;
	Hyperlink removeTripLink;
	Hyperlink assignDriversLink;
	Hyperlink viewTrips;
	Hyperlink removeDriverFromTripLink;
	Hyperlink viewVehicles;
	Manager manager;
	/*
	 * Constructor
	 */

	ManagerProfileScreen(double width, double height, Stage stage, Database database, User user) {
		super(width, height, stage, database, user);

		addTripLink = new Hyperlink("Add new trip");
		removeTripLink = new Hyperlink("Remove trip");
		assignDriversLink = new Hyperlink("Assign driver to trip");
		viewTrips = new Hyperlink("View all trips");
		removeDriverFromTripLink = new Hyperlink("Remove driver from trip");
		drawableInformation = new EmployeeInfo(user);
		comboBoxFromList(database.getPassengersList(), comboBox, "Passenger");
		comboBoxFromList(database.getDriverList(), comboBox, "Driver");
		viewVehicles = new Hyperlink("View vehicles");
		manager = (Manager) user;
	}

	/*
	 * Behavior
	 */

	public void setActions() {

		removeTripLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				removeTripLink.setVisited(false);

				if (!database.getTripList().isEmpty()) {
					Iterator<Trip> tripsIterator = database.getTripList().iterator();
					showList(database.getTripList(), 300, 200, "Hyperlink", "Red");

					for (Node x : gridpane.getChildren()) {

						Hyperlink hyperlink = (Hyperlink) x;

						hyperlink.setOnAction(new EventHandler<ActionEvent>() {

							Trip trip = tripsIterator.next();

							@Override
							public void handle(ActionEvent event) {
								manager.removeTrip(trip);
								addConfirmationText("Trip has been removed successfully.");
							}

						});

					}

				}

				else
					addConfirmationText("No trips to show.");

			}
		});

		// done
		viewTrips.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				viewTrips.setVisited(false);

				cleanScrollableGridPane(0);

				if (!database.getTripList().isEmpty())
					showList(database.getTripList(), 300, 200, "Label", "Black");

				else
					addConfirmationText("No trips to show.");

			}
		}

		);

		// needs testing
		addTripLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				addTripLink.setVisited(false);

				cleanGridPane(10);

				Label vehicleLabel = new Label("Vehicle: ");
				Label sourceLabel = new Label("Source: ");
				Label destinationLabel = new Label("Destionation: ");
				Label distanceLabel = new Label("Distance: ");
				Label typeLabel = new Label("Type: ");
				Label numberOfStopsLabel = new Label("Number of stops: ");
				Label dateLabel = new Label("Date: ");
				Label timeLabel = new Label("Time: ");
				Label priceLabel = new Label("Trip price: ");
				Label durationLabel = new Label("Duration: ");

				Label kmLabel = new Label("KM");
				Label egpLabel = new Label("EGP");
				Label hrLabel = new Label("Hour");

				ComboBox<String> vehicleComboBox = new ComboBox<String>();
				vehicleComboBox.getItems().addAll("Limosine", "Bus", "MiniBus");
				vehicleComboBox.getSelectionModel().select(0);

				TextField sourceField = new TextField();
				TextField destinationField = new TextField();
				TextField distanceField = new TextField();

				ComboBox<String> typeComboBox = new ComboBox<String>();
				typeComboBox.getItems().addAll("Internal", "External");
				typeComboBox.getSelectionModel().select(0);

				TextField numberOfStopsField = new TextField();
				TextField priceField = new TextField();
				TextField durationField = new TextField();

				TextField[] dateFields = { new TextField(), new TextField(), new TextField() };
				TextField[] timeFields = { new TextField(), new TextField() };

				ComboBox<String> amOrPmComboBox = new ComboBox<String>();

				amOrPmComboBox.getItems().addAll("am", "pm");
				amOrPmComboBox.getSelectionModel().select(0);

				HBox dateHBox = new HBox();
				dateHBox.getChildren().addAll(dateFields[0], new Text("/"), dateFields[1], new Text("/"),
						dateFields[2]);
				for (int i = 0; i < 2; i++)
					dateFields[i].setPrefSize(30, 20);
				dateFields[2].setPrefSize(70, 20);
				HBox timeHBox = new HBox();

				timeHBox.getChildren().addAll(timeFields[0], new Text(":"), timeFields[1], amOrPmComboBox);
				for (int i = 0; i < 2; i++)
					timeFields[i].setPrefSize(30, 20);

				Button saveButton = new Button("Save");
				Button discardChangesButton = new Button("Discard changes");

				gridpane.add(vehicleLabel, 0, 0);
				gridpane.add(sourceLabel, 0, 1);
				gridpane.add(destinationLabel, 0, 2);
				gridpane.add(distanceLabel, 0, 3);
				gridpane.add(kmLabel, 2, 3);
				gridpane.add(typeLabel, 0, 4);
				gridpane.add(numberOfStopsLabel, 0, 5);
				gridpane.add(dateLabel, 0, 6);
				gridpane.add(timeLabel, 0, 7);
				gridpane.add(durationLabel, 0, 9);
				gridpane.add(hrLabel, 2, 9);
				gridpane.add(priceLabel, 0, 8);
				gridpane.add(egpLabel, 2, 8);
				gridpane.add(saveButton, 0, 10);

				gridpane.add(vehicleComboBox, 1, 0);
				gridpane.add(sourceField, 1, 1);
				gridpane.add(destinationField, 1, 2);
				gridpane.add(distanceField, 1, 3);
				gridpane.add(typeComboBox, 1, 4);
				gridpane.add(numberOfStopsField, 1, 5);
				gridpane.add(dateHBox, 1, 6);
				gridpane.add(timeHBox, 1, 7);
				gridpane.add(priceField, 1, 8);
				gridpane.add(durationField, 1, 9);
				gridpane.add(discardChangesButton, 1, 10);

				saveButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						Trip t = null;
						boolean isError = false;
						try {
							t = manager.addTrip(vehicleComboBox.getValue(), sourceField.getText(),
									destinationField.getText(),

									Double.parseDouble(distanceField.getText()), typeComboBox.getValue(),
									Integer.parseInt(numberOfStopsField.getText()),
									database.stringToDate(dateFields[0].getText() + "/" + dateFields[1].getText() + "/"
											+ dateFields[2].getText()),
									database.stringToTime(timeFields[0].getText() + ":" + timeFields[1].getText() + ","
											+ amOrPmComboBox.getValue()),
									Double.parseDouble(priceField.getText()),
									Double.parseDouble(durationField.getText()));
						} catch (Exception e) {
							addConfirmationText("Error in entered data.");
							isError = true;
						}
						if (t == null && !isError) {
							addConfirmationText("No free vehicle available.");
						} else if (t != null && !isError) {
							addConfirmationText("Trip added successfully.");
							try {
								database.writeList(database.getTripList(), "Trips.txt");
							} catch (IOException e) {
								e.printStackTrace();
							}
						}

					}

				});

				discardChangesButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						addConfirmationText("changes has been discarded.");
					}

				});

			}
		});

		// done but needs testing

		removeDriverFromTripLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				removeDriverFromTripLink.setVisited(false);

				if (!database.getDriverList().isEmpty()) {
					Iterator<Driver> driverIterator = database.getDriverList().iterator();
					showList(database.getDriverList(), 300, 45, "Hyperlink", "Red");

					for (Node x : gridpane.getChildren()) {

						Hyperlink hyperlink = (Hyperlink) x;

						hyperlink.setOnAction(new EventHandler<ActionEvent>() {

							Driver driver = driverIterator.next();

							@Override
							public void handle(ActionEvent event) {

								if (!driver.getTripsList().isEmpty()) {
									showList(driver.getTripsList(), 300, 200, "Hyperlink", "Red");
									Iterator<Trip> tripsIterator = driver.getTripsList().iterator();

									for (Node y : gridpane.getChildren()) {
										Hyperlink hyperlinky = (Hyperlink) y;
										hyperlinky.setOnAction(new EventHandler<ActionEvent>() {

											Trip trip = tripsIterator.next();

											@Override
											public void handle(ActionEvent event) {
												manager.removeDriverFromTrip(driver, trip);
												addConfirmationText("Trip removed successfully.");
											}
										});

									}
								} else {
									addConfirmationText("Driver doesn't have any assigned trips.");
								}

							}

						});

					}

				}

				else {
					addConfirmationText("No drivers Available.");
				}
			}

		});

		// done but needs testing
		assignDriversLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				assignDriversLink.setVisited(false);

				if (!database.getDriverList().isEmpty()) {

					Iterator<Driver> driverIterator = database.getDriverList().iterator();

					showList(database.getDriverList(), 300, 45, "Hyperlink", "Blue");

					for (Node x : gridpane.getChildren()) {

						Hyperlink hyperlink = (Hyperlink) x;

						hyperlink.setOnAction(new EventHandler<ActionEvent>() {

							Driver driver = driverIterator.next();

							@Override
							public void handle(ActionEvent event) {

								LinkedList<Trip> canTakeTrips = driver.tripsCanTake(database.getTripList());

								if (!canTakeTrips.isEmpty()) {

									Iterator<Trip> tripsIterator = canTakeTrips.iterator();
									showList(canTakeTrips, 300, 225, "Hyperlink", "Blue");

									for (Node y : gridpane.getChildren()) {
										Hyperlink hyperlinky = (Hyperlink) y;
										hyperlinky.setOnAction(new EventHandler<ActionEvent>() {

											Trip trip = tripsIterator.next();

											@Override
											public void handle(ActionEvent event) {
												Driver assignedDriver = manager.assignTrip(trip, driver);
												if (assignedDriver == null)
													addConfirmationText("Trip assigned successfully.");
												else
													addConfirmationText("Trip is already assigned to another driver "
															+ assignedDriver.getUserName()
															+ " please remove him from the trip first.");

											}
										});
									}
								} else {
									addConfirmationText("No trips can be taken by this driver he is so busy.");
								}

							}

						});

					}

				}

				else {
					addConfirmationText("No drivers Available.");
				}
			}

		});

		viewVehicles.setOnAction(new EventHandler<ActionEvent>() {

			@Override

			public void handle(ActionEvent event) {
				viewVehicles.setVisited(false);
				if (!database.getVehicleList().isEmpty()) {
					showList(database.getVehicleList(), 300, 30, "Label", "Black");
				} else {
					addConfirmationText("No vehicles available.");
				}
			}

		});

	}

	public void draw() {
		super.drawAboveChild();

		vBox.getChildren().add(addTripLink);
		vBox.getChildren().add(removeTripLink);
		vBox.getChildren().add(assignDriversLink);
		vBox.getChildren().add(removeDriverFromTripLink);
		vBox.getChildren().add(viewTrips);
		vBox.getChildren().add(viewVehicles);
		setActions();

		super.drawBelowChild();
	}

}
