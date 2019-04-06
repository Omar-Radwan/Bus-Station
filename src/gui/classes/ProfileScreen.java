package gui.classes;

import javax.xml.ws.handler.MessageContext;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import users.classes.User;

public abstract class ProfileScreen extends Screen {

	/*
	 * Attributes
	 */

	Label welcomeLabel;
	Label menuLabel;
	
	Hyperlink  messagesLink;
	Hyperlink  sendMessageLink;
	Hyperlink  infoLink;
	Hyperlink editProfileLink;
	Hyperlink logoutLink;
	
	
	User user;

	VBox vBox;
	HBox hBox;
	
	/*
	 * Constructor
	 */

	ProfileScreen(double width, double height, Stage stage) {
		super(width, height, stage);

		welcomeLabel = new Label("Welcome");
		menuLabel = new Label("Home menu:");
		
		sendMessageLink = new Hyperlink("Send new message");
		messagesLink = new Hyperlink("View messages");
		infoLink =new Hyperlink("View your info");
		editProfileLink = new Hyperlink("Edit your info");
		logoutLink = new Hyperlink("Logout");
	
		vBox = new VBox();
		hBox = new HBox();
	}

	
	/*
	 * Behavior
	 */
	

	protected void drawAboveChild() {


		hBox.setAlignment(Pos.TOP_LEFT);
		
		hBox.getChildren().add(welcomeLabel);
		
		welcomeLabel.setFont(Font.font(null, FontWeight.BOLD,15));
		menuLabel.setFont(Font.font(null,FontWeight.BLACK,12));
		
		vBox.setAlignment(Pos.BASELINE_LEFT);
	
		vBox.getChildren().add(menuLabel);
		vBox.getChildren().add(sendMessageLink);
		vBox.getChildren().add(messagesLink);
		vBox.getChildren().add(infoLink);
		vBox.getChildren().add(editProfileLink);

		borderpane.setTop(hBox);
		borderpane.setLeft(vBox);
		
		vBox.setSpacing(12);
		hBox.setSpacing(12);
		
	
		
	
		
		super.draw();
		setActions();
	}

	protected void drawBelowChild() {
		vBox.getChildren().add(logoutLink);
	}

	@Override
	public abstract void draw();
	
	
	

	private void setActions() {
		
		sendMessageLink.setOnAction(new EventHandler<ActionEvent>() {
			
			
			@Override
			public void handle(ActionEvent event) {
				
				double gridWidth = gridpane.widthProperty().doubleValue();
				double gridHeight = gridpane.heightProperty().doubleValue();
				
				gridpane.setPrefHeight(800);
				gridpane.setPrefWidth(400);
				
				

				ColumnConstraints cs = new ColumnConstraints();
				cs.setPrefWidth(gridWidth);
				gridpane.getColumnConstraints().add(cs);


				
				RowConstraints rc = new RowConstraints();
				rc .setPrefHeight((gridHeight/8));
				gridpane.getRowConstraints().add(rc);
				
				rc = new RowConstraints();
				rc .setPrefHeight((gridHeight/8));
				gridpane.getRowConstraints().add(rc);
				
				rc = new RowConstraints();
				rc .setPrefHeight((gridHeight/8));
				gridpane.getRowConstraints().add(rc);
				
				rc = new RowConstraints();
				rc .setPrefHeight((gridHeight/8));
				gridpane.getRowConstraints().add(rc);
				
				
				gridpane.setGridLinesVisible(true);
				borderpane.setVisible(true);
			
				
				TextArea messageField = new TextArea();
			
				gridpane.setAlignment(Pos.CENTER);
				borderpane.setCenter(gridpane);

		

			}
		});
		
		messagesLink.setOnAction(new EventHandler<ActionEvent>() {
			
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		
		infoLink.setOnAction(new EventHandler<ActionEvent>() {
			
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println(scene.getWidth());
				System.out.println(scene.getHeight());
				
			}
		});
		
		editProfileLink.setOnAction(new EventHandler<ActionEvent>() {
			
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		
		logoutLink.setOnAction(new EventHandler<ActionEvent>() {

			
			
			@Override
			public void handle(ActionEvent event) {
				Screen loginScreen = new LoginScreen(scene.getWidth(),scene.getHeight(),stage);
				loginScreen.draw();
			}
		});

		

	}

}
