package org.educon.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import com.educon.utils.DBUtils;

public class Program
{
	public static void main(String[] args) 
	{
		String sql= "{?=call fn_fund_transfer(?,?,?)}";
		
		try( Connection connection = DBUtils.getConnection();
			 CallableStatement statement = connection.prepareCall(sql);)
		{
			statement.setInt(2, 1002);
			statement.setInt(3, 1001);
			statement.setFloat(4, 10000);
			
			statement.registerOutParameter(1, Types.FLOAT);
			
			boolean status = statement.execute();
			System.out.println(status);
			
			System.out.println("Source Balance	:	"+statement.getFloat(1));
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
