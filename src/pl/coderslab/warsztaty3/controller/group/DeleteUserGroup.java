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
import pl.coderslab.warsztaty3.util.DbUtil;

/**
 * Servlet implementation class DeleteUserGroup
 */
@WebServlet("/users-group/delete")
public class DeleteUserGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteUserGroup() {
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
		GroupDao gDao = new GroupDao();
		try {
			Connection c = DbUtil.getConn();
			gDao.delete(c, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.getWriter().append("Usunales grupe wraz z uzytkownikami");
	}
}
