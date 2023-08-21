package layouts;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class LayoutMenu extends Menu {
	
	public LayoutMenu(String name) {
		//set the name for this menu
		this.setText(name);
		
		//temp vars for submenus within this JMenu
		Menu submenu;
		MenuItem menuItem;
        
		String[] labels = 
			{"AnchoPane", "BorderPane", "FlowPane",
			 "GridPane", "HBox", "TilePane", "VBox"};
		
		for(int i=0; i<labels.length; i++) {
			menuItem = new MenuItem(labels[i]);
			this.getItems().add(menuItem);
		}
		
		 //...add a separator
        this.getItems().add( new SeparatorMenuItem());
		
		// control panes menu within this menu
        submenu = new Menu("ControlPane...");
        
        menuItem = new MenuItem("Accordion");
        submenu.getItems().add(menuItem);

        menuItem = new MenuItem("SplitPane");
        submenu.getItems().add(menuItem);
        
        menuItem = new MenuItem("TabPane");
        submenu.getItems().add(menuItem);
        
        this.getItems().add(submenu);
        
	}
}
