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
import pl.coderslab.warsztaty3.dao.UserDao;
import pl.coderslab.warsztaty3.model.Group;
import pl.coderslab.warsztaty3.model.User;
import pl.coderslab.warsztaty3.util.DbUtil;

/**
 * Servlet implementation class AddUserGroup
 */
@WebServlet("/users-group/add")
public class AddUserGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserGroup() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/group/add-group-form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");

		Group group = new Group(name);

		GroupDao groupDao = new GroupDao();

		try {
			Connection c = DbUtil.getConn();
			groupDao.saveToDB(c, group);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
