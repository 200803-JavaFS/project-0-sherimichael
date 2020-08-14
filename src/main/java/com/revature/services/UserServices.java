package com.revature.services;

import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;

import com.revature.dao.UserDAOImpl;

public class UserServices {
	
	private static UserDAOImpl dao = new UserDAO();
	private static final Logger Log = LogManager.getLogger(UserServices.class);
	
	public List<User> findAll() {
		Log.info("finding users");
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
		Log.info("adding new user users");
		if (dao.addUser(user)) {
			return true;
		}
		
	}
}
