package example.jdbc.dao;

import java.util.Collection;
// This interface provide basic template for DAO pattern
// Its implementation class decides the actual entity type
// and the ID type.
public interface DaoInterface <T,k>{
//    T--> Type   K-->Key
	Collection<T> retrieveAll();
	//retrieveOne(); ---> one record
	T retrieveOne(k id);
	//to insert
	void create(T  t);
	//Delete
	void delete(k id);
	//update
	void update(T t);
	
	
}

// user ID : int ----> Integer---> UserDao<user,Integer>