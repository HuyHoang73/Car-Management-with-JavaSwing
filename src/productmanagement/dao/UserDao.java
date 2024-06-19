package productmanagement.dao;

import java.util.List;

import productmanagement.model.entity.User;

public interface UserDao {
	boolean addUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(int id);

	List<User> getAllUsers();
	
	List<User> getAllUsersActive();
	
	List<User> getAllUsersDisable();

	List<User> searchUser(String name);

	User searchUserById(int id);
}
