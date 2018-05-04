package pl.coderslab.warsztaty3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pl.coderslab.warsztaty3.model.SolutionMainPage;

public class SolutionMainPaigeDao {

	static public SolutionMainPage[] loadAllSolution(Connection conn, int number) throws SQLException {
		ArrayList<SolutionMainPage> solutions = new ArrayList<SolutionMainPage>();
		PreparedStatement preparedStatement;
		preparedStatement = conn
				.prepareStatement("SELECT title, username, solution.created, solution.id FROM solution \n"
						+ "JOIN exercise on solution.exercise_id = exercise.id \n"
						+ "JOIN users ON solution.users_id = users.id ORDER BY solution.created DESC LIMIT ?");
		preparedStatement.setInt(1, number);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			SolutionMainPage loadedSolution = new SolutionMainPage();
			loadedSolution.setExerciseTitle(resultSet.getString("title"));
			loadedSolution.setUsername(resultSet.getString("username"));
			loadedSolution.setCreated(resultSet.getDate("solution.created"));
			loadedSolution.setId(resultSet.getInt("solution.id"));
			solutions.add(loadedSolution);
		}
		SolutionMainPage[] uArray = new SolutionMainPage[solutions.size()];
		uArray = solutions.toArray(uArray);
		return uArray;
	}

}
