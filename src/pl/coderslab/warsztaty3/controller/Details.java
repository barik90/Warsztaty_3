package pl.coderslab.warsztaty3.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.warsztaty3.dao.SolutionDao;
import pl.coderslab.warsztaty3.util.DbUtil;

/**
 * Servlet implementation class Details
 */
@WebServlet("/details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Details() {
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
		SolutionDao solutionDao = new SolutionDao();
		try {
			Connection c = DbUtil.getConn();
			request.setAttribute("details", solutionDao.loadSolutionById(c, id));
			getServletContext().getRequestDispatcher("/WEB-INF/views/details/details.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
