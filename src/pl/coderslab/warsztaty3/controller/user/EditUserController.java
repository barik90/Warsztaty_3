package pl.coderslab.warsztaty3.controller.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.warsztaty3.dao.UserDao;
import pl.coderslab.warsztaty3.model.User;
import pl.coderslab.warsztaty3.util.DbUtil;

/**
 * Servlet implementation class EditUserController
 */
@WebServlet("/user/edit")
public class EditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUserController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/user/edit-user-form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		System.out.println(id);
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String struserGroupId = request.getParameter("userGroupId");
		int userGroupId = Integer.parseInt(struserGroupId);
		User user = new User(id, username, email, password, userGroupId);
		UserDao userDao = new UserDao();
		try {
			Connection c = DbUtil.getConn();
			userDao.saveToDB(c, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
