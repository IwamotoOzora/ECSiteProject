package jp.co.aforce.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.beans.MessageBean;
import jp.co.aforce.models.PurchaseModel;

public class PurchaseServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		Object carts = session.getAttribute("carts");

		MessageBean messageBean = new MessageBean();

		if (request.getParameter("purchase") != null) { //カートから購入画面へ

			if (session.getAttribute("carts") != null) {

				messageBean.setSmsg("上記の商品を購入しますか");

				request.setAttribute("messageBean", messageBean);
				request.setAttribute("carts", carts);

				RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/purcahse.jsp");
				rDispatcher.forward(request, response);

			} else {

				RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/cart.jsp");
				rDispatcher.forward(request, response);

			}

		} else { //購入確定後

			ArrayList<CartBean> items = (ArrayList<CartBean>) session.getAttribute("carts");

			CartBean cartBean = new CartBean();

			PurchaseModel purchaseModel = new PurchaseModel();

			String userCode = request.getParameter("user_code");
			System.out.println(userCode);

			Calendar cTime = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");

			for (CartBean item : items) {

				item.setUserCode(userCode);
				String userCodes = item.getUserCode();
				String itemCode = item.getItemCode();
				int price = item.getPrice();
				int count = item.getCount();
				String purchaseDate = sdf.format(cTime.getTime());

				cartBean.setUserCode(userCodes);
				cartBean.setItemCode(itemCode);
				cartBean.setPrice(price);
				cartBean.setCount(count);
				cartBean.setPurchaseDate(sdf.format(cTime.getTime()));

				purchaseModel.purchase(userCodes, itemCode, price, count, purchaseDate);

			}

			session.removeAttribute("carts");

			messageBean.setSmsg("購入完了しました");

			request.setAttribute("messageBean", messageBean);

			RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/cart.jsp");
			rDispatcher.forward(request, response);

		}
	}
}
