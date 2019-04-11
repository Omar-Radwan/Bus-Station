package gui.classes;

import java.util.LinkedList;
import java.util.StringTokenizer;

import classes.Database;
import classes.Message;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import users.classes.Manager;
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

	ComboBox<String> userComboBox;
	/*
	 * Constructor
	 */

	ProfileScreen(double width, double height, Stage stage, Database database, User user) {
		super(width, height, stage, database);
		this.user = user;
		welcomeLabel = new Label("Welcome");
		menuLabel = new Label("Home menu:");

		sendMessageLink = new Hyperlink("Send message");
		messagesLink = new Hyperlink("View messages");
		infoLink = new Hyperlink("View your info");
		editProfileLink = new Hyperlink("Edit your info");
		logoutLink = new Hyperlink("Logout");

		this.userComboBox = new ComboBox<String>();
		userComboBox.setPrefSize(150, 10);

		for (Manager x : database.getManagerList()) {
			if (!x.equals(this.user)) {
				userComboBox.getItems().add(x.getJob() + ": " + x.getUserName());
			}
			userComboBox.getSelectionModel().select(0);
		}

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

	private void showUserInfo() {

		cleanGridPane(10);

		Label firstNameLabel = new Label("Firstname: ");
		Label lastNameLabel = new Label("Lastname: ");
		Label userNameLabel = new Label("Username: ");

		Label firstName = new Label(user.getFirstName());
		Label lastName = new Label(user.getLastName());
		Label userName = new Label(user.getUserName());

		gridpane.add(firstNameLabel, 0, 0);
		gridpane.add(lastNameLabel, 0, 1);
		gridpane.add(userNameLabel, 0, 2);

		gridpane.add(firstName, 1, 0);
		gridpane.add(lastName, 1, 1);
		gridpane.add(userName, 1, 2);

	}

	@Override
	public abstract void draw();

	private void setActions() {

		sendMessageLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				sendMessageLink.setVisited(false);
				cleanGridPane(0);

				Button send = new Button("Send");

				Label toLabel = new Label("			To:");

				Label subjectLabel = new Label("Subject");
				TextField subjectField = new TextField();
				subjectField.setPrefWidth(300 - subjectLabel.getWidth() - 10);

				HBox buttonsBox = new HBox();
				buttonsBox.setSpacing(10);

				HBox subjectBox = new HBox();
				subjectBox.setSpacing(10);

				subjectBox.getChildren().addAll(subjectLabel, subjectField);

				TextArea messageTextArea = new TextArea();
				messageTextArea.setPrefSize(300, 300);

				buttonsBox.getChildren().addAll(send, toLabel, userComboBox);

				gridpane.add(buttonsBox, 0, 0);
				gridpane.add(subjectBox, 0, 1);
				gridpane.add(messageTextArea, 0, 2);

				send.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {

						StringTokenizer st = new StringTokenizer(userComboBox.getValue(), ": ");

						st.nextToken();

						String userName = st.nextToken();

						User x = database.getUser(userName);

						x.addMessage(user.getUserName(), x.getUserName(), subjectField.getText(),
								messageTextArea.getText());

						addConfirmationText("Your feedback has been sent to the manager thanks.");
					}

				});

			}
		});

		messagesLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				messagesLink.setVisited(false);

				cleanScrollableGridPane(0);
				int i = 0;

				if (!user.getMessageList().isEmpty()) {

					for (Message x : user.getMessageList()) {
						Hyperlink messageSubjectLink = new Hyperlink(x.getSubject());
						messageSubjectLink.setPrefSize(400, 50);

						messageSubjectLink.setTextFill(Paint.valueOf("blue"));
						messageSubjectLink.setFont(Font.font(15));

						gridpane.add(messageSubjectLink, 0, i);
						i++;
						messageSubjectLink.setOnAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent arg0) {
								addConfirmationText(x.getContent());
							}

						});

					}

				}

				else {
					addConfirmationText("You don't have any messages.");
				}

			}
		});

		infoLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				infoLink.setVisited(false);
				showUserInfo();
			}
		});

		editProfileLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				editProfileLink.setVisited(false);

				cleanGridPane(10);

				Label firstNameLabel = new Label("Firstname: ");
				Label lastNameLabel = new Label("Lastname: ");
				Label userNameLabel = new Label("Username: ");
				Label passwordLabel = new Label("Password: ");

				TextField firstNameField = new TextField(user.getFirstName());
				TextField lastNameField = new TextField(user.getLastName());
				TextField userNameField = new TextField(user.getUserName());

				PasswordField passwordField = new PasswordField();
				passwordField.setText(user.getPassword());

				Button saveButton = new Button("Save");
				Button discardChangesButton = new Button("Discard changes");

				gridpane.add(firstNameLabel, 0, 0);
				gridpane.add(lastNameLabel, 0, 1);
				gridpane.add(userNameLabel, 0, 2);
				gridpane.add(passwordLabel, 0, 3);
				gridpane.add(saveButton, 0, 4);

				gridpane.add(firstNameField, 1, 0);
				gridpane.add(lastNameField, 1, 1);
				gridpane.add(userNameField, 1, 2);
				gridpane.add(passwordField, 1, 3);
				gridpane.add(discardChangesButton, 1, 4);

				discardChangesButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						showUserInfo();
					}
				});

				saveButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						// fill change result function
						int changeResult = database.changeUserAttributes(user, firstNameField.getText(),
								lastNameField.getText(), userNameField.getText(), passwordField.getText());

						if (changeResult == 1) {
							showUserInfo();
						}
						
					}
				});

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
	
	

	
	
	
	
	
	
	/*
	 * Helping functions
	 */
	
	
	
	
	


	protected void cleanGridPane(double vGap) {
		gridpane = new GridPane();
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setVgap(vGap);
		borderpane.setCenter(gridpane);

	}

	protected void cleanScrollableGridPane(double vGap) {
		gridpane = new GridPane();
		gridpane.setVgap(vGap);
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(gridpane);
		borderpane.setCenter(scrollPane);
	}
	
	protected void addConfirmationText (String text) {
		cleanGridPane(0);
		Text confirmationText = new Text(text);
		gridpane.add(confirmationText, 0, 0);
		confirmationText.setWrappingWidth(300);
		confirmationText.setFont(Font.font("Verdana", 20));
	}
	
	protected void comboBoxFromList(LinkedList<User> list, ComboBox<String> comboBox,String type) {
		
		for (User x: list) {
			comboBox.getItems().add(type+": "+x.getUserName());
		}
	
		if (!comboBox.getSelectionModel().isEmpty())
		comboBox.getSelectionModel().select(0);
	
	}

}
