package pl.edu.pw.fizyka.pojava.BozekKlis.application;
	
import pl.edu.pw.fizyka.pojava.BozekKlis.application.GUI.GUI;
import javafx.application.Application;
import javafx.stage.Stage;


public class StartingClass extends Application {
	
	GUI gui;
	
	@Override
	public void start(Stage primaryStage) {
		gui = new GUI(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}