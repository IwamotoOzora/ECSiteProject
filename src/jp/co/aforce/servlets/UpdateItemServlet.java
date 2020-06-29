package jp.co.aforce.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.beans.MessageBean;

public class UpdateItemServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

	}


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException { //登録する商品の一覧を表示するまでの処理
		request.setCharacterEncoding("UTF-8");

		String itemCode = request.getParameter("item_code");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String color = request.getParameter("color");
		String category = request.getParameter("category");
		String image = request.getParameter("image");
		String introduction = request.getParameter("introduction");

		File file = new File(image);
		String imagePath = file.getName();

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

			RequestDispatcher rD = request.getRequestDispatcher("/views/administration_update.jsp");
			rD.forward(request, response);

		} else {

			messageBean.setSmsg("上記の内容で商品情報を変更しますか");
			request.setAttribute("messageBean", messageBean);

			request.setAttribute("itemBean", itemBean);

			RequestDispatcher rD = request.getRequestDispatcher("/views/update_check.jsp");
			rD.forward(request, response);

		}
	}
}
