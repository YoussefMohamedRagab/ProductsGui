import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DeleteScene {

	private Stage window;
	deleteProduct deleteproduct;
	
	public Stage getWindow() {
		return window;
	}

	public void setWindow(Stage window) {
		this.window = window;
	}

	public Scene display() {
		
		window.setTitle("Delete Product");
		
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		Label label1 = new Label("Product Id: ");
		GridPane.setConstraints(label1, 1, 0);
		
		Button back_btn = new Button("Back");
		GridPane.setConstraints(back_btn, 0, 32);
		back_btn.setOnAction(e->{
			Main menu = new Main();
			menu.start(this.window);
		});
		
		Label label2 = new Label("");
		GridPane.setConstraints(label2, 1, 3);
		
		TextField id_text = new TextField();
		GridPane.setConstraints(id_text, 1, 1);
		
		Button delete_btn = new Button("Delete");
		delete_btn.setOnAction(e->{
			Validator validator = new Validator();
			if(validator.validate_id(id_text.getText())) {
				deleteproduct = new deleteProduct();
				boolean is_found = deleteproduct.find_product(Integer.parseInt(id_text.getText()));
				if(is_found) {
					ConfirmationBox confirmbox = new ConfirmationBox();
					boolean result =confirmbox.display("Confirm Deletion", "Are Yo sure you want to delete this product?");
					if(result) {
						boolean done =deleteproduct.delete_product(Integer.parseInt(id_text.getText()));
						if(done)
							label2.setText("Product deleted successfully");
						else
							label2.setText("Product was not deleted..");
						
					}else {
						label2.setText("Deletion Cancelled..");
					}
				}else {
					label2.setText("Product with such id does not exists.");
				}
			}
			else {
				label2.setText("Not a valid input..");
			}
			
			
			
		});
		GridPane.setConstraints(delete_btn, 1, 2);
		
		grid.getChildren().addAll(label1,id_text,delete_btn,label2,back_btn);
		Scene scene = new Scene(grid,400,400);
		
		return scene;
		
		
		
	}
}
