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

public class CartServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		ArrayList<CartBean> carts = (ArrayList<CartBean>) session.getAttribute("carts");

		String itemCode = request.getParameter("item_code");
		int count = Integer.parseInt(request.getParameter("count"));

		if (request.getParameter("register") != null) { //商品をカートに入れる処理
			CartModel cartModel = new CartModel();
			boolean isNewItem = true;

			if (carts == null) {
				carts = new ArrayList<CartBean>();

			} else {

				for (CartBean cart : carts) {

					if (itemCode.equals(cart.getItemCode())) { //既にカートに存在する商品の場合個数を１足す

						if (cart.getCount() >= 10) {
							break;
						}

						cart.setCount(cart.getCount() + 1);
						isNewItem = false;
					}
				}
			}

			if (isNewItem) {
				CartBean addItem = cartModel.getSelectItems(itemCode);
				addItem.setCount(count);
				carts.add(addItem);
			}

		} else if (request.getParameter("delete") != null) { //削除処理

			for (CartBean cart : carts) {

				if (itemCode.equals(cart.getItemCode())) {
					carts.remove(cart);
					break;
				}
			}

		} else if (request.getParameter("update") != null) { //数量変更処理

			for (CartBean cart : carts) {

				if (itemCode.equals(cart.getItemCode())) {
					cart.setCount(count);
					cart.getCount();

				}
			}
		}

		session.setAttribute("carts", carts);
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/cart.jsp");
		rDispatcher.forward(request, response);
	}
}
