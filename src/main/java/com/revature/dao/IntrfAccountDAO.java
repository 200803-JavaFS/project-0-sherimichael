package com.revature.dao;

import java.util.List;

import com.revature.models.Account;

public interface IntrfAccountDAO {
	//These methods handle CRUD ops and read info back to Java
	
		public List<Account> findAllAccounts();
		public Account findByUserId(int acntId);
		public Account findByAcntId(int id);
		public boolean addAccount(Account newAccount);
		public boolean updateAccount(Account changedAccount);
}
