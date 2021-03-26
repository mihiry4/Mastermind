import javafx.application.Application;
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

	public MastermindGUIView() {
	}

	
	public void start(Stage stage) throws Exception {
		BorderPane pane = new BorderPane();
        GridPane bottomGridPane = new GridPane();

        VBox vbox = new VBox(10);
        pane.setCenter(vbox);
        pane.setBottom(bottomGridPane);
        vbox.setStyle("-fx-background-color: tan");
        vbox.setPadding(new Insets(5, 5, 5, 5));
        
        // putting new gridpane in vbox
        for(int i = 1;i<=10;i++) {
        	vbox.getChildren().add(addGP(i));
        }
        
        // putting 
        
        
        
        
        // bottom grid pane
        bottomGridPane.setStyle("-fx-background-color: white");
        bottomGridPane.setPadding(new Insets(5, 5, 5, 5));
        bottomGridPane.setHgap(30);
		for(int i = 1;i<5;i++) {
			Circle circle = new Circle(20);
			bottomGridPane.add(circle,i,0,1, 1);
		}
		Button guessButton = new Button("Guess");
		bottomGridPane.add(guessButton,5,0);
		
		
		// stage setup
		Scene scene = new Scene(pane, 400, 600);
		stage.setScene(scene);
		stage.setTitle("Mastermind");
		stage.show();
		
	}
	
	public GridPane addGP(int guessIndex) {
		 GridPane gridPane = new GridPane();
		 gridPane.setHgap(30);

     	Label text = new Label(Integer.toString(guessIndex));
     	text.setFont(new Font("Arial", 20));
     	gridPane.add(text, 0, 0);
		 for(int i = 1;i<5;i++) {
				Circle circle = new Circle(20);
				gridPane.add(circle,i,0,1, 1);
			}
		 gridPane.add(addStatusGP(), 5, 0);

		 return gridPane;
	}
	
	public GridPane addStatusGP() {
		 GridPane gridPane = new GridPane();
		 gridPane.setHgap(5);
		 gridPane.setVgap(5);
		 gridPane.setPadding(new Insets(5, 5, 5, 5));
		 Paint blackpaint = Paint.valueOf("black");
		 Paint whitePaint = Paint.valueOf("white");

		for(int i = 0;i<2;i++) {
			Circle circle = new Circle(5);
			circle.setFill(blackpaint);
			gridPane.add(circle,i,0,1, 1);
		}
		for(int i = 0;i<2;i++) {
			Circle circle = new Circle(5);
			circle.setFill(whitePaint);
			gridPane.add(circle,i,1,1, 1);
		}
		return gridPane;
	}	
}
