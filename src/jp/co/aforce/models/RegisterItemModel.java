package jp.co.aforce.models;

import java.sql.ResultSet;

import jp.co.aforce.util.DBUtil;

public class RegisterItemModel {

	public boolean registerItem(String itemCode, String name, int price, String color, String category,
			String imagePath, String introduction) {

		ResultSet rs = null;

		try {

			DBUtil.makeConnection();
			DBUtil.makeStatement();

			String SQL = "INSERT INTO `items` (`item_code`, `name`, `price`, `color`, `category`, `image_path`, `introduction`) VALUES ('"
					+ itemCode + "','" + name + "', '" + price + "','" + color + "', '" + category + "','" + imagePath
					+ "','" + introduction + "')";
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
