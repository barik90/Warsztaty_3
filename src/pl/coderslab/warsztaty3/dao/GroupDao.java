package pl.coderslab.warsztaty3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.warsztaty3.model.Group;

public class GroupDao {

	public void saveToDB(Connection conn, Group group) throws SQLException {
		if (group.getId() == 0) {
			String sql = "INSERT INTO user_group(name) VALUES (?)";
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns);
			preparedStatement.setString(1, group.getName());
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				group.setId(rs.getInt(1));
			}
		} else {
			String sql = "UPDATE user_group SET where id=?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, group.getName());
			preparedStatement.setInt(2, group.getId());
			preparedStatement.executeUpdate();
		}
	}

	static public Group loadGroupById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM user_group where id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Group loadedGroup = new Group();
			loadedGroup.setId(resultSet.getInt("id"));
			loadedGroup.setName(resultSet.getString("name"));
			return loadedGroup;
		}
		return null;
	}

	static public Group[] loadAllGroups(Connection conn) throws SQLException {
		ArrayList<Group> groups = new ArrayList<Group>();
		String sql = "SELECT * FROM	user_group";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Group loadedGroup = new Group();
			loadedGroup.setId(resultSet.getInt("id"));
			loadedGroup.setName(resultSet.getString("name"));
			groups.add(loadedGroup);
		}
		Group[] uArray = new Group[groups.size()];
		uArray = groups.toArray(uArray);
		return uArray;
	}

	public void delete(Connection conn, int id) throws SQLException {
		if (id != 0) {
			String sql = "DELETE FROM user_group WHERE id= ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			id = 0;
		}
	}
}
