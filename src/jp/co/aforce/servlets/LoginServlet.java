package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.AdministratorBean;
import jp.co.aforce.beans.UserBean;
import jp.co.aforce.models.LoginModel;

@SuppressWarnings("serial")

public class LoginServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/top.jsp");
		rDispatcher.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		String userCode = request.getParameter("user_code");
		String password = request.getParameter("password");
		String administratorCode = request.getParameter("administrator_code");

		UserBean userBean = new UserBean();
		userBean.setUserCode(userCode);
		userBean.setPassword(password);

		LoginModel loginModel = new LoginModel();
		String forward_jsp = "/views/login.jsp";

		if (request.getParameter("normal") != null) { //一般会員のログインチェック//

			if (loginModel.loginCheck(userCode, password)) {

				request.setAttribute("userBean", userBean);

				forward_jsp = "/views/top.jsp";

			} else {

				userBean.setEmsg("会員番号またはパスワードが違います");
				request.setAttribute("userBean", userBean);
			}

			HttpSession session = request.getSession(true);

			session.setAttribute("userBean", userBean);

			RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
			rDispatcher.forward(request, response);

		} else if (request.getParameter("administrator") != null) { //管理者のログインチェック

			AdministratorBean administratorBean = new AdministratorBean();
			administratorBean.setAdministratorCode(administratorCode);
			administratorBean.setPassword(password);

			if (loginModel.administratorLoginCheck(administratorCode, password)) {

				request.setAttribute("userBean", userBean);

				forward_jsp = "/views/administration.jsp";

			} else {

				administratorBean.setEmsg("管理者番号またはパスワードが違います");
				request.setAttribute("administratorBean", administratorBean);

				forward_jsp = "/views/login.jsp";
			}

			HttpSession session = request.getSession(true);

			RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
			rDispatcher.forward(request, response);

		}
	}

}