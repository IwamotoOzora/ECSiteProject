package jp.co.aforce.models;

import java.sql.ResultSet;

import jp.co.aforce.util.DBUtil;

public class PurchaseModel {

	public boolean purchase(String userCode, String itemCode, int price, int count, String purchaseDate) {

		ResultSet rs = null;

		try {

			DBUtil.makeConnection();
			DBUtil.makeStatement();

			String SQL = "INSERT INTO `histories` (`user_code`, `item_code`, `price`, `count`, `purchase_date`) VALUES ('"
					+ userCode + "', '" + itemCode + "', '" + price + "', '" + count + "', '" + purchaseDate + "')";
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
