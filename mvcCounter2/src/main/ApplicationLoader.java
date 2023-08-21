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
		
		/* --APPROACH 2--
		 * The view and model are decoupled. The controller is 
		 * passed a reference to the model and view. Its job
		 * is to add event handlers to the view and ensure that
		 * the model and view are updated appropriately. The 
		 * benefit of this approach is that both the model and
		 * view could easily be replaced with other implementations,
		 * or worked on separately.
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



