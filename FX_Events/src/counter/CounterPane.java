package counter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class CounterPane extends HBox {

	private TextField tf;
	
	public CounterPane() {
		this.setPadding(new Insets(10));
		this.setSpacing(30);
		
		
		Button minus = new Button("-");
		minus.setPrefSize(70, 30);
		minus.setOnAction(new MinusHandler());
		
		
		tf = new TextField("0");
		tf.setPrefSize(100, 30);
		tf.setAlignment(Pos.CENTER);
		tf.setEditable(false);
		
		
		Button plus = new Button("+");
		plus.setPrefSize(70, 30);
		plus.setOnAction(e -> tf.setText(String.valueOf(Integer.parseInt(tf.getText())+1)));
		
		
		Button reset = new Button("Reset");
		reset.setPrefSize(120, 30);
		reset.setOnAction(new ResetHandler());
		
		HBox spacer = new HBox();
		spacer.setPadding(new Insets(0,0,0,60));
		spacer.getChildren().add(reset);
		
		
		this.getChildren().addAll(minus, tf, plus, spacer);
		
	}
	
	private class MinusHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			tf.setText(String.valueOf(Integer.parseInt(tf.getText())-1));
		}
	}
	
	private class ResetHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			tf.setText("0");
		}
	}
	
}
