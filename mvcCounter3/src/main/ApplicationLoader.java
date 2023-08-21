package main;

import controller.CounterController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import model.Counter;
import model.ModuloCounter;
import view.CounterPane;

public class ApplicationLoader extends Application {

	private Accordion root;

	@Override
	/* Build the scene graph in this method */
	public void init() throws Exception {
		
		/* --APPROACH 3--
		 * Largely the same as Approach 2. The controller is passed a 
		 * reference to the model and view. Its job is to add event handlers 
		 * to the view and ensure that the model and view are updated. 
		 * The difference is that in this approach the view is registered to 
		 * the observable model as an observer and will thus update to keep
		 * in synchronisation with the view rather than the controller having
		 * to do this. 
		 * See this reflected in the model - Counter has extended Observable and
		 * notifies observers of changes. In the view - CounterPanel has
		 * implemented the Observer interface and replaced its previous
		 * updateTextField method with the required update method.
		 * In the controller - CounterController adds observers to the model
		 * and no longer needs to update the view itself.
		 */
		Counter model1 = new Counter(); 
		CounterPane view1 = new CounterPane();
		new CounterController(view1, model1);
		
		Counter model2 = new ModuloCounter(5); 
		CounterPane view2 = new CounterPane();
		new CounterController(view2, model2);

		root = new Accordion(); 
		root.getPanes().addAll(new TitledPane("Counter", view1), new TitledPane("ModuloCounter", view2));
		root.setExpandedPane(root.getPanes().get(0));
		
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(root);
		stage.setTitle("Counter");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}



