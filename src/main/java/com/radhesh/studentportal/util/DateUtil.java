package com.radhesh.studentportal.util;

import java.util.Calendar;
import java.util.Locale;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class DateUtil {

	public static Boolean isDateNull(LocalDate field) {
		return (field == null);
	}

	public static Boolean isTimeNull(LocalTime field) {
		return (field == null);
	}

	public static LocalDate getCurrentDate() {
		Calendar currentCalendar = Calendar.getInstance();
		LocalDate currentDate = LocalDate.fromCalendarFields(currentCalendar);
		return currentDate;
	}

	public static String getCurrentMonthName() {
		Calendar currentCalendar = Calendar.getInstance();
		String monthName = currentCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		return monthName;
	}

	public static String getPreviousMonthName() {
		Calendar currentCalendar = Calendar.getInstance();
		String monthName = currentCalendar.getDisplayName(Calendar.MONTH - 1, Calendar.LONG, Locale.getDefault());
		return monthName;
	}

	public static Integer getCurrentYear() {
		Calendar currentCalendar = Calendar.getInstance();
		return currentCalendar.get(Calendar.YEAR);
	}

	public static Integer getCurrentDayOfMonth() {
		Calendar currentCalendar = Calendar.getInstance();
		LocalDate currentDate = LocalDate.fromCalendarFields(currentCalendar);
		return currentDate.getDayOfMonth();
	}

//	public static Integer getDayOfMonth(LocalDate date) throws NonNullableFieldException {
//		if (DateUtil.isDateNull(date)) {
//			throw new NonNullableFieldException("date should not be null");
//		}
//		Integer dayOfMonth = null;
//		try {
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(date);
//			dayOfMonth = calendar.get(Calendar.DATE);
//		} catch (HibernateException e) {
//			e.printStackTrace();
//			throw new NonNullableFieldException(e);
//		}
//		return dayOfMonth;
//	}

	public static Integer getCurrentDayOfWeek() {
		Calendar currentCalendar = Calendar.getInstance();
		LocalDate currentDate = LocalDate.fromCalendarFields(currentCalendar);
		return currentDate.getDayOfWeek();
	}

//	public static Integer getDayOfWeek(LocalDate date) throws NonNullableFieldException {
//		if (DateUtil.isDateNull(date)) {
//			throw new NonNullableFieldException("date should not be null");
//		}
//		Integer dayOfWeek = null;
//		try {
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(date);
//			dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
//		} catch (HibernateException e) {
//			e.printStackTrace();
//			throw new NonNullableFieldException(e);
//		}
//		return dayOfWeek;
//	}
}