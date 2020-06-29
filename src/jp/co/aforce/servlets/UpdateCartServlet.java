package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.models.CartModel;

public class UpdateCartServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		//変更したい
		String itemCode = request.getParameter("item_code");
		int count = Integer.parseInt(request.getParameter("count"));


		//beanへの格納
		CartBean cartBean = new CartBean();
		cartBean.setItemCode(itemCode);
		cartBean.setCount(count);

		//modelのインスタンス化
		CartModel cartModel = new CartModel();

		HttpSession session = request.getSession();

		ArrayList<CartBean> carts = (ArrayList<CartBean>) session.getAttribute("carts");

		for (CartBean cart:carts) {
			System.out.println(cart.getCount());
		}

		session.setAttribute("cartBean", cartBean);



		session.setAttribute("cartBean", cartBean);
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/cart.jsp");
		rDispatcher.forward(request, response);
	}
}
