package com.radhesh.studentportal.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TIMESHEET")
public class Timesheet implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "TS_DATE")
	private Date tsDate;

	@Column(name = "TASK")
	private String task;

	@Column(name = "HRS")
	private Integer hrs;

	@Column(name = "MINS")
	private Integer mins;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Student student;

	public Timesheet() {
	}

	public Timesheet(Date tsDate, Integer hrs, Integer mins, String task) {
		this.tsDate = tsDate;
		this.hrs = hrs;
		this.mins = mins;
		this.task = task;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTsDate() {
		return tsDate;
	}

	public void setTsDate(Date tsDate) {
		this.tsDate = tsDate;
	}

	public Integer getHrs() {
		return hrs;
	}

	public void setHrs(Integer hrs) {
		this.hrs = hrs;
	}

	public Integer getMins() {
		return mins;
	}

	public void setMins(Integer mins) {
		this.mins = mins;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
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
		builder.append("[tsDate:");
		builder.append(tsDate);
		builder.append(" hrs:");
		builder.append(hrs);
		builder.append(" mins:");
		builder.append(mins);
		builder.append(" task:");
		builder.append(task);
		builder.append(" studentId:");
		builder.append(student.getId());
		builder.append("]");
		return builder.toString();

	}
}