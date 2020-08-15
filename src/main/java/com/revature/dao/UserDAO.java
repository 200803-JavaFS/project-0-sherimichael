/*
 * UserDAO implements the interface, IntrfUserDAO.
 * Methods to manipulate data in SQL dB:
 * FindAllUsers(), FindById(), AddUser(User user),
 * UpdateUser(User user)
 * 
 * Note: DeleteUser(User user) is included for employees & admins.
 * We will never delete a member account, even if they leave the credit union
 */

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

public class UserDAO implements IntrfUserDAO {
	
	private IntrfAccountDAO iAcntDao = new AccountDAO();

	@Override
	public List<User> findAllUsers() {
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM acnt_holders;";

			Statement statement = conn.createStatement();

			List<User> list = new ArrayList<>();

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				User user = new User(result.getInt("id"),result.getInt("user_type"), result.getString("first_name"),
						result.getString("last_name"), null,
						result.getString("pword"));
				if (result.getString("email_fk") != null) {
					user.setEmail(iAcntDao.findbyAcntNo(result.getString("email_fk")));
				} 
				list.add(user);
			}
			return list;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findbyId(int id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM avengers WHERE superhero_id =" + id + ";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			if (result.next()) {
				User user = new User(result.getInt("id"),result.getInt("user_type"), result.getString("first_name"),
						result.getString("last_name"), null,
						result.getString("pword"));
				if (result.getString("email_fk") != null) {
					user.setEmail(iAcntDao.findbyAcntNo(result.getString("email_fk")));
				} 
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(User user) {
		try (Connection conn = ConnectionUtility.getConnection()) {

			String sql = "INSERT INTO acnt_holders (user_type, first_name, last_name, pword, email_fk)"
					+ "VALUES (?, ?, ?, ?, ?);";

			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setInt(++index, user.getUserType());
			statement.setString(++index, user.getFirstName());
			statement.setString(++index, user.getLastName());
			statement.setString(++index, user.getPassword());
			if(user.getEmail()!=null) {
				Account account = user.getEmail();
				statement.setString(++index, account.getEmail());
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
	public boolean updateUser(User user) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE acnt_holders SET user_type = ?, first_name= ?, "
					+ "last_name = ?, email_fk = ? WHERE user_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setInt(++index, user.getUserType());
			statement.setString(++index, user.getFirstName());
			statement.setString(++index, user.getLastName());
			statement.setString(++index, user.getPassword());
			if(user.getEmail()!=null) {
				Account account = user.getEmail();
				statement.setString(++index, account.getEmail());
			}else {
				statement.setString(++index, null);
			}
			statement.setInt(++index, user.getId());
			
			statement.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean addUserWithJointAccnt(User user) {
		try (Connection conn = ConnectionUtility.getConnection()){
			
			String sql = "BEGIN; "
					+ "INSERT INTO accounts (acnt_no, email, acnt_type, balance, isJoint, acnt_status, isActive)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?);"
					+ "INSERT INTO users (user_type, first_name, last_name, email_fk, pword)"
					+ "VALUES (?, ?, ?, ?, ?);"
					+ "COMMIT;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			Account acnt = user.getEmail();
			
			int index = 0;
			statement.setString(++index, acnt.getAccountNo());
			statement.setInt(++index, acnt.getAcntType());
			statement.setDouble(++index, acnt.getBalance());
			statement.setBoolean(++index, acnt.isJoint());
			statement.setInt(++index, acnt.getAcntStatus());
			statement.setBoolean(++index, acnt.isActive());
			statement.setInt(++index, user.getUserType());
			statement.setString(++index, user.getFirstName());
			statement.setString(++index, user.getLastName());
			statement.setString(++index, user.getPassword());
			statement.setString(++index, acnt.getEmail());
			
			statement.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//Delete method included for admins and employees who no longer work for The Credit Union
	@Override
	public boolean deleteUser(int userId) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "DELETE FROM avengers WHERE superhero_id =" + userId + ";";

			Statement statement = conn.createStatement();

			statement.execute(sql);
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	


}
