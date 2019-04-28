package com.educon.dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.educon.pojo.Employee;
import com.educon.utils.DBUtils;

public class EmployeeDao implements Closeable
{
	private Statement statement;
	public EmployeeDao( )throws Exception  
	{
		Connection connection = DBUtils.getConnection();
		this.statement = connection.createStatement();
	}
	public int insert( Employee emp )throws Exception
	{
		String sql = "insert into EmployeeTable values("+emp.getEmpid()+",'"+emp.getFullName()+"','"+emp.getPermanentAddress()+"','"+emp.getJoinDate()+"',"+emp.getSalary()+")";
		int updateCount = this.statement.executeUpdate(sql);
		return updateCount;
	}
	public int update( int empid, float salary )throws Exception
	{
		String sql = "update EmployeeTable set salary="+salary+" where emp_id="+empid+"";
		int updateCount = this.statement.executeUpdate(sql);
		return updateCount;
	}
	public int delete( int empid )throws Exception
	{
		String sql = "delete from EmployeeTable where emp_id="+empid+"";
		int updateCount = this.statement.executeUpdate(sql);
		return updateCount;
	}
	public List<Employee> getEmployees( ) throws Exception
	{
		List<Employee> empList = new ArrayList<Employee>();
		String sql = "select * from EmployeeTable";
		try(ResultSet rs = statement.executeQuery(sql);)
		{
			while( rs.next())
			{
				Employee emp = new Employee(rs.getInt("emp_id"),rs.getString("full_name"),rs.getString("permanent_address"),rs.getDate("join_date"),rs.getFloat("salary"));	
				empList.add(emp);
			}
		}
		return empList;
	}
	@Override
	public void close() throws IOException 
	{
		try 
		{
			this.statement.close();
			DBUtils.closeConnection();
		} 
		catch (Exception cause) 
		{
			throw new IOException(cause);
		}
	}
}
