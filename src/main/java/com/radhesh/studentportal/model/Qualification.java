package com.radhesh.studentportal.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "QUALIFICATION")
public class Qualification implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min = 1, max = 50)
	@Column(name = "QUALIFICATION_NAME", unique = true, nullable = false)
	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATE", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private Date date;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Student student;

	public Qualification() {
	}

	public Qualification(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(getClass().getSimpleName());
		builder.append("[name:");
		builder.append(name);
		builder.append(" studentId:");
		builder.append(student.getId());
		builder.append("]");
		return builder.toString();
	}
}