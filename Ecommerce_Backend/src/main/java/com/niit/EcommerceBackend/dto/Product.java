package com.niit.EcommerceBackend.dto;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productID;

	private String productCode;
	
	@NotBlank(message="Please enter the Product Name!")
	private String productName;
	
	@NotBlank(message="Please enter the Product Brand!")
	private String productBrand;
	
	@JsonIgnore
	@NotBlank(message="Please enter the Product Description!")
	private String productDescription;
	
	@Min(value = 1, message="The price cannot be less than 1!")
	private String productUnitPrice;
	private int productQuantity;
	
	private boolean productIsActive;
	
	@JsonIgnore
	private int categoryID;
	
	@JsonIgnore
	private int supplierID;
	
	private int productPurchases;
	private int productViews;
	
	@Transient
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	//Product Code generation from default constructor!!
	public Product() {
		this.productCode = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	//Setters and Getters!!
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductUnitPrice() {
		return productUnitPrice;
	}
	public void setProductUnitPrice(String productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public boolean getProductIsActive() {
		return productIsActive;
	}
	public void setProductIsActive(boolean productIsActive) {
		this.productIsActive = productIsActive;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	public int getProductPurchases() {
		return productPurchases;
	}
	public void setProductPurchases(int productPurchases) {
		this.productPurchases = productPurchases;
	}
	public int getProductViews() {
		return productViews;
	}
	public void setProductViews(int productViews) {
		this.productViews = productViews;
	}
}
