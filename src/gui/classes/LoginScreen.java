package gui.classes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginScreen extends Screen  {

	/*
	 * Attributes
	 */
	
	Label usernameLabel ; 
	Label passwordLabel ; 
	Label messageLabel ; 
	
	TextField usernameField ; 
	PasswordField passwordField ; 
	
	Button loginButton;
	Button backButton;
	

	/*
	 * Constructor
	 */

	
	public LoginScreen(double width, double height,Stage stage) {
		
		super(width,height,stage);
		
		this.usernameLabel = new Label("Username");
		this.passwordLabel = new Label("Password");
		this.messageLabel = new Label("Press login to sign in. ");
		this.usernameField = new TextField();
		this.passwordField = new PasswordField();
		this.loginButton = new Button("Login");
		this.backButton = new Button("Back");
		
		this.gridpane = new GridPane();
		this.borderpane = new BorderPane();

	} 
	
	

	/*
	 * Behavior
	 */	
	
	private void setProperties () {
		
		
		usernameLabel.setPrefSize(75, 40);
		usernameLabel.setFont(Font.font(null,FontWeight.SEMI_BOLD,13));
		
		passwordLabel.setPrefSize(75, 40);
		passwordLabel.setFont(Font.font(null,FontWeight.SEMI_BOLD,13));
		
		
	}
	
	@Override
	public void draw() {
		setProperties();
		stage.setTitle("Login Page");
		
		gridpane.add(usernameLabel, 0, 0);
		gridpane.add(usernameField, 1, 0);
		
		gridpane.add(passwordLabel, 0, 1);
		gridpane.add(passwordField, 1, 1);
		
		gridpane.add(loginButton, 0, 2);
		gridpane.add(backButton, 1,2);

		super.draw();
		
		setActions();
	
	}




	
	private void setActions() {
	
		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ProfileScreen passengerProfileScreen = new PassengerProfileScreen(scene.getWidth(), scene.getHeight(), stage);
				passengerProfileScreen.draw();
			}
		});
		
		backButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Screen homeScreen = new HomeScreen(scene.getWidth(), scene.getHeight(), stage);
				homeScreen.draw();
			}
			
		});
		
		
	}






	
	

}
