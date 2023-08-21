package controls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FXControlsRootPane extends FlowPane{

	public FXControlsRootPane() {
		/*
		 * This pane is a FlowPane with left to right layout (by default),
		 * and horizontal and vertical gaps between its children (set as
		 * parameters)
		 */
		//set this FlowPane's properties
		this.setHgap(20);
		this.setVgap(20);
		this.setPrefWrapLength(600);
		this.setPadding(new Insets(20)); // create a 20px margin between
		// flowpane and the window
		this.setBackground(new Background(new BackgroundFill(Color.BISQUE, null, null)));


		/*=== Create and add example UI control children to this pane======*/

		// --------Label------------------------------
		Label lb = new Label("Hello");
		lb.setFont(Font.font("Calibri", 24));
		lb.setTextFill(Color.BLUE);
		this.getChildren().add(lb);

		// --------TextField---------------------------
		TextField tf = new TextField();
		tf.setEditable(true); // try false
		tf.setText("Type in here");
		tf.setAlignment(Pos.CENTER_RIGHT);
		tf.setTooltip(new Tooltip("An editable text field"));
		this.getChildren().add(tf);

		// --------Button------------------------------
		Button btn = new Button("Big button");
		btn.setTooltip(new Tooltip("Press me"));
		btn.setPrefSize(100, 50);
		this.getChildren().add(btn);

		// ------A Pane with a Text field and a Button----------
		HBox hbox = new HBox(8); // spacing 8
		hbox.setPadding(new Insets(10));
		Tooltip.install(hbox, new Tooltip("A HBox pane with a Textfield and a Button"));

		hbox.setBorder(new Border(
				new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderStroke.MEDIUM))); // add
		// a
		// border
		hbox.setBackground(new Background(new BackgroundFill(Color.CYAN, new CornerRadii(10), null)));

		hbox.getChildren().addAll(new TextField("A TextField in a Panel"), new Button("Button"));
		this.getChildren().add(hbox);

		// --------ComboBox------------------------------
		ObservableList<String> choices 
		= FXCollections.observableArrayList(
				"A choice", "B choice", "C choice", "D choice", 
				"E choice", "F choice", "G choice", "H choice"
				);
		ComboBox<String> combo = new ComboBox<>(choices);
		combo.setTooltip(new Tooltip("Select an item"));
		combo.setItems(choices);
		combo.getSelectionModel().select(2); // sets the initial choice
		combo.setVisibleRowCount(5);		
		this.getChildren().add(combo);


		// --------Slider------------------------------
		Slider slider = new Slider();
		slider.setOrientation(Orientation.VERTICAL);
		slider.setMax(212);
		slider.setMin(-32);
		slider.setMajorTickUnit(50);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setPrefHeight(120);// .setPrefSize(20, 100);
		slider.setMaxHeight(Control.USE_PREF_SIZE);
		slider.setValue(100);

		this.getChildren().add(slider);

		// --------ListView--------------------------------
		ObservableList<String> names 
		= FXCollections.observableArrayList(
				"Mercury", "Venus", "Earth", "Mars", "Jupiter",
				"Saturn", "Uranus", "Neptune", "Pluto"
				);
		ListView<String> listView = new ListView<>(names);
		listView.setPrefSize(80, 100);
		listView.setMaxHeight(Control.USE_PREF_SIZE);
		listView.getSelectionModel().select(4);
		listView.scrollTo(5);
		this.getChildren().add(listView);

		// --------CheckBox------------------------------
		CheckBox one = new CheckBox("one");
		CheckBox two = new CheckBox("two");
		one.setSelected(true);
		two.setIndeterminate(true);
		HBox hbox1 = new HBox(10);
		hbox1.setAlignment(Pos.CENTER);
		hbox1.getChildren().add(one);
		hbox1.getChildren().add(two);
		this.getChildren().add(hbox1);


		// --------RadioButtons in a ToggleGroup-----------------
		RadioButton small= new RadioButton("small");
		RadioButton medium= new RadioButton("medium");
		RadioButton large= new RadioButton("large");

		ToggleGroup group = new ToggleGroup();
		small.setToggleGroup(group);
		medium.setToggleGroup(group);
		large.setToggleGroup(group);

		medium.setSelected(true);

		VBox vbox = new VBox(8); // spacing 8
		vbox.setPadding(new Insets(10));
		Tooltip.install(vbox, new Tooltip("Select Size"));

		vbox.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));

		vbox.getChildren().addAll(small, medium, large);
		vbox.setPrefHeight(100);
		vbox.setMaxHeight(Control.USE_PREF_SIZE);

		TitledPane tpane = new TitledPane("Size", vbox);
		tpane.setCollapsible(false);
		tpane.setBorder(new Border(
				new BorderStroke(null, BorderStrokeStyle.SOLID, null, null))); // add

		this.getChildren().add(tpane);

		// --------TextArea----------------------------
		TextArea textarea = new TextArea("Type\nin\nhere");
		textarea.setPrefColumnCount(15);
		textarea.setPrefHeight(100);
		this.getChildren().add(textarea);

	}
}