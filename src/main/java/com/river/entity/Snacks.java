package com.river.entity;

import java.io.Serializable;

public class Snacks implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2449943078054717984L;
	private String snacksId;
	private String snackName;
	private Double price;
	private String description;
	private String image;
	private Integer state;
	private Category category;
	private String categoryId;
	public String getSnacksId() {
		return snacksId;
	}
	public void setSnacksId(String snacksId) {
		this.snacksId = snacksId;
	}
	public String getSnackName() {
		return snackName;
	}
	public void setSnackName(String snackName) {
		this.snackName = snackName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
}
