import gui.classes.LoginScreen;
import gui.classes.Screen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	
	public static void main  (String [] args) {

		launch(args);
	
	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Screen loginScreen = new LoginScreen();
		
		loginScreen.setStage(primaryStage);
		loginScreen.setSize(300, 300);
		loginScreen.draw();
		
		primaryStage.show();
		
	}
	
	
}
