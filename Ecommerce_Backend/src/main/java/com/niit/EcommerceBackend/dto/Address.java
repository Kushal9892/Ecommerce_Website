package com.niit.EcommerceBackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Address {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int AddressID;
	private int userID;
	private String addressLineOne;
	private String addressLineTwo;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private boolean shipping;
	private boolean billing;
	
	
	public int getAddressID() {
		return AddressID;
	}
	public void setAddressID(int addressID) {
		AddressID = addressID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
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
		return "Address [AddressID=" + AddressID + ", userID=" + userID + ", addressLineOne=" + addressLineOne
				+ ", addressLineTwo=" + addressLineTwo + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", postalCode=" + postalCode + ", shipping=" + shipping + ", billing=" + billing + "]";
	}	
}
