/*
 * An Employee is an employee of the credit union.
 * This class extends the class, User, and assigns a member to be of userType=EMPLOYEE
 */

package com.revature.models;

import java.io.Serializable;

public class Employee extends User implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	public Employee(String email) {
		super(email, UserType.EMPLOYEE);
	}

}
