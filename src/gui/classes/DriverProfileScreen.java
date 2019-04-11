package gui.classes;

import classes.Database;
import classes.Message;
import classes.Trip;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import users.classes.Driver;
import users.classes.User;

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
		sendMessageLink.setText("Send message to an employee");

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

					int i = 1;

					for (Trip x : driver.getTripsList()) {
						Label tripLabel = new Label();
						tripLabel.setPrefSize(400, 150);
						tripLabel.setBorder(Border.EMPTY);
						tripLabel.setTextFill(Paint.valueOf("black"));
						tripLabel.setFont(Font.font(12));
						gridpane.add(tripLabel, 0, i);
						
					
						tripLabel.setText(i+x.data());

						i++;
					}

				}

				else {
					
					addConfirmationText("You don't have any trips.");
					

				}

			}
		});

		cancelTripLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				cleanScrollableGridPane(0);
				
				int i = 1; 

				for (Trip x : driver.getTripsList()) {
					Hyperlink tripLink = new Hyperlink();
					
					tripLink.setPrefSize(400, 150);
					tripLink.setBorder(Border.EMPTY);
					tripLink.setTextFill(Paint.valueOf("blue"));
					tripLink.setFont(Font.font(12));
					
					gridpane.add(tripLink, 0, i);
			
					tripLink.setText(i+x.data());
				
					tripLink.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent event) {
							// send a message to the concerned manager
							
							String driverName = driver.getUserName();
							String managerName = database.getManagerList().get(0).getUserName();
							String subject = "Trip cancelation";
							String content = "unfortunately i won't be able to take trip number"+x.getNumber();
							
							database.getManagerList().get(0).addMessage(driverName, managerName, subject, content);
							
							addConfirmationText("A message has been sent to the concerned manager");

						}
					});

					i++;
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
