
package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;


/* A menubar for the journey planner with common options */
public class JourneyMenuBar extends MenuBar {

	//declared for access throughout class, as handlers are now attached via methods
	private MenuItem loadItem, saveItem, exitItem, aboutItem;

	public JourneyMenuBar() {      

		//temp var for menus within this MenuBar
		Menu menu;

		//----------Build the first menu on the menu bar.--------------------
		menu = new Menu("_File");

		//define and add the 'Load' menu item
		loadItem = new MenuItem("_Load Journey Data");
		loadItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+L"));
		menu.getItems().add(loadItem);

		//'Save' menu item
		saveItem = new MenuItem("_Save Journey Data");
		saveItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+S"));
		menu.getItems().add(saveItem);

		//...add a separator
		 menu.getItems().add( new SeparatorMenuItem());


		//... add an 'Exit' item
		exitItem = new MenuItem("E_xit");
		exitItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+X"));
		menu.getItems().add(exitItem);
		
		this.getMenus().add(menu); //add the menu to this menubar


		//----------Build the second menu on the menu bar.--------------------
		menu = new Menu("_Help");

		//'About' menu item
		aboutItem = new MenuItem("_About");
		aboutItem.setAccelerator(KeyCombination.keyCombination("SHORTCUT+A"));
		menu.getItems().add(aboutItem);

		this.getMenus().add(menu); //add the menu to this menubar
	}

	//these methods allow handlers to be externally attached to this view by the controller
	public void addLoadHandler(EventHandler<ActionEvent> handler) {
		loadItem.setOnAction(handler);
	}
    
    public void addSaveHandler(EventHandler<ActionEvent> handler) {
  		saveItem.setOnAction(handler);
  	}
    
    public void addExitHandler(EventHandler<ActionEvent> handler) {
  		exitItem.setOnAction(handler);
  	}
    
    public void addAboutHandler(EventHandler<ActionEvent> handler) {
  		aboutItem.setOnAction(handler);
  	}

}
