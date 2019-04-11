package gui.classes;

import classes.Database;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class Screen {

	/*
	 * Attributes
	 */
	protected Database  database ; 
	protected double width;
	protected double height;

	protected Scene scene;
	protected Stage stage;

	protected GridPane gridpane;
	protected BorderPane borderpane;

	/*
	 * Constructor
	 */

	Screen(double width, double height, Stage stage,Database database) {
		this.database = database;
		this.width = width;
		this.height = height;
		
		this.stage = stage;
		
		gridpane = new GridPane();
		
		borderpane = new BorderPane();
		

	}

	/*
	 * Behavior
	 */

	public void draw() {

		gridpane.setVgap(10);
		gridpane.setHgap(10);

		gridpane.setAlignment(Pos.CENTER);

		borderpane.setCenter(gridpane);
		borderpane.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);

		scene = new Scene(borderpane, width, height);
		gridpane.setGridLinesVisible(true);
		stage.setScene(scene);

	};
	
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

	protected void addConfirmationText(String text) {
		cleanGridPane(0);
		Text confirmationText = new Text(text);
		gridpane.add(confirmationText, 0, 0);
		confirmationText.setWrappingWidth(300);
		confirmationText.setFont(Font.font("Verdana", 20));
	}


}
