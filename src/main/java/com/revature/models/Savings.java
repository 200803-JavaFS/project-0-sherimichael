package com.revature.models;

import java.io.Serializable;

public class Savings extends Account implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	public Savings(int accountNo) {
		super(accountNo, AcntType.SAVINGS);
	}

}