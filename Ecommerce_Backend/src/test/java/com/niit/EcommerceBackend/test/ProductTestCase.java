package com.niit.EcommerceBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcommerceBackend.dao.ProductDAO;
import com.niit.EcommerceBackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.EcommerceBackend");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
//	@Test
//	public void testAddCategory() {
//		category = new Category();
//		category.setCategoryName("Laptops");
//		category.setCategoryDescription("This is the description for Laptops!!");
//		category.setCategoryImageURL("category2.png");
//		assertEquals("Failed to add a new category!!",true,categoryDAO.addCategory(category));
//	}
	
//	@Test
//	public void testGetCategory() {
//		category = categoryDAO.getCategoryID(1);
//		assertEquals("Failed to get a category!!","Televisions",category.getCategoryName());
//	}

//	@Test
//	public void testUpdateCategory() {
//		category = categoryDAO.getCategoryID(1);
//		category.setCategoryName("TV");
//		assertEquals("Failed to update a category!!",true,categoryDAO.updateCategory(category));
//	}
	
//	@Test
//	public void testDeleteCategory() {
//		category = categoryDAO.getCategoryID(1);
//		category.setCategoryName("TV");
//		assertEquals("Failed to delete a category!!",true,categoryDAO.deleteCategory(category));
//	}
	
//	@Test
//	public void testGetistCategory() {
//		assertEquals("Failed to fetch the list of categories!!",1,categoryDAO.getListCategory().size());
//	}
	
//	@Test
//	public void testCRUDCategory() {
//		
//		//Adding Products!!
//		product = new Product();
//		product.setProductName("Oppo Selfie S53");
//		product.setProductBrand("Oppo");
//		product.setProductDescription("This is the description for Oppo Mobile phones!!");
//		product.setProductUnitPrice("25000");
//		product.setProductIsActive(true);
//		product.setCategoryID(3);
//		product.setSupplierID(3);
//		//product.setProductImageURL("product1.png");
//		assertEquals("Failed to add a new product!!",true,productDAO.addProduct(product));
//		
//		//Updating a category!!
//		product = productDAO.getProductID(2);
//		product.setProductName("Samsung Galaxy S7");
//		assertEquals("Failed to update a product!!",true,productDAO.updateProduct(product));
//		
//		//Deleting a category!!
//		assertEquals("Failed to delete a product!!",true,productDAO.deleteProduct(product));
//		
//		//Fetching the list!!
//		assertEquals("Failed to fetch the list of products!!",6,productDAO.getListProduct().size());
//	}
	
	@Test
	public void testListActiveProducts() {
		assertEquals("Failed to fetch the list of products",5,productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Failed to fetch the list of products",3,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Failed to fetch the list of products",2,productDAO.listActiveProductsByCategory(1).size());
	}
	
	@Test
	public void testGetLatestActiveProducts() {
		assertEquals("Failed to fetch the list of products",3,productDAO.getLatestActiveProducts(3).size());
	}
	
	
	
	
}
