package pl.coderslab.warsztaty3.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.warsztaty3.dao.UserDao;
import pl.coderslab.warsztaty3.util.DbUtil;

/**
 * Servlet implementation class Users
 */
@WebServlet("/admin-users")
public class AdminUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminUsers() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao userDao = new UserDao();
		try {
			Connection c = DbUtil.getConn();
			request.setAttribute("users", (userDao.loadAllUsers(c)));
			getServletContext().getRequestDispatcher("/WEB-INF/views/user/admin-users.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
