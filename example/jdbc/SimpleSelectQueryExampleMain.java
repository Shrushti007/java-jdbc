package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleSelectQueryExampleMain {

	public static void main(String[] args) {
		// 1.Load the Driver
		String driverClassName="com.mysql.cj.jdbc.Driver";
		
		// java.io.FileInputStream
		//java.util.ArrayList  ....java.util-package name & ArrayList-classname
		
		//It is predefined class 
		
		Connection dbConnection=null;
		Statement stmt=null;
		ResultSet rs = null;
		try {
			//exclude loading
			Class.forName(driverClassName);
		System.out.println("Driver Loaded");
		
		//2.Establish Connection
		
		String URL="jdbc:mysql://localhost:3306/employee";
		String UID="root";
		String PWD="password";
		dbConnection = DriverManager.getConnection(URL, UID, PWD);
		System.out.println("Connected.");
		
		
		//3.obtain Some statement
		 stmt= dbConnection.createStatement();
		
		
		//4.Execute SQL Query 
		String sqlQuery="select id, username,userage from emp1";
		 rs = stmt.executeQuery(sqlQuery);
		
		 //5.Perform Navigation
		 while(rs.next()) {
			 String name = rs.getString(2);
			 String age = rs.getString(3);
			 int id=rs.getInt(1);
			 System.out.println("ID:"+id+",Name:" +name+",Age:"+age);
					 
					 
		 }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//forward-->throw--->classNotFoundExceptiona
	

		finally {
			try {
				rs.close();
				stmt.close();
				dbConnection.close();
				}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	private static void createStatement() {
		// TODO Auto-generated method stub
		
	}

}

