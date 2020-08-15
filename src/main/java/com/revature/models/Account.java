package com.revature.models;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	private int accountNo;
	private int acntType; //1 = checking, 2 = savings
	private double balance;
	private boolean isJoint; // default=false
	
	public Account() {
		super();
	}
	
	public Account(int accountNo, int acntType, double balance, boolean isJoint) {
		super();
		this.accountNo = accountNo;
		this.acntType = acntType;
		this.balance = balance;
		this.isJoint = isJoint;
	}
	
	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
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

	public boolean isJoint() {
		return isJoint;
	}

	public void setJoint(boolean isJoint) {
		this.isJoint = isJoint;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", acntType=" + acntType + ", balance=" + balance + ", isJoint="
				+ isJoint + "]";
	}
	
}
