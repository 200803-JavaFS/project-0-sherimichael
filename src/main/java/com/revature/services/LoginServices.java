package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.UserDAO;
import com.revature.models.User;
import com.revature.utils.EmployeeScreen;
import com.revature.utils.LoginScreen;
import com.revature.utils.MemberScreen;



public class LoginServices {
	
	private static final Logger log = LogManager.getLogger(LoginServices.class); 
	
	public void checkPassword(int inputUserId, String inputPword){
		String pword = null;
		
		log.info("@checkPassword");
		UserDAO check = new UserDAO();
		User user = new User();
		user=check.findById(inputUserId);
		System.out.println(user);
			if (user.getUserId() == inputUserId) {
				pword = user.getPassword();
				System.out.println(pword);
				if (pword.equals(inputPword) && user.getUserType() == 1) {
					log.info("User is member --> MemberScreen.MemberApp");
					MemberScreen member = new MemberScreen();
					member.MemberApp(user.getUserId());					
				} else if(pword.equals(inputPword) && user.getUserType() == 2){
					log.info("User is employee --> EmployeeScreen.EmployeeApp");
					EmployeeScreen employee = new EmployeeScreen();
					employee.EmployeeApp(user.getUserId());		
				} else if(pword.equals(inputPword) && user.getUserType() == 3){
					log.info("User is admin --> AdminScreen.AdminApp");
					/*AdminScreen admin = new AdminScreen();
					admin.AdminApp();	
					*/
				}else {
					log.info("no password match --> return to LoginScreen");
					System.out.println("There are no matches for your user id/password combination."
									+ "Please try logging in again.");
					LoginScreen ls = new LoginScreen();
					ls.acntLogin();
					
			}
		}
	}
}
