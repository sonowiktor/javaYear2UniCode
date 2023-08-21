
package view;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCombination;
import model.JourneyReturn;


/* A menubar for the journey planner with common options */
public class JourneyMenuBar extends MenuBar {

	//declared for access throughout class
	private JourneyPlannerRootPane viewRoot;
	private JourneyReturn model;

	//note the references accepted to the parent root pane and the model - to be usd by event handlers
	public JourneyMenuBar(JourneyPlannerRootPane viewRoot, JourneyReturn model) {      

		//initialise the view and model in this class with the accepted parameter references
		this.viewRoot = viewRoot;
		this.model = model;

		//temp var for menus within this MenuBar
		Menu menu;

		//----------Build the first menu on the menu bar.--------------------
		menu = new Menu("_File");

		//define and add the 'Load' menu item
		MenuItem loadItem = new MenuItem("_Load Journey Data");
		loadItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+L"));
		loadItem.setOnAction(new LoadMenuHandler());
		menu.getItems().add(loadItem);

		//'Save' menu item
		MenuItem saveItem = new MenuItem("_Save Journey Data");
		saveItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+S"));
		saveItem.setOnAction(new SaveMenuHandler());
		menu.getItems().add(saveItem);

		//...add a separator
		menu.getItems().add( new SeparatorMenuItem());


		//... add an 'Exit' item
		MenuItem exitItem = new MenuItem("E_xit");
		exitItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+X"));
		exitItem.setOnAction(e -> System.exit(0));
		menu.getItems().add(exitItem);

		this.getMenus().add(menu); //add the menu to this menubar


		//----------Build the second menu on the menu bar.--------------------
		menu = new Menu("_Help");

		//'About' menu item
		MenuItem aboutItem = new MenuItem("_About");
		aboutItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+A"));
		aboutItem.setOnAction(e -> this.alertDialogBuilder("Information Dialog", null, "Journey Planner app v1.0"));
		menu.getItems().add(aboutItem);

		this.getMenus().add(menu); //add the menu to this menubar
	}

	//helper method to build dialogs
	private void alertDialogBuilder(String title, String header, String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

	//these named inner-class event handlers use the model and view references
	private class LoadMenuHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			//load in the data model
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("journeyObj.dat"));) {

				model = (JourneyReturn) ois.readObject(); //reads the model object back from a file	
				
				alertDialogBuilder("Information Dialog", "Load success", "Journey Return loaded from journeyObj.dat");
				viewRoot.fadeAnimation(); //invokes an animation in the view to give the user visual feedback
			}
			catch (IOException ioExcep){
				System.out.println("Error loading");
			}
			catch (ClassNotFoundException c) {
				System.out.println("Class Not found");
			}

			//refresh the view
			viewRoot.getOutwardPane().setJourneyDetails(model.getOutJourney());
			viewRoot.getReturnPane().setJourneyDetails(model.getReturnJourney());
		}
	}

	private class SaveMenuHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {          
			//save the data model
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("journeyObj.dat"));) {

				oos.writeObject(model); //writes the model object to a file
				oos.flush();

				alertDialogBuilder("Information Dialog", "Save success", "Journey Return saved to journeyObj.dat");
				viewRoot.fadeAnimation(); //invokes an animation in the view to give the user visual feedback
			}
			catch (IOException ioExcep){
				System.out.println("Error saving");
			}
		}
	}

}
