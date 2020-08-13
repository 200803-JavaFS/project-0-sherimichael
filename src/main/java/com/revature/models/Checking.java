package com.revature.models;

import java.io.Serializable;

public class Checking extends Account implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	public Checking(int accountNo) {
		super(accountNo, AcntType.CHECKING);
	}

}
