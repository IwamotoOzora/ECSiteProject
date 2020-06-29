package jp.co.aforce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.beans.MessageBean;
import jp.co.aforce.models.UpdateItemModel;

public class UpdateDisicionServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		//入力情報の取得
		String itemCode = request.getParameter("item_code");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String color = request.getParameter("color");
		String category = request.getParameter("category");
		String imagePath = request.getParameter("image_path");
		String introduction = request.getParameter("introduction");

		//ItemBeanへ格納
		ItemBean itemBean = new ItemBean();
		itemBean.setItemCode(itemCode);
		itemBean.setName(name);
		itemBean.setPrice(price);
		itemBean.setColor(color);
		itemBean.setCategory(category);
		itemBean.setImagePath(imagePath);
		itemBean.setIntroduction(introduction);

		//モデルのインスタンス化
		UpdateItemModel updateItemModel = new UpdateItemModel();

		//beanのインスタンス化
		MessageBean messageBean = new MessageBean();

		//商品情報の変更
		if (updateItemModel.updateItem(itemCode, name, price, color, category, imagePath, introduction) == true) {
			messageBean.setSmsg("変更に成功しました");
			request.setAttribute("messageBean", messageBean);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/administration_update.jsp");
			requestDispatcher.forward(request, response);
		} else {
			messageBean.setEmsg("変更に失敗しました");
			request.setAttribute("messageBean", messageBean);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/administration_update.jsp");
			requestDispatcher.forward(request, response);
		}

	}
}
