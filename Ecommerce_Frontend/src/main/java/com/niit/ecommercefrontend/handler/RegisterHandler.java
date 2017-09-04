package com.niit.ecommercefrontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.niit.EcommerceBackend.dao.UserDAO;
import com.niit.EcommerceBackend.dto.Address;
import com.niit.EcommerceBackend.dto.Cart;
import com.niit.EcommerceBackend.dto.User;
import com.niit.ecommercefrontend.model.RegisterModel;

@Component // Used to create a bean!! 
public class RegisterHandler {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
	
	public String saveAll(RegisterModel model) {
		String transitionValue = "success";
		
		// Fetch the User!!
		User user = model.getUser();
		
		if(user.getUserRole().equals("USER")) {
			
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
			
			// Encode the password!!
			user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
			
			// Save the User!!
			userDAO.addUser(user);
			
			// Get the Address!!
			Address billing = model.getBilling();
			billing.setUser(user);
			billing.setBilling(true);
			
			// Save the Address!!
			userDAO.addAddress(billing);
			
		}
		return transitionValue;
	}
	
	public String validateUser(User user, MessageContext error) {
		
		String transitionValue = "success";
		
		
		// Checking if Password matches Confirm Password!!
		if(!(user.getUserPassword().equals(user.getUserConfirmPassword()))) {
			
			error.addMessage(new MessageBuilder().error()
					.source("userConfirmPassword").defaultText("Password and Confirm Password do not match").build());
			
			transitionValue = "failure";
		}
		
		// Checking uniqueness of the Email ID!!
		if(userDAO.getByEmail(user.getUserEmail())!=null) {
			
			error.addMessage(new MessageBuilder().error()
					.source("userEmail").defaultText("Email ID already taken!!").build());
			
			transitionValue="failure";
		}
		return transitionValue;
	}
}
