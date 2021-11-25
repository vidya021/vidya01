package db_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class SampleSelectQuery 
{

	public static void main(String[] args) throws SQLException 
	{
		// step 1
		Driver driverref =new Driver();
		DriverManager.registerDriver(driverref);
		// step 2
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
		
		//step 3
		Statement stat =con.createStatement();
		
		//step 4
		ResultSet set =stat.executeQuery("select * from student");
		while(set.next())
		{
			System.out.println(set.getInt(1) + "\t" + set.getString(2) + "\t" + set.getString(3) + "\t" +set.getString(4));
		}
		
		//verify
		//step 5
		
		con.close();

	}

}
