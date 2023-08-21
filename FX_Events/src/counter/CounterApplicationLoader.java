package counter;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CounterApplicationLoader extends Application {

	private Parent root;

	@Override
	public void init() throws Exception {
		root = new VBox(50, new CounterPane(), new CounterPane(), new CounterPane());
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(root);
		stage.setTitle("JavaFX Counter Panes");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
