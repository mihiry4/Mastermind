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
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MastermindGUIView extends Application {

	public MastermindGUIView() {
	}

	
	public void start(Stage stage) throws Exception {
		BorderPane pane = new BorderPane();
		Label label = new Label("Seeing this window means Mastermind is installed correctly.");
		pane.setTop(label);
		Button btnClickMe = new Button("Click Me");
		pane.setCenter(btnClickMe);
		TilePane tile = new TilePane();	
		Paint paint = Paint.valueOf("black");
		pane.setBottom(tile);
		tile.setStyle("-fx-background-color: #FFE5B4");
		tile.setMaxHeight(20);
		tile.setPadding(new Insets(5, 5, 5, 5));
		tile.setHgap(40);
		for (int i = 0; i < 4; i++) {
			Circle circle = new Circle(20);
	        tile.getChildren().add(circle);
			circle.setFill(paint);
	    }
		btnClickMe.setOnAction((event) -> { 
			Alert a = new Alert(Alert.AlertType.INFORMATION);
			a.setTitle("Mastermind Works!");
			a.setContentText("Mastermind appears to be properly installed");
			a.setHeaderText("Mastermind Test");
			a.showAndWait();
		});
		
		Scene scene = new Scene(pane, 400, 600);
		stage.setScene(scene);
		stage.setTitle("Mastermind Test");
		stage.show();
		
	}
}
