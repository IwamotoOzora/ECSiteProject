package jp.co.aforce.models;

import java.sql.ResultSet;

import jp.co.aforce.util.DBUtil;

public class DeleteItemModel {
	public boolean deleteItem(String itemCode) {
		ResultSet rs = null;

		try {
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			String SQL = "DELETE FROM `items` WHERE item_code = '" + itemCode + "'";
			;

			rs = DBUtil.execute(SQL);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.closeConnection();
		}
		return true;
	}

}
