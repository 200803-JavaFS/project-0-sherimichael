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
	
	private IntrfUserDAO uDao = new UserDAO();
	
	@Override
	public List<Account> findAllAccounts() {

	try (Connection conn = ConnectionUtility.getConnection()) {
		String sql = "SELECT * FROM accounts;";

		Statement statement = conn.createStatement();

		List<Account> list = new ArrayList<>();

		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			Account a = new Account(
					result.getInt("acnt_id"), 
					result.getInt("acnt_type"),
					result.getDouble("balance"), 
					result.getInt("acnt_status"),
					null);
			if (result.getInt("user_id_fk") != 0) {
				a.setUserID(uDao.findById(result.getInt("user_id_fk")));
			}
			list.add(a);
			}
			return list;

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public Account findByUserId(int id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE acnt_id =" + id + ";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			if (result.next()) {
				Account a = new Account(
					result.getInt("acnt_id"), 
					result.getInt("acnt_type"),
					result.getDouble("balance"), 
					result.getInt("acnt_status"),
					null);
				if (result.getInt("user_id_fk") != 0) {
					a.setUserID(uDao.findById(result.getInt("user_id_fk")));
				}
				return a;
			}
			} catch (SQLException e) {
				e.printStackTrace();
		}
		return null;
	}
	
	public Account findByAcntId(int id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE acnt_id =" + id + ";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			if (result.next()) {
				Account a = new Account(
					result.getInt("acnt_id"), 
					result.getInt("acnt_type"),
					result.getDouble("balance"), 
					result.getInt("acnt_status"),
					null);
				if (result.getInt("user_id_fk") != 0) {
					a.setUserID(uDao.findById(result.getInt("user_id_fk")));
				}
				return a;
			}
			} catch (SQLException e) {
				e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addAccount(Account a) {
		try (Connection conn = ConnectionUtility.getConnection()) {

			String sql = "INSERT INTO accounts (acnt_id, acnt_type, balance, acnt_status, user_id_fk)"
				+ "VALUES (?, ?, ?, ?, ?);";

			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setInt(++index, a.getAccountId());
			statement.setInt(++index, a.getAcntType());
			statement.setDouble(++index, a.getBalance());
			statement.setInt(++index, a.getAcntStatus());
			if(a.getUserID()!=null) {
				User u = a.getUserID();
				statement.setInt(++index, u.getUserId());
			}else {
				statement.setString(++index, null);
			}

			statement.execute();
			return true;

			} catch (SQLException e) {
			e.printStackTrace();
		}
			return false;
	}

	@Override
	public boolean updateAccount(Account a) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE accounts SET acnt_type = ?, balance= acnt_status = ?, user_id_fk =? WHERE acnt_id = ?;";
		
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setInt(++index, a.getAccountId());
			statement.setInt(++index, a.getAcntType());
			statement.setDouble(++index, a.getBalance());
			statement.setInt(++index, a.getAcntStatus());
			if(a.getUserID()!=null) {
				User u = a.getUserID();
				statement.setInt(++index, u.getUserId());
			}else {
				statement.setString(++index, null);
			}
			statement.setInt(++index, a.getAccountId());
		
			statement.execute();
			return true;
			}catch (SQLException e) {
				e.printStackTrace();
		}
	
		return false;
	}

}