
package view;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

/* A button pane for the journey planner allowing
 * various options such as clear, submit, and restore. */
public class ButtonPane extends HBox {

	//declared for access throughout class (handlers are now attached via methods, so buttons need to be declared as fields)
	private Button clear, submit, restore;
	private ComboBox<String> choices;
	
	public ButtonPane() {
		this.setStyle("-fx-background-color: #D6D6D6;");	
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setAlignment(Pos.CENTER_RIGHT);
		
		clear = new Button("Clear");
		clear.setPrefSize(70, 30);
	    submit = new Button("Submit");
	    submit.setPrefSize(70, 30);
	    restore = new Button("Restore");
	    restore.setPrefSize(70, 30);
	    
	    ObservableList<String> list = FXCollections.observableArrayList("Both", "Outward", "Return");
	    choices = new ComboBox<String>(list);
	    choices.getSelectionModel().select(0);
	    choices.setPrefSize(90, 30);
	    
	    HBox clearBox = new HBox(clear);
	    clearBox.setAlignment(Pos.CENTER_LEFT);
	    clearBox.setPadding(new Insets(0,50,0,0));
	    
	    HBox submitBox = new HBox(restore, choices, submit);
	    submitBox.setAlignment(Pos.CENTER_RIGHT);
	    submitBox.setSpacing(8);
	    
		this.getChildren().addAll(clearBox, submitBox);
	}
	
	//get the selected choice
	public String getSelectedChoice() {
		return choices.getSelectionModel().getSelectedItem();
	}
	
	//these methods allow handlers to be externally attached to this view by the controller
	public void addClearHandler(EventHandler<ActionEvent> handler) {
		clear.setOnAction(handler);
	}
	
	public void addSubmitHandler(EventHandler<ActionEvent> handler) {
		submit.setOnAction(handler);
	}
	
	public void addRestoreHandler(EventHandler<ActionEvent> handler) {
		restore.setOnAction(handler);
	}
	
	//this method allows a change listener to be externally attached to the selectedItemProperty
	public void addSelectionChangeListener(ChangeListener<String> listener) {
		choices.getSelectionModel().selectedItemProperty().addListener(listener);
	}
	
}
