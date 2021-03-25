import javafx.application.Application;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
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
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: coral");
		Paint blackpaint = Paint.valueOf("black");
		Paint whitePaint = Paint.valueOf("white");
		pane.setCenter(gridPane);

		gridPane.setHgap(30);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(5, 5, 5, 5));
		for(int i = 1;i<=10;i++) {
			Label text = new Label(Integer.toString(i));
			text.setFont(new Font("Arial", 20));
			gridPane.add(text,0,i,1, 1);
			for (int j = 1; j < 5; j++) {
				Circle circle = new Circle(20);
				gridPane.add(circle,j,i,1, 1);
				circle.setFill(blackpaint);
			}
			for(int j =5;j<7;j++) {
				Circle smallCircle = new Circle(5);
				gridPane.add(smallCircle,j,i,1, 1);
				smallCircle.setFill(blackpaint);
			}
			
			
			
		}
		
		
		TilePane lastTile = addTile(pane);
		pane.setBottom(lastTile);
		Button guessButton = new Button("Guess");
		lastTile.getChildren().add(guessButton);
		
		
		Scene scene = new Scene(pane, 400, 600);
		stage.setScene(scene);
		stage.setTitle("Mastermind");
		stage.show();
		
	}
	
	
	public TilePane addTile(BorderPane pane) {
		TilePane tile = new TilePane();	
		Paint paint = Paint.valueOf("black");
		tile.setMaxHeight(20);
		tile.setPadding(new Insets(5, 5, 5, 5));
		tile.setHgap(30);
		for (int i = 0; i < 4; i++) {
			Circle circle = new Circle(20);
	        tile.getChildren().add(circle);
			circle.setFill(paint);
	    }
		return tile;
	}
	
	
}
