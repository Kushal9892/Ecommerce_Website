package com.niit.EcommerceBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcommerceBackend.dao.CategoryDAO;
import com.niit.EcommerceBackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.EcommerceBackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
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
	
	@Test
	public void testCRUDCategory() {
		
		//Adding Categories!!
		category = new Category();
		category.setCategoryName("Laptops");
		category.setCategoryDescription("This is the description for Laptops!!");
		category.setCategoryImageURL("category1.png");
		assertEquals("Failed to add a new category!!",true,categoryDAO.addCategory(category));
		
		category = new Category();
		category.setCategoryName("Televisions");
		category.setCategoryDescription("This is the description for Televisions!!");
		category.setCategoryImageURL("category2.png");
		assertEquals("Failed to add a new category!!",true,categoryDAO.addCategory(category));
		
		category = new Category();
		category.setCategoryName("Mobiles");
		category.setCategoryDescription("This is the description for Mobiles!!");
		category.setCategoryImageURL("category3.png");
		assertEquals("Failed to add a new category!!",true,categoryDAO.addCategory(category));
		
		category = new Category();
		category.setCategoryName("Cameras");
		category.setCategoryDescription("This is the description for Cameras!!");
		category.setCategoryImageURL("category4.png");
		assertEquals("Failed to add a new category!!",true,categoryDAO.addCategory(category));
		
		//Updating a category!!
		category = categoryDAO.getCategoryID(2);
		category.setCategoryName("TV");
		assertEquals("Failed to update a category!!",true,categoryDAO.updateCategory(category));
		
		//Deleting a category!!
		assertEquals("Failed to delete a category!!",true,categoryDAO.deleteCategory(category));
		
		//Fetching the list!!
		assertEquals("Failed to fetch the list of categories!!",3,categoryDAO.getListCategory().size());
	}
}
