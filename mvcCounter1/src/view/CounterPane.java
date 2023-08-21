package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.Counter;

public class CounterPane extends HBox {

	private Counter model;
	private Label numberField;

	//accepts a reference to the model for event handling
	public CounterPane(Counter model) {
		//set the style for this pane 
		this.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.getStyleClass().add("counter-pane");

		this.model = model; //initialises the model
		
		// ------------Number Field-----------------------
		numberField = new Label(String.valueOf(model.getCount()));
		
        //---------------Plus Button---------------------
        Button plusBtn = new Button("+");
        plusBtn.setOnAction(new IncrementButtonHandler());
        
        //---------------Minus Button---------------------
        Button minusBtn = new Button("-");
        minusBtn.setOnAction(new DecrementButtonHandler());
        
        //add nodes to the scene graph for this pane
        this.getChildren().addAll(minusBtn, numberField, plusBtn);
	
	}

	//updates the view
    public void updateTextField(int count) {
    	numberField.setText(String.valueOf(count));
    }
     
    //event handling controllers
    private class IncrementButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
    		model.increment();
    		updateTextField(model.getCount());
		}
    }

    private class DecrementButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
    		model.decrement();
    		updateTextField(model.getCount());
    	}
    }

}
