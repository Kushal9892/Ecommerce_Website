package com.niit.EcommerceBackend.entity;

public class Category {
	private int categoryID;
	private String categoryName;
	private String categoryDescription;
	private boolean categoryIsActive;
	
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public boolean isCategoryIsActive() {
		return categoryIsActive;
	}
	public void setCategoryIsActive(boolean categoryIsActive) {
		this.categoryIsActive = categoryIsActive;
	}
}
