package com.niit.EcommerceBackend.dao;

import java.util.List;

import com.niit.EcommerceBackend.entity.Category;

public interface CategoryDAO {
	//get
	Category getCategory (int categoryID);
	
	//list
	List<Category> getListCategory();
	
	//add
	boolean addCategory(Category category);
	
	//update
	boolean updateCategory(Category category);
	
	//delete
	boolean deleteCategory(Category category);
	
}
