package com.radhesh.studentportal.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TEACHER")
public class Teacher extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Size(min = 1, max = 50)
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Size(max = 50)
	@Column(name = "MIDDLE_NAME", nullable = true)
	private String middleName;

	@Size(min = 1, max = 50)
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATE_OF_BIRTH", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate dateOfBirth;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATE_OF_JOINING", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate dateOfJoining;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATE_LEFT", nullable = true)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate dateLeft;

	@ManyToMany(mappedBy = "teachers")
	private Set<Student> students = new HashSet<Student>();

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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public LocalDate getDateLeft() {
		return dateLeft;
	}

	public void setDateLeft(LocalDate dateLeft) {
		this.dateLeft = dateLeft;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Teacher)) {
			return false;
		}
		Teacher other = (Teacher) obj;
		if (getId() != other.getId()) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(getClass().getSimpleName());
		builder.append("[id:");
		builder.append(id);
		builder.append("  firstName:");
		builder.append(getFirstName());
		builder.append(" middleName:");
		builder.append(getMiddleName());
		builder.append(" lastName:");
		builder.append(getLastName());
		builder.append(" email:");
		builder.append(getEmail());
		builder.append(" dateOfBirth:");
		builder.append(getDateOfBirth());
		builder.append(" dateOfJoining:");
		builder.append(getDateOfJoining());
		builder.append(" dateLeft:");
		builder.append(getDateLeft());
		builder.append(" studentCount:");
		builder.append(students.size());
		builder.append("]");
		return builder.toString();
	}
}
