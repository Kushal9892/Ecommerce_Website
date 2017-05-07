package com.niit.ecommercefrontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.EcommerceBackend.dao.CategoryDAO;
import com.niit.EcommerceBackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	
//	@RequestMapping(value = { "/test" })
//	public ModelAndView test(@RequestParam(value="greeting", required=false)String greetingVar) {
//		if(greetingVar == null) {
//			greetingVar = "Hello There!!";
//		}
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting", greetingVar);
//		return mv;
//	}
	
//	@RequestMapping(value = { "/test/{greeting}" })
//	public ModelAndView test(@PathVariable("greeting") String greeting) {
//		if(greeting == null) {
//			greeting = "Hello There!!";
//		}
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting", greeting);
//		return mv;
//	}
	
	@RequestMapping(value = { "/", "/index", "/home", "/default" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifUserClickedHome", true);
		mv.addObject("title", "Home");
		//passing the list of categories
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
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifUserClickedLogin", true);
		mv.addObject("title", "Login");
		return mv;
	}
		
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifUserClickedAllProducts", true);
		mv.addObject("title", "All Products");
		//passing the list of categories
		mv.addObject("categories", categoryDAO.getListCategory());
		return mv;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		//Category DAO to fetch a single category
		Category category = null;
		category = categoryDAO.getCategoryID(id);
		mv.addObject("ifUserClickedCategoryProducts", true);
		mv.addObject("title", category.getCategoryName());
		//passing a single category!!
		mv.addObject("category", category);
		//passing the list of categories
		mv.addObject("categories", categoryDAO.getListCategory());
		return mv;
	}
}
