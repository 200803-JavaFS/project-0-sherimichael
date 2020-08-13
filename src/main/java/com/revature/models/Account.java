package com.revature.models;

import java.io.Serializable;

public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	private int accountNo;
	private AcntType acntType;
	private double balance;
	private boolean isJoint; // default=false
	private boolean isLinked;
	
	public enum AcntType {
		CHECKING, SAVINGS, MONEY_MARKET;
	}
	
	public Account () {}
	
	public Account(int accountNo, AcntType acntType) {
		this.accountNo = accountNo;
		this.acntType = acntType;
	}
	
	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public AcntType getAcntType() {
		return acntType;
	}

	public void setAcntType(AcntType acntType) {
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
	
	public boolean isLinked() {
		return isLinked;
	}

	public void setLinked(boolean isLinked) {
		this.isLinked = isLinked;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", acntType=" + acntType + ", balance=" + balance + ", isJoint="
				+ isJoint + ", isLinked=" + isLinked + "]";
	}

	


	
		
	
}
