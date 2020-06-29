package jp.co.aforce.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.PurchaseHistoryBean;
import jp.co.aforce.util.DBUtil;

public class PurchaseHistoryModel {

	public List<PurchaseHistoryBean> history(String userCode) {

		ResultSet rs = null;

		List<PurchaseHistoryBean> histories = new ArrayList<PurchaseHistoryBean>();

		try {

			DBUtil.makeConnection();
			DBUtil.makeStatement();

			String SQL = "SELECT items.name, histories.count, histories.purchase_date, TRUNCATE(histories.count * histories.price * 1.1 , 0) as total FROM `histories` INNER JOIN `items` on histories.item_code = items.item_code WHERE `user_code` = '" + userCode + "' ";;

			rs = DBUtil.execute(SQL);

			rs.beforeFirst();
			while(rs.next()) {

			PurchaseHistoryBean purchaseHistoryBean = new PurchaseHistoryBean();
			purchaseHistoryBean.setName(rs.getString("items.name"));
			purchaseHistoryBean.setCount(Integer.parseInt(rs.getString("histories.count")));
			purchaseHistoryBean.setTotal(Integer.parseInt(rs.getString("total")));
			purchaseHistoryBean.setPurchaseDate(rs.getString("histories.purchase_date"));
			histories.add(purchaseHistoryBean);

			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {

			DBUtil.closeConnection();
		}

		return histories ;

	}
}