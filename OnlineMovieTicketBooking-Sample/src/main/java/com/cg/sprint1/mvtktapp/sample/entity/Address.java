package com.cg.sprint1.mvtktapp.sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="address")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="addressId")
public class Address 
{
	@Id
	@Column(name="add_id")
	int addressId;

	@Column(name="add_area")
	String addressArea;
	
	@Column(name="add_city ")
	String addressCity;
	
	@Column(name="add_state")
	String addressState;

	public Address() {}

	public Address(int addressId, String addressArea, String addressCity, String addressState) {
		super();
		this.addressId = addressId;
		this.addressArea = addressArea;
		this.addressCity = addressCity;
		this.addressState = addressState;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressArea() {
		return addressArea;
	}

	public void setAddressArea(String addressArea) {
		this.addressArea = addressArea;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	
}
