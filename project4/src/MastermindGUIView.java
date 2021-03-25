import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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
		btnClickMe.setOnAction((event) -> { 
			Alert a = new Alert(Alert.AlertType.INFORMATION);
			a.setTitle("Mastermind Works!");
			a.setContentText("Mastermind appears to be properly installed");
			a.setHeaderText("Mastermind Test");
			a.showAndWait();
		});
		
		Scene scene = new Scene(pane, 300, 200);
		stage.setScene(scene);
		stage.setTitle("Mastermind Test");
		stage.show();
		
	}
}
