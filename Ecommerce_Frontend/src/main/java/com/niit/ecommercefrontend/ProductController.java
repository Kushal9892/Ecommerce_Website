/*package com.niit.ecommercefrontend;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.EcommerceBackend.dao.ProductDAO;
import com.niit.EcommerceBackend.entity.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	private ProductDAO productDAO;
	
	public @ResponseBody List<Product> allProducts() {
		return ProductDAO.list();
	}
}
*/