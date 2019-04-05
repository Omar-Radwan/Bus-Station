import gui.classes.HomeScreen;
import gui.classes.LoginScreen;
import gui.classes.Screen;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	
	static final double defaultWidth =400; 
	static final double defaultHeight = 400;
	
	public static void main  (String [] args) {

		launch(args);
	
	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Screen homeScreen = new HomeScreen(defaultWidth,defaultHeight,primaryStage);
		Screen logiScreen = new LoginScreen(defaultWidth, defaultHeight, primaryStage);
		
		primaryStage.setMinWidth(defaultWidth);
		primaryStage.setMinHeight(defaultHeight);

		homeScreen.draw();
		
		primaryStage.show();
	}
	
	
}
