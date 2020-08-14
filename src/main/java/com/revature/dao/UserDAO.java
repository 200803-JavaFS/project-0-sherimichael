package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.models.User.UserType;
import com.revature.utils.ConnectionUtility;

public class UserDAO implements IntrfUserDAO {
	
	private IntrfAccountDAO intrAccountDao = new AccountDAO();

	@Override
	public List<User> findAllUsers() {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "SELECT * FROM users;";

			Statement statement = conn.createStatement();

			List<User> list = new ArrayList<>();

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				User user = new User(result.getString("user_type"), result.getString("first_name"),
						result.getString("last_name"), null,
						result.getString("password"));
				if (result.getString("email_fk") != null) {
					user.setEmail(((Object) intrAccountDao).findById(result.getString("email_fk")));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUser(User addUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User updateUser) {
		// TODO Auto-generated method stub
		return false;
	}

}
