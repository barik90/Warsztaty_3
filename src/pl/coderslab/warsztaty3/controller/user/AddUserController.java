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
 * Servlet implementation class AddUserController
 */
@WebServlet("/user/add")
public class AddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/user/add-user-form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String strUserGroupId = request.getParameter("user_group_id");
		int userGroupId = Integer.parseInt(strUserGroupId);
		User user = new User(username, email, password, userGroupId);

		UserDao userDao = new UserDao();

		try {
			Connection c = DbUtil.getConn();
			userDao.saveToDB(c, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
