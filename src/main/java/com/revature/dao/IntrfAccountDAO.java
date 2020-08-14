package com.revature.dao;

import java.util.List;

import com.revature.models.Account;

public interface IntrfAccountDAO {
	//These methods handle CRUD ops and read info back to Java
	
		public List<Account> findAllUsers();
		public Account findbyId(int id);
		public boolean addAccount(Account addAccount);
		public boolean updateAccount(Account updateAccount);

}
