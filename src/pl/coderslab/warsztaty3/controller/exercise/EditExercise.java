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
import pl.coderslab.warsztaty3.model.Exercise;
import pl.coderslab.warsztaty3.util.DbUtil;

/**
 * Servlet implementation class AddExercise
 */
@WebServlet("/exercise/edit")
public class EditExercise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditExercise() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/exercise/edit-exercise-form.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		Exercise exercise = new Exercise(id, title, description);
		ExerciseDao eDao = new ExerciseDao();
		try {
			Connection c = DbUtil.getConn();
			eDao.saveToDB(c, exercise);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
