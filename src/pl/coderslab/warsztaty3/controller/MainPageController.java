package pl.coderslab.warsztaty3.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.coderslab.warsztaty3.dao.SolutionMainPaigeDao;
import pl.coderslab.warsztaty3.util.DbUtil;

/**
 * Servlet implementation class MainPageController
 */
@WebServlet("/")
public class MainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainPageController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numberSolutions = getServletContext().getInitParameter("number-solutions");
		int numberSolution = Integer.parseInt(numberSolutions);
		// SolutionDao s = new SolutionDao();
		SolutionMainPaigeDao s = new SolutionMainPaigeDao();
		try {
			Connection c = DbUtil.getConn();
			// request.setAttribute("load5", s.loadAllSolution(c, numberSolution));
			request.setAttribute("load5", s.loadAllSolution(c, numberSolution));
			getServletContext().getRequestDispatcher("/WEB-INF/views/main/index.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
