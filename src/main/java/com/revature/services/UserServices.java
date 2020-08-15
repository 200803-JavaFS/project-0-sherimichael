package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.AccountDAO;
import com.revature.dao.IntrfAccountDAO;
import com.revature.dao.IntrfUserDAO;
import com.revature.dao.UserDAO;
import com.revature.models.User;

import java.util.List;

public class UserServices {
	
	
	private static final Logger log = LogManager.getLogger(UserServices.class);
	
	private static IntrfUserDAO uDao = new UserDAO();
	private static IntrfAccountDAO aDao = new AccountDAO();
	
	public List<User> findAllMembers() {
		log.info("Retrieving all members");
		return uDao.findAllMembers();
		}
	
	public List<User> findAllEmployees() {
		log.info("Retrieving all members");
		return uDao.findAllEmployees();
		}
	
	public List<User> findAllAdmins() {
		log.info("Retrieving all members");
		return uDao.findAllMembers();
		}

	public User findMemberById(int id) {
		log.info("finding a Avenger with id " + id);
		return uDao.findMemberById(id);
	}
	
	public User findEmployeeById(int id) {
		log.info("finding a Avenger with id " + id);
		return uDao.findEmployeeById(id);
	}
	
	public User findAdminById(int id) {
		log.info("finding a Avenger with id " + id);
		return uDao.findAdminById(id);
	}
		
	public boolean updateUser(User user) {
		log.info("updating users");
		if (uDao.addUser(user)) {
			return true;
		}
		return false;
	}
	
	public boolean addNewUser(User user) {
		log.info("adding new user");
		if (uDao.addUser(user)) {
			return true;
		}	
		return false;
	}
	
	public boolean addUserWithJointAccnt(User jointUser) {
		log.info("adding user with joint account");
		if (uDao.addUser(jointUser)) {
			return true;
		}	
		return false;
	}
	
	public boolean deleteUser(int userId) {
		log.info("deleting employee or admin");
		if (uDao.deleteUser(userId)) {
			return true;
		}	
		return false;
	}
	
}
