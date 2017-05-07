package com.niit.EcommerceBackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryID;
	private String categoryName;
	private String categoryDescription;
	private String categoryImageURL;
	private boolean categoryIsActive=true;
	
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
	public String getCategoryImageURL() {
		return categoryImageURL;
	}
	public void setCategoryImageURL(String categoryImageURL) {
		this.categoryImageURL = categoryImageURL;
	}
	public boolean isCategoryIsActive() {
		return categoryIsActive;
	}
	public void setCategoryIsActive(boolean categoryIsActive) {
		this.categoryIsActive = categoryIsActive;
	}
	
	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + ", categoryImageURL=" + categoryImageURL + ", categoryIsActive="
				+ categoryIsActive + "]";
	}
}
