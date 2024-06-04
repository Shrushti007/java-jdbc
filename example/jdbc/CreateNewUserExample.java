package example.jdbc;

import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.UserDao;
import example.jdbc.entity.User;

public class CreateNewUserExample {
	public static void main(String[] args) {

		DaoInterface<User , Integer> daoRef=new UserDao();
		User UserObj=new User(7,"shrushti","23");
		daoRef.create(UserObj);
	}
}
