import java.util.Arrays;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MastermindGUIView extends Application {

    private int p = 1;
    private MastermindModel model;
    private boolean gameWon = false;


	public MastermindGUIView() {
		 model = new MastermindModel("rgbp");
	}

	
	public void start(Stage stage) throws Exception {
		BorderPane pane = new BorderPane();
        GridPane bottomGridPane = new GridPane();

        VBox vbox = new VBox(10);
        pane.setCenter(vbox);
        pane.setBottom(bottomGridPane);
        vbox.setStyle("-fx-background-color: tan");
        vbox.setPadding(new Insets(5, 5, 5, 5));
        
        
        // bottom grid pane
        bottomGridPane.setStyle("-fx-background-color: white");
        bottomGridPane.setPadding(new Insets(5, 5, 5, 5));
        bottomGridPane.setHgap(30);
		Button colorButton1 = createButton();
		Button colorButton2 = createButton();
		Button colorButton3 = createButton();
		Button colorButton4 = createButton();
		bottomGridPane.add(colorButton1,1,0,1, 1);
		bottomGridPane.add(colorButton2,2,0,1, 1);
		bottomGridPane.add(colorButton3,3,0,1, 1);
		bottomGridPane.add(colorButton4,4,0,1, 1);
		
		Button guessButton = new Button("Guess");
		bottomGridPane.add(guessButton,5,0);
		guessButton.setOnAction((event)->{
			String color1 = getButtonColor(colorButton1);
			String color2 = getButtonColor(colorButton2);
			String color3 = getButtonColor(colorButton3);
			String color4 = getButtonColor(colorButton4);
			if(color1.equals("black")||color2.equals("black")
				|| color3.equals("black") || color4.equals("black")) {
				Alert a = new Alert(Alert.AlertType.INFORMATION);
				a.setTitle("Mastermind");
				a.setContentText("Please select 4 colors");
				a.setHeaderText("Try again!");
				a.showAndWait();
			} else {
			GridPane temp =addGP(p,color1,color2,color3,color4);
			if(temp != null) {
				vbox.getChildren().add(temp);
				if(gameWon) {
					Alert a = new Alert(Alert.AlertType.INFORMATION);
					a.setTitle("Mastermind");
					a.setContentText("Congratulations! You won.");
					a.setHeaderText("Game complete.");
					a.showAndWait();
					System.exit(0);
				}
			} else {
				Alert a = new Alert(Alert.AlertType.INFORMATION);
				a.setTitle("Mastermind");
				a.setContentText("You Lost! Please try again.");
				a.setHeaderText("Out of turns");
				a.showAndWait();
				System.exit(0);
			}
			resetColor(colorButton1);
			resetColor(colorButton2);
			resetColor(colorButton3);
			resetColor(colorButton4);
			}
		});
		
		
		
		
		// stage setup
		Scene scene = new Scene(pane, 400, 600);
		stage.setScene(scene);
		stage.setTitle("Mastermind");
		stage.show();
		
	}
	
	public void resetColor(Button button) {
		button.setStyle ("-fx-background-radius: 40px; "+
                "-fx-background-color: black;"+
                "-fx-min-width: 40px; " +
                "-fx-min-height: 40px; " +
                "-fx-max-width: 40px; " +
                "-fx-max-height: 40px;");
	}
	
	public Button createButton() {
		Button colorButton = new Button();
		colorButton.setStyle(
                "-fx-background-radius: 40px; "+
                "-fx-background-color: black;"+
                "-fx-min-width: 40px; " +
                "-fx-min-height: 40px; " +
                "-fx-max-width: 40px; " +
                "-fx-max-height: 40px;"
        );
		colorButton.setOnAction((event)->{
     		ButtonOnAction(event,colorButton);
     	});
		return colorButton;
	}
	
	public void ButtonOnAction (ActionEvent event, Button roundButton) {
		String color = getButtonColor(roundButton);
		String[] colors = new String[] {"red","orange","yellow",
				"green","blue","purple"};
		int ind = findIndex(colors,color);
		if(ind<colors.length-1) {
			color = colors[ind+1];
		} else {
			color = colors[0];
		}
		roundButton.setStyle ("-fx-background-radius: 40px; "+
                "-fx-background-color: "+ color + ";"+
                "-fx-min-width: 40px; " +
                "-fx-min-height: 40px; " +
                "-fx-max-width: 40px; " +
                "-fx-max-height: 40px;");

	}
	
	public String getButtonColor(Button button) {
		String s = button.getStyle();
		String[] temp = s.split(";");
		int tempInd = temp[1].indexOf(':');
		String color = temp[1].substring(tempInd+2);
		return color;
	}
	
	public int findIndex(String arr[], String t)
    {
		int len = arr.length;
        int i = 0;
 
        while (i < len) {
            if (arr[i].equals(t)) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

	
	public GridPane addGP(int guessIndex, String color1, String color2, 
			String color3, String color4) {
		if(p>10)
			return null;
		GridPane gridPane = new GridPane();
		gridPane.setHgap(30);
     	Label text = new Label(Integer.toString(guessIndex));
     	text.setFont(new Font("Arial", 20));
     	gridPane.add(text, 0, 0);
		Circle circle1 = new Circle(20);
		circle1.setFill(getPaint(color1));
		gridPane.add(circle1,1,0,1, 1);
		Circle circle2 = new Circle(20);
		circle2.setFill(getPaint(color2));
		gridPane.add(circle2,2,0,1, 1);
		Circle circle3 = new Circle(20);
		circle3.setFill(getPaint(color3));
		gridPane.add(circle3,3,0,1, 1);
		Circle circle4 = new Circle(20);
		circle4.setFill(getPaint(color4));
		gridPane.add(circle4,4,0,1, 1);
		gridPane.add(addStatusGP(color1,color2,color3,color4), 5, 0);
		p++;
		return gridPane;
	}
	
	public Paint getPaint(String s) {
		Paint paint1 = Paint.valueOf(s);
		return paint1;
	}
	
	public GridPane addStatusGP( String color1, String color2, 
			String color3, String color4) {
		MastermindController mc = new MastermindController(model);
		StringBuilder guess = new StringBuilder();
		guess.append(color1.charAt(0));
		guess.append(color2.charAt(0));
		guess.append(color3.charAt(0));
		guess.append(color4.charAt(0));
		int RCRP = 0;
		int RCWP = 0;
		try {
			RCRP = mc.getRightColorRightPlace(guess.toString());
			RCWP = mc.getRightColorWrongPlace(guess.toString());
		} catch (MastermindIllegalColorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MastermindIllegalLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 GridPane gridPane = new GridPane();
		 gridPane.setHgap(5);
		 gridPane.setVgap(5);
		 gridPane.setPadding(new Insets(5, 5, 5, 5));
		 Paint blackpaint = Paint.valueOf("black");
		 Paint whitePaint = Paint.valueOf("white");
		if(RCRP == 4)
			gameWon = true;
		for(int i = 0;i<RCRP;i++) {
			Circle circle = new Circle(5);
			circle.setFill(blackpaint);
			gridPane.add(circle,i,0,1, 1);
		}
		for(int i = 0;i<RCWP;i++) {
			Circle circle = new Circle(5);
			circle.setFill(whitePaint);
			gridPane.add(circle,i,1,1, 1);
		}
		return gridPane;
	}	
}
