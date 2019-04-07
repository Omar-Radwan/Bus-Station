package gui.classes;

import classes.Database;
import classes.Message;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import users.classes.User;

public abstract class ProfileScreen extends Screen {

	/*
	 * Attributes
	 */

	Label welcomeLabel;
	Label menuLabel;

	Hyperlink messagesLink;
	Hyperlink sendMessageLink;
	Hyperlink infoLink;
	Hyperlink editProfileLink;
	Hyperlink logoutLink;

	User user;

	VBox vBox;
	HBox hBox;

	/*
	 * Constructor
	 */

	ProfileScreen(double width, double height, Stage stage, Database database, User user) {
		super(width, height, stage, database);
		this.user = user;
		welcomeLabel = new Label("Welcome");
		menuLabel = new Label("Home menu:");

		sendMessageLink = new Hyperlink("Send new message");
		messagesLink = new Hyperlink("View messages");
		infoLink = new Hyperlink("View your info");
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

		welcomeLabel.setFont(Font.font(null, FontWeight.BOLD, 15));
		menuLabel.setFont(Font.font(null, FontWeight.BLACK, 12));

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
				sendMessageLink.setVisited(false);
				
				gridpane  = new GridPane();

				

				Button send = new Button("Send");

				Label toLabel = new Label("			To:");

				TextField userNameField = new TextField();

				HBox buttonsBox = new HBox();
				buttonsBox.setSpacing(10);

				TextArea messageTextArea = new TextArea();
				messageTextArea.setPrefSize(300, 300);

				buttonsBox.getChildren().addAll(send, toLabel, userNameField);

				gridpane.add(buttonsBox, 0, 0);
				gridpane.add(messageTextArea, 0, 1);

				gridpane.setAlignment(Pos.CENTER);
				borderpane.setCenter(gridpane);

			}
		});

		messagesLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				messagesLink.setVisited(false);
				
				gridpane = new GridPane();
				
				ScrollPane scrollPane = new ScrollPane();
				
				int i = 0 ; 
				
				for (Message x : user.getMessageList()) {
					Hyperlink messageSubjectLink = new Hyperlink(x.getSubject());
					messageSubjectLink.setPrefSize(400, 50);
					
					
					messageSubjectLink.setTextFill(Paint.valueOf("blue"));;
					messageSubjectLink.setFont(Font.font(15));
					
					gridpane.add(messageSubjectLink, 0, i);
					
					i++;
				}
				
				scrollPane.setContent(gridpane);
				
				borderpane.setCenter(scrollPane);

			}
		});

		infoLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				infoLink.setVisited(false);

			}
		});

		editProfileLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				editProfileLink.setVisited(false);

			}
		});

		logoutLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				logoutLink.setVisited(false);

				Screen loginScreen = new LoginScreen(scene.getWidth(), scene.getHeight(), stage, database);
				loginScreen.draw();
			}
		});

	}

}
