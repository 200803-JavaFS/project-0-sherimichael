package com.revature.services;

	
	import java.util.logging.LogManager;
	import java.util.logging.Logger;

import com.revature.models.Account;
import com.revature;
import com.revature.dao.AccountDAO;

public class AccountServices {

	public class AccountServices{
		private static final Logger log = LogManager.getLogger(AccountService.class);
		
		private AccountDAO dao= new AccountDAO(); 
		
		public Account findAccountById(int id) {
			log.info("I am accessing account "+id+" from the service.");
			
			return dao.findById(id); 
			
		}

	}

}
