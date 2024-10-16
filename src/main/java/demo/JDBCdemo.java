package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

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

	}

}
