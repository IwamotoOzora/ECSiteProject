package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.beans.MessageBean;
import jp.co.aforce.models.ViewModel;

public class ViewServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		String itemCode = request.getParameter("item_code");

		ItemBean itemBean = new ItemBean();
		itemBean.setItemCode(itemCode);

		MessageBean messageBean = new MessageBean();

		ViewModel viewModel = new ViewModel();

		if (viewModel.viewItem(itemCode) == null) {

			messageBean.setEmsg("該当する商品コードは存在しません");
			request.setAttribute("messageBean", messageBean);

			if (request.getParameter("view") != null) {

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/administration_update.jsp");
				requestDispatcher.forward(request, response);

			} else if (request.getParameter("view_delete") != null) {

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/administration_delete.jsp");
				requestDispatcher.forward(request, response);

			}

		} else { //商品コードが存在する場合

			List<ItemBean> items = viewModel.viewItem(itemCode);

			for (ItemBean item : items) {

				request.setAttribute("item", item);
			}

			if (request.getParameter("view") != null) { //更新画面

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/administration_update.jsp");
				requestDispatcher.forward(request, response);

			} else if (request.getParameter("view_delete") != null) { //削除画面

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/administration_delete.jsp");
				requestDispatcher.forward(request, response);

			}
		}
	}
}