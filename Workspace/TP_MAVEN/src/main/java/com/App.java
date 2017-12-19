package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args)
	  {
	    try
	    {
	      // create our mysql database connection
	      String myDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql://192.168.4.218/eseo_tp_maven?useSSL=false";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "maven", "network");
	      
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT Nom_commune FROM ville_france WHERE code_postal = 01400";

	      // create the java statement
	      Statement st = conn.createStatement();
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      ResultSetMetaData rsmd = rs.getMetaData();
	      
	      int columnsNumber = rsmd.getColumnCount();
	      // iterate through the java resultset
	      while (rs.next())
	      {
	    	  for(int i = 1 ; i <= columnsNumber; i++){

	    		  System.out.print(rs.getString(i) + " ");
	        
	        // print the results
	    	  }
	    	  System.out.println();//
	      }
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	  }
}
