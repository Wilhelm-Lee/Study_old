package com.michealwilliam;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class BasicFunctions {

	// All method should be written in form Recursive-Call

	// PERMEATE CODE:
		// Calculation
		public static int getBitOn(int number, int index) {
			if (index == 1)
				return number % 10;
			else
				return getBitOn(number / 10, index - 1);
		}
		public int delta(int valueA, int valueB) {
			return Math.abs(valueA - valueB);
		}
		// Date & Time
		public boolean isLeapYear(long prolepticYear) { // Taken from IsoChronology.java
			return ((prolepticYear & 3) == 0) && ((prolepticYear % 100) != 0 || (prolepticYear % 400) == 0);
		}
		public long durationToSecond(LocalDateTime start, LocalDateTime end, ZoneOffset zoneOffset) {

		final int metaYear = 1970;

		return ZonedDateTime.of(
				delta(start.getYear(), end.getYear()) + metaYear,
				delta(start.getMonthValue(), end.getMonthValue()) + 1,
				delta(start.getDayOfMonth(), end.getDayOfMonth() + 1),
				delta(start.getHour(), end.getHour()) + ( zoneOffset.getTotalSeconds() / 3600 ),
				delta(start.getMinute(), end.getMinute()),
				delta(start.getSecond(), end.getSecond()),
				0, ZoneId.systemDefault()
		).toEpochSecond();
	}

	// NEW ADD-IN CODE:
}
