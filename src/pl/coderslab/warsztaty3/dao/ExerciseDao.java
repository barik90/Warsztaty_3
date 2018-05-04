package pl.coderslab.warsztaty3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.coderslab.warsztaty3.model.Exercise;

public class ExerciseDao {

	public void saveToDB(Connection conn, Exercise exercise) throws SQLException {
		if (exercise.getId() == 0) {
			String sql = "INSERT INTO exercise(title, description) VALUES (?, ?)";
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns);
			preparedStatement.setString(1, exercise.getTitle());
			preparedStatement.setString(2, exercise.getDescription());
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				exercise.setId(rs.getInt(1));
			}
		} else {
			String sql = "UPDATE exercise SET title=?, description=? where id=?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, exercise.getTitle());
			preparedStatement.setString(2, exercise.getDescription());
			preparedStatement.setInt(3, exercise.getId());
			preparedStatement.executeUpdate();
		}
	}

	static public Exercise loadExerciseById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM exercise where id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Exercise loadedExercise = new Exercise();
			loadedExercise.setId(resultSet.getInt("id"));
			loadedExercise.setTitle(resultSet.getString("title"));
			loadedExercise.setDescription(resultSet.getString("description"));
			return loadedExercise;
		}
		return null;
	}

	static public Exercise[] loadAllExercises(Connection conn) throws SQLException {
		ArrayList<Exercise> exercises = new ArrayList<Exercise>();
		String sql = "SELECT * FROM	exercise";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Exercise loadedExercise = new Exercise();
			loadedExercise.setId(resultSet.getInt("id"));
			loadedExercise.setTitle(resultSet.getString("title"));
			loadedExercise.setDescription(resultSet.getString("description"));
			exercises.add(loadedExercise);
		}
		Exercise[] uArray = new Exercise[exercises.size()];
		uArray = exercises.toArray(uArray);
		return uArray;
	}

	public void delete(Connection conn, int id) throws SQLException {
		if (id != 0) {
			String sql = "DELETE FROM exercise WHERE id= ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			id = 0;
		}
	}

}
