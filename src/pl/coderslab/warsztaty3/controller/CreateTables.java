package pl.coderslab.warsztaty3.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.warsztaty3.util.DbUtil;

/**
 * Servlet implementation class CreateTables
 */
@WebServlet("/createTables")
public class CreateTables extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateTables() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final String QUERY1 = "CREATE TABLE user_group(id int(11) AUTO_INCREMENT,\n"
			+ "                   name varchar(255),\n" + "                   PRIMARY KEY(id));";
	private static final String QUERY2 = "CREATE TABLE users(id bigint(20) AUTO_INCREMENT,\n"
			+ "                   username varchar(255),\n" + "                   email varchar(255) UNIQUE,\n"
			+ "                   password varchar(245),\n" + "                   user_group_id int(11),\n"
			+ "                   PRIMARY KEY(id),\n"
			+ "                   FOREIGN KEY(user_group_id) REFERENCES user_group(id) ON DELETE CASCADE);";
	private static final String QUERY3 = "CREATE TABLE exercise(id int(11) AUTO_INCREMENT,\n"
			+ "                      title varchar(255),\n" + "                      description TEXT,\n"
			+ "                      PRIMARY KEY(id));";
	private static final String QUERY4 = "CREATE TABLE solution(id int(11) AUTO_INCREMENT,\n"
			+ "                      created DATETIME,\n" + "                      updated DATETIME,\n"
			+ "                      description TEXT,\n" + "                      exercise_id int(11),\n"
			+ "                      users_id bigint(20),\n" + "                      PRIMARY KEY(id),\n"
			+ "                      FOREIGN KEY(exercise_id) REFERENCES exercise(id) ON DELETE CASCADE,\n"
			+ "                      FOREIGN KEY(users_id) REFERENCES users(id) ON DELETE CASCADE);";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection c = DbUtil.getConn();
			Statement stm = c.createStatement();
			stm.executeUpdate(QUERY1);
			stm.executeUpdate(QUERY2);
			stm.executeUpdate(QUERY3);
			stm.executeUpdate(QUERY4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
