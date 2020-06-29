package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.beans.MessageBean;
import jp.co.aforce.models.DeleteItemModel;

public class DeleteDisicionServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		String itemCode = request.getParameter("item_code");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String color = request.getParameter("color");
		String category = request.getParameter("category");
		String imagePath = request.getParameter("image_path");
		String introduction = request.getParameter("introduction");

		ItemBean itemBean = new ItemBean();
		itemBean.setItemCode(itemCode);
		itemBean.setName(name);
		itemBean.setPrice(price);
		itemBean.setColor(color);
		itemBean.setCategory(category);
		itemBean.setImagePath(imagePath);
		itemBean.setIntroduction(introduction);

		DeleteItemModel deleteItemModel = new DeleteItemModel();

		MessageBean messageBean = new MessageBean();

		if (deleteItemModel.deleteItem(itemCode)) { //商品の登録
			messageBean.setSmsg("削除に成功しました");

		} else {
			messageBean.setEmsg("削除に失敗しました");

		}
		request.setAttribute("messageBean", messageBean);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/administration_delete.jsp");
		requestDispatcher.forward(request, response);
	}
}
