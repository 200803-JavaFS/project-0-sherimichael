/*
 * This class holds all the info to create a User Object. 
 * A User can be a Member, an Employee, or an Admin
 */

package com.revature.models;

//importing Serializable for best practice
import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	private int id;
	private int userType; // 1 = member, 2 = employee, 3 = admin
	private String firstName;
	private String lastName;
	private Account email; //login uname is email
	private String password;
	
	//Constructors
	
	public User() {
		super();
	}
	
	//full args minus id constructor
	public User(int userType, String firstName, String lastName, Account email, String password) {
		super();
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	//fulls args constructor
	public User(int id, int userType, String firstName, String lastName, Account email, String password) {
		super();
		this.id = id;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Account getEmail() {
		return email;
	}

	public void setEmail(Account email) {
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

