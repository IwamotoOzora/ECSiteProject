package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.beans.MessageBean;

public class DeleteItemServlet extends HttpServlet {
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

		MessageBean messageBean = new MessageBean();

		if (itemCode.isBlank() || name.isBlank() || price == 0 || color.isBlank() || category.isBlank()
				|| imagePath.isBlank() || introduction.isBlank()) {

			messageBean.setEmsg("入力されていない項目があります");

			request.setAttribute("messageBean", messageBean);
			RequestDispatcher rD = request.getRequestDispatcher("/views/administration_delete.jsp");
			rD.forward(request, response);

			return;

		} else {

			messageBean.setSmsg("上記の内容の商品情報を削除しますか");

			request.setAttribute("messageBean", messageBean);
			request.setAttribute("itemBean", itemBean);
			RequestDispatcher rD = request.getRequestDispatcher("/views/delete_check.jsp");
			rD.forward(request, response);
		}
	}
}