package demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class JDBCdemo {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		readRecords();
		//readRecordsUsingStoredProcedure();
		//writeRecords();
		//writeRecordsUsingVariable();	
		//deleteRecords();
		//updateRecords();
		//commitDemo();
		batchDemo();
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
	
	public static void readRecordsUsingStoredProcedure() throws SQLException{
		System.out.println("---------List of Records----------");
		//Use connection Interface To connect With database
		String url ="jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "rootuser";
		Connection con = DriverManager.getConnection(url, username, password);
		CallableStatement cst = con.prepareCall("{call getEmployeeDetails()}");
		ResultSet rs = cst.executeQuery();
		
		while(rs.next()) {
			System.out.println("ID : " +rs.getInt(1));
			System.out.println("Name : " +rs.getString(2));
			System.out.println("Age : " +rs.getInt(3));
			System.out.println("");
		}
		
		System.out.println("------End----------");
		
		
		//get particular employee details
		int empId = 1;
		System.out.println("Details of Particular Employee of Id " +empId);
		CallableStatement cst2 = con.prepareCall("{call getEmployeeDetailsById(?)}");
		cst2.setInt(1, empId);
		ResultSet rs1 = cst2.executeQuery();
		
		rs1.next();
		System.out.println("ID : " +rs1.getInt(1));
		System.out.println("Name : " +rs1.getString(2));
		System.out.println("Age : " +rs1.getInt(3));
		System.out.println("");
		
		System.out.println("------End----------");
		
		//Get Name By Using Employee Id - stored Procedure In and out
		System.out.println("Name of the Employee of Id " +empId);
		CallableStatement cst3 = con.prepareCall("{call getNameByEmployeeId(?,?)}");
		cst3.setInt(1, empId);
		cst3.registerOutParameter(2, Types.VARCHAR);
		//Because we pass Parameter
		cst3.executeUpdate();
		//Because its an secondParameter here getEmployeeDetailsById(?,?)
		System.out.println("Name: " +cst3.getString(2));
		
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

	public static void commitDemo() throws SQLException{
		
		//commit - to Execute Multiple Query at the same time
		String url ="jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "rootuser";
		Connection con = DriverManager.getConnection(url, username, password);
		con.setAutoCommit(false);
		Statement st = con.createStatement();
		
		String query1 = "update employee set age = 20 where employeeId = 2";
		String query2 = "update employee set age = 35 where employeeId = 3";
		
		st.executeUpdate(query1);
		st.executeUpdate(query2);
		
		con.commit();
		
		readRecords();
	}
	
	public static void batchDemo() throws SQLException{
		
		String url ="jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "rootuser";
		Connection con = DriverManager.getConnection(url, username, password);
		
		String query1 = "update employee set name = 'Divya' where employeeId = 2";
		String query2 = "update employee set name = 'Preetha' where employeeId = 3";
		
		Statement st = con.createStatement();
		st.addBatch(query1);
		st.addBatch(query2);
		
		st.executeBatch();
		
		readRecords();
		
	}
}
