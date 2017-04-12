package com.river.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable{
	

	private static final long serialVersionUID = 3401729631065959058L;
	private String categoryId;
	private String categoryName;
	private List<Snacks> snacksList = new ArrayList<Snacks>();
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<Snacks> getSnacksList() {
		return snacksList;
	}
	public void setSnacksList(List<Snacks> snacksList) {
		this.snacksList = snacksList;
	}
	
	
	
}
