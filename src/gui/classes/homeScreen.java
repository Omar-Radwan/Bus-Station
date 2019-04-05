package gui.classes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class HomeScreen extends Screen {

	/*
	 * Attributes
	 */
	
	Button signInButton ;
	Button registerButton;
	Button exitButton ; 
	
	/*
	 * Constructor
	 */
	
	public HomeScreen(double width, double height,Stage stage) {
		super(width, height,stage);
		signInButton = new Button("Sign in");
		registerButton = new Button("Register");
		exitButton = new Button("Exit");
	}


	/*
	 * Behavior
	 */
	
	@Override
	public void draw() {
		
		stage.setTitle("Home Page");
		
		gridpane.add(signInButton,0,0);
		gridpane.add(registerButton, 0, 1);
		gridpane.add(exitButton, 0,2);
		
		super.draw();
		
		setActions();
	}


	private void setActions() {
		
		signInButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Screen loginScreen = new LoginScreen(scene.getWidth(), scene.getHeight(),stage);
				loginScreen.draw();
			}
		});
		
		registerButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Screen registerScreen = new RegisterScreen(scene.getWidth(), scene.getHeight(), stage);
				registerScreen.draw();
			}
		});
		
		
		exitButton .setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {	
				stage.close();
			}
		});
		
	}




}
