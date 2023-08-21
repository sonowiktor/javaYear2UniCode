
package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import model.JourneyReturn;

/* A button pane for the journey planner allowing
 * various options such as clear, submit, and restore. */
public class ButtonPane extends HBox {

	//declared for access throughout class
	private JourneyPlannerRootPane viewRoot;
	private JourneyReturn model;
	private ComboBox<String> choices;

	//note the references accepted to the parent root pane and the model - to be usd by event handlers
	public ButtonPane(JourneyPlannerRootPane viewRoot, JourneyReturn model) {

		//initialise the view and model in this class with the accepted parameter references
		this.viewRoot = viewRoot;
		this.model = model;

		this.setStyle("-fx-background-color: #D6D6D6;");	
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setAlignment(Pos.CENTER_RIGHT);

		Button clear = new Button("Clear");
		clear.setPrefSize(70, 30);
		clear.setOnAction(new ClearHandler());

		Button submit = new Button("Submit");
		submit.setPrefSize(70, 30);
		submit.setOnAction(new SubmitHandler());

		Button restore = new Button("Restore");
		restore.setPrefSize(70, 30);
		restore.setOnAction(new RestoreHandler());

		ObservableList<String> list = FXCollections.observableArrayList("Both", "Outward", "Return");
		choices = new ComboBox<String>(list);
		choices.getSelectionModel().select(0);
		choices.setPrefSize(90, 30);
		
		//note how the change listener is attached using a lambda and then a helper method selectionChangeHandler (see below)  is called
		choices.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selectionChangeHandler(newValue));

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

	//A private helper method used for the selection change handler.
	//This is another approach when defining event handlers - to use a lambda when
	//attaching (see above) and then call a private method which defines the handler's logic.
	private void selectionChangeHandler(String newValue) {
		if (newValue.equals("Both")) {
			viewRoot.displayPanes("both");
		} else if (newValue.equals("Outward")) {
			viewRoot.displayPanes("outward");
		} else if (newValue.equals("Return")) {
			viewRoot.displayPanes("return");
		}
	}

	//these named inner-class event handlers that use the viewRoot and model references
	private class ClearHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			if (getSelectedChoice().equals("Both")) {

				viewRoot.getOutwardPane().setDefaultInputs();
				viewRoot.getReturnPane().setDefaultInputs();

			} else if (getSelectedChoice().equals("Outward")) {

				viewRoot.getOutwardPane().setDefaultInputs();

			} else if (getSelectedChoice().equals("Return")) {

				viewRoot.getReturnPane().setDefaultInputs();

			}	
		}
	}

	private class SubmitHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			model.setOutJourney(viewRoot.getOutwardPane().getJourneyDetails());
			model.setReturnJourney(viewRoot.getReturnPane().getJourneyDetails());

			viewRoot.fadeAnimation(); //invokes an animation in the view to give the user visual feedback

			viewRoot.getOutwardPane().setDefaultInputs();
			viewRoot.getReturnPane().setDefaultInputs();
		}
	}

	private class RestoreHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			if (getSelectedChoice().equals("Both")) {

				viewRoot.getOutwardPane().setJourneyDetails(model.getOutJourney());
				viewRoot.getReturnPane().setJourneyDetails(model.getReturnJourney());

			} else if (getSelectedChoice().equals("Outward")) {

				viewRoot.getOutwardPane().setJourneyDetails(model.getOutJourney());

			} else if (getSelectedChoice().equals("Return")) {

				viewRoot.getReturnPane().setJourneyDetails(model.getReturnJourney());

			}

			viewRoot.fadeAnimation(); //invokes an animation in the view to give the user visual feedback
		}
	}

}
