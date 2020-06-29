package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToAdministrationServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/administration.jsp");
		rDispatcher.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/administration.jsp");
		rDispatcher.forward(request, response);
	}

}