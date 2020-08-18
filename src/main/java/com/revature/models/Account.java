package com.revature.models;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	private int accountId;
	private int acntType;
	private double balance;
	private int acntStatus;
	private User userID;
	
	//no args constructor
	public Account() {
		super();
	}

	//full args constructor
	public Account(int accountId, int acntType, double balance, int acntStatus, User userID) {
		super();
		this.accountId = accountId;
		this.acntType = acntType;
		this.balance = balance;
		this.acntStatus = acntStatus;
		this.userID = userID;
	}

	//full args - accountId(serial -pk) field
	public Account(int acntType, double balance, int acntStatus, User userID) {
		super();
		this.acntType = acntType;
		this.balance = balance;
		this.acntStatus = acntStatus;
		this.userID = userID;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAcntType() {
		return acntType;
	}

	public void setAcntType(int acntType) {
		this.acntType = acntType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAcntStatus() {
		return acntStatus;
	}

	public void setAcntStatus(int acntStatus) {
		this.acntStatus = acntStatus;
	}

	public User getUserID() {
		return userID;
	}

	public void setUserID(User userID) {
		this.userID = userID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", acntType=" + acntType
				+ ", balance=" + balance + ", acntStatus=" + acntStatus + ", userID=" + userID
				+ "]";
	}

	
}
