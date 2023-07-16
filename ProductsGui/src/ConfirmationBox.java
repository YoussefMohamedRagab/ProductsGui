import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmationBox {
	boolean result = false;
	
	public boolean display(String Title,String message) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(Title);
		window.setMinWidth(350);
		window.setMaxHeight(150);
		
		Label label = new Label();
		label.setText(message);
		
		Button yes_button = new Button("Yes");
		yes_button.setOnAction(e->{
			result = true;
			window.close();
		});
		
		Button no_button = new Button("No");
		no_button.setOnAction(e->{
			result = false;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label,yes_button,no_button);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return result;
	}
	
}
