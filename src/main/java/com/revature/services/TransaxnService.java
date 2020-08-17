package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.AccountDAO;
import com.revature.models.Account;

public class TransaxnService {
	
	private static final Logger log = LogManager.getLogger(TransaxnService.class); 
	
		AccountDAO aDao = new AccountDAO();
		Account a = new Account();
		
		private double b;
	
		public double getAcntBalance(String choice, int id) {
			log.info("@getAcntBalance in TransaxnService");
			a = aDao.findByUserId(id);
			System.out.println(a);
				int aId = a.getAccountId();
				return aDao.findByAcntId(aId).getBalance();
		}
	
		public double DepositMoney(int userId, int depositAmount) {
			log.info("@MakeDeposit in TransaxnService");
			a = aDao.findByUserId(userId);
			System.out.println(a);
			int aId = a.getAccountId();
			b = aDao.findByAcntId(aId).getBalance();
			b = b + depositAmount;
			a.setBalance(b);
			aDao.updateAccount(a);
			return b;
		}
	
		public double WithdrawMoney(int userId, int withdrawAmount) {
			log.info("@gWithdrawMoney in TransaxnService");	
			a = aDao.findByUserId(userId);
			System.out.println(a);
			int aId = a.getAccountId();
			b = aDao.findByAcntId(aId).getBalance();
			if (b>= withdrawAmount) {
				b = withdrawAmount - b;
				b = a.getBalance();
				aDao.updateAccount(a);
				return b;
			} else {
				System.out.println("There are not enough finds to withdraw $" + withdrawAmount);
				return b;
			}
		}
	
		public void TransferMoney() {
			log.info("@gTransferwMoney in TransaxnService");	
		}
}
