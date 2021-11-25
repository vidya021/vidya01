package db_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class SampleNonSelectQuerry_try_catch_realtime_jdbc 
{

	public static void main(String[] args) throws Throwable
	{
	Connection con = null;
	try
	{
		// step 1:load/register the driver for specific database
		Driver driverref =new Driver();
		DriverManager.registerDriver(driverref);
		
		// step 2:connection to db
	   con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
		
		//step 3:create\issue sql statement
		Statement stat =con.createStatement();
		
		//step 4:execute the query
		int result =stat.executeUpdate("insert into student values(8,'zam','gowda','zamgowda@gmail.com')");
			if (result==1)
			{  
			System.out.println("student is successfully created..!");
		    }
			
	}catch (Exception e)
	
	{
		System.err.println("student not created");
	}
	
	finally
	{
		
		//verify
		//step 5:close the connection
		
		con.close();
		System.out.println("close Connection");
	}

	}	

}


	
