package jp.co.aforce.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.SearchBean;
import jp.co.aforce.util.DBUtil;

public class SearchItemModel {

	//検索値と一致する商品リストの取得
	public List<SearchBean> getSearchItem(String search, int price, String color) {

		ResultSet rs = null;
		List<SearchBean> searchItems = new ArrayList<SearchBean>();

		try {
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			//商品名のみの検索
			if (color == null && price == 0) {
				String SQL = "SELECT * FROM `items` WHERE name LIKE '%" + search + "%'";
				;
				rs = DBUtil.execute(SQL);
				//TODO 色のみの検索
			} else if (search.isBlank() && price == 0) {
				String SQL = "SELECT * FROM `items` WHERE color = '" + color + "'";
				;
				rs = DBUtil.execute(SQL);
				//値段のみの検索
			} else if (color == null && search.isBlank()) {
				String SQL = "SELECT * FROM `items` WHERE (price >= " + price + " AND price < " + price + " +1000)";
				;
				rs = DBUtil.execute(SQL);

				//商品名と色の検索
			} else if (price == 0) {
				String SQL = "SELECT * FROM `items` WHERE name LIKE '%" + search + "%' AND color = '" + color + "'";
				;
				rs = DBUtil.execute(SQL);

				//商品名と値段の検索
			} else if (color == null) {
				String SQL = "SELECT * FROM `items` WHERE name LIKE '%" + search + "%' AND (price >= " + price
						+ " AND price < " + price + "+1000)";
				;
				rs = DBUtil.execute(SQL);

				//色と値段の検索
			} else if (search.isBlank()) {
				String SQL = "SELECT * FROM `items` WHERE (price >=" + price + " AND price < " + price
						+ "+1000) AND color = '" + color + "'";
				;
				rs = DBUtil.execute(SQL);

				//全て入力されている際の検索
			} else {
				String SQL = "SELECT * FROM `items` WHERE name LIKE  '%" + search + "%' AND (price >= " + price
						+ " AND price < " + price + " +1000) AND color = '" + color + "'";
				;
				rs = DBUtil.execute(SQL);
			}
			//商品一覧の取得
			rs.beforeFirst();
			while (rs.next()) {
				SearchBean searchItemBean = new SearchBean();
				searchItemBean.setItemCode(rs.getString("item_code"));
				searchItemBean.setName(rs.getString("name"));
				searchItemBean.setPrice(rs.getInt("price"));
				searchItemBean.setColor(rs.getString("color"));
				searchItemBean.setImagePath(rs.getString("image_path"));
				searchItems.add(searchItemBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeConnection();
		}
		return searchItems;
	}

}
