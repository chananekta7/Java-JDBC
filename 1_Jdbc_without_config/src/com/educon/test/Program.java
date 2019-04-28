package com.educon.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Step 0 : Add database connector in runtime classpath / buildpath ( mysql-connector-java-8.0.15.jar )
public class Program
{
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/Educon?useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "manager";
	
	public static void main(String[] args) 
	{
		Connection connection = null;
		Statement statement = null;
		try
		{
			//Step 1 : Load and register driver ( Optional step since Java SE 8 )
			Class.forName(DRIVER);
			
			//Step 2 : Get Connection using users credential
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//Step 3 : Create Statement instance to execute commands/queries
			statement = connection.createStatement();
			
			//Step 4 : Prepare and execute query
			String sql = "select * from EmployeeTable";
			ResultSet rs = statement.executeQuery(sql);
			
			while( rs.next())
			{
				//int empId = rs.getInt(1);	//1 --> column index or
				int empId = rs.getInt("emp_id");	//emp_id --> column name
				
				//String fullName = rs.getString(2);	//or
				String fullName = rs.getString("full_name");		
				
				//String permanentAddress = rs.getString(3);	//or
				String permanentAddress = rs.getString("permanent_address");
				
				//Date joinDate = rs.getDate(4);	//or
				Date joinDate = rs.getDate("join_date");	
				
				//float salary = rs.getFloat(5);	//or
				float salary = rs.getFloat("salary");
	
				System.out.printf("%-5d%-30s%-50s%-15s%-10.2f\n",empId, fullName, permanentAddress, joinDate, salary );
			}
			rs.close();
		}
		catch( SQLException | ClassNotFoundException ex )
		{
			ex.printStackTrace();
		}
		finally 
		{
			//Step 5 : Close the resources
			try 
			{
				if( statement != null )
					statement.close();
				if( connection != null )
					connection.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
