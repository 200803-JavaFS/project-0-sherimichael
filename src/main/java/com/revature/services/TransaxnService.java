package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.AccountDAO;
import com.revature.dao.UserDAO;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.utils.MemberScreen;

public class TransaxnService {
	
	private static final Logger log = LogManager.getLogger(TransaxnService.class); 
	
		AccountDAO aDao = new AccountDAO();
		Account a = new Account();
		User u = new User();
		UserDAO uDao = new UserDAO();
		MemberScreen member = new MemberScreen();
		
		private double b;
	
		public double getAcntBalance(String choice, int userId) {
			log.info("@getAcntBalance in TransaxnService");
			a = aDao.findByUserId(userId);
			System.out.println(a);
			int aId = a.getAccountId();
			if (uDao.findById(userId).getUserType() == 1) {
				if (aDao.findByAcntId(aId).getAcntType() == 1) {
					System.out.println("Your checking account balance is $" + aDao.findByAcntId(aId).getBalance());
				}else {
					System.out.println("Your savings account balance is $" + aDao.findByAcntId(aId).getBalance());
				} 
			}else if ((uDao.findById(userId).getUserType() == 2)|| (uDao.findById(userId).getUserType() == 3)){
				if (aDao.findByAcntId(aId).getAcntType() == 1) {
					System.out.println("The checking account balance for user id "+ userId + " is $" + aDao.findByAcntId(aId).getBalance());
				}else {
					System.out.println("The savings account balance for user id "+ userId + " is $" + aDao.findByAcntId(aId).getBalance());
				} 
			}
			member.MoreMemberAxns(userId);
			return aDao.findByAcntId(aId).getBalance();
		}
	
		public double DepositMoney(int userId, int depositAmount) {
			log.info("@MakeDeposit in TransaxnService");
			a = aDao.findByUserId(userId);
			System.out.println(a);
			int aId = a.getAccountId();
			b = aDao.findByAcntId(aId).getBalance();
			System.out.println("Your starting balance was $" + b);
			b = b + depositAmount;
			a.setBalance(b);
			System.out.println("With a deposit of $" + depositAmount + ", your new balance is $" + b);
			aDao.updateAccount(a);
			member.MoreMemberAxns(userId);
			return b;
		}
	
		public double WithdrawMoney(int userId, int withdrawAmount) {
			log.info("@gWithdrawMoney in TransaxnService");	
			a = aDao.findByUserId(userId);
			System.out.println(a);
			int aId = a.getAccountId();
			b = aDao.findByAcntId(aId).getBalance();
			System.out.println("Your starting balance was $" + b);
			if (b>= withdrawAmount) {
				b = withdrawAmount - b;
				a.setBalance(b);
				System.out.println("With a withdrawal of $" + withdrawAmount + ", your new balance is $" + b);
				aDao.updateAccount(a);
				member.MoreMemberAxns(userId);
				return b;
			} else {
				System.out.println("There are not enough finds to withdraw $" + withdrawAmount);
				member.MoreMemberAxns(userId);
				return b;
			}
		}
	
		public void TransferMoney() {
			log.info("@gTransferwMoney in TransaxnService");	
		}
		
		public void CheckAcntInfo(int userId) {
			log.info("@gWithdrawMoney in TransaxnService");	
			a = aDao.findByUserId(userId);
			System.out.println(a);
			System.out.println("Account Info for " + a.getAccountId() + " for " + a.getUserID() + ":" + a);		
		}
		
		public void CheckPersonalInfo(int userId) {
			log.info("@CheckPersonalInfo in TransaxnService");	
			u = uDao.findById(userId);
			System.out.println("Personal info for user id " + u.getUserId() + ":" + u);			
		}
}
