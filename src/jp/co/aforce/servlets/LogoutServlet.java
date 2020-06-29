package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		if (session == null) {

			RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/login.jsp");
			rDispatcher.forward(request, response);
		} else {
			session.invalidate();
			RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/top.jsp");
			rDispatcher.forward(request, response);
		}
	}
}
