package gui.classes;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagerProfileScreen extends ProfileScreen{
	/*
	 * Attributes
	 */

	Hyperlink addTripLink;
	Hyperlink removeTripLink ; 
	Hyperlink swapDriversLink;
	
	/*
	 * Constructor
	 */
	
	
	ManagerProfileScreen(double width, double height,Stage stage) {
		super(width, height,stage);
		addTripLink = new Hyperlink("Add new trip");
		removeTripLink = new Hyperlink("Remove trip");
		swapDriversLink = new Hyperlink("Swap drivers");
	}
	
	/*
	 * Behavior
	 */
	
	private void setProperties() {
		VBox.setVgrow(addTripLink, Priority.ALWAYS);
		VBox.setVgrow(removeTripLink, Priority.ALWAYS);
		VBox.setVgrow(swapDriversLink, Priority.ALWAYS);
		
		swapDriversLink.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		
	}
	public void draw () {
		super.drawAboveChild();
		
		vBox.getChildren().add(addTripLink);
		vBox.getChildren().add(removeTripLink);
		vBox.getChildren().add(swapDriversLink);
		
		
		super.drawBelowChild();
	}
	

}
