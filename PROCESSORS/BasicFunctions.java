package com.study.PROCESSORS;

import com.study.STORAGE.BasicVariables;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * @author william
 */

public class BasicFunctions {

	// All method should be written in form of Recursive-Call

	/* PERMEATE CODE: */
	public static final @NotNull String CLASS_NAME = "BasicFunctions";

	/**
	 * Calculation
	 */
	public static int getBitOn(
			int number,
			int index
	) {

		if ( index == 1 ) {
			return number % 10;
		} else {
			return getBitOn(
					number / 10,
					index - 1
			);
		}
	}

	public static int delta(
			int valueA,
			int valueB
	) {

		return Math.abs( valueA - valueB );
	}

	/**
	 * @Formular {@code GCD(valueA, valueB)} * {@code LCM(valueA, valueB)} = valueA * valueB
	 * @HOWDOESITWORKS When {@code valueA} times {@code valueB}, it equals as the value of
	 * the GreatestCommonDivisor of {@code valueA} and {@code valueB} times
	 * the LeastCommonMultiple of {@code valueA} and {@code valueB}.
	 * @see #leastCommonMultiple(int, int)
	 **/
	public static int greatestCommonDivisor(
			int valueA,
			int valueB
	) {

		if ( valueB == 0 ) {
			return valueA;
		} else {
			return greatestCommonDivisor(
					valueB,
					valueA % valueB
			);
		}
	}

	/**
	 * @Formular {@code GCD(valueA, valueB)} * {@code LCM(valueA, valueB)} = valueA * valueB
	 * @HOWDOESITWORKS When {@code valueA} times {@code valueB}, it equals as the value of
	 * the GreatestCommonDivisor of {@code valueA} and {@code valueB} times
	 * the LeastCommonMultiple of {@code valueA} and {@code valueB}.
	 * @see #greatestCommonDivisor(int, int)
	 **/
	public static int leastCommonMultiple(
			int valueA,
			int valueB
	) {

		return ( valueA * valueB ) / BasicFunctions.greatestCommonDivisor(
				valueA,
				valueB
		);
	}

	/**
	 * Date & Time
	 */
	public static boolean isLeapYear( long prolepticYear ) {
		// Taken from IsoChronology.java
		return ( ( prolepticYear & 3 ) == 0 ) && ( ( prolepticYear % 100 ) != 0 || ( prolepticYear % 400 ) == 0 );
	}

	public static long durationOfLocalDateTimeToSecond(
			@NotNull LocalDateTime itemLocalDateTimeStart,
			@NotNull LocalDateTime itemLocalDateTimeEnd,
			@NotNull ZoneOffset zoneOffset
	) {

		return ZonedDateTime.of(
				delta(
						itemLocalDateTimeStart.getYear(),
						itemLocalDateTimeEnd.getYear()
				) + BasicVariables.META_YEAR,
				delta(
						itemLocalDateTimeStart.getMonthValue(),
						itemLocalDateTimeEnd.getMonthValue()
				) + 1,
				delta(
						itemLocalDateTimeStart.getDayOfMonth(),
						itemLocalDateTimeEnd.getDayOfMonth() + 1
				),
				delta(
						itemLocalDateTimeStart.getHour(),
						itemLocalDateTimeEnd.getHour()
				) + ( zoneOffset.getTotalSeconds() / 3600 ),
				delta(
						itemLocalDateTimeStart.getMinute(),
						itemLocalDateTimeEnd.getMinute()
				),
				delta(
						itemLocalDateTimeStart.getSecond(),
						itemLocalDateTimeEnd.getSecond()
				),
				0,
				// nanosecond above
				ZoneId.systemDefault()
		).toEpochSecond();
	}

	public static long durationOfLocalDateTimeToSecond(
			@NotNull LocalDateTime itemLocalDateTimeStart,
			@NotNull LocalDateTime itemLocalDateTimeEnd
	) {

		ZoneOffset zoneOffset = ZoneOffset.ofHours( BasicVariables.TIME_ZONE_OFFSET_EAST_EIGHT );

		return ZonedDateTime.of(
				delta(
						itemLocalDateTimeStart.getYear(),
						itemLocalDateTimeEnd.getYear()
				) + BasicVariables.META_YEAR,
				delta(
						itemLocalDateTimeStart.getMonthValue(),
						itemLocalDateTimeEnd.getMonthValue()
				) + 1,
				delta(
						itemLocalDateTimeStart.getDayOfMonth(),
						itemLocalDateTimeEnd.getDayOfMonth() + 1
				),
				delta(
						itemLocalDateTimeStart.getHour(),
						itemLocalDateTimeEnd.getHour()
				) + ( zoneOffset.getTotalSeconds() / 3600 ),
				delta(
						itemLocalDateTimeStart.getMinute(),
						itemLocalDateTimeEnd.getMinute()
				),
				delta(
						itemLocalDateTimeStart.getSecond(),
						itemLocalDateTimeEnd.getSecond()
				),
				0,
				// nanosecond above
				ZoneId.systemDefault()
		).toEpochSecond();
	}

	// NEW ADD-IN CODE:

}
