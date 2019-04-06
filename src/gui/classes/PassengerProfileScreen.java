package gui.classes;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PassengerProfileScreen extends ProfileScreen{

	/*
	 * Attributes
	 */
	

	Hyperlink bookTripLink ;
	Hyperlink cancelTripLink;
	Hyperlink viewTripsLink;	
	
	/*
	 * Constructor
	 */
	
	PassengerProfileScreen(double width, double height,Stage stage){
		super(width, height,stage);
		bookTripLink = new Hyperlink("Book a trip");
		cancelTripLink = new Hyperlink("Cancel a trip");
		viewTripsLink = new Hyperlink("View trips");
		
	}
	

	
	/*
	 * Behavior
	 */
	
	private void setProperties() {
	

	}
	
	@Override 
	public void draw() {
		drawAboveChild();
		setProperties();
		vBox.getChildren().addAll(bookTripLink,cancelTripLink,viewTripsLink);
		
		
		
		drawBelowChild();
		
		
	}
	
}
