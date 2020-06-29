package jp.co.aforce.beans;

public class AdministratorBean {

	private String administratorCode;
	private String name;
	private String password;

	private String emsg;

	public AdministratorBean() {

	}

	public String getAdministratorCode() {
		return administratorCode;
	}

	public void setAdministratorCode(String administratorCode) {
		this.administratorCode = administratorCode;
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

	public String getEmsg() {
		return emsg;
	}

	public void setEmsg(String emsg) {
		this.emsg = emsg;
	}
}
