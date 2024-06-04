package example.jdbc;

import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.UserDao;
import example.jdbc.entity.User;

public class DeleteUserExample {
	public static void main(String[] args) {
		DaoInterface<User, Integer> daoRef = new UserDao();
		//delete
		daoRef.delete(7);
	}
}
