package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.utils.ConnectionUtility;

public class AccountDAO implements IntrfAccountDAO {

	@Override
	public List<Account> findAllAccounts() {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM accounts;";
			
			Statement statement = conn.createStatement();
			
			List<Account> list = new ArrayList<>(); 
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				Account acnt = new Account();
				acnt.setAccountNo(result.getString("acnt_no"));
				acnt.setEmail(result.getString("email"));
				acnt.setAcntType(result.getInt("acnt_type"));
				acnt.setBalance(result.getDouble("balance"));
				acnt.setAcntStatus(result.getInt("acnt_status"));
				acnt.setActive(result.getBoolean("active"));
				acnt.setJoint(result.getBoolean("joint"));	
				
				list.add(acnt); 
			}
			
			return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Account findByAcntNo(String acnt_no) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM accounts WHERE acnt_no = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, acnt_no);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				Account acnt = new Account();
				acnt.setAccountNo(result.getString("acnt_no"));
				acnt.setEmail(result.getString("email"));
				acnt.setAcntType(result.getInt("acnt_type"));
				acnt.setBalance(result.getDouble("balance"));
				acnt.setAcntStatus(result.getInt("acnt_status"));
				acnt.setActive(result.getBoolean("active"));
				acnt.setJoint(result.getBoolean("joint"));	
				return acnt;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Account findByEmail(String email) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM accounts WHERE email = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, email);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				Account acnt = new Account();
				acnt.setAccountNo(result.getString("acnt_no"));
				acnt.setEmail(result.getString("email"));
				acnt.setAcntType(result.getInt("acnt_type"));
				acnt.setBalance(result.getDouble("balance"));
				acnt.setAcntStatus(result.getInt("acnt_status"));
				acnt.setActive(result.getBoolean("active"));
				acnt.setJoint(result.getBoolean("joint"));	
				return acnt;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean addAccount(Account acnt) {
		try(Connection conn = ConnectionUtility.getConnection()){
			
			String sql = "INSERT INTO accounts (email, acnt_no, balance, acnt_status, acnt_type, active, joint)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, acnt.getAccountNo());
			statement.setString(++index, acnt.getEmail());
			statement.setDouble(++index, acnt.getBalance());
			statement.setInt(++index, acnt.getAcntStatus());
			statement.setInt(++index, acnt.getAcntType());
			statement.setBoolean(++index, acnt.isActive());
			statement.setBoolean(++index, acnt.isJoint());

			statement.execute();
			return true; 
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateAccount(Account acnt) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE accounts SET user_type = ?, first_name= ?, "
					+ "last_name = ?, email_fk = ? WHERE user_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setString(++index, acnt.getAccountNo());
			statement.setDouble(++index, acnt.getBalance());
			statement.setInt(++index, acnt.getAcntStatus());
			statement.setInt(++index, acnt.getAcntType());
			statement.setBoolean(++index, acnt.isActive());
			statement.setBoolean(++index, acnt.isJoint());
			statement.setString(++index, acnt.getEmail());
			
			statement.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
