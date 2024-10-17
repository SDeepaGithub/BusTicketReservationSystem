package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		readRecords();
		//writeRecords();
		//writeRecordsUsingVariable();
		
		//deleteRecords();
		updateRecords();
	}
	
	public static void readRecords() throws SQLException{
		System.out.println("---------List of Records----------");
		//Use connection Interface To connect With database
		String url ="jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "rootuser";
		Connection con = DriverManager.getConnection(url, username, password);
		
		//create Statement for the Query Execution
		Statement st = con.createStatement();
		
		//Execute Query and Its an Resultset
		String query = "select * from employee";
		//It Return as resultSet So I Use resultSet object
		ResultSet rs =st.executeQuery(query);
		
		//to move to next record-rs.next();
		
		//Need to Include the Jar in the Project
		//here ! mention 1,2,3 mean for Column Index 1 for id,2 for name,3 for age
		//rs.next() - return true of not if there is a next row the loop continue
		while(rs.next()) {
			System.out.println("ID : " +rs.getInt(1));
			System.out.println("Name : " +rs.getString(2));
			System.out.println("Age : " +rs.getInt(3));
			System.out.println("");
		}
		
		System.out.println("------End----------");
		
		con.close();
	}
	
	   //InsertData Using Prepared Statement
		public static void writeRecords() throws SQLException{
			
			String url ="jdbc:mysql://localhost:3306/demo";
			String username = "root";
			String password = "rootuser";
			Connection con = DriverManager.getConnection(url, username, password);
		    
		    //Directly Include the value
		    //String query = "insert into employee values(3,'Aishu',21)";
		    int id = 5;
		    String name = "Vicky";
		    int age = 28;
		    
	        //Include value using variable
		    String query = "insert into employee values(?,?,?)";
		    
			//create Statement for the Query Execution
		    PreparedStatement pst = con.prepareStatement(query);
		    pst.setInt(1, id);
		    pst.setString(2, name);
		    pst.setInt(3, age);
		    
		    //It update the Query ANd return the affected rows
		    int rows = pst.executeUpdate();
		    
		    System.out.println("Rows Affected " +rows);
			
		}
		
	//InsertData
	public static void writeRecordsUsingVariable() throws SQLException{
		
		String url ="jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "rootuser";
		Connection con = DriverManager.getConnection(url, username, password);
		
		//create Statement for the Query Execution
	    Statement st = con.createStatement();
	    
	    //Directly Include the value
	    //String query = "insert into employee values(3,'Aishu',21)";
	    int id = 4;
	    String name = "Dhanush";
	    int age = 30;
	    
        //Include value using variable
	    String query = "insert into employee values(+" +id +",'" +name +"'," +age +")";
	    
	    //It update the Query ANd return the affected rows
	    int rows = st.executeUpdate(query);
	    
	    System.out.println("Rows Affected " +rows);
		
	}
	
	public static void deleteRecords() throws SQLException{
		
		String url ="jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "rootuser";
		Connection con = DriverManager.getConnection(url, username, password);
		
		//create Statement for the Query Execution
	    Statement st = con.createStatement();

	    int id = 5;
	    
        //Include value using variable
	    String query = "delete from employee where employeeId =" +id;
	    
	    //It update the Query ANd return the affected rows
	    int rows = st.executeUpdate(query);
	    
	    System.out.println("Deleted Rows - " +rows +" of Id-"+id);
		
	    readRecords();
	}
	
	public static void updateRecords() throws SQLException{
		
		String url ="jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "rootuser";
		Connection con = DriverManager.getConnection(url, username, password);
		
		//create Statement for the Query Execution
	    Statement st = con.createStatement();

	    int id = 2;
	    
        //Include value using variable
	    String query = "update employee set age = 25 where employeeId =" +id;
	    
	    //It update the Query ANd return the affected rows
	    int rows = st.executeUpdate(query);
	    
	    System.out.println("Rows Updated - " +rows +" of Id-"+id);
	    
	    readRecords();
		
	}

}
