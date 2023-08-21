package controls;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class FXControlsEvents extends Application {

	private Parent root;

	@Override
	/* Build the scene graph in this method */
	public void init() throws Exception {
		root = new FXControlsEventsRootPane();
	}

	@Override
	public void start(Stage stage) {

		Scene scene = new Scene(root);

		stage.setTitle("JavaFX Control Catalogue with Event Handling");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
