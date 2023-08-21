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

		//initialise text field in view with the model's initial count value
		view.updateTextField(model.getCount());

		//attach event handlers
		this.attachEventHandlers();
	}

	private void attachEventHandlers() {
		view.addIncrementHandler(new IncrementButtonHandler()); //inner-class
		view.addDecrementHandler(e -> { model.decrement(); view.updateTextField(model.getCount());}); //lambda expression
	}

	//event handling named inner class
	private class IncrementButtonHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent arg0) {
			model.increment();
			view.updateTextField(model.getCount());
		}
	}


}

