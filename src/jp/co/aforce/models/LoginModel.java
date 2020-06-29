package jp.co.aforce.models;

import java.sql.ResultSet;

import jp.co.aforce.util.DBUtil;

public class LoginModel {

	public boolean loginCheck(String userCode, String password) { //一般会員ログインチェック

		ResultSet rs = null;

		try {

			DBUtil.makeConnection();
			DBUtil.makeStatement();

			String SQL = "SELECT * FROM `users` WHERE `user_code`='" + userCode + "' AND `password`='" + password + "'";
			rs = DBUtil.execute(SQL);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection();

		}

		return rs != null;
	}

	public boolean administratorLoginCheck(String administratorCode, String password) { //管理者ログインチェック
		ResultSet rs = null;

		try {

			DBUtil.makeConnection();
			DBUtil.makeStatement();

			String SQL = "SELECT * FROM `administrators` WHERE `administrator_code`='" + administratorCode
					+ "' AND `password`='" + password + "'";
			rs = DBUtil.execute(SQL);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBUtil.closeConnection();

		}

		return rs != null;
	}

}