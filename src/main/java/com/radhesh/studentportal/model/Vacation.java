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
import org.springframework.format.annotation.DateTimeFormat;

import com.radhesh.studentportal.refdata.LeaveType;

@Entity
@Table(name = "VACATION")
public class Vacation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FROM_DATE", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate fromDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "TO_DATE", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate toDate;

	@Column(name = "LEAVE_TYPE", nullable = false)
	private LeaveType leaveType;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Student student;

	public Vacation() {
	}

	public Vacation(LocalDate fromDate, LocalDate toDate, LeaveType leaveType) {
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.leaveType = leaveType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(getClass().getSimpleName());
		builder.append("[fromDate:");
		builder.append(fromDate);
		builder.append(" toDate:");
		builder.append(toDate);
		builder.append(" leaveType:");
		builder.append(leaveType);
		builder.append("]");
		return builder.toString();
	}
}