package jp.co.aforce.beans;

import java.io.Serializable;

public class CartBean implements Serializable {

	private String itemCode;
	private String name;
	private int price;
	private String imagePath;
	private int count;
	private String purchaseDate;

	private String userCode;

	public CartBean() {

	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
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
