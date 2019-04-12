package gui.classes;

import actors.classes.Manager;
import actors.classes.Passenger;
import actors.classes.User;
import database.classes.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginScreen extends Screen {

	/*
	 * Attributes
	 */

	Label usernameLabel;
	Label passwordLabel;
	Label messageLabel;

	TextField usernameField;
	PasswordField passwordField;

	Button loginButton;
	Button backButton;

	ComboBox<String> comboBox;

	/*
	 * Constructor
	 */

	public LoginScreen(double width, double height, Stage stage, Database database) {

		super(width, height, stage, database);

		this.usernameLabel = new Label("Username");
		this.passwordLabel = new Label("Password");
		this.messageLabel = new Label("Press login to sign in. ");
		this.usernameField = new TextField();
		this.passwordField = new PasswordField();
		this.loginButton = new Button("Login");
		this.backButton = new Button("Back");

		this.comboBox = new ComboBox<String>();

		comboBox.getItems().addAll("Passenger", "Employee");
		comboBox.getSelectionModel().select(0);

		this.gridpane = new GridPane();
		this.borderpane = new BorderPane();

	}

	/*
	 * Behavior
	 */

	@Override
	public void draw() {

		stage.setTitle("Login Page");

		gridpane.add(usernameLabel, 0, 0);
		gridpane.add(usernameField, 1, 0);
		gridpane.add(comboBox, 2, 0);

		gridpane.add(passwordLabel, 0, 1);
		gridpane.add(passwordField, 1, 1);

		gridpane.add(loginButton, 0, 2);
		gridpane.add(backButton, 1, 2);

		gridpane.add(messageLabel, 1, 3);
		messageLabel.setPrefSize(200, 50);
		messageLabel.setWrapText(true);
		messageLabel.setFont(Font.font("Vernada", FontWeight.MEDIUM, 15));
		super.draw();

		setActions();

	}

	private void setActions() {

		loginButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				User x;

				if (comboBox.getValue().equals("Passenger")) {
					x = database.authenticate(usernameField.getText(), passwordField.getText(), "Passenger");
				} else {
					x = database.authenticate(usernameField.getText(), passwordField.getText(), "Employee");
				}

				if (x == null) {
					messageLabel.setText("You entered an invalid username or password");
					messageLabel.setTextFill(Paint.valueOf("Red"));
				} else {
					ProfileScreen profileScreen;
					if (x instanceof Passenger) {
						profileScreen = new PassengerProfileScreen(scene.getWidth(), scene.getHeight(), stage, database,
								x);
					} else if (x instanceof Manager) {
						profileScreen = new ManagerProfileScreen(scene.getWidth(), scene.getHeight(), stage, database,
								x);
					} else {
						profileScreen = new DriverProfileScreen(scene.getWidth(), scene.getHeight(), stage, database,
								x);
					}

					profileScreen.draw();
				}

			}
		});

		backButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Screen homeScreen = new HomeScreen(scene.getWidth(), scene.getHeight(), stage, database);
				homeScreen.draw();
			}

		});

	}

}
