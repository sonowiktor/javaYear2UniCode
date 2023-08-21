
package view;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/* The root of the journey planner, which creates subcontainers
 * and provides relevant access to other parts of the application.
 */
public class JourneyPlannerRootPane extends VBox {

	private ButtonPane bp;
	private JourneyInputPane outwardJourney; 
	private JourneyInputPane returnJourney;
	private JourneyMenuBar menuBar;
	
	public JourneyPlannerRootPane() {
	
		this.setStyle("-fx-background-color: #415D78;");
		
		bp = new ButtonPane();
		outwardJourney = new JourneyInputPane("Outward Journey");
		returnJourney = new JourneyInputPane("Return Journey");
		menuBar = new JourneyMenuBar();
		
		VBox rootContainer = new VBox(outwardJourney, returnJourney, bp);
		//set styling for main container
		rootContainer.setPadding(new Insets(10,10,10,10));
		rootContainer.setSpacing(20);

		//add the menu bar and root container
		this.getChildren().addAll(menuBar, rootContainer);
	}

	/* These methods provide a public interface for the root pane and allow
	 * each of the sub-containers to be accessed by the controller.
	 */
	public ButtonPane getButtonPane() {
		return bp;
	}

	public JourneyInputPane getOutwardPane() {
		return outwardJourney;
	}

	public JourneyInputPane getReturnPane() {
		return returnJourney;
	}
	
	public JourneyMenuBar getMenuBar() {
		return menuBar;
	}
	
	//method to hide/show panes and change background colour
	public void displayPanes(String type) {
		if (type.equalsIgnoreCase("outward")) {
			outwardJourney.setVisible(true);
			returnJourney.setVisible(false);
			this.setStyle("-fx-background-color: #123456;");
		} else if (type.equalsIgnoreCase("return")){
			returnJourney.setVisible(true);
			outwardJourney.setVisible(false);
			this.setStyle("-fx-background-color: #123456;");
		} else if (type.equalsIgnoreCase("both")) {
			returnJourney.setVisible(true);
			outwardJourney.setVisible(true);
			this.setStyle("-fx-background-color: #415D78;");
		}
	}
	
	//animation fade effects used by the controller to give visual feedback of certain operations
	public void fadeAnimation() {
		FadeTransition ft = new FadeTransition(Duration.millis(1000), this);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(2);
		ft.setAutoReverse(true);
		ft.play();
	}
	
}
