package com.niit.ecommercefrontend.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.niit.EcommerceBackend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target; //Typecasting target into Product type!!

		// Whether file has been selected or not!!
		if (product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select an image to upload!!");
			return;
		}

		// Check if the image is other than JPEG, PNG and GIF then reject!!
		if (!( 
				product.getFile().getContentType().equals("image/jpeg")|| 
				product.getFile().getContentType().equals("image/png") ||
				product.getFile().getContentType().equals("image/gif")
				
				)) {
			errors.rejectValue("file", null, "Please select only an image file for upload!!");
			return;
		}
	}
}
