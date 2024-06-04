package example.jdbc;

import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.UserDao;
import example.jdbc.entity.User;

public class RetrieveOneUserExampleMain {

	public static void main(String[] args) {
		DaoInterface<User , Integer> daoRef=new UserDao();
		User UserRef=daoRef.retrieveOne(7);
		if(UserRef != null)
			System.out.println(UserRef);
		else
			System.out.println("user with given Id does not exists");

	}

}
