package com.radhesh.studentportal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "GREETING")
public class Greeting implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min = 1, max = 50)
	@Column(name = "GREETING_NAME")
	private String message;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FROM_DATE")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate fromDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "TO_DATE")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate toDate;

	public Greeting() {
	}

	public Greeting(String message, LocalDate fromDate, LocalDate toDate) {
		this.message = message;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(getClass().getSimpleName());
		builder.append("[message:");
		builder.append(message);
		builder.append(" fromDate:");
		builder.append(fromDate);
		builder.append(" toDate:");
		builder.append(toDate);
		builder.append("]");
		return builder.toString();
	}
}