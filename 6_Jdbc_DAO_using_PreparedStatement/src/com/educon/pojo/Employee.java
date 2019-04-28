package com.educon.pojo;

import java.sql.Date;

public class Employee
{
	private int empid;
	private String fullName, permanentAddress;
	private Date joinDate;
	private float salary;
	public Employee() 
	{	
		this.joinDate = new Date(2019, 23, 04);
	}
	public Employee(int empid, String fullName, String permanentAddress, Date joinDate, float salary) 
	{
		this.empid = empid;
		this.fullName = fullName;
		this.permanentAddress = permanentAddress;
		this.joinDate = joinDate;
		this.salary = salary;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() 
	{
		return String.format("%-5d%-30s%-50s%-15s%-10.2f\n",this.empid, this.fullName, this.permanentAddress, this.joinDate, this.salary );
	}
}
