/*
 * This class holds all the info to create a User Object. 
 * A User can be a Member, an Employee, or an Admin
 */

package com.revature.models;

//importing Serializable for best practice
import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	private int userId;
	private int userType; // 1 = member, 2 = employee, 3 = admin
	private String firstName;
	private String lastName;
	private String email; //login uname is email
	private String password;
	
	//Constructors
	
	public User() {
		super();
	}
	
	//full args minus id constructor
	public User(int userType, String firstName, String lastName, String email, String password) {
		super();
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	//full args constructor
	public User(int userId, int userType, String firstName, String lastName, String email, String password) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userType=" + userType + ", firstName=" + firstName + ", lastName=" + lastName + ", email_fk=" + email
				+ ", password=" + password + "]";
	}
	
}

