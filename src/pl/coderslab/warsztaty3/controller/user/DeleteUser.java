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
import pl.coderslab.warsztaty3.util.DbUtil;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/user/delete")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteUser() {
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
		UserDao uDao = new UserDao();
		try {
			Connection c = DbUtil.getConn();
			uDao.delete(c, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.getWriter().append("Usunales uzytkownika");
	}
}
