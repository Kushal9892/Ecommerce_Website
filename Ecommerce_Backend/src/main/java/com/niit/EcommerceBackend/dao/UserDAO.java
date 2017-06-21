package com.niit.EcommerceBackend.dao;

import com.niit.EcommerceBackend.dto.Address;
import com.niit.EcommerceBackend.dto.Cart;
import com.niit.EcommerceBackend.dto.User;

public interface UserDAO {

	// Add an User!!
	boolean addUser(User user);
	
	// Add an Address!!
	boolean addAddress(Address address);
	
	// Add a Cart!!
	boolean addCart(Cart cart);
}
