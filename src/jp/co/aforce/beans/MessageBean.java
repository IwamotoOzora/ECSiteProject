package jp.co.aforce.beans;

import java.io.Serializable;

public class MessageBean implements Serializable {

	private String emsg;
	private String smsg;

	public MessageBean() {

	}

	public String getEmsg() {
		return emsg;
	}

	public void setEmsg(String emsg) {
		this.emsg = emsg;
	}

	public String getSmsg() {
		return smsg;
	}

	public void setSmsg(String smsg) {
		this.smsg = smsg;
	}
}
