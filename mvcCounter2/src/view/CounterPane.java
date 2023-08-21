package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class CounterPane extends HBox {

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


}
