package pl.coderslab.warsztaty3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.warsztaty3.model.Solution;

public class SolutionDao {

	public void saveToDB(Connection conn, Solution solution) throws SQLException {
		if (solution.getId() == 0) {
			String sql = "INSERT INTO solution(created, updated, description, exercise_id, users_id) VALUES (?, ?, ?, ?, ?)";
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns);
			preparedStatement.setDate(1, solution.getCreated());
			preparedStatement.setDate(2, solution.getUpdated());
			preparedStatement.setString(3, solution.getDescription());
			preparedStatement.setInt(4, solution.getExercise_id());
			preparedStatement.setInt(5, solution.getUsers_id());
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				solution.setId(rs.getInt(1));
			}
		} else {
			String sql = "UPDATE solution SET created=?, updated=?, description=?, exercise_id=?, users_id=? where id=?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setDate(1, solution.getCreated());
			preparedStatement.setDate(2, solution.getUpdated());
			preparedStatement.setString(3, solution.getDescription());
			preparedStatement.setInt(4, solution.getExercise_id());
			preparedStatement.setInt(5, solution.getUsers_id());
			preparedStatement.setInt(6, solution.getId());
			preparedStatement.executeUpdate();
		}
	}

	static public Solution loadSolutionById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM solution where id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.setId(resultSet.getInt("id"));
			loadedSolution.setCreated(resultSet.getDate("created"));
			loadedSolution.setUpdated(resultSet.getDate("updated"));
			loadedSolution.setDescription(resultSet.getString("description"));
			loadedSolution.setExercise_id(resultSet.getInt("exercise_id"));
			loadedSolution.setUsers_id(resultSet.getInt("users_id"));
			return loadedSolution;
		}
		return null;
	}

	static public Solution[] loadAllSolution(Connection conn, Solution solution) throws SQLException {
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		String sql = "SELECT * FROM	solution";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.setId(resultSet.getInt("id"));
			loadedSolution.setCreated(resultSet.getDate("created"));
			loadedSolution.setUpdated(resultSet.getDate("updated"));
			loadedSolution.setDescription(resultSet.getString("description"));
			loadedSolution.setExercise_id(resultSet.getInt("exercise_id"));
			loadedSolution.setUsers_id(resultSet.getInt("users_id"));
			solutions.add(loadedSolution);
		}
		Solution[] uArray = new Solution[solutions.size()];
		uArray = solutions.toArray(uArray);
		return uArray;
	}

	static public Solution[] loadAllSolution(Connection conn, int number) throws SQLException {
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement("SELECT * FROM solution ORDER BY created DESC LIMIT ?");
		preparedStatement.setInt(1, number);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.setId(resultSet.getInt("id"));
			loadedSolution.setCreated(resultSet.getDate("created"));
			loadedSolution.setUpdated(resultSet.getDate("updated"));
			loadedSolution.setDescription(resultSet.getString("description"));
			loadedSolution.setExercise_id(resultSet.getInt("exercise_id"));
			loadedSolution.setUsers_id(resultSet.getInt("users_id"));
			solutions.add(loadedSolution);
		}
		Solution[] uArray = new Solution[solutions.size()];
		uArray = solutions.toArray(uArray);
		return uArray;
	}

	static public Solution[] testloadAllSolution(Connection conn, int number) throws SQLException {
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(
				"SELECT exercise.title, users.username, solution.created FROM exercise, users, solution ORDER BY created DESC LIMIT ?");
		preparedStatement.setInt(1, number);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.setId(resultSet.getInt("id"));
			loadedSolution.setCreated(resultSet.getDate("created"));
			loadedSolution.setUpdated(resultSet.getDate("updated"));
			loadedSolution.setDescription(resultSet.getString("description"));
			loadedSolution.setExercise_id(resultSet.getInt("exercise_id"));
			loadedSolution.setUsers_id(resultSet.getInt("users_id"));
			solutions.add(loadedSolution);
		}
		Solution[] uArray = new Solution[solutions.size()];
		uArray = solutions.toArray(uArray);
		return uArray;
	}

	public void delete(Connection conn, int id) throws SQLException {
		if (id != 0) {
			String sql = "DELETE FROM solution WHERE id= ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			id = 0;
		}
	}
}
