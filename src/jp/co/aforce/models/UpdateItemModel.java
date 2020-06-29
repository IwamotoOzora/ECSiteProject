package jp.co.aforce.models;

import java.sql.ResultSet;

import jp.co.aforce.util.DBUtil;

public class UpdateItemModel {

	public boolean updateItem(String itemCode, String name, int price, String color, String category, String imagePath,
			String introduction) {
		ResultSet rs = null;
		try {
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			String SQL = "UPDATE `items` SET `name` = '" + name + "', `price` = " + price + ", `color` = '" + color
					+ "', `category` = '" + category + "', `image_path` = '" + imagePath + "', `introduction` = '"
					+ introduction + "' WHERE item_code = '" + itemCode + "'";
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