
package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.JourneyReturn;
import view.ButtonPane;
import view.JourneyInputPane;
import view.JourneyMenuBar;
import view.JourneyPlannerRootPane;


public class JourneyController {
	//declare fields to be used throughout class
	private JourneyReturn model;
	private JourneyPlannerRootPane view;
	private ButtonPane bp;
	private JourneyInputPane outwardJourney, returnJourney;
	private JourneyMenuBar journeyMenu;

	public JourneyController(JourneyPlannerRootPane view, JourneyReturn model) {
		//initialise model and view
		this.model = model;
		this.view = view;

		//initialise view subcontainer fields for convenient access to these
		outwardJourney = view.getOutwardPane();
		returnJourney = view.getReturnPane();
		bp = view.getButtonPane();
		journeyMenu = view.getMenuBar();

		//attach event handlers to view using private helper method
		this.attachEventHandlers();
	}

	private void attachEventHandlers() {
		//attach button and menu item handlers to the view, which can either be done as inner-classes or lambda expressions
		bp.addSubmitHandler(new SubmitHandler());
		bp.addClearHandler(new ClearHandler());
		bp.addRestoreHandler(new RestoreHandler());

		journeyMenu.addLoadHandler(new LoadMenuHandler());
		journeyMenu.addSaveHandler(new SaveMenuHandler());
		journeyMenu.addExitHandler(e -> System.exit(0)); //example of lambda expression event handler
		journeyMenu.addAboutHandler(e -> this.alertDialogBuilder("Information Dialog", null, "Journey Planner app v2.0")); //lambda uses internal dialog method - see end of class
		
		//example of adding a change listener to a property in the view - the lambda uses the private helper method below
		bp.addSelectionChangeListener((observable, oldValue, newValue) -> selectionChangeHandler(newValue));
	}
	
	//A private helper method used for the selection change handler.
	//This is another approach when defining event handlers - to use a lambda when
	//attaching and then call a private method which defines the handler's logic.
	private void selectionChangeHandler(String newValue) {
		if (newValue.equals("Both")) {
			view.displayPanes("both");
		} else if (newValue.equals("Outward")) {
			view.displayPanes("outward");
		} else if (newValue.equals("Return")) {
			view.displayPanes("return");
		}
	}

	//event handlers are now all inside of the controller - below are inner-class implementations
	private class SubmitHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			model.setOutJourney(outwardJourney.getJourneyDetails());
			model.setReturnJourney(returnJourney.getJourneyDetails());

			view.fadeAnimation(); //invokes an animation in the view to give the user visual feedback
			
			outwardJourney.setDefaultInputs();
			returnJourney.setDefaultInputs();
		}
	}

	private class ClearHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			if (bp.getSelectedChoice().equals("Both")) {

				outwardJourney.setDefaultInputs();
				returnJourney.setDefaultInputs();

			} else if (bp.getSelectedChoice().equals("Outward")) {

				outwardJourney.setDefaultInputs();

			} else if (bp.getSelectedChoice().equals("Return")) {

				returnJourney.setDefaultInputs();

			}	
		}
	}

	private class RestoreHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			if (bp.getSelectedChoice().equals("Both")) {

				outwardJourney.setJourneyDetails(model.getOutJourney());
				returnJourney.setJourneyDetails(model.getReturnJourney());

			} else if (bp.getSelectedChoice().equals("Outward")) {

				outwardJourney.setJourneyDetails(model.getOutJourney());

			} else if (bp.getSelectedChoice().equals("Return")) {

				returnJourney.setJourneyDetails(model.getReturnJourney());

			}
			
			view.fadeAnimation(); //invokes an animation in the view to give the user visual feedback
		}
	}

	private class LoadMenuHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			//load in the data model
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("journeyObj.dat"));) {
				
				model = (JourneyReturn) ois.readObject(); //reads the model object back from a file	
				
				alertDialogBuilder("Information Dialog", "Load success", "Journey Return loaded from journeyObj.dat");
				view.fadeAnimation(); //invokes an animation in the view to give the user visual feedback
	        }
	        catch (IOException ioExcep){
	            System.out.println("Error loading");
	        }
			catch (ClassNotFoundException c) {
	            System.out.println("Class Not found");
	        }	

			//refresh the view
			outwardJourney.setJourneyDetails(model.getOutJourney());
			returnJourney.setJourneyDetails(model.getReturnJourney());
		}
	}

	private class SaveMenuHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {          
			//save the data model
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("journeyObj.dat"));) {

				oos.writeObject(model); //writes the model object to a file
				oos.flush();
				
				alertDialogBuilder("Information Dialog", "Save success", "Journey Return saved to journeyObj.dat");
				view.fadeAnimation(); //invokes an animation in the view to give the user visual feedback
			}
			catch (IOException ioExcep){
				System.out.println("Error saving");
			}
		}
	}

	
	//helper method to build dialogs
	private void alertDialogBuilder(String title, String header, String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle(title);
    	alert.setHeaderText(header);
    	alert.setContentText(content);
    	alert.showAndWait();
	}

}
