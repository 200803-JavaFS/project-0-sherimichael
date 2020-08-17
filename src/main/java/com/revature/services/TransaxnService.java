package com.revature.services;

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
		User u = new User();
		UserDAO uDao = new UserDAO();
		MemberScreen member = new MemberScreen();
		EmployeeScreen employee = new EmployeeScreen();
		AdminScreen admin = new AdminScreen();
		
		private double b;
	
		//**********Actions Authorized for All User Types (Members, Employees, Admins)******
		public boolean getAcntBalance(String choice, int memberUserId, int userType) {
			log.info("@getAcntBalance in TransaxnService");
			a = aDao.findByUserId(memberUserId);
			int aId = a.getAccountId();
			int aType = a.getAcntType();
			if (a.getAcntStatus() == 1) {
				if (aType == 1) {
					System.out.println("\nThe checking account balance for member " + memberUserId + " is $" + aDao.findByAcntId(aId).getBalance()+"\n");
					if (userType ==1) {member.MoreMemberAxns(memberUserId); return true;}
					else if (userType == 2) {employee.EmployeeApp(); return true;}
					else if (userType == 3) {admin.AdminApp(); return true;}
					else {System.out.println("\nYou do not have authorization to deposit money into this account.");
						return false;}
				}else if (aType == 1) {
					System.out.println("\nThe checking account balance for member " + memberUserId + " is $" + aDao.findByAcntId(aId).getBalance()+"\n");
					if (userType ==1) {member.MoreMemberAxns(memberUserId); return true;}
					else if (userType == 2) {employee.EmployeeApp(); return true;}
					else if (userType == 3) {admin.AdminApp(); return true;}
					else {System.out.println("\nYou do not have authorization to deposit money into this account.");
						return false;}
				}
			}return false;
		}
		
		public User createNewMember(String firstName, String lastName, String email, String password) {
			log.info("@CreateNewMember in TransaxnService");
			u.setFirstName(firstName);
			u.setLastName(lastName);
			u.setEmail(email);
			u.setPassword(password);
			u.setUserType(4);
			return u;			
		}
		
		public void checkAcntInfo(int userId) {
			log.info("@CheckAcntInfo in TransaxnService");	
			a = aDao.findByUserId(userId);
			System.out.println("Account Info for " + a.getAccountId() + " for " + a.getUserID() + ":" + a);		
		}
		
		public void checkPersonalInfo(int userId) {
			log.info("@CheckPersonalInfo in TransaxnService");	
			u = uDao.findById(userId);
			System.out.println("Personal info for user id " + u.getUserId() + ":" + u);			
		}
		
		//**********Actions Authorized for Members and Admins)******
	
		public boolean depositMoney(int userId, double depositAmount) {
			log.info("@MakeDeposit in TransaxnService");
			if ((uDao.findById(userId).getUserType() ==1) || (uDao.findById(userId).getUserType() == 3)){
				a = aDao.findByUserId(userId);
				int aId = a.getAccountId();
				b = aDao.findByAcntId(aId).getBalance();
				System.out.println("The starting balance for account number " + a.getAccountId() + " is $" + b);
				b = b + depositAmount;
				a.setBalance(b);
				System.out.println("With a deposit of $" + depositAmount + ", the new balance for this account is $" + b);
				aDao.updateAccount(a);
				member.MoreMemberAxns(userId);
				return true;
			}else {
				System.out.println("You do not have authorization to deposit money into this account.");
				return false;}
		}
	
		public boolean withdrawMoney(int userId, double withdrawAmount) {
			log.info("@WithdrawMoney in TransaxnService");	
			a = aDao.findByUserId(userId);
			if ((uDao.findById(userId).getUserType() ==1) || (uDao.findById(userId).getUserType() == 3)){
				if (a.getAcntStatus() == 1) {
					System.out.println(a);
					int aId = a.getAccountId();
					b = aDao.findByAcntId(aId).getBalance();
					System.out.println("The starting balance for account number " + a.getAccountId() + " is $" + b);
					if (b>= withdrawAmount) {
						b = withdrawAmount - b;
						a.setBalance(b);
						System.out.println("With a withdrawal of $" + withdrawAmount + ", the new balance for this account is $" + b);
						aDao.updateAccount(a);
						member.MoreMemberAxns(userId);
						return true;
				} else {
					System.out.println("There are not enough finds to withdraw $" + withdrawAmount);
					member.MoreMemberAxns(userId);
					return false;}
				}
			}else {
				System.out.println("You do not have authorization to deposit money into this account.");
				return false;}
			return false;
		}
	
		public void transferMoney() {
			log.info("@TransferMoney in TransaxnService");	
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
				as.createNewAcnt();
			}else {System.out.println("We are sorry. We cannot confirm your membership at this time.");}
		}
		
		public void confirmNewAcnt(Account NewAcnt) {
			
		}
}
