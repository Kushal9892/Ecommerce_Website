package com.niit.EcommerceBackend.dao;

import java.util.List;

import com.niit.EcommerceBackend.dto.Product;

public interface ProductDAO {

	//get
	Product getProductID(int productID);
		
	//list
	List<Product> getListProduct();
		
	//add
	boolean addProduct(Product product);
		
	//update
	boolean updateProduct(Product product);
		
	//delete
	boolean deleteProduct(Product product);
	
	//
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryID);
	List<Product> getLatestActiveProducts(int count);
}
