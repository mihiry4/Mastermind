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
public class Mastermind{

	 /**
	 * main: takes command line arguments and calls either GUI view
	 * or text view of mastermind game
	 * @param args 
	 * @return NONE
	 */
	public static void main(String[] args) {
		if(args[0].equals("-text")) {
			MastermindTextView m1 = new MastermindTextView();
			m1.play();
		} else if(args[0].equals("-window")) {
			Application.launch(MastermindGUIView.class, args);
		}
	}

}
