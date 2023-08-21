package view;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class RegisterRootPane extends BorderPane {

	private ButtonPane bp;
	private NamePane np;
	private ViewPane vp;
	private RegisterMenuBar rmb;
	
	public RegisterRootPane() {
		//background
		this.setStyle("-fx-background-color: #415D78;");
		
		np = new NamePane();
		vp = new ViewPane();
		bp = new ButtonPane();
		rmb = new RegisterMenuBar();
		
		VBox topContainer = new VBox(np, bp);
		topContainer.setSpacing(20); //spacing between np and bp
		topContainer.setPadding(new Insets(0,0,20,0)); //bottom padding between this container and vp
		
		BorderPane rootContainer = new BorderPane();
		rootContainer.setTop(topContainer);
		rootContainer.setCenter(vp);
		rootContainer.setPadding(new Insets(20,20,20,20)); //padding around the entire root container
		
		this.setTop(rmb);
		this.setCenter(rootContainer);
	}

	/* These methods provide a public interface for the root pane and allow
	 * each of the sub-containers to be accessed by the controller.
	 */
	public ButtonPane getButtonPane() {
		return bp;
	}

	public NamePane getNamePane() {
		return np;
	}

	public ViewPane getViewPane() {
		return vp;
	}
	
	public RegisterMenuBar getMenuBar() {
		return rmb;
	}
}
