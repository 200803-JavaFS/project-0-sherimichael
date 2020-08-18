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

import com.revature.models.User;
import com.revature.utils.ConnectionUtility;

public class UserDAO implements IntrfUserDAO {

	private User user = new User();

	@Override
	public List<User> findAll() {
		
			try (Connection conn = ConnectionUtility.getConnection()) {
				String sql = "SELECT * FROM users;";

				Statement statement = conn.createStatement();

				List<User> list = new ArrayList<>();

				ResultSet result = statement.executeQuery(sql);
				

				while (result.next()) {
					
							user.setUserId(result.getInt("user_id"));
							user.setUserType(result.getInt("user_type"));
							user.setFirstName(result.getString("first_name"));
							user.setLastName(result.getString("last_name")); 
							user.setEmail(result.getString("email"));
							user.setPassword(result.getString("pword"));
							list.add(user);
				}
				return list;
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}
	

	@Override
	public User findById(int id) {
			try (Connection conn = ConnectionUtility.getConnection()) {
				String sql = "SELECT * FROM users WHERE user_id =" + id + ";";

				Statement statement = conn.createStatement();

				ResultSet result = statement.executeQuery(sql);

				if (result.next()) {
					User user = new User(
							result.getInt("user_id"),
							result.getInt("user_type"), 
							result.getString("first_name"),
							result.getString("last_name"),
							result.getString("email") ,
							result.getString("pword"));  
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

			String sql = "INSERT INTO users (user_type, first_name, last_name, email, pword)"
					+ "VALUES (?, ?, ?, ?, ?);";

			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setInt(++index, user.getUserType());
			statement.setString(++index, user.getFirstName());
			statement.setString(++index, user.getLastName());
			statement.setString(++index, user.getEmail());
			statement.setString(++index, user.getPassword());
			
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
			String sql = "UPDATE users SET user_type = ?, first_name= ?, "
					+ "last_name = ?, email= ?, pword = ? WHERE user_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setInt(++index, user.getUserId());
			statement.setInt(++index, user.getUserType());
			statement.setString(++index, user.getFirstName());
			statement.setString(++index, user.getLastName());
			statement.setString(++index, user.getEmail());
			statement.setString(++index, user.getPassword());
			
			statement.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	//Delete method included for admins and employees who no longer work for The Credit Union
	@Override
	public boolean deleteUser(int userId) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "DELETE FROM users WHERE user_type !=1 and user_id =" + userId + ";";

			Statement statement = conn.createStatement();

			statement.execute(sql);
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
