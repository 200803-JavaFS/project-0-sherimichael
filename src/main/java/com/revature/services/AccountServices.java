package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Account;
import com.revature.dao.AccountDAO;
import com.revature.dao.IntrfAccountDAO;
import com.revature.dao.IntrfUserDAO;
import com.revature.dao.UserDAO;

import java.util.List;

public class AccountServices {

		private static final Logger log = LogManager.getLogger(AccountServices.class);
		
		private static IntrfUserDAO uDao = new UserDAO();
		private static IntrfAccountDAO aDao = new AccountDAO();
		
		public List<Account> findAllAccounts() {
			log.info("Retrieving all accounts from the service.");
			return aDao.findAllAccounts();
			}
		
		public Account findAccountByAcntId(int acntId) {
			log.info("I am accessing account "+acntId+" from the service.");
			return aDao.findByAcntId(acntId); 			
		}
		
		public boolean addAccount(Account acnt) {
			log.info("adding new account from the service.");
			if (aDao.addAccount(acnt)) {
				return true;
			}	
			return false; 			
		}
		
		public boolean updateAccount(Account acnt) {
			log.info("updating account from the service.");
			if (aDao.updateAccount(acnt)) {
				return true;
			}	
			return false; 			
		}

}




