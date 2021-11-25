package com.crm.comcast.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility 
{
	Driver driver;
	Connection con;
	ResultSet result;
	Statement stat;
	FileUtility fui=new FileUtility();
	
	public void connectToDB()
	{
		try
		{
			driver = new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection(fui.getPropertykey("dburl"),fui.getPropertykey("dbusername"),fui.getPropertykey("dbpassword"));
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
public void closeDB() throws SQLException
{
	con.close();
}

public ResultSet ExecuteQuerry(String query)
{
	try
	{
		stat =con.createStatement();
		result = stat.executeQuery(query);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return result;
}

}
