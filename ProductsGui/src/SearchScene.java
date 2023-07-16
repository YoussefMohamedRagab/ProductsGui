import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchScene {
	
private Stage window;
searchProduct searchproduct;
	
	public Stage getWindow() {
		return window;
	}

	public void setWindow(Stage window) {
		this.window = window;
	}
	
	public Scene display() {
		window.setTitle("Products");

		Label label1 = new Label("Type or Model: ");
		TextField search_text = new TextField();
		search_text.setPromptText("write type or model");
		Button back_btn = new Button("Back");
		back_btn.setOnAction(e->{
			Main menu = new Main();
			menu.start(this.window);
		});
		
		
		TableView<Product> table;
		
		TableColumn<Product, Integer> idColumn = new TableColumn<>("ID");
		idColumn.setMaxWidth(150);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Product, String> typeColumn = new TableColumn<>("Type");
		typeColumn.setMinWidth(150);
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
		
		TableColumn<Product, String> modelColumn = new TableColumn<>("Model");
		modelColumn.setMinWidth(150);
		modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
		
		TableColumn<Product, Float> priceColumn = new TableColumn<>("Price");
		priceColumn.setMinWidth(150);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		TableColumn<Product, Integer> countColumn = new TableColumn<>("Count");
		countColumn.setMaxWidth(150);
		countColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
		
		TableColumn<Product, Date> dateColumn = new TableColumn<>("DeliveryDate");
		dateColumn.setMinWidth(150);
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("delivery_date"));
		
		table = new TableView<>();

		table.getColumns().addAll(idColumn,typeColumn,modelColumn,priceColumn,countColumn,dateColumn);
		
		Button button = new Button("Search");
		button.setOnAction(e->{
			String search_by = search_text.getText();
			if(search_by.length()==0 || search_by.equalsIgnoreCase(" ")) {
				table.setItems(getProduct());
			}else {
				table.setItems(getProductBySearch(search_by));
			}
		});
		

		HBox hbox = new HBox(8);
		hbox.getChildren().addAll(back_btn,label1,search_text,button);
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		hbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox,table);
		
		
		
		Scene scene = new Scene(vbox);
		return scene;
	}
	
	public ObservableList<Product> getProduct(){
		
		searchproduct = new searchProduct();
		ObservableList<Product> products = searchproduct.getAll();
		
		return products;
		
	}
public ObservableList<Product> getProductBySearch(String criteria){
		
		searchproduct = new searchProduct();
		ObservableList<Product> products = searchproduct.getBySearch(criteria);
		
		return products;
		
	}

}
