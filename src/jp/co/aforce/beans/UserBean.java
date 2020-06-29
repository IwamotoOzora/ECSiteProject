package jp.co.aforce.beans;

import java.io.Serializable;

public class UserBean implements Serializable {

	private String userCode;
	private String name;
	private String password;
	private String mail;
	private String address;
	private String age;

	private String emsg;

	public UserBean() {

	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmsg() {
		return emsg;
	}

	public void setEmsg(String emsg) {
		this.emsg = emsg;
	}

}
