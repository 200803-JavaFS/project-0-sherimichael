package com.revature.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.AccountDAO;
import com.revature.dao.UserDAO;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.utils.AdminScreen;
import com.revature.utils.EmployeeScreen;
import com.revature.utils.MemberScreen;

public class TransaxnService {
	
	private static final Logger log = LogManager.getLogger(TransaxnService.class); 
	private static final Scanner scan = new Scanner(System.in);
	
		AccountDAO aDao = new AccountDAO();
		Account a = new Account();
		Account a2 = new Account();
		User u = new User();
		UserDAO uDao = new UserDAO();
		MemberScreen member = new MemberScreen();
		EmployeeScreen employee = new EmployeeScreen();
		AdminScreen admin = new AdminScreen();
		
		private double b;
	
		//**********Actions Authorized for All User Types (Members, Employees, Admins)******
		public Account getAcntBalance(int memberUserId) {
			log.info("@getAcntBalance in TransaxnService");
			a = aDao.findByUserId(memberUserId);
			return a;
		}
		
		public User createMember(String firstName, String lastName, String email, String password) {
			log.info("@CreateNewMember in TransaxnService");
			u.setFirstName(firstName);
			u.setLastName(lastName);
			u.setEmail(email);
			u.setPassword(password);
			u.setUserType(4);
			return u;			
		}
		
		public Account checkAcntInfo(int userId) {
			log.info("@CheckAcntInfo in TransaxnService");	
			a = aDao.findByUserId(userId);
			return a;	
		}
		
		public User checkPersonalInfo(int userId) {
			log.info("@CheckPersonalInfo in TransaxnService");	
			u = uDao.findById(userId);	
			return u;
		}
		
		//**********Actions Authorized for Members and Admins)******
	
		public boolean depositChecking(int userId, double depositAmount) {
			log.info("@MakeDeposit in TransaxnService");
			a = aDao.findByUserId(userId);
			System.out.println(a);
			if (a.getAcntStatus() == 1) {
				if (a.getAcntType() == 1) {
					b = a.getBalance();
					System.out.println("\nThe starting balance for checking account number " + a.getAccountId() + " is $" + b +"\n");
					b = b + depositAmount;
					a.setBalance(b);
					System.out.println("With a deposit of $" + depositAmount + ", the new balance for this checking account is $" + b +"\n");
					aDao.updateAccount(a);
					return true;}
			}else {
				System.out.println("\nIt seems that you do not have an active checking account. Please see an admin.\n");
				return false;}
			member.MoreMemberAxns(userId);
			return false;
		}
		
		public boolean depositSavings(int userId, double depositAmount) {
			log.info("@MakeDeposit in TransaxnService");
			a = aDao.findByUserId(userId);
			if (a.getAcntStatus() == 1) {
				b = a.getBalance();
				if (a.getAcntType() == 2) {
					System.out.println("\nThe starting balance for savings account number " + a.getAccountId() + " is $" + b + "\n");
					b = b + depositAmount;
					a.setBalance(b);
					System.out.println("With a deposit of $" + depositAmount + ", the new balance for this savings account is $" + b +"\n");
					aDao.updateAccount(a);
					return true;
				}else {
					System.out.println("\nIt seems that you do not have an active savings account. Please see an admin.\n");
					return false;
					}
			}
			member.MoreMemberAxns(userId);
			return false;
		}
	
		public boolean withdrawChecking(int userId, double withdrawAmount) {
			log.info("@WithdrawMoney in TransaxnService");
			a = aDao.findByUserId(userId);
			if (a.getAcntType() == 1) {
				if (a.getAcntStatus() == 1) {
					b = a.getBalance();
					System.out.println("\nThe starting balance for checking account number " + a.getAccountId() + " is $" + b);
					if (b>= withdrawAmount) {
						b = b - withdrawAmount;
						System.out.println(b);
						a.setBalance(b);
						System.out.println("\nWith a withdrawal of $" + withdrawAmount + ", the new balance for this account is $" + b);
						aDao.updateAccount(a);
						member.MoreMemberAxns(userId);
						return true;
				} else {
					System.out.println("\nThere are not enough finds to withdraw $" + withdrawAmount);
					member.MoreMemberAxns(userId);
					return false;}
				}
			}else {
				System.out.println("\nIt seems that you do not have an active checking account. Please see an admin.\"");
				return false;
			}
			return false;
		}
		
		public boolean withdrawSavings(int userId, double withdrawAmount) {
			log.info("@WithdrawMoney in TransaxnService");	
			a = aDao.findByUserId(userId);
			if (a.getAcntType() == 2) {
				if (a.getAcntStatus() == 1) {
					b = a.getBalance();
					System.out.println("\nThe starting balance for savings account number " + a.getAccountId() + " is $" + b);
					if (b>= withdrawAmount) {
						b = b - withdrawAmount;
						a.setBalance(b);
						System.out.println("\nWith a withdrawal of $" + withdrawAmount + ", the new balance for this account is $" + b);
						aDao.updateAccount(a);
						member.MoreMemberAxns(userId);
						return true;
				} else {
					System.out.println("\nThere are not enough finds to withdraw $" + withdrawAmount);
					member.MoreMemberAxns(userId);
					return false;}
				}
			}else {
				System.out.println("\nIt seems that you do not have an active savings account. Please see an admin.\"");
				return false;
			}
			return false;
		}
	
		public boolean transferMoney(int userId, int toId, double amount) {
			log.info("@TransferMoney in TransaxnService");
			a = aDao.findByUserId(userId);
			a2 = aDao.findByUserId(toId);
			double fromInitialBalance = a.getBalance();
			double toInitialBalance = a2.getBalance();
			if (fromInitialBalance > amount) {
				if (a.getAcntType() == 1) {
					System.out.println("Your checking account will be debited $" + amount + "\n");
					withdrawChecking(userId, amount);
					return true;
				}else if (a.getAcntType() == 2) {
					System.out.println("Your savings account will be debited $" + amount);
					withdrawSavings(userId, amount);
					return true;
				}else {
					System.out.println("There are not sufficient funds to make this transfer.");
					return false;
				}
			}
			if (fromInitialBalance > amount) {
				if (a2.getAcntType() == 1) {
					System.out.println("The checking account for member number " + toId + " will be credited $" + amount + "\n");
					depositChecking(toId, amount);
				}else if (a2.getAcntType() == 2){
					System.out.println("The checking account for member number " + toId + " will be credited $" + amount + "\n");
					depositSavings(toId, amount);
				}		
				return true;
			}
			return false;
		}
		
		//++++++++++++++++Actions Authorized for Employees and Admins********************
		
		public void confirmNewMember(User NewMember) {
			log.info("@ConfirmNewMember in TransaxnService");
			System.out.println(NewMember.getFirstName() + NewMember.getLastName() + " would like will\n"
					+ "to become a member of The Credit Union. Please review. If all looks good,\n"
					+ "set the UserType to 1. to activate the new user. Please also contact the\n"
					+ "new member to talk accounts that best meet needs.\n\n");

			
			System.out.println("Do you want to confirm this new membership?");
			String yesNo = scan.nextLine().toLowerCase();
			if (yesNo.equals("yes")) {
				NewMember.setUserType(1);
				uDao.addUser(NewMember);
				System.out.println("The new member has been issued a member number and has an active user\n"
								+ "account. Please ask an admin to contact the new member to set up accounts.\n");
				AdminScreen as = new AdminScreen();
				as.createNewAcnt(NewMember);
			}else {System.out.println("We are sorry. We cannot confirm your membership at this time.");}
		}
		
		public void confirmNewAcnt(Account NewAcnt) {
			
		}
		
		public List<User> CheckPendingUserProfiles() {
			log.info("@CheckPendingUserProfiles() in TransactionService");
			List<User> list = new ArrayList<>();
			List<User> l2 = new ArrayList<>();
			
			list = uDao.findAll();
			for (User u: list) {
				if (u.getUserType() == 4) {
					l2.add(u);
				}
				return l2;
			}
			return l2;
		}
}














