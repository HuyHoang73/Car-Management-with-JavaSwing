package productmanagement.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import productmanagement.dao.UserDao;
import productmanagement.model.entity.User;

public class UserDaoImpl implements UserDao{
	private List<User> userList;
	private static final String FILE_NAME = "User.bin";
	private static int currentId;
	
	public UserDaoImpl() {
		userList = loadUserList();
		if (!userList.isEmpty()) {
			currentId = userList.get(userList.size() - 1).getId();
		} else {
			currentId = 0;
		}
	}

	@Override
	public boolean addUser(User user) {
		user.setId(generateId());
		if (userList.add(user)) {
			saveUserList();
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId() == user.getId()) {
				userList.set(i, user);
				saveUserList();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		if (userList.removeIf(user -> user.getId() == id)) {
			saveUserList();
			return true;
		}
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> result = loadUserList();
		return result;
	}
	
	@Override
	public List<User> getAllUsersActive() {
		List<User> userList = loadUserList();
		List<User> result = new ArrayList<User>();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getStatus() == 1) {
				result.add(userList.get(i));
			}
		}
		return result;
	}

	@Override
	public List<User> getAllUsersDisable() {
		List<User> userList = loadUserList();
		List<User> result = new ArrayList<User>();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getStatus() == 0) {
				result.add(userList.get(i));
			}
		}
		return result;
	}

	@Override
	public List<User> searchUser(String name) {
		List<User> result = new ArrayList<User>();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getFullName().toLowerCase().contains(name.toLowerCase())) {
				result.add(userList.get(i));
			}
		}
		return result;
	}

	@Override
	public User searchUserById(int id) {
		User user = new User();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId() == id) {
				user = userList.get(i);
			}
		}
		return user;
	}
	
	private void saveUserList() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
			for (User user : userList) {
				writer.write(user.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<User> loadUserList() {
		List<User> userList = new ArrayList<User>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String data;
			while ((data = reader.readLine()) != null) {
				User user = User.fromStringToUser(data);
				userList.add(user);
			}
			return userList;
		} catch (IOException e) {
			userList = new ArrayList<>();
		}
		return userList;
	}

	private int generateId() {
		return ++currentId;
	}
}