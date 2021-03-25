import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



/**
 * 
 * @author Mihir Yadav
 * Assignment:  In this game, the computer chooses 4 pegs each with one of 6 colors. 
 * The player's job is then to guess the colors that the computer has chosen in
 * the proper order. After each guess by the player, if the player's guess is not 
 * correct, the computer will give two numbers as feedback. The first number is how
 * many pegs are the proper color and in the proper position. The second number is 
 * how many pegs are the proper color, but not in the correct position.
 * The game ends when the color string is correct -- and the player wins -- or they give
 * 10 incorrect guesses -- and they lose.
 */
public class Mastermind extends Application {

	/**
	 * main: Takes user arguments and initiates games
	 * @param String[] args
	 * @return NONE
	 */ 
//	public static void main(String[] args) {
//		if(args[0].equals("-text")) {
//			MastermindGUIView m1 = new MastermindGUIView();
//			m1.play();
//		} else if(args[0].equals("-window")) {
//			MastermindGUIView m2 = new MastermindGUIView();
//			m2.play();
//		}
//	}
	
	public void start(Stage stage) throws Exception {
		BorderPane pane = new BorderPane();
		Label label = new Label("Seeing this window means JavaFX is installed correctly.");
		pane.setTop(label);
		Button btnClickMe = new Button("Click Me");
		pane.setCenter(btnClickMe);
		btnClickMe.setOnAction((event) -> { 
			Alert a = new Alert(Alert.AlertType.INFORMATION);
			a.setTitle("JavaFX Works!");
			a.setContentText("JavaFX appears to be properly installed");
			a.setHeaderText("JavaFX Test");
			a.showAndWait();
		});
		
		Scene scene = new Scene(pane, 300, 200);
		stage.setScene(scene);
		stage.setTitle("JavaFX Test");
		stage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
