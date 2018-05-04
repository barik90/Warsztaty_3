package pl.coderslab.warsztaty3.controller.exercise;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.warsztaty3.dao.ExerciseDao;
import pl.coderslab.warsztaty3.util.DbUtil;

/**
 * Servlet implementation class DeleteExercise
 */
@WebServlet("/exercise/delete")
public class DeleteExercise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteExercise() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		ExerciseDao eDao = new ExerciseDao();
		try {
			Connection c = DbUtil.getConn();
			eDao.delete(c, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
