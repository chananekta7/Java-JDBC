package com.educon.dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.educon.pojo.Employee;
import com.educon.utils.DBUtils;

public class EmployeeDao implements Closeable
{
	private CallableStatement insertStatement;
	private CallableStatement updateStatement;
	private CallableStatement deleteStatement;
	private CallableStatement selectStatement;
	public EmployeeDao( )throws Exception  
	{
		Connection connection = DBUtils.getConnection();
		this.insertStatement = connection.prepareCall("{call sp_insert_employee(?,?,?,?,?)}");
		this.updateStatement = connection.prepareCall("{call sp_update_employee(?,?)}");
		this.deleteStatement = connection.prepareCall("{call sp_delete_employee(?)}");
		this.selectStatement = connection.prepareCall("{call sp_get_employees()}");
	}
	public boolean insert( Employee emp )throws Exception
	{
		this.insertStatement.setInt(1, emp.getEmpid());
		this.insertStatement.setString(2, emp.getFullName());
		this.insertStatement.setString(3, emp.getPermanentAddress());
		this.insertStatement.setDate(4, emp.getJoinDate());
		this.insertStatement.setFloat(5, emp.getSalary());
		return this.insertStatement.execute();
	}
	public boolean update( int empid, float salary )throws Exception
	{
		this.updateStatement.setFloat(1, salary);
		this.updateStatement.setInt(2, empid);
		return this.updateStatement.execute();
	}
	public boolean delete( int empid )throws Exception
	{
		this.deleteStatement.setInt(1, empid);
		return this.deleteStatement.execute();
	}
	public List<Employee> getEmployees( ) throws Exception
	{
		this.selectStatement.execute();
		List<Employee> empList = new ArrayList<Employee>();
		try(ResultSet rs = this.selectStatement.getResultSet())
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
			this.insertStatement.close();
			this.updateStatement.close();
			this.deleteStatement.close();
			this.selectStatement.close();
			DBUtils.closeConnection();
		} 
		catch (Exception cause) 
		{
			throw new IOException(cause);
		}
	}
}
