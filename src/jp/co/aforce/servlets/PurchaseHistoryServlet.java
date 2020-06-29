package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MessageBean;
import jp.co.aforce.beans.PurchaseHistoryBean;
import jp.co.aforce.models.PurchaseHistoryModel;

public class PurchaseHistoryServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		String userCode = request.getParameter("user_code");

		MessageBean messageBean = new MessageBean();
		PurchaseHistoryBean purchaseHistoryBean = new PurchaseHistoryBean();

		PurchaseHistoryModel purchaseHistoryModel = new PurchaseHistoryModel();

		if (request.getParameter("history") != null) {

			if (purchaseHistoryModel.history(userCode) != null) {

				messageBean.setSmsg("購入履歴を表示します");

				List<PurchaseHistoryBean> histories = purchaseHistoryModel.history(userCode);

				request.setAttribute("histories", histories);

			} else {

				messageBean.setEmsg("購入履歴がありません");

			}

			request.setAttribute("messageBean", messageBean);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/purchase_history.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
