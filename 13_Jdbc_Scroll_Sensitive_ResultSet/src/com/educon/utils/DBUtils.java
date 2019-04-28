package com.educon.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtils
{
	private static Properties getProperties( )throws Exception
	{
		InputStream inputStream = new FileInputStream("Config.properties");
		Properties prop = new  Properties();
		prop.load(inputStream);
		return prop;
	}
	private static Connection connection;
	public static Connection getConnection( )throws Exception
	{
		Properties prop = DBUtils.getProperties();
		Class.forName( prop.getProperty("DRIVER"));
		connection = DriverManager.getConnection(prop.getProperty("URL"), prop.getProperty("USER"), prop.getProperty("PASSWORD"));
		return connection;
	}
	public static void closeConnection( )throws Exception
	{
		if( connection != null )
			connection.close();
	}
}
