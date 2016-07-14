package com.radhesh.studentportal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "HOBBY")
public class Hobby implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min = 1, max = 50)
	@Column(name = "HOBBY_NAME")
	private String name;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Student student;

	public Hobby() {
	}

	public Hobby(String name) {
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

	public Student getEmployee() {
		return student;
	}

	public void setEmployee(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(getClass().getSimpleName());
		builder.append("[name:");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
}