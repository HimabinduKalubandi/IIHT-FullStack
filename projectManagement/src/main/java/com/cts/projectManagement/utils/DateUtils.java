package com.cts.projectManagement.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	public static final String DATE_PATTERN = "MM/dd/yyyy";

	public static LocalDate toLocalDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

		// convert String to LocalDate
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate;
	}

}
