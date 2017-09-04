package com.niit.EcommerceBackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="UserDetails")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	
	@NotBlank(message="Please enter the First Name!")
	private String userFirstName;
	
	@NotBlank(message="Please enter the Last Name!")
	private String userLastName;
	
	@NotBlank(message="Please enter the Email Address!")
	private String userEmail;
	
	private String userRole;
	
	@NotBlank(message="Please enter the Mobile Number!")
	private String userContactNumber;
	
	@NotBlank(message="Please enter the Password!")
	private String userPassword;
	
	@Transient
	private String userConfirmPassword;
	
	private boolean userEnabled = true;
	
	/* Getters and Setters for private fields */
	
	/* ---------------------------- */
	
	@OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	/* ---------------------------- */
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
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
	public String getUserContactNumber() {
		return userContactNumber;
	}
	public void setUserContactNumber(String userContactNumber) {
		this.userContactNumber = userContactNumber;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public boolean isUserEnabled() {
		return userEnabled;
	}
	public void setUserEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	}
	
	public String getUserConfirmPassword() {
		return userConfirmPassword;
	}
	public void setUserConfirmPassword(String confirmPassword) {
		this.userConfirmPassword = confirmPassword;
	}
	
	/* toString() for the fields */
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userEmail=" + userEmail + ", userRole=" + userRole + ", userContactNumber=" + userContactNumber
				+ ", userPassword=" + userPassword + ", confirmPassword=" + userConfirmPassword + ", userEnabled="
				+ userEnabled + ", cart=" + cart + "]";
	}
}
