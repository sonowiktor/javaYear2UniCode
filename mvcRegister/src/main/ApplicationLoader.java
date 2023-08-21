package main;

import controller.RegisterController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Register;
import view.RegisterRootPane;

public class ApplicationLoader extends Application {

	private RegisterRootPane view;
	
	@Override
	public void init() {
		//create model and view and pass their references to the controller
		Register model = new Register();
		view = new RegisterRootPane();
		new RegisterController(view, model);	
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Registration form - MVC binding");
		stage.setScene(new Scene(view));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}


}
