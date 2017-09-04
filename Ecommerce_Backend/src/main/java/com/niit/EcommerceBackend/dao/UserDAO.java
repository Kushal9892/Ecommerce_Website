package com.niit.EcommerceBackend.dao;

import java.util.List;

import com.niit.EcommerceBackend.dto.Address;
import com.niit.EcommerceBackend.dto.Cart;
import com.niit.EcommerceBackend.dto.User;

public interface UserDAO {

	// Add an User!!
	boolean addUser(User user);
	User getByEmail(String email);
	
	// Add an Address!!
	boolean addAddress(Address address);
	// Billing Address should be one per user!!
	Address getBillingAddress(User user);
	// Shipping Address can be multiple for each user!!
	List <Address> getShippingAddress(User user);
	
	// Add a Cart!!
	boolean updateCart(Cart cart);
}
