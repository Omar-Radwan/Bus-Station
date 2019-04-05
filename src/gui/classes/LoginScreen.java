package gui.classes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

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
	
	

	/*
	 * Constructor
	 */
	
	public LoginScreen() {
		super();
		

		this.usernameLabel = new Label("Username");
		this.passwordLabel = new Label("Password");
		this.messageLabel = new Label("Press login to sign in. ");
		this.usernameField = new TextField();
		this.passwordField = new PasswordField();
		this.loginButton = new Button("Login");
		this.gridpane = new GridPane();
		this.borderpane = new BorderPane();
	} 
	
	
	

	/*
	 * Getters And Setters
	 */


	/*
	 * toString uses " " as delimiter
	 */

	/*
	 * Behavior
	 */	
	
	@Override
	public void draw() {
		
		stage.setTitle("Login Page");
		
		gridpane.add(usernameLabel, 0, 0);
		gridpane.add(usernameField, 1, 0);
		
		gridpane.add(passwordLabel, 0, 1);
		gridpane.add(passwordField, 1, 1);
		
		gridpane.add(loginButton, 0, 2);
		

		gridpane.setAlignment(Pos.CENTER);
		borderpane.setCenter(gridpane);
		
		scene = new Scene(borderpane,width,height);
		
		stage.setScene(scene);
		
	
	}




	@Override
	public void setActions() {
	
		
	}






	
	

}
