package com.radhesh.studentportal.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.radhesh.studentportal.refdata.ResolutionStatus;

@Entity
@Table(name = "ANNOUNCEMENT")
public class Contact implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min = 1, max = 50)
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Size(min = 1, max = 50)
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "EMAIL")
	private String email;

	@DateTimeFormat(pattern = "yyyy-MM-dd mm:hh:ss")
	@Column(name = "CONTACT_DATE_TIME")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDateTime contactDateTime;

	@Size(min = 1, max = 200)
	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "RESOLUTION_STATUS", nullable = false)
	private ResolutionStatus resolutionStatus;

	@Size(min = 1, max = 200)
	@Column(name = "RESOLUTION")
	private String resolution;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getContactDateTime() {
		return contactDateTime;
	}

	public void setContactDateTime(LocalDateTime contactDateTime) {
		this.contactDateTime = contactDateTime;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ResolutionStatus getResolutionStatus() {
		return resolutionStatus;
	}

	public void setResolutionStatus(ResolutionStatus resolutionStatus) {
		this.resolutionStatus = resolutionStatus;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(getClass().getSimpleName());
		builder.append("[id:");
		builder.append(id);
		builder.append(" firstName:");
		builder.append(getFirstName());
		builder.append(" lastName:");
		builder.append(getLastName());
		builder.append(" phoneNumber:");
		builder.append(getPhoneNumber());
		builder.append(" email:");
		builder.append(getEmail());
		builder.append(" contactDateTime:");
		builder.append(getContactDateTime());
		builder.append(" description:");
		builder.append(getDescription());
		builder.append(" resolutionStatus:");
		builder.append(getResolutionStatus());
		builder.append(" resolution:");
		builder.append(getResolution());
		builder.append("]");
		return builder.toString();
	}

}
