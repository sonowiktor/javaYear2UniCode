
package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.JourneyReturn;
import view.JourneyPlannerRootPane;

/* Loads the application and creates an instance of the model and view */
public class ApplicationLoader extends Application {

	private JourneyPlannerRootPane view;
	
	public void init() {
		/* --APPROACH 1--
		 * The view is passed a reference to the model and also
		 * contains the (event handling) controller internally.
		 */
		JourneyReturn model = new JourneyReturn();
		view = new JourneyPlannerRootPane(model);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Journey Planner MVC1");
		stage.setScene(new Scene(view));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
