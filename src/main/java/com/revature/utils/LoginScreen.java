package com.revature.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

import com.revature.services.LoginServices;

public class LoginScreen {
	
	private static final Logger log = LogManager.getLogger(LoginScreen.class); 
	private static final Scanner scan = new Scanner(System.in);
	
	public void acntLogin() {
		
		log.info("@acntLogin - userId");
		System.out.println("Good day! To log into The Credit Union,");
		System.out.print("please enter your userId:");
		String userId = scan.nextLine();
		System.out.print("please enter your password:");
		String password = scan.nextLine();
		password = password.toLowerCase();
		
		int id = Integer.parseInt(userId);
		
		LoginServices ls = new LoginServices();
		ls.checkPassword(id, password);
	}
}
