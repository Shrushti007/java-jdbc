package example.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import example.jdbc.entity.User;
import example.jdbc.utils.JdbcUtils;

public class UserDao  implements DaoInterface<User,Integer>{

	@Override
	public Collection<User> retrieveAll(){
		//creating an empty collection of users
		Collection<User> allUser=new ArrayList<>();
		//some code to get data from database and fill that 
		//into this collection
		String sqlQuery="select id, username,userage from emp1";
		try(
				Connection dbConnection= JdbcUtils.buildConnection();
				Statement stmt=dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery);
				){
			while(rs.next()) {
				 String name = rs.getString(2);
				 String age = rs.getString(3);
				 int id=rs.getInt(1);
//				 Populating an object of customer class based
//				 upon : id ,name,age
				 User currentUser = new User(id, name, age);
//				 Adding this object into user collection
				 allUser.add(currentUser);
						 
			 }
			
			
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return allUser;
}

	@Override
	public User retrieveOne(Integer id) {
		// Fetching single customer against Id and returning it
		User foundUser=null;
		String sqlQuery="select id, username,userage from emp1 where id=?";
		try (
			Connection dbConnection = JdbcUtils.buildConnection();
			PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
		){
			pstmt.setInt(1,id);
			ResultSet rs =pstmt.executeQuery();
			if(rs.next()) {
				//If user exists
				String name = rs.getString(2);
				 String age = rs.getString(3);
				 int usid=rs.getInt(1);
				 foundUser=new User(usid,name,age);
			}
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
		return foundUser;
	}

	@Override
	public void create(User UserRef) {
		String sqlQuery = 
				"insert into emp1 values(?,?,?)";
		try (
				Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
			)
				
		{
//				Retrieving
				int usId= UserRef.getUserId();
				String name=UserRef.getName();
				String age=UserRef.getAge();
				
				//setting the data
				pstmt.setInt(1,usId);
				pstmt.setString(2,name);
				pstmt.setString(3,age);
				
				int updateCount = pstmt.executeUpdate();
				System.out.println(updateCount + " record inserted.");
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}

	}

	@Override
	public void delete(Integer id) {
		String sqlQuery=
				" delete from emp1 where id = ?";
		try (
				Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
			)
		{
			pstmt.setInt(1, id);
			
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + " record deleted.");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void update(User modifiedUser) {
		String sqlQuery =
				"update emp1 set username = ?,userage = ? where id = ?";
			int id = modifiedUser.getUserId();
			String newName=modifiedUser.getName();
			String newAge = modifiedUser.getAge();
			try (
					Connection dbConnection = JdbcUtils.buildConnection();
					PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				){
				pstmt.setString(1, newName);
				pstmt.setString(2, newAge);
				pstmt.setInt(3, id);
				
				int updateCount = pstmt.executeUpdate();
				System.out.println(updateCount + " record updated.");
			}
			catch (Exception ex) {
				
				ex.printStackTrace();
			}
	}
	
	
	}
	
	


