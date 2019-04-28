package org.educon.test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;

import com.educon.utils.DBUtils;

public class Program
{
	public static String[] getQueries( )
	{
		String[] arr = new String[ 5 ];
		arr[ 0 ] = " insert into EmployeeTable values(31,'Mukesh Kisan Salunkhe', 'Ambegaon Pune','2006-10-12',35000)";
		
		arr[ 1 ] = "insert into EmployeeTable values(32,'Rahul Yogendra Kale', 'Padmavti Pune','2006-06-08',85000)";
		
		arr[ 2 ] = " insert into EmployeeTable values(33,'Sandeep Vitthal Kulange', 'Bharti Vidyapeeth,Pune','2007-01-01',113000)";
		
		arr[ 3 ] = " insert into EmployeeTable values(34,'Sangita Ashok Jadhav', 'Shivaji Housing Society, Karad','2014-09-13',25000)";
		
		arr[ 4 ] = " insert into EmployeeTable values(35,'Amol Nandkumar Pisal', 'Ghonsi,Karad','2007-02-05',18000)";
		return arr;
	}
	public static void main(String[] args) 
	{
		try( Connection connection = DBUtils.getConnection();
			 Statement statement = connection.createStatement();)
		{
			String[] queries = Program.getQueries();
			for( String query : queries )
				statement.addBatch(query);
			
			int[] count = statement.executeBatch();
			System.out.println(count.length+"	"+Arrays.toString(count));
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
