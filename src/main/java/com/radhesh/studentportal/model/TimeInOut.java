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

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TIME_IN_OUT")
public class TimeInOut implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "IO_DATE", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate ioDate;

	@DateTimeFormat(pattern = "HH:mm:ss")
	@Column(name = "IN_TIME", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalTime inTime;

	@DateTimeFormat(pattern = "HH:mm:ss")
	@Column(name = "OUT_TIME", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalTime outTime;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Student student;

	public TimeInOut() {
	}

	public TimeInOut(LocalDate ioDate, LocalTime inTime, LocalTime outTime) {
		this.ioDate = ioDate;
		this.inTime = inTime;
		this.outTime = outTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getIoDate() {
		return ioDate;
	}

	public void setIoDate(LocalDate ioDate) {
		this.ioDate = ioDate;
	}

	public LocalTime getInTime() {
		return inTime;
	}

	public void setInTime(LocalTime inTime) {
		this.inTime = inTime;
	}

	public LocalTime getOutTime() {
		return outTime;
	}

	public void setOutTime(LocalTime outTime) {
		this.outTime = outTime;
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
		builder.append("[ioDate:");
		builder.append(ioDate);
		builder.append(" inTime:");
		builder.append(inTime);
		builder.append(" outTime:");
		builder.append(outTime);
		builder.append(" studentId:");
		builder.append(student.getId());
		builder.append("]");
		return builder.toString();
	}
}