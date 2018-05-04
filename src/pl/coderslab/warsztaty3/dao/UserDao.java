package pl.coderslab.warsztaty3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pl.coderslab.warsztaty3.model.User;

public class UserDao {

	public void saveToDB(Connection conn, User user) throws SQLException {
		if (user.getId() == 0) {
			String sql = "INSERT INTO users(username, email, password, user_group_id) VALUES (?, ?, ?, ?)";
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, user.getUserGroupId());
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				user.setId(rs.getInt(1));
			}
		} else {
			String sql = "UPDATE users SET username=?, email=?, password=?, user_group_id=? where id=?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, user.getUserGroupId());
			preparedStatement.setInt(5, user.getId());
			preparedStatement.executeUpdate();
		}
	}

	static public User loadUserById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM users where id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			User loadedUser = new User();
			loadedUser.setId(resultSet.getInt("id"));
			loadedUser.setUsername(resultSet.getString("username"));
			loadedUser.setPassword(resultSet.getString("password"));
			loadedUser.setEmail(resultSet.getString("email"));
			loadedUser.setUserGroupId(resultSet.getInt("user_group_id"));
			return loadedUser;
		}
		return null;
	}

	static public User[] loadAllUserByGroupId(Connection conn, int id) throws SQLException {
		ArrayList<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users where user_group_id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			User loadedUser = new User();
			loadedUser.setId(resultSet.getInt("id"));
			loadedUser.setUsername(resultSet.getString("username"));
			loadedUser.setPassword(resultSet.getString("password"));
			loadedUser.setEmail(resultSet.getString("email"));
			users.add(loadedUser);
		}
		User[] uArray = new User[users.size()];
		uArray = users.toArray(uArray);
		return uArray;
	}

	static public User[] loadAllUsers(Connection conn) throws SQLException {
		ArrayList<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM	users";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			User loadedUser = new User();
			loadedUser.setId(resultSet.getInt("id"));
			loadedUser.setUsername(resultSet.getString("username"));
			loadedUser.setPassword(resultSet.getString("password"));
			loadedUser.setEmail(resultSet.getString("email"));
			users.add(loadedUser);
		}
		User[] uArray = new User[users.size()];
		uArray = users.toArray(uArray);
		return uArray;
	}

	public void delete(Connection conn, int id) throws SQLException {
		if (id != 0) {
			String sql = "DELETE FROM users WHERE id= ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			id = 0;
		}
	}

}
