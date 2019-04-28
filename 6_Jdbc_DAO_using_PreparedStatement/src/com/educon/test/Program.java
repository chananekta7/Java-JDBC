package com.educon.test;
public class Program
{
	public static void main(String[] args) 
	{
		try 
		{
			int choice;
			EmployeeTest test = new EmployeeTest();
			while( ( choice = EmployeeTest.menuList( ) ) != 0 )
			{
				switch( choice )
				{
				case 1:
					test.addEmployee();
					break;
				case 2:
					test.updateEmployee();
					break;
				case 3:
					test.removeEmployee();
					break;
				case 4:
					test.printEmployees();
					break;
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
