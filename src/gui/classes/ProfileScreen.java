package gui.classes;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import users.classes.User;

public class ProfileScreen extends Screen {

	/*
	 * Attributes
	 */

	Label welcomeLabel;

	Button messagesButton;
	Button sendMessageButton;
	Button infoButton;
	Button editProfileButton;
	Button logoutButton;

	User user;

	/*
	 * Constructor
	 */

	ProfileScreen(double width, double height, Stage stage) {
		super(width, height, stage);

		welcomeLabel = new Label("Welcome" + user.getFirstName() + " " + user.getLastName());
		sendMessageButton = new Button("Send new message");
		messagesButton = new Button("View messages");
		infoButton = new Button("View your info");
		editProfileButton = new Button("Edit your info");
		logoutButton = new Button("Logout");
	}

	
	/*
	 * Behavior
	 */

	protected void drawAboveChild() {

	}

	protected void drawBelowChild() {

	}

	@Override
	public void draw() {

	}

	private void setActions() {

	}

}
