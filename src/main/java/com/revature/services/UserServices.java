package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.IntrfUserDAO;
import com.revature.dao.UserDAO;
import com.revature.models.User;

import java.util.List;

public class UserServices {
	
	private static IntrfUserDAO dao = new UserDAO();
	private static final Logger Log = LogManager.getLogger(UserServices.class);
	
	public List<User> findAll() {
		Log.info("finding all users");
		List<User> list = dao.findAllUsers();
		
		for (User user : list) {
			if (user.getUserType().equals(1)) {
				user.
			}
		}

		return list;
		return dao.findAllUsers();
	}
		
	public boolean updateUser(User user) {
		Log.info("updating users");
		if (dao.addUser(user)) {
			return true;
		}
		return false;
	}
	
	public boolean addNewUser(User user) {
		Log.info("adding new user");
		if (dao.addUser(user)) {
			return true;
		}
		
	}
}
