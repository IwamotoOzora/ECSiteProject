package jp.co.aforce.beans;

import java.io.Serializable;

public class PurchaseHistoryBean implements Serializable {

	private String name;
	private String imagePath;
	private int count;
	private int total;
	private String purchaseDate;


	public PurchaseHistoryBean() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public void getAll(String string) {

	}

}
