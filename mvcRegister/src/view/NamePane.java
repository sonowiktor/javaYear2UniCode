package view;

import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import model.Name;

public class NamePane extends GridPane {

	private ComboBox<String> cboTitle;
	private TextField txtSurname, txtFirstName;

	public NamePane() {
		//styling
		this.setPadding(new Insets(20, 20, 20, 20));
		this.setVgap(15);
		this.setHgap(20);
		this.setStyle("-fx-background-color: #EBF6FF;");
		this.setBorder(new Border(new BorderStroke(Color.web("#DADADA"), BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
		this.setAlignment(Pos.CENTER);

		ColumnConstraints column0 = new ColumnConstraints();
		column0.setHalignment(HPos.RIGHT);

		ColumnConstraints column1 = new ColumnConstraints();
		column1.setHgrow(Priority.ALWAYS);

		this.getColumnConstraints().addAll(column0, column1);

		//create labels
		Label lblTitle = new Label("Title");
		Label lblFirstName = new Label("First name");
		Label lblSurname = new Label("Surname");

		// setup combobox
		ObservableList<String> titles = FXCollections.observableArrayList("Mr", "Mrs", "Miss", "Ms", "Dr");
		cboTitle = new ComboBox<String>(titles);
		cboTitle.getSelectionModel().select(0);
		cboTitle.setVisibleRowCount(4);

		// setup text fields
		txtFirstName = new TextField();
		txtSurname = new TextField();

		//add controls and labels to container
		this.add(lblTitle, 0, 0);
		this.add(cboTitle, 1, 0);

		this.add(lblFirstName, 0, 1);
		this.add(txtFirstName, 1, 1);

		this.add(txtSurname, 1, 2);
		this.add(lblSurname, 0, 2);
	}

	/* a method that returns a boolean binding based upon either textfield being empty */
	public BooleanBinding isEitherFieldEmpty() {
		return txtFirstName.textProperty().isEmpty().or(txtSurname.textProperty().isEmpty());
	}

	//clear the input fields
	public void clear() {
		cboTitle.getSelectionModel().selectFirst();
		txtFirstName.setText("");
		txtSurname.setText("");
	}

	//returns a name object based on the input fields
	public Name getNameInput() {
		String title = cboTitle.getSelectionModel().getSelectedItem();
		String fName =  txtFirstName.getText();
		String lName = txtSurname.getText();
		return new Name(title, fName, lName);
	}

}
