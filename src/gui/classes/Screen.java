package gui.classes;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public abstract class Screen {

	Scene scene;
	Stage stage;
	
	Screen previousScreen;
	Screen nextScreen;
	
	GridPane gridpane ; 
	BorderPane borderpane;
	
	double width;
	double height;
	

	public void setSize(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public void setStage (Stage stage) {
		this.stage = stage;
	}
	public Scene getScene() {
		return scene;
	}


	
	public abstract void draw () ;
	public abstract void setActions () ;
	
}

