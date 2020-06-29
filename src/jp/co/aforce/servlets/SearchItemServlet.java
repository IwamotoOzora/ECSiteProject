package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MessageBean;
import jp.co.aforce.beans.SearchBean;
import jp.co.aforce.models.SearchItemModel;

//商品検索用サーブレット
public class SearchItemServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		String search = request.getParameter("search");
		String color = request.getParameter("color");
		int price = Integer.parseInt(request.getParameter("price"));

		SearchBean searchBean = new SearchBean();
		searchBean.setSearch(search);
		searchBean.setColor(color);
		searchBean.setPrice(price);

		MessageBean messageBean = new MessageBean();

		if (search.isBlank() && color == null && price == 0) { //検索欄に一項目も入力されていない場合
			messageBean.setEmsg("一項目以上入力してください");
			request.setAttribute("messageBean", messageBean);

			RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/search.jsp");
			rDispatcher.forward(request, response);
//			return;
		}

		if (request.getParameter("search") != null) {
			SearchItemModel searchItemModel = new SearchItemModel();
			List<SearchBean> searchItems = searchItemModel.getSearchItem(search, price, color);

			if (searchItemModel.getSearchItem(search, price, color) == null) { //該当商品がない場合
				messageBean.setEmsg("該当商品はありません");
				request.setAttribute("messageBean", messageBean);

			} else {
				request.setAttribute("searchItems", searchItems);
			}
			RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/search.jsp");
			rDispatcher.forward(request, response);
		}
	}
}
