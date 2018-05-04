package pl.coderslab.warsztaty3.controller;

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
import pl.coderslab.warsztaty3.util.DbUtil;

/**
 * Servlet implementation class UsersGroup
 */
@WebServlet("/admin-users-group")
public class AdminUsersGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminUsersGroup() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GroupDao groupDao = new GroupDao();
		try {
			Connection c = DbUtil.getConn();
			request.setAttribute("groups", (groupDao.loadAllGroups(c)));
			getServletContext().getRequestDispatcher("/WEB-INF/views/group/admin-users-group.jsp").forward(request,
					response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
