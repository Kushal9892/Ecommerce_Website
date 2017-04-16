package com.niit.ecommercefrontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {

	private ProductDAO productDAO;
	
	public @ResponseBody List<Product> allProducts() {
		return ProductDAO.list();
	}
}
