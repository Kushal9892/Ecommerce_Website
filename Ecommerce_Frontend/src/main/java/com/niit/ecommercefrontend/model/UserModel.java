package com.niit.ecommercefrontend.model;

import java.io.Serializable;

import com.niit.EcommerceBackend.dto.Cart;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;


	private int userID;
	private String userFullName;
	private String userEmail;
	private String userRole;
	private Cart cart;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	@Override
	public String toString() {
		return "UserModel [userID=" + userID + ", userFullName=" + userFullName + ", userEmail=" + userEmail
				+ ", userRole=" + userRole + ", cart=" + cart + "]";
	}
}
