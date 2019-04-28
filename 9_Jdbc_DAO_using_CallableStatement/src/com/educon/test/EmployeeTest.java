package com.educon.test;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.educon.dao.EmployeeDao;
import com.educon.pojo.Employee;

public class EmployeeTest 
{
	private static Scanner sc = new Scanner(System.in);
	EmployeeDao  dao;
	public EmployeeTest()throws Exception
	{
		this.dao = new EmployeeDao();
	}
	public static void acceptRecord( Employee emp )
	{
		System.out.print("Employee Id	:	");
		emp.setEmpid(sc.nextInt());
		System.out.print("Full Name	:	");
		sc.nextLine();
		emp.setFullName(sc.nextLine());
		System.out.print("Permanent Address	:	");
		emp.setPermanentAddress(sc.nextLine());
		System.out.print("Join Date[yyyy-mm-dd]	:	");
		emp.setJoinDate( Date.valueOf(sc.nextLine()));
		System.out.print("Salary	:	");
		emp.setSalary(sc.nextFloat());
	}
	public void addEmployee( )throws Exception
	{
		Employee emp = new Employee();
		EmployeeTest.acceptRecord(emp);
		boolean status = this.dao.insert(emp);
		if( status == false )
			System.out.println("Record inserted successfully.");
	}
	public void updateEmployee( )throws Exception
	{
		System.out.print("Employee Id	:	");
		int empid = sc.nextInt();
		System.out.print("Salary	:	");
		float salary = sc.nextFloat();
		boolean status = this.dao.update(empid, salary);
		if( status == false )
			System.out.println("Record updated successfully.");

	}
	public void removeEmployee( )throws Exception
	{
		System.out.print("Employee Id	:	");
		int empid = sc.nextInt();
		boolean status = this.dao.delete(empid);
		if( status == false )
			System.out.println("Record deleted successfully.");
	}
	public void printEmployees( )throws Exception
	{
 		List<Employee> empList = this.dao.getEmployees();
 		if( !empList.isEmpty())
 		{
	 		for (Employee emp : empList) 
	 			System.out.println(emp.toString());
 		}
	}
	public static int menuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Add Employee");
		System.out.println("2.Update Employee");
		System.out.println("3.Remove Employee");
		System.out.println("4.Print Employee(s)");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
}
