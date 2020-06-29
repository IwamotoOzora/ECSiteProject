package jp.co.aforce.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.util.DBUtil;

public class ItemListModel {
	//商品一覧を取得する
	public List<ItemBean> getAllItems() {

		ResultSet rs = null;
		List<ItemBean> items = new ArrayList<ItemBean>();

		try {
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			String SQL = "SELECT * FROM `items`;";

			rs = DBUtil.execute(SQL);

			//商品一覧の取得
			rs.beforeFirst();
			while (rs.next()) {
				ItemBean itemBean = new ItemBean();
				itemBean.setItemCode(rs.getString("item_code"));
				itemBean.setName(rs.getString("name"));
				itemBean.setPrice(rs.getInt("price"));
				itemBean.setColor(rs.getString("color"));
				itemBean.setCategory(rs.getString("category"));
				itemBean.setImagePath(rs.getString("image_path"));
				items.add(itemBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return items;
	}

}
