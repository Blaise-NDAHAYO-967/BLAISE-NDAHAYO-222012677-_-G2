package MyEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Submission {//	SubmissionID	AssignmentID	student_id	SubmissionDate	FilePath
	private int sbmid;
	private String assgnid;
	private String stid;
	private String sbmdate;
	private String filpath;
	
	public Submission() {
	    // Default constructor
	}
	public Submission(int sbmid,String assgnid,String stid,String sbmdate,String filpath) {
		super();
		this.sbmid=sbmid;
		this.assgnid=assgnid;
		this.stid=stid;
		this.sbmdate=sbmdate;
		this.filpath=filpath;
	}
	
	public int getSbmid() {
		return sbmid;
	}
	public void setSbmid(int sbmid) {
		this.sbmid = sbmid;
	}
	public String getAssgnid() {
		return assgnid;
	}
	public void setAssgnid(String assgnid) {
		this.assgnid = assgnid;
	}
	public String getStid() {
		return stid;
	}
	public void setStid(String stid) {
		this.stid = stid;
	}
	public String getSbmdate() {
		return sbmdate;
	}
	public void setSbmdate(String sbmdate) {
		this.sbmdate = sbmdate;
	}
	public String getFilpath() {
		return filpath;
	}
	public void setFilpath(String filpath) {
		this.filpath = filpath;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/cas_lms";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO submissions (AssignmentID,	student_id,	SubmissionDate,	FilePath) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.assgnid);
	       preparedStatement.setString(2, this.stid);
	       preparedStatement.setString(3, this.sbmdate);
	       preparedStatement.setString(4, this.filpath);
	     
	        
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

        String sql = "SELECT * FROM submissions";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
public void update(int inputsbmid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/cas_lms";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE submissions SET AssignmentID=?,	student_id=?,	SubmissionDate=?,	FilePath=?  WHERE SubmissionID	= ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getAssgnid());
	          stm.setString(2, this.getStid());
	          stm.setString(3, this.getSbmdate());
	          stm.setString(4, this.getFilpath());
	          // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(5, inputsbmid);
	       
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
	public void delete(int inputsbmid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/cas_lms";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM submissions WHERE SubmissionID	= ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputsbmid); // Assuming there is a column named 'id' for the WHERE clause

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






