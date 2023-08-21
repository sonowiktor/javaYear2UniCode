package view;

import javafx.animation.FadeTransition;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class ButtonPane extends HBox {

	//declared for access throughout class, as handlers are now attached via methods
	private Button addBtn, clearBtn, removeBtn;

	public ButtonPane() {

		this.setAlignment(Pos.CENTER);
		this.setSpacing(15);

		addBtn = new Button("Add");
		clearBtn = new Button("Clear");
		removeBtn = new Button("Remove"); 
		addBtn.setDisable(true); //initially disable submit button until items added

		this.getChildren().addAll(addBtn, clearBtn, removeBtn);

		for (Node n : this.getChildren()) {
			((Button) n).setPrefSize(70, 30); //set preferred size for each button
		}

	}
	
	/* Binds boolean bindings to the disable property of the add button
	 * so that it will be disabled whenever the binding attached registers true */
	public void addBtnDisableBind(BooleanBinding property) {
		addBtn.disableProperty().bind(property);
	}
	
	//these methods allow handlers to be externally attached to this view
	public void addAddHandler(EventHandler<ActionEvent> handler) {
		addBtn.setOnAction(handler);
	}

	public void addClearHandler(EventHandler<ActionEvent> handler) {
		clearBtn.setOnAction(handler);
	}

	public void addRemoveHandler(EventHandler<ActionEvent> handler) {
		removeBtn.setOnAction(handler);
	}

}
