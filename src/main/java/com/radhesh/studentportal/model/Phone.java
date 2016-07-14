package com.radhesh.studentportal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE")
public class Phone implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;

	@Column(name = "HOME_NUMBER")
	private String homeNumber;

	@Column(name = "OFFICE_NUMBER")
	private String officeNumber;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Student student;

	public Phone() {
	}

	public Phone(String mobileNumber, String officeNumber, String homeNumber) {
		this.mobileNumber = mobileNumber;
		this.officeNumber = officeNumber;
		this.homeNumber = homeNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(getClass().getSimpleName());
		builder.append("[mobileNumber:");
		builder.append(mobileNumber);
		builder.append(" officeNumber:");
		builder.append(officeNumber);
		builder.append(" homeNumber:");
		builder.append(homeNumber);
		builder.append(" studentId:");
		builder.append(student.getId());
		builder.append("]");
		return builder.toString();
	}
}