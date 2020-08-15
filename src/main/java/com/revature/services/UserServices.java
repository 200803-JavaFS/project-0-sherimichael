package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.UserDAOImpl;

public class UserServices {
	
	private static UserDAOImpl dao = new UserDAO();
	private static final Logger Log = LogManager.getLogger(UserServices.class);
	
	public List<User> findAll() {
		Log.info("finding all users");
		List<User> list = dao.findAll();
		
		for (User user : list) {
			if (user.getUserType().equals(1)) {
				user.
			}
		}

		return list;
		return dao.findAll();
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
