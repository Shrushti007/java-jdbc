package example.jdbc;

import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.UserDao;
import example.jdbc.entity.User;

public class UpdateUserExample {

	public static void main(String[] args) {
		DaoInterface<User , Integer> daoRef=new UserDao();
		//Load the record
		daoRef.retrieveOne(6);
		User UserRef = daoRef.retrieveOne(6);
		//Update name and age in database table
		UserRef.setName("Shantanu");
		UserRef.setAge("25");
		daoRef.update(UserRef);
	}

}
