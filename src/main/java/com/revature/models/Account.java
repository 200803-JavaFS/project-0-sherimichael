package com.revature.models;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	private String accountNo;
	private String email;
	private int acntType; //1 = checking, 2 = savings
	private double balance;
	private int acntStatus;
	private boolean isActive;
	private boolean isJoint; // default=false
	
	public Account() {
		super();
	}
	
	public Account(String accountNo, String email, int acntType, double balance, boolean isJoint) {
		super();
		this.accountNo = accountNo;
		this.acntType = acntType;
		this.balance = balance;
		this.isJoint = isJoint;
	}
	
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isJoint() {
		return isJoint;
	}

	public void setJoint(boolean isJoint) {
		this.isJoint = isJoint;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", email=" + email + ", acntType=" + acntType + ", balance="
				+ balance + ", acntStatus=" + acntStatus + ", isActive=" + isActive + ", isJoint=" + isJoint + "]";
	}
}
