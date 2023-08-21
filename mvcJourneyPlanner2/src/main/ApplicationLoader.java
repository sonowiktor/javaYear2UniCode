
package main;

import controller.JourneyController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.JourneyReturn;
import view.JourneyPlannerRootPane;

/* Loads the application and creates an instance of the model, view and controller */
public class ApplicationLoader extends Application {

	private JourneyPlannerRootPane view;
	
	public void init() {
		/* --APPROACH 2--
		 * The view and model are decoupled. The controller is 
		 * passed a reference to the model and view. Its job
		 * is to attach event handlers to the view and ensure that
		 * the model and view are updated appropriately. The 
		 * benefit of this approach is that both the model and
		 * view could easily be replaced with other implementations,
		 * or worked on separately.
		 */
		view = new JourneyPlannerRootPane();
		JourneyReturn model = new JourneyReturn();
		new JourneyController(view, model);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Journey Planner MVC2");
		stage.setScene(new Scene(view));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
