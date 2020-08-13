/*
 * A member is a customer of the credit union.
 * This class extends the class, User, and assigns a member to be of userType=MEMBER
 */


package com.revature.models;

import java.io.Serializable;

public class Member extends User implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	public Member(String email) {
		super(email, UserType.MEMBER);
	}

}
