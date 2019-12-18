package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

	
	public static ArrayList<String> getDataTableColumn(String SQLqyeries,String columnName) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522/orcl", "hr", "sarower");
		Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SQLqyeries);
		
		  ArrayList<String> columnValue = new ArrayList<String>();
		  
		  while(rs.next())
		  { 
			  columnValue.add( rs.getString(columnName)); 
		  
	}
		 

		System.out.println(columnValue);
		// step5 close the connection object
		connection.close();
		return columnValue;

	}

}


