package register;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;

/* A menu bar for the registration form providing common utilities */
public class RegisterMenuBar extends MenuBar {

	private ViewPane vp; //holds a reference to the view pane

	public RegisterMenuBar(ViewPane vp) { 

		this.vp = vp; //initialises view pane

		//temp vars for menus and menu items within this MenuBar
		Menu menu;
		MenuItem menuItem;

		//file menu
		menu = new Menu("_File");

		menuItem = new MenuItem("_Load");
		menuItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+L"));
		menuItem.setOnAction(new LoadHandler()); //attach event handler
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("_Save");
		menuItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+S"));
		menuItem.setOnAction(new SaveHandler()); //attach event handler
		menu.getItems().add(menuItem);

		menu.getItems().add( new SeparatorMenuItem());

		menuItem = new MenuItem("E_xit");
		menuItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+X"));
		menuItem.setOnAction(e -> System.exit(0)); //event handler to exit the application
		menu.getItems().add(menuItem);

		this.getMenus().add(menu);

		//show name(s) menu
		menu = new Menu("_Show name");

		menuItem = new MenuItem("_Individual selection");
		menuItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+I"));
		menuItem.setOnAction(new IndividualSelectionHandler());  //attach event handler  
		menu.getItems().add(menuItem); 

		menuItem = new MenuItem("_Multiple selection");
		menuItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+M"));
		menuItem.setOnAction(new MultipleSelectionHandler());  //attach event handler
		menu.getItems().add(menuItem); 

		this.getMenus().add(menu);     

		//help menu
		menu = new Menu("_Help");

		menuItem = new MenuItem("_About");
		menuItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+A"));
		menuItem.setOnAction(new AboutHandler()); //attach event handler
		menu.getItems().add(menuItem);

		this.getMenus().add(menu); 
	}

	//inner-class event handlers
	private class SaveHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			FileChooser fileChooser = new FileChooser();
			File file = fileChooser.showSaveDialog(null);
			if (file != null) {
				try {
					Files.write(file.toPath(), vp.getContents());
				} catch (IOException e1) {
					System.out.println("Error saving.");
				}            	
			}
		}
	}

	private class LoadHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			FileChooser fileChooser = new FileChooser();
			File file = fileChooser.showOpenDialog(null);
			if (file != null) {
				try {
					vp.clearNames();
					Files.readAllLines(file.toPath()).forEach(vp::addName);
				} catch (IOException e1) {
					System.out.println("Error loading.");
				}            	
			}
		}
	}

	private class AboutHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Registration app v2.0");
			alert.showAndWait();
		}
	}

	private class IndividualSelectionHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Name Selected");
			alert.setHeaderText(null);
			alert.setContentText("You selected " + vp.getSelectedItem());
			alert.showAndWait();
		}
	}

	private class MultipleSelectionHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Names Selected");
			alert.setHeaderText(null);
			alert.setContentText("You selected " + vp.getSelectedItems());
			alert.showAndWait();
		}
	}


}