package com.radhesh.studentportal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.radhesh.studentportal.refdata.AddressType;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

	@Size(min = 1, max = 50)
	@Column(name = "ADDR_LN1")
	private String addressLine1;

	@Size(min = 0, max = 50)
	@Column(name = "ADDR_LN2")
	private String addressLine2;

	@Size(min = 1, max = 50)
	@Column(name = "CITY")
	private String city;

	@Size(min = 2, max = 50)
	@Column(name = "STATE")
	private String state;

	@Size(min = 2, max = 50)
	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "POSTAL_CODE")
	private Integer postalCode;

	@Id
	@Column(name = "ADDR_TYPE")
	@Enumerated(EnumType.STRING)
	private AddressType addressType;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Student student;

	public Address() {
	}

	public Address(String addressLine1, String addressLine2, String city, String state, String country, Integer zipcode,
			AddressType addressType) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = zipcode;
		this.addressType = addressType;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(getClass().getSimpleName());
		builder.append("[addressLine1:");
		builder.append(addressLine1);
		builder.append(" addressLine2:");
		builder.append(addressLine2);
		builder.append(" city:");
		builder.append(city);
		builder.append(" state:");
		builder.append(state);
		builder.append(" country:");
		builder.append(country);
		builder.append(" postalCode:");
		builder.append(postalCode);
		builder.append(" addressType:");
		builder.append(addressType);
		builder.append(" studentId:");
		builder.append(student.getId());
		builder.append("]");
		return builder.toString();
	}
}