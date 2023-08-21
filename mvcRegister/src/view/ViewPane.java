package view;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
import model.Name;


public class ViewPane extends StackPane {

	private ListView<Name> listView;
	private ObservableList<Name> names;
	
	public ViewPane() {
		names = FXCollections.observableArrayList();
		listView = new ListView<>(names);
		
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		listView.setPrefSize(200, 150);
		
		this.getChildren().add(listView);
	}
	
	//public interface for this pane
	public void addName(Name name) {
		names.add(name);
		this.clearSelection();
	}
	
	public ObservableList<Name> getContents() {
		return names;
	}
	
	public void clearNames() {
		names.clear();
	}
	
	public Name getSelectedItem() {
		return listView.getSelectionModel().getSelectedItem();
	}
	
	public ObservableList<Name> getSelectedItems() {
		return listView.getSelectionModel().getSelectedItems();
	}
	
	public void removeSelectedName() {
		int index = listView.getSelectionModel().getSelectedIndex();
		
		if (index != -1) {
			names.removeAll(this.getSelectedItems());
			this.clearSelection();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Selection Error");
			alert.setContentText("Please select an item to remove.");
			alert.showAndWait();
		}
	}
	
	public void clearSelection() {
		listView.getSelectionModel().clearSelection();
	}
	
}
