package com.niit.ecommercefrontend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.EcommerceBackend.dao.CategoryDAO;
import com.niit.EcommerceBackend.dao.ProductDAO;
import com.niit.EcommerceBackend.dto.Category;
import com.niit.EcommerceBackend.dto.Product;
import com.niit.ecommercefrontend.exception.ProductNotFoundException;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	// @RequestMapping(value = { "/test" })
	// public ModelAndView test(@RequestParam(value="greeting",
	// required=false)String greetingVar) {
	// if(greetingVar == null) {
	// greetingVar = "Hello There!!";
	// }
	// ModelAndView mv = new ModelAndView("page");
	// mv.addObject("greeting", greetingVar);
	// return mv;
	// }

	// @RequestMapping(value = { "/test/{greeting}" })
	// public ModelAndView test(@PathVariable("greeting") String greeting) {
	// if(greeting == null) {
	// greeting = "Hello There!!";
	// }
	// ModelAndView mv = new ModelAndView("page");
	// mv.addObject("greeting", greeting);
	// return mv;
	// }

	@RequestMapping(value = { "/", "/index", "/home", "/default" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifUserClickedHome", true);
		mv.addObject("title", "Home");
		
		logger.info("Inside the PageController index method!! - INFO");
		logger.debug("Inside the PageController index method!! - DEBUG");
		
		//Passing the list of Categories!!
		mv.addObject("categories", categoryDAO.getListCategory());
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifUserClickedAbout", true);
		mv.addObject("title", "About Us");
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifUserClickedContact", true);
		mv.addObject("title", "Contact Us");
		return mv;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name="error", required=false) String error, 
			@RequestParam(name="logout", required=false) String logout) {
		ModelAndView mv = new ModelAndView("login");
		if(error != null) {
			mv.addObject("message", "Invalid Username and Password!!");
		}
		
		if(logout != null) {
			mv.addObject("logout", "You have logged out successfully!!");
		}
		
		mv.addObject("title", "Login");
		return mv;
	}
	
	@RequestMapping(value = "/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("ifUserClickedRegister", true);
		mv.addObject("title", "Register");
		return mv;
	}
	
	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "403 - Access Denied");
		mv.addObject("errorTitle", "Aha! Caught You!");
		mv.addObject("errorDescription", "You are not authorized to view this page");
		return mv;
	}

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifUserClickedAllProducts", true);
		mv.addObject("title", "All Products");
		// passing the list of categories
		mv.addObject("categories", categoryDAO.getListCategory());
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		// Category DAO to fetch a single category
		Category category = null;
		category = categoryDAO.getCategoryID(id);
		mv.addObject("ifUserClickedCategoryProducts", true);
		mv.addObject("title", category.getCategoryName());
		// passing a single category!!
		mv.addObject("category", category);
		// passing the list of categories
		mv.addObject("categories", categoryDAO.getListCategory());
		return mv;
	}

	/*
	 * 
	 * To view a single product.
	 */

	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");

		Product product = productDAO.getProductID(id);
		if(product == null) throw new ProductNotFoundException();
		
		// Update the view count
		product.setProductViews(product.getProductViews() + 1);
		productDAO.updateProduct(product);
		//---------------------------------------
		
		mv.addObject("title",product.getProductName());
		mv.addObject("product",product);
		mv.addObject("ifUserClickedShowProduct",true);
		return mv;

	}
	
	@RequestMapping(value = "/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		// First we are going to fetch the authentication!!
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:login?logout";
	}
	
	
}
