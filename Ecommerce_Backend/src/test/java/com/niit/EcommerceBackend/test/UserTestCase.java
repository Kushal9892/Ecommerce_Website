package com.niit.EcommerceBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
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
	
	/*@Test
	public void testAdd() {
		user = new User();
		user.setUserFirstName("Kushal");
		user.setUserLastName("Majithia");
		user.setUserEmail("km@gmail.com");
		user.setUserRole("USER");
		user.setUserContactNumber("9987581283");
		user.setUserPassword("123456");
		
		// Add the user!!
		assertEquals("Failed to add the user!!",true,userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("Sai Plaza");
		address.setAddressLineTwo("NIIT, 2nd Floor");
		address.setCity("Ghatkopar");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400098");
		address.setBilling(true);
		
		// Link the user with he address using user ID!!
		address.setUserID(user.getUserID());
		
		// Add the Address!!
		assertEquals("Failed to add the address!!", true, userDAO.addAddress(address));
		
		if(user.getUserRole().equals("USER")) {
			// Create a Cart for this user!!
			cart = new Cart();
			cart.setUser(user);
			
			// Add the cart!!
			assertEquals("Failed to create a cart!!", true, userDAO.addCart(cart));
			
			// Add a shipping address for this user!!
			address = new Address();
			address.setAddressLineOne("Oberoi Gardens");;
			address.setAddressLineTwo("Tech Mahindra, 6th Floor");;
			address.setCity("Andheri");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400072");
			
			// Set shipping to true!!
			address.setShipping(true);
			
			// Link the shipping address to this user!!
			address.setUserID(user.getUserID());
			
			// Add the shipping address!!
			assertEquals("Failed to add the shipping address!!", true, userDAO.addAddress(address));	
			
		}		
	}*/
	
	/*@Test
	public void testAdd() {
		user = new User();
		user.setUserFirstName("Kushal");
		user.setUserLastName("Majithia");
		user.setUserEmail("km@gmail.com");
		user.setUserRole("USER");
		user.setUserContactNumber("9987581283");
		user.setUserPassword("123456");
		
		if(user.getUserRole().equals("USER")) {
			// Create a Cart for this user!!
			cart = new Cart();
			cart.setUser(user);
			
			// Attach the Cart to the created the user!!
			user.setCart(cart);
		}

		// Add the user!!
		assertEquals("Failed to add the user!!",true,userDAO.addUser(user));
	}*/
	
	/*@Test
	public void testUpdateCart() {
		
		// Fetch user by his Email!!
		user = userDAO.getByEmail("km@gmail.com");
		
		// Get the cart of the user!!
		cart = user.getCart();
		
		// Set the cart attributes!!
		cart.setGrandTotal(5555);
		cart.setCartLines(2);
		
		assertEquals("Failed to update the cart!!", true, userDAO.updateCart(cart));
	}*/
	
	/*@Test
	public void testAddAddress() {
		
		// Add a new user!!
		user = new User();
		user.setUserFirstName("Test");
		user.setUserLastName("User");
		user.setUserEmail("TestUser@gmail.com");
		user.setUserRole("USER");
		user.setUserContactNumber("9987581283");
		user.setUserPassword("123456");

		assertEquals("Failed to add the user!!",true,userDAO.addUser(user));
		
		// Add the Billing Address!!
		address = new Address();
		address.setAddressLineOne("Sai Plaza");
		address.setAddressLineTwo("NIIT, 2nd Floor");
		address.setCity("Ghatkopar");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400098");
		address.setBilling(true);
		
		// Attach the user with the address!!
		address.setUser(user);
		
		assertEquals("Failed to add the billing address!!", true, userDAO.addAddress(address));
		
		// Add the Shipping Address!!
		address = new Address();
		address.setAddressLineOne("Oberoi Gardens");;
		address.setAddressLineTwo("Tech Mahindra, 6th Floor");;
		address.setCity("Andheri");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400072");
		// Set shipping to true!!
		address.setShipping(true);
		
		// Link the shipping address to this user!!
		address.setUser(user);
		
		assertEquals("Failed to add the shipping address!!", true, userDAO.addAddress(address));
	}*/
	
	/*@Test
	public void testFetchUserAddShippingAddress() {
		
		// Fetch the user by his Email!!
		user = userDAO.getByEmail("TestUser@gmail.com");
		
		// Add the Shipping Address!!
		address = new Address();
		address.setAddressLineOne("Oberoi Gardens");
		address.setAddressLineTwo("Tech Mahindra, 6th Floor");
		address.setCity("Bangalore");
		address.setState("Karnartaka");
		address.setCountry("India");
		address.setPostalCode("400072");
		// Set shipping to true!!
		address.setShipping(true);
				
		// Link the shipping address to this user!!
		address.setUser(user);
				
		assertEquals("Failed to add the shipping address!!", true, userDAO.addAddress(address));
	}*/

	@Test
	public void testBillingAndShippingAddress() {
		
		user = userDAO.getByEmail("TestUser@gmail.com");
		
		assertEquals("Failed to fetch the list of addresses and the size did not match!!", 2, 
				userDAO.getShippingAddress(user).size());
		
		assertEquals("Failed to fetch the Billing Address!!", "Maharashtra", 
				userDAO.getBillingAddress(user).getState());
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
