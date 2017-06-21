package com.niit.EcommerceBackend.test;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcommerceBackend.dao.UserDAO;
import com.niit.EcommerceBackend.dto.Address;
import com.niit.EcommerceBackend.dto.Cart;
import com.niit.EcommerceBackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Address address = null;
	private Cart cart = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.EcommerceBackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}	
}
