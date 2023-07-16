

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class deleteProduct {
	
	// Defining our Database Variables
	private String url = "jdbc:mysql://localhost:3306/productsdb_mohamed";
	private String username = "root";
	private String password = "eljoe2010";
	//here we need 2 queries first we check if the id is present so we can then run the second one to delete it
	private String select_query = "Select * FROM productstbl_youssef WHERE id = ?";
	private String delete_query = "DELETE FROM productstbl_youssef WHERE id = ?";
	
	
	public boolean find_product(int id) {
		
		try {
			//We start by checking for jdbc driver if present
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Make our connection with the database with predefined parameters
			Connection conn = DriverManager.getConnection(url, username, password);
			
			//Prepare our query by adding the id of product then execute
			PreparedStatement pstmt = conn.prepareStatement(select_query);
			pstmt.setInt(1, id);
			ResultSet result_set = pstmt.executeQuery();
			// Run our select query and check if there is a matching product
			// beforefirst returns false if there is no retrieved data
			if(!result_set.isBeforeFirst()) {
				// no matching records for this id
				return false;
			}
			result_set.close();
			pstmt.close();
			conn.close();

			return true;
		}catch (SQLException e) {
            System.out.println("\nProduct deletion failed due to an error: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("\nError: Unable to load driver class! ");
        } catch (InputMismatchException e) {
            System.out.println("\nThere was mismatch ");
        }
		return false;
		
	}
	
	public boolean delete_product(int id) {
		
		try {
			//We start by checking for jdbc driver if present
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Make our connection with the database with predefined parameters
			Connection conn = DriverManager.getConnection(url, username, password);
			
			PreparedStatement pstmt = conn.prepareStatement(delete_query);
			pstmt.setInt(1, id);
			int res = pstmt.executeUpdate();
			
			if(res == 1) {
				return true;
			}
			pstmt.close();
			conn.close();

			return false;
			
			
		}catch (SQLException e) {
            System.out.println("\nProduct deletion failed due to an error: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("\nError: Unable to load driver class! ");
        } catch (InputMismatchException e) {
            System.out.println("\nThere was mismatch ");
        }
		return false;
	}
	
		

}
