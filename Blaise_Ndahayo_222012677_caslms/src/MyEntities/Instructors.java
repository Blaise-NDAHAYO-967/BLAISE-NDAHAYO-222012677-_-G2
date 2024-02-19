package MyEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Instructors {//InstructorID	InstructorName	ContactInfo
	private int instrctid;
	private String instrctname;
	private String cntctinfo;
	
	public Instructors() {
	    // Default constructor
	}
	public Instructors(int instrctid,String instrctname,String cntctinfo) {
		super();
		this.instrctid=instrctid;
		this.instrctname=instrctname;
		this.cntctinfo=cntctinfo;
		}
	
	public int getInstrctid() {
		return instrctid;
	}
	public void setInstrctid(int instrctid) {
		this.instrctid = instrctid;
	}
	public String getInstrctname() {
		return instrctname;
	}
	public void setInstrctname(String instrctname) {
		this.instrctname = instrctname;
	}
	public String getCntctinfo() {
		return cntctinfo;
	}
	public void setCntctinfo(String cntctinfo) {
		this.cntctinfo = cntctinfo;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/cas_lms";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO instructors (InstructorName,	ContactInfo) VALUES (?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.instrctname);
	       preparedStatement.setString(2, this.cntctinfo);
	       
	      // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	 
	
    public static ResultSet viewData() {
        String host = "jdbc:mysql://localhost/cas_lms";
        String user = "root";
        String password = "";

        String sql = "SELECT * FROM instructors";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
public void update(int inputinstrctid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/cas_lms";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE instructors SET InstructorName=?,	ContactInfo=?  WHERE InstructorID = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getInstrctname());
	          stm.setString(2, this.getCntctinfo());
	          
	          // Assuming there is a column named 'id' for the WHERE clause
	        
	          stm.setInt(3, inputinstrctid);
	         
	          // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputinstrctid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/cas_lms";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM instructors WHERE InstructorID= ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputinstrctid); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	}
}








