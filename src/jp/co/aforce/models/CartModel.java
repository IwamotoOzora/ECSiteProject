package jp.co.aforce.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.CartBean;
import jp.co.aforce.util.DBUtil;

public class CartModel {

	public CartBean getSelectItems(String itemCode) { //購入ボタンの商品コードから商品一覧を取得する

		ResultSet rs = null;
		List<CartBean> carts = new ArrayList<CartBean>();

		CartBean cartBean = new CartBean();

		try {
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			String SQL = "SELECT * FROM `items` WHERE item_code = '" + itemCode + "';";

			rs = DBUtil.execute(SQL);

			cartBean.setItemCode(rs.getString("item_code"));
			cartBean.setName(rs.getString("name"));
			cartBean.setPrice(rs.getInt("price"));
			cartBean.setImagePath(rs.getString("image_path"));
			carts.add(cartBean);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection();

		}
		return cartBean;
	}
}
