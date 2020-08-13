/*
 * This class holds all the info to create a User Object. 
 * A User can be a Member, an Employee, or an Admin
 */

package com.revature.models;

//importing Serializable for best practice
import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	private UserType userType;
	private String firstName;
	private String lastName;
	private String email; //login uname is email
	private String password;
	
	//info on enum https://www.geeksforgeeks.org/enum-in-java/
	public enum UserType {
		MEMBER, EMPLOYEE, ADMIN;
	}
	
	//Constructors
	
	public User() {}
	
	public User(String email) {
		this.setEmail(email);		
	}
	
	public User(String email, UserType userType) {
		this.setEmail(email);
		this.userType = userType;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
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
		return "User [userType=" + userType + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}

}

