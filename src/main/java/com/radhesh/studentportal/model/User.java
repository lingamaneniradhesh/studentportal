package com.radhesh.studentportal.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Size(min = 5, max = 50)
	@Column(name = "USER_NAME")
	private String userName;

	@Size(min = 5, max = 100)
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "IS_ENABLED")
	private Boolean isEnabled;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Student student;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Role role;

	public User() {
	}

	public User(String userName, String password, Boolean isEnabled) {
		this.userName = userName;
		this.password = password;
		this.isEnabled = isEnabled;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(getClass().getSimpleName());
		builder.append("[id:");
		builder.append(id);
		builder.append(" userName:");
		builder.append(userName);
		builder.append(" password:");
		builder.append("MASKED");
		builder.append(" isEnabled:");
		builder.append(isEnabled);
		builder.append(" studentId:");
		builder.append(student.getId());
		builder.append(" roleId:");
		builder.append(role.getId());
		builder.append("]");
		return builder.toString();
	}
}