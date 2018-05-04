package pl.coderslab.warsztaty3.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.warsztaty3.dao.ExerciseDao;
import pl.coderslab.warsztaty3.dao.UserDao;
import pl.coderslab.warsztaty3.util.DbUtil;

/**
 * Servlet implementation class AdminExercises
 */
@WebServlet("/admin-exercises")
public class AdminExercises extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminExercises() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ExerciseDao exercisesDao = new ExerciseDao();
		try {
			Connection c = DbUtil.getConn();
			request.setAttribute("exercises", (exercisesDao.loadAllExercises(c)));
			getServletContext().getRequestDispatcher("/WEB-INF/views/exercise/admin-exercise.jsp").forward(request,
					response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
