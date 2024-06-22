package productmanagement.services.impl;

import java.util.List;

import productmanagement.dao.UserDao;
import productmanagement.dao.impl.UserDaoImpl;
import productmanagement.model.entity.User;
import productmanagement.services.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();

	@Override
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public boolean deleteUser(int id) {
		return userDao.deleteUser(id);
	}

	@Override
	public List<User> searchUser(String name, boolean choice) {
		return userDao.searchUser(name, choice);
	}

	@Override
	public List<User> getAllUsersActive() {
		return userDao.getAllUsersActive();
	}

	@Override
	public List<User> getAllUsersDisable() {
		return userDao.getAllUsersDisable();
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUsers();
	}

	@Override
	public User searchUserById(int id) {
		return userDao.searchUserById(id);
	}

	@Override
	public boolean restoreUser(int id) {
		return userDao.restoreUser(id);
	}

}
