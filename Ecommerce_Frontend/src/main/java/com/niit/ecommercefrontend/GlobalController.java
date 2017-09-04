package com.niit.ecommercefrontend;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.niit.EcommerceBackend.dao.UserDAO;
import com.niit.EcommerceBackend.dto.User;
import com.niit.ecommercefrontend.model.UserModel;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel = null; 
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		
		if(session.getAttribute("userModel") == null) {
			
			// Add the user model!!
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = userDAO.getByEmail(authentication.getName());
			
			if(user != null) {
				
				// Create a new UserModel object to pass the User Details!!
				userModel = new UserModel();
				
				userModel.setUserID(user.getUserID());
				userModel.setUserFullName(user.getUserFirstName() + " " + user.getUserLastName());
				userModel.setUserEmail(user.getUserEmail());
				userModel.setUserRole(user.getUserRole());
				
				if(userModel.getUserRole().equals("USER")) {
					// Set the cart only if the user is buyer!!
					userModel.setCart(user.getCart());
				}
				
				// Set the userModel in the session!!
				session.setAttribute("userModel", userModel);
				
			}
			
		}
		return (UserModel) session.getAttribute("userModel");
	} 
	
}
