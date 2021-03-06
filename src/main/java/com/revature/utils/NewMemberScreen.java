package com.revature.utils;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.User;
import com.revature.services.TransaxnService;

public class NewMemberScreen {
	
	private static final Logger log = LogManager.getLogger(NewMemberScreen.class);
	private static final Scanner scan = new Scanner(System.in);
	TransaxnService ts = new TransaxnService();
	
	public void checkAgeNewMember() {
		log.info("@checkAgeNewMember in NewMemberScreen");
		System.out.println("\nThank you for considering being a member of The Credit Union.\n"
				          + "We have a few questions for you.\n");
		System.out.print("Are you 18 years or older? Yes No");
		String yesNo = scan.nextLine().toLowerCase();
		if (yesNo.equals("yes")) {
			createNewMember();
		}else {System.out.println("We are sorry. We can only offer accounts and services to those 18 or older.");}	
	}
	
	public void createNewMember() {
		System.out.println("\n\nWe look forward to serving you as a new member. Please create your "
						 + "user profile below.\n"
						 + "User profile questions:\n");
		System.out.print("First Name: ");
		String firstName = scan.nextLine();
		System.out.print("Last Name: ");
		String lastName = scan.nextLine();
		System.out.print("Email: ");
		String email = scan.nextLine();
		System.out.print("Desired Login Password: ");
		String password = scan.nextLine().toLowerCase();
		User u = ts.createMember(firstName, lastName, email, password);
		System.out.println("Thank you, " + firstName + " " + lastName + ","
				+ " for completing a new user profile for The Credit Union. \n"
				+ " An employee will be contacting you soon to learn how we can best serve you.");
	}
}
