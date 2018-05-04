package pl.coderslab.warsztaty3.controller.group;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.warsztaty3.dao.GroupDao;
import pl.coderslab.warsztaty3.model.Group;
import pl.coderslab.warsztaty3.util.DbUtil;

/**
 * Servlet implementation class EditUserGroup
 */
@WebServlet("/users-group/edit")
public class EditUserGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUserGroup() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/group/edit-group-form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		String name = request.getParameter("name");

		Group group = new Group(id, name);

		GroupDao groupDao = new GroupDao();

		try {
			Connection c = DbUtil.getConn();
			groupDao.saveToDB(c, group);
			// System.out.println(Arrays.toString(s.loadAllSolution(c, numberSolution)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
