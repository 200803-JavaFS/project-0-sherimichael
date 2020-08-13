/*
 * An Admin is an admin of the credit union.
 * This class extends the class, User, and assigns a member to be of userType=ADMIN
 */

package com.revature.models;

import java.io.Serializable;

public class Admin extends User implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	public Admin(String email) {
		super(email, UserType.ADMIN);
	}

}
