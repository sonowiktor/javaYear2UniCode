package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Counter;
import view.CounterPane;

public class CounterController {

	//can be accessed throughout the class
	private CounterPane view;
	private Counter model;

	public CounterController(CounterPane view, Counter model) {
		//initialise fields
		this.view = view;
		this.model = model;

		//add observer view to the model
		model.addObserver(view);
		
		//initialise text field in view with the model's initial count value
		view.updateTextField(model.getCount());

		//attach event handlers
		this.attachEventHandlers();
	}

	private void attachEventHandlers() {
		view.addIncrementHandler(new IncrementButtonHandler());
		
		//no need to update view as it is an observer of the observable model
		view.addDecrementHandler(e -> model.decrement());
	}

	//event handling named inner class
	private class IncrementButtonHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent arg0) {
			model.increment();
			//no need to update view as it is an observer of the observable model
		}
	}


}


