package com.revature.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

import com.revature.dao.UserDAO;
import com.revature.models.User;
import com.revature.services.LoginServices;

public class LoginScreen {
	
	private static final Logger log = LogManager.getLogger(LoginScreen.class); 
	private static final Scanner scan = new Scanner(System.in);
	
	LoginServices ls = new LoginServices();
	
	public void acntLogin() {
		
		log.info("@acntLogin - userId");
		System.out.println("\n\nGood day! To log into The Credit Union,");
		System.out.print("please enter your userId:");
		String userId = scan.nextLine();
		System.out.print("please enter your password:");
		String password = scan.nextLine();
		password = password.toLowerCase();
		
		int id = Integer.parseInt(userId);
		
		ls.checkPassword(id, password);
	}
	
	public void incorrectPwordEntry(User user) {
		System.out.println("There are no matches for your user id/password combination."
				+ "Please select what you want to do below:"
				+ "1. Try logging in again."
				+ "2. Reset my password.");
		int c = Integer.parseInt(scan.nextLine());
		if (c == 1) {
			log.info("@incorrectPwordEntry - trying to login again");
			acntLogin();
		}else if (c == 2) {
			log.info("@incorrectPwordEntry - resetting pword");
			System.out.print("Please enter a new password:");
			String newPassword = scan.nextLine();
			newPassword = newPassword.toLowerCase();
			UserDAO uDao = new UserDAO();
			user.setPassword(newPassword);
			uDao.updateUser(user);
			acntLogin();	
		}else {System.out.println("Invalid Response. Please start over.");}
	}
}
