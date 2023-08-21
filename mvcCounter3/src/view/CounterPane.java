package view;

import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class CounterPane extends HBox implements Observer {

	//accessible throughout the class
	private Button plusBtn, minusBtn;
	private Label numberField;

	public CounterPane() {
		//set the style for this pane 
		this.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.getStyleClass().add("counter-pane");

		// ------------Number Field-----------------------
		numberField = new Label("0");

		//---------------Plus Button---------------------
		plusBtn = new Button("+");

		//---------------Minus Button---------------------
		minusBtn = new Button("-");

		//add nodes to the scene graph for this pane
		this.getChildren().addAll(minusBtn, numberField, plusBtn);

	}

	//updates the view
	public void updateTextField(int count) {
		numberField.setText(String.valueOf(count));
	}

	//methods allow listeners to be externally attached to this view
	public void addIncrementHandler(EventHandler<ActionEvent> handler) {
		plusBtn.setOnAction(handler);
	}

	public void addDecrementHandler(EventHandler<ActionEvent> handler) {
		minusBtn.setOnAction(handler);
	}  

	//updates the view as part of the Observer pattern
	public void update(Observable o, Object arg) {
		/* cast argument object containing count value (pushed) into
		       an Integer then update the text field with this. */
		Integer count = (Integer) arg;
		updateTextField(count);


		/* Another approach would be to cast observable object into
		 *  a Counter then update the text field by pulling the 
		 *  count value from the model. See below:
		 */
		//Counter model = (Counter) o;
		//updateTextField(model.getCount());
	}



}
