
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application{
	
	Stage window;
	Scene scene;
	AddProductScene addProductScene;
	DeleteScene deletescene;
	SearchScene searchscene;
	 // launch the application
    public void start(Stage primaryStage)
    {
    	window = primaryStage;
        // set title for the stage
    	addProductScene = new AddProductScene();
    	addProductScene.setWindow(this.window);
    	deletescene = new DeleteScene();
    	deletescene.setWindow(this.window);
    	searchscene = new SearchScene();
    	searchscene.setWindow(this.window);
    	
    	Menu productsMenu = new Menu("Products");
    	Menu productSubMenu = new Menu("Product");
    	
    	MenuItem addItem = new MenuItem("Add");
    	addItem.setOnAction(e-> window.setScene(addProductScene.display()));
    	
    	MenuItem searchItem = new MenuItem("Search");
    	searchItem.setOnAction(e-> window.setScene(searchscene.display()));
    	
    	MenuItem deleteItem = new MenuItem("Delete");
    	deleteItem.setOnAction(e-> window.setScene(deletescene.display()));
    	
    	MenuItem exitItem = new MenuItem("Exit");
    	exitItem.setOnAction(e-> window.close());
    	
    	productSubMenu.getItems().addAll(addItem,searchItem,deleteItem);
    	productsMenu.getItems().addAll(productSubMenu,exitItem);
    	
    	MenuBar menuBar = new MenuBar();
    	menuBar.getMenus().add(productsMenu);
        
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(menuBar);
        scene = new Scene(layout1,400,400);
        
        window.setScene(scene);
        window.setTitle("Title of the window");
        window.show();
  
    }


	public static void main(String[] args) {

        // launch the application
        launch(args);
	}


}
