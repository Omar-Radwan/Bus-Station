package gui.classes;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

import actors.classes.Driver;
import actors.classes.User;
import database.classes.Database;
import gui.behaviors.DrawableInformation;
import helping.classes.Message;
import helping.classes.Ticket;
import helping.classes.Trip;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import vehicles.classes.Vehicle;

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

	ComboBox<String> comboBox;
	DrawableInformation drawableInformation ;
	
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

		this.comboBox = new ComboBox<String>();
		comboBoxFromList(database.getManagerList(), comboBox, "Manager");

		vBox = new VBox();
		hBox = new HBox();

	}

	/*
	 * Behavior
	 */

	protected void drawAboveChild() {
		showUserInfo();
		stage.setTitle(user.getFirstName()+" "+user.getLastName()+"'s Profile");
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

		vBox.setSpacing(7);
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

		// done .. recheck
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
				messageTextArea.setWrapText(true);
				
				buttonsBox.getChildren().addAll(send, toLabel, comboBox);

				gridpane.add(buttonsBox, 0, 0);
				gridpane.add(subjectBox, 0, 1);
				gridpane.add(messageTextArea, 0, 2);

				send.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {

						StringTokenizer st = new StringTokenizer(comboBox.getValue(), ": ");

						st.nextToken();

						String userName = st.nextToken();

						User x = database.getUser(userName);

						x.addMessage(user.getUserName(), x.getUserName(), subjectField.getText(),
								messageTextArea.getText());

						addConfirmationText("Message sent successfully.");

						try {
							database.writeUsers();
						} catch (IOException e) {
							e.printStackTrace();
						}

					}

				});

			}
		});

		// done .. recheck many times
		messagesLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				messagesLink.setVisited(false);
				cleanScrollableGridPane(0);

				if (!user.getMessageList().isEmpty()) {

					showList(user.getMessageList(), 300, 75, "Hyperlink", "Blue");

					Iterator<Message> messageIterator = user.getMessageList().iterator();

					for (Node x : gridpane.getChildren()) {

						Hyperlink hyperlink = (Hyperlink) x;

						hyperlink.setOnAction(new EventHandler<ActionEvent>() {

							Message message = messageIterator.next();

							@Override
							public void handle(ActionEvent event) {
								addConfirmationText(message.getContent());
								message.setOpened(true);
							}
						});
					}

				}

				else {
					addConfirmationText("You don't have any messages.");
				}

			}
		});

		// done
		infoLink.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				infoLink.setVisited(false);
				showUserInfo();
			}
		});

		// done
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

						int changeResult = database.changeUserAttributes(user, firstNameField.getText(),
								lastNameField.getText(), userNameField.getText(), passwordField.getText());

						if (changeResult == 1) {
							addConfirmationText("Info changed successfully.");
							try {
								database.writeUsers();
							} catch (IOException e) {
								e.printStackTrace();
							}
						} else {
							addConfirmationText(
									"unfortunately, a user with the same username you chose exist, please try choosing another username.");
						}
					}
				});

			}
		});

		// done
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

	protected <T> void comboBoxFromList(LinkedList<T> list, ComboBox<String> comboBox, String type) {

		comboBox.setPrefSize(150, 10);

		for (T x : list) {
			User temp = (User) x;

			if (!x.equals(this.user))
				comboBox.getItems().add(type + ": " + temp.getUserName());
		}

		comboBox.getSelectionModel().select(0);

	}

	protected <T> void showList(LinkedList<T> list, double prefWidth, double prefHeight, String nodeType,
			String color) {
		cleanScrollableGridPane(0);

		int i = 1;
		String data = null;

		Label tLabel;
		Hyperlink tLink;

		for (T x : list) {
			if (x instanceof Trip)
				data = ((Trip) x).data();

			else if (x instanceof Ticket) {
				data = ((Ticket) x).data();
			} else if (x instanceof Message) {
				data = ((Message) x).data();
				Message y = (Message )x;
				color = y.isOpened()? "Blue":"Red";
			} else if (x instanceof Driver) {
				data = ((Driver) x).data();
			}
			else if (x instanceof Vehicle) {
				data = ((Vehicle) x).data();
			}
			if (nodeType.equals("Label")) {
				tLabel = new Label();
				tLabel.setPrefSize(prefWidth, prefHeight);
				tLabel.setBorder(Border.EMPTY);
				tLabel.setFont(Font.font(12));
				tLabel.setWrapText(true);
				gridpane.add(tLabel, 0, i - 1);
				tLabel.setText(i + ". " + data);
				tLabel.setTextFill(Paint.valueOf(color));
			}

			else if (nodeType.equals("Hyperlink")) {
				tLink = new Hyperlink();
				tLink.setPrefSize(prefWidth, prefHeight);
				tLink.setBorder(Border.EMPTY);
				tLink.setFont(Font.font(12));
				tLink.setWrapText(true);
				gridpane.add(tLink, 0, i - 1);
				tLink.setText(i + ". " + data);
				tLink.setTextFill(Paint.valueOf(color));
			}

			i++;
		}

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
		

		
		drawableInformation.drawExtraInfo(gridpane);
		
		for (Node n : gridpane.getChildren()) {
			Label l = (Label) n;
			l.setFont(Font.font(null, FontWeight.LIGHT,15 ));
		}
		
		gridpane.setVgap(20);
	}

}
