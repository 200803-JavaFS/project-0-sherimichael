//need deposit, withdraw, transfer

package com.revature.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Transaction implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	private static Map<Member, Account> memberAcnts = new HashMap<>();

	public static Map<Member, Account> getMemberAcnts() {
		return memberAcnts;
	}

	public static void setMemberAcnts(Map<Member, Account> memberAcnts) {
		Transaction.memberAcnts = memberAcnts;
	}
}
