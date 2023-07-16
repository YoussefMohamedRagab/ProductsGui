

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class searchProduct {

	// Defining our Database Variables
	private String url = "jdbc:mysql://localhost:3306/productsdb_mohamed";
	private String username = "root";
	private String password = "eljoe2010";
	private String query = null;
	//Defining our choice for search criteria , string to look for , scanners for inputs

	public ObservableList<Product> getAll() {
		ObservableList<Product> products = FXCollections.observableArrayList();
		try {
			//We start by checking for jdbc driver if present
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Make our connection with the database with predefined parameters
			Connection conn = DriverManager.getConnection(url, username, password);
			
			query = "SELECT * FROM productstbl_youssef";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
	        ResultSet result_set = pstmt.executeQuery();
	        
	        while(result_set.next()) {
	        	int id= result_set.getInt(1);
	        	String type= result_set.getString(2);
	        	String model = result_set.getString(3);
	        	float price = result_set.getFloat(4);
	        	int count = result_set.getInt(5);
	        	Date delivery_date = result_set.getDate(6);
	        	
	        	Product temp = new Product(id, type, model, price, count, delivery_date);
	        	products.add(temp);
	        }
	        	
		}  catch (SQLException e) {
            System.out.println("\nThe search failed due to an error: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("\nError: Unable to load driver class! ");
        }
		
		return products;
		
	}
	public ObservableList<Product> getBySearch(String criteria) {
		ObservableList<Product> products = FXCollections.observableArrayList();
		try {
			//We start by checking for jdbc driver if present
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Make our connection with the database with predefined parameters
			Connection conn = DriverManager.getConnection(url, username, password);
			
			query = "SELECT * FROM productstbl_youssef where type like '%"+ criteria +"%' OR model like '%"+criteria +"%'";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
	        ResultSet result_set = pstmt.executeQuery();
	        
	        while(result_set.next()) {
	        	int id= result_set.getInt(1);
	        	String type= result_set.getString(2);
	        	String model = result_set.getString(3);
	        	float price = result_set.getFloat(4);
	        	int count = result_set.getInt(5);
	        	Date delivery_date = result_set.getDate(6);
	        	
	        	Product temp = new Product(id, type, model, price, count, delivery_date);
	        	products.add(temp);
	        }
		}catch (SQLException e) {
            System.out.println("\nThe search failed due to an error: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("\nError: Unable to load driver class! ");
        }
		
		return products;
		
	}
	
}
