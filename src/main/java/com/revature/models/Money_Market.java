package com.revature.models;

import java.io.Serializable;

public class Money_Market extends Account implements Serializable {
	
	private static final long serialVersionUID = 1L; 
		
	public Money_Market(int accountNo) {
		super(accountNo, AcntType.MONEY_MARKET);
	}

}
