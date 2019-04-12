package gui.classes;

import database.classes.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeScreen extends Screen {

	/*
	 * Attributes
	 */

	Button signInButton;
	Button registerButton;
	Button exitButton;

	/*
	 * Constructor
	 */

	public HomeScreen(double width, double height, Stage stage, Database database) {
		super(width, height, stage, database);

		signInButton = new Button("Sign in");
		registerButton = new Button("Register");
		exitButton = new Button("Exit");

	}

	/*
	 * Behavior
	 */
	private void setProperties() {

		signInButton.setPrefSize(150, 50);
		registerButton.setPrefSize(150, 50);
		exitButton.setPrefSize(150, 50);

	}

	@Override
	public void draw() {

		stage.setTitle("Home Page");

		gridpane.add(signInButton, 0, 0);
		gridpane.add(registerButton, 0, 1);
		gridpane.add(exitButton, 0, 2);

		setProperties();

		super.draw();

		setActions();
	}

	private void setActions() {

		signInButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Screen loginScreen = new LoginScreen(scene.getWidth(), scene.getHeight(), stage, database);
				loginScreen.draw();
			}
		});

		registerButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Screen registerScreen = new RegisterScreen(scene.getWidth(), scene.getHeight(), stage, database);
				registerScreen.draw();
			}
		});

		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				stage.close();
			}
		});

	}

}
