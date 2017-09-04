package com.niit.ecommercefrontend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.EcommerceBackend.dao.CategoryDAO;
import com.niit.EcommerceBackend.dao.ProductDAO;
import com.niit.EcommerceBackend.dto.Category;
import com.niit.EcommerceBackend.dto.Product;
import com.niit.ecommercefrontend.util.FileUploadUtility;
import com.niit.ecommercefrontend.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation ) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifUserClickedManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product nProduct = new Product();
		nProduct.setSupplierID(1);
		nProduct.setProductIsActive(true);
		mv.addObject("product", nProduct);
		
		if(operation != null) {
			if(operation.equals("product")) {
				mv.addObject("message", "Product Added Successfully!!");
			}
			
			else if(operation.equals("category")) {
				mv.addObject("message", "Category Added Successfully!!");
			}
		}
		return mv;
	}
	 
	// 
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("ifUserClickedManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		// Fetch the product from the database!!
		Product nProduct = productDAO.getProductID(id);
		// Set the product fetched from the database!!
		mv.addObject("product", nProduct);
		return mv;
		}
		
	
	// Handling product submission
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model, HttpServletRequest request) {
		
		// Handle image validation for new products!!
		if(mProduct.getProductID() == 0) {
			new ProductValidator().validate(mProduct, results);
		}
		else {
			if(!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, results);
			}
		}
		
		// Check if there are any errors!!
		if(results.hasErrors()) {
			model.addAttribute("ifUserClickedManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for Product Submission!!");
			return "page";
		}
		
		// If the product id is 0 then it is a new product, 
		// else it is an existing product so we will be updating the existing product!!
		if(mProduct.getProductID() == 0) {
			productDAO.addProduct(mProduct);
		}
		else {
			productDAO.updateProduct(mProduct);
		}
		
		
		// If the image for upload is present
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getProductCode());
		}
		
		return "redirect:/manage/products?operation=product"; //Return type of GET is mv, Return type of POSt is String because after submission we will redirect to 'Manage Products'!!
	}
	
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		// Fetching the product from the database!!
		Product product = productDAO.getProductID(id);
		// Activating and deactivating based on the active field!!
		boolean isActive = product.getProductIsActive();
		product.setProductIsActive(!product.getProductIsActive());
		// Updating the product!!
		productDAO.updateProduct(product);
		return (isActive)? "You have successfully deactivated the product with ID "+product.getProductID()
		: "You have successfully activated the product with ID "+product.getProductID();
	}
	
	// To handle Category Submission
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		categoryDAO.addCategory(category);
		return "redirect:/manage/products?operation=category";	
	} 
	
	// Returning categories for all the request mappings!!
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.getListCategory();
	}
	
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	
	
	
	
	
	
	
	
	
	
}
