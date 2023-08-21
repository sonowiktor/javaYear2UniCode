package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import model.Name;
import model.Register;

import view.ButtonPane;
import view.NamePane;
import view.RegisterRootPane;
import view.ViewPane;
import view.RegisterMenuBar;


public class RegisterController {

	//fields to be used throughout the class
	private NamePane np;
	private ButtonPane bp;
	private ViewPane vp;
	private RegisterMenuBar rmb;
	private Register model;

	public RegisterController(RegisterRootPane view, Register model) {
		//initialise model and view fields
		this.model = model;

		np = view.getNamePane();
		bp = view.getButtonPane();
		vp = view.getViewPane();
		rmb = view.getMenuBar();

		//attach event handlers to view using private helper method
		this.attachEventHandlers();	

		//attach bindings within view using private helper method
		this.attachBindings();
	}

	private void attachEventHandlers() {
		//attaching event handlers
		bp.addAddHandler(new AddHandler());
		bp.addClearHandler(e -> np.clear());
		bp.addRemoveHandler(e -> vp.removeSelectedName()); //this will now also remove names in the model due to the bidirectional binding

		rmb.addLoadHandler(new LoadMenuHandler());
		rmb.addSaveHandler(new SaveMenuHandler());
		rmb.addExitHandler(e -> System.exit(0));
		rmb.addAboutHandler(e -> this.alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", null, "Register MVC app v3.0 with binding"));
		rmb.addIndividSelectHandler(e -> this.alertDialogBuilder(AlertType.CONFIRMATION, "Name Selected", null, "You selected " + vp.getSelectedItem()));
		rmb.addMultiSelectHandler(e -> this.alertDialogBuilder(AlertType.CONFIRMATION, "Name Selecteds", null, "You selected " + vp.getSelectedItems()));
	}

	/* this method attaches bindings in the view, e.g. for validation, and to the model to ensure synchronisation between the data model and view */
	private void attachBindings() {
		//attaches a binding such that the add button in the view will be disabled whenever either of the text fields in the NamePane are empty
		bp.addBtnDisableBind(np.isEitherFieldEmpty());

		//Binds model's register collection and view's listview display bidirectionally.
		//If either is updated then the other will automatically mirror these updates.
		//In this case it means we can remove the submit button and all associated functionality.
		model.bindContentBidirectional(vp.getContents());
	}

	private class AddHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {	
			//retrieves name from view
			Name n = np.getNameInput();

			//check input not empty
			if(n.getFirstName().equals("") || n.getFamilyName().equals("")) {
				//output error
				alertDialogBuilder(AlertType.ERROR, "Error Dialog", null, "Need to input both first and family name!");

			} else {
				//adds it to the model (due to binding, list view will get automatically updated)
				model.add(n);

				//resets name panel in view
				np.clear();
			}
		}
	}

	private class SaveMenuHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			//save the data model
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("registerObj.dat"));) {

				//write name objects individually as cannot serialize the observable list in register
				for (Name n : model) {
					oos.writeObject(n);
				}

				oos.writeObject(null);

				oos.flush();

				alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Save success", "Register saved to registerObj.dat");
			}
			catch (IOException ioExcep){
				System.out.println("Error saving");
			}
		}
	}

	private class LoadMenuHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			//load in the data model
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("registerObj.dat"));) {

				vp.clearNames(); //clear any existing names in view
				
				//read back in names objects individually
				Name n = null;

				while ((n = (Name) ois.readObject()) != null) {
					model.add(n);
				}	

				ois.close(); 
			}
			catch (IOException ioExcep){
				System.out.println("Error loading");
			}
			catch (ClassNotFoundException c) {
				System.out.println("Class Not found");
			}

			alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Load success", "Register loaded from registerObj.dat");
		}
	}

	//helper method to build dialogs
	private void alertDialogBuilder(AlertType type, String title, String header, String content) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

}
