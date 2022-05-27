package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class DataBaseConnection 
{
		public static void main(String [] args) throws SQLException
	{
		Connection connection=null;
		//step 1 - create object for implementation class
		Driver driver=new Driver();
		
		//step 2 - register the driver with jdbc
		DriverManager.registerDriver(driver);
		
		//step 3 - establish the database connection
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet34","root","root");
		
		// step 4- create statement
		Statement statement = connection.createStatement();
		
		//step 5 - execute query
		ResultSet result = statement.executeQuery("select * from sdet34;");
		
		//step 5- validate based on test case
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
		}
	
			connection.close();
		}
}
