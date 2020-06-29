package jp.co.aforce.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.util.DBUtil;

public class ViewModel {
	public List<ItemBean> viewItem(String itemCode) {
		ResultSet rs = null;

		List<ItemBean> items = new ArrayList<ItemBean>();

		try {

			DBUtil.makeConnection();
			DBUtil.makeStatement();

			String SQL = "SELECT * FROM `items` WHERE `item_code` ='" + itemCode + "'";
			rs = DBUtil.execute(SQL);

			ItemBean itemBean = new ItemBean();

			itemBean.setItemCode(rs.getString("item_code"));
			itemBean.setName(rs.getString("name"));
			itemBean.setPrice(Integer.parseInt(rs.getString("price")));
			itemBean.setColor(rs.getString("color"));
			itemBean.setCategory(rs.getString("category"));
			itemBean.setImagePath(rs.getString("image_path"));
			itemBean.setIntroduction(rs.getString("introduction"));
			items.add(itemBean);

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		} finally {
			DBUtil.closeConnection();
		}
		return items;
	}

}
