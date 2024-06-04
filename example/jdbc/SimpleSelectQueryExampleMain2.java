package example.jdbc;

import java.util.Collection;

import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.UserDao;
import example.jdbc.entity.User;

public class SimpleSelectQueryExampleMain2 {

	public static void main(String[] args) {
		DaoInterface<User, Integer> daoRef=new UserDao();
		Collection<User> allUser=daoRef.retrieveAll();
		for(User us: allUser) {
			System.out.println(us);
		}
	}

}
