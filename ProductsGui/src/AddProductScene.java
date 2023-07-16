
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.*;

public class AddProductScene implements  EventHandler<ActionEvent>{
	
	ChoiceBox<String> choicebox;
	TextField model_text,price_text;
	Label label1;
	Slider count_slider;
	DatePicker datepicker;
	addProduct addproduct;
	private Stage window;
	
	public Stage getWindow() {
		return window;
	}

	public void setWindow(Stage window) {
		this.window = window;
	}

	public  Scene display(){
		
		window.setTitle("AddProduct");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		label1 = new Label("");
		GridPane.setConstraints(label1, 1, 7);
		
		Button back_btn = new Button("Back");
		GridPane.setConstraints(back_btn, 0, 20);
		back_btn.setOnAction(e->{
			Main menu = new Main();
			menu.start(this.window);
		});
		
		Label type_label = new Label("Type: ");
		GridPane.setConstraints(type_label, 0, 1);
		
		choicebox = new ChoiceBox<>();
		choicebox.getItems().addAll("Television","Fridge","Microwave","Washing machine","Dryer");
		GridPane.setConstraints(choicebox, 1, 1);
		
		Label model_label = new Label("Model: ");
		GridPane.setConstraints(model_label, 0, 2);
		
		model_text = new TextField();
		GridPane.setConstraints(model_text, 1, 2);
		
		Label price_label = new Label("Price: ");
		GridPane.setConstraints(price_label, 0, 3);
		
		
		price_text = new TextField();
		GridPane.setConstraints(price_text, 1, 3);
		
		Label count_label = new Label("Count: ");
		GridPane.setConstraints(count_label, 0, 4);
		
		count_slider = new Slider(1,10,0);
		count_slider.setBlockIncrement(1);
		count_slider.setMajorTickUnit(1);
		count_slider.setMinorTickCount(0);
		count_slider.setShowTickLabels(true);
		count_slider.setSnapToTicks(true);
		GridPane.setConstraints(count_slider, 1, 4);
		
		Label delivery_label = new Label("Delivery Date: ");
		GridPane.setConstraints(delivery_label, 0, 5);
		
		datepicker = new DatePicker();
		GridPane.setConstraints(datepicker, 1, 5);
		
		Button save_btn = new Button("Save");
		save_btn.setOnAction(this);
		GridPane.setConstraints(save_btn, 1, 6);
		
		grid.getChildren().addAll(label1,type_label,choicebox,model_label,model_text,price_label,price_text);
		grid.getChildren().addAll(count_label,count_slider,delivery_label,datepicker,save_btn,back_btn);
		
		Scene scene = new Scene(grid,400,400);
		return scene;
		
		
	}

	@Override
	public void handle(ActionEvent arg0) {
		addproduct = new addProduct();
		Validator validator = new Validator();
		String type = choicebox.getValue();
		String model = model_text.getText();
		if(validator.validate_price(price_text.getText())) {
			float price = Float.parseFloat(price_text.getText());
			int count = (int)count_slider.getValue();
			if(validator.validate_model(model) && validator.validate_type(type) &&datepicker.getValue() != null &&validator.validate_date(datepicker.getValue())) {
				boolean result =addproduct.addAndSaveProduct(choicebox.getValue(),model_text.getText() ,Float.parseFloat(price_text.getText()),(int)count_slider.getValue(), datepicker.getValue());		
				if(result) {
					AlertBox.display("Adding a product", "Product was Successfully added to the database.");	
				}else {
					AlertBox.display("Adding a product", "Something Gone Wrong While adding to the database.");
				}
			}
			else {
				label1.setText("Please recheck the data entered.");
			}
		}else {
			label1.setText("Price must be a positive number.");
		}
		
	}

}
