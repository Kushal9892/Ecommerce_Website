package com.niit.EcommerceBackend.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;



@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int AddressID;
	
	@NotBlank(message="Please enter the Address!")
	private String addressLineOne;
	
	@NotBlank(message="Please enter the Address!")
	private String addressLineTwo;
	
	@NotBlank(message="Please enter the City!")
	private String city;
	
	@NotBlank(message="Please enter the State!")
	private String state;
	
	@NotBlank(message="Please enter the Country!")
	private String country;
	
	@NotBlank(message="Please enter the Postal Code!")
	private String postalCode;
	
	private boolean shipping;
	
	private boolean billing;
	
	/* ------------------------ */
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/* ------------------------ */
	
	public int getAddressID() {
		return AddressID;
	}
	public void setAddressID(int addressID) {
		AddressID = addressID;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public boolean isShipping() {
		return shipping;
	}
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	public boolean isBilling() {
		return billing;
	}
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	
	@Override
	public String toString() {
		return "Address [AddressID=" + AddressID + ", addressLineOne=" + addressLineOne + ", addressLineTwo="
				+ addressLineTwo + ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode="
				+ postalCode + ", shipping=" + shipping + ", billing=" + billing + ", user=" + user + "]";
	}
}
