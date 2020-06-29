package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.models.ItemListModel;

public class ItemListServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		ItemListModel itemListModel = new ItemListModel();
		List<ItemBean> items = itemListModel.getAllItems();

		request.setAttribute("items", items);

		if (request.getParameter("list") != null) {

			RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/administration_item.jsp");
			rDispatcher.forward(request, response);

		} else {

			RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/item.jsp");
			rDispatcher.forward(request, response);
		}
	}
}
