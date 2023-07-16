

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.InputMismatchException;


public class addProduct {
	// Defining our Database Variables
	private String url = "jdbc:mysql://localhost:3306/productsdb_mohamed";
	private String username = "root";
	private String password = "eljoe2010";
	//get the insert query ready and we insert to it the obtained user variables
	private String query = "INSERT INTO productstbl_youssef (Type,Model,Price,Count,DeliveryDate) VALUES (?,?,?,?,?)";
	
	//Now Declaring our product variables to be inserted.
	private String product_type,product_model;
	private float price;
	private int count;
	private LocalDate delivery_date;
	
	
	
	public boolean addAndSaveProduct(String type,String model,float price, int count , LocalDate date) {
		this.product_type = type;
		this.product_model = model;
		this.price = price;
		this.count = count;
		this.delivery_date = date;
		try {
			
			//We start by checking for jdbc driver if present
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Make our connection with the database with predefined parameters
			Connection conn = DriverManager.getConnection(url, username, password);			
			
			Date  sql_date =  Date.valueOf(this.delivery_date);
			
			
			//Filling our sql query with the variables obtained from user
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, this.product_type);
			pstmt.setString(2, this.product_model);
			pstmt.setFloat(3, this.price);
			pstmt.setInt(4, this.count);
			pstmt.setDate(5, sql_date);
			
			//Now we Execute...
			int result = pstmt.executeUpdate();
			//the result is either 1 if query was success or 0 if not 
			if(result == 1) {
				System.out.println("Product is added Successfully...");
				return true;
			}
			else {
				System.out.println("Something Gone wrong...");
			}
			
			pstmt.close();
			conn.close();
			return false;
			
			
		} catch (SQLException e) {
            System.out.println("\nProduct addition failed due to an error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (InputMismatchException e) {
            System.out.println("\nThere was mismatch");
        }
		return false;
	}
}
