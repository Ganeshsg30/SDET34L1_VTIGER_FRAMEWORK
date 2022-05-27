package com.sdet34l1.genericlibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;


/**
 * This class contains all common actions related to database
 * @author Ganesh
 */
public class DataBaseUse
{
	static Driver driver;
	static Connection connection; 
	static Statement statement;
	
	/**
	 * This method is used to open the database connection and initialize the connection and statement
	 * @param DBUrl
	 * @param DBUsername
	 * @param DBPassword
	 * @throws SQLException
	 */
	public static void openDBConnection(String DBUrl,String DBUsername,String DBPassword) throws SQLException
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection(DBUrl,DBUsername,DBPassword);
		statement=connection.createStatement();	
	}


	/**
	 * This method is used to fetch the data from database to be DQL actions on database
	 * @param query
	 * @param columnnum
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<String> getDataFromDataBase(String query, String columnname) throws SQLException 
	{
		ArrayList<String> list = new ArrayList<>();
		ResultSet result = statement.executeQuery(query);
			while(result.next())
			{
				list.add(result.getString(columnname));
			}
			return list;
	}

	/**
	 * This method is used to set the Data into Database
	 * @param query
	 * @throws SQLException
	 */
	public static void setDataIntoDataBase(String query) throws SQLException
	{
		int result = statement.executeUpdate(query);
		{
			if(result>=1)
			{
				System.out.println("Data entered / modified successfully");
			}
		}
	}
	
	
	/**
	 * This method is used to validate the data weather it is present in database or not
	 * @param query
	 * @param columnname
	 * @param expecteddata
	 * @return
	 * @throws SQLException
	 */
	public static boolean validateDataInDatabase(String query,String columnname,String expecteddata) throws SQLException
	{
		ArrayList<String> list = getDataFromDataBase(query,columnname);
		boolean flag = false;
		for(String actualData:list)
		{
			if(actualData.equalsIgnoreCase(expecteddata))
			{
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	
	/**
	 * This method is used to close the database connection
	 */
	public static void closeDBConnection() 
	{
		try
		{
			connection.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("While closing the database connection we got exception");
		}
	}
}