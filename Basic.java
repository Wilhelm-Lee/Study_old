package com.study;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Scanner;

/**
 * @author william
 */

public class Basic {

	public static final @NotNull String CLASS_NAME = "Basic";

	/**
	 * @author william
	 */

	public static class BasicFunctions {

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

	/**
	 * @author william
	 */

	public static class BasicInput {

		public static final String CLASS_NAME = "BasicInput";

		private static final Scanner BASIC_SCANNER = new Scanner( System.in );

		public static String recorder( @NotNull String typeOfInput ) {

			System.out.println( BasicOutput.dyeing(
					true,
					BasicVariables.BASIC_INPUT_RECORDER_TYPE_REGULAR.equalsIgnoreCase( typeOfInput )
							? BasicVariables.TERMINAL_COLOR_WHITE
							: BasicVariables.BASIC_INPUT_RECORDER_TYPE_ANSWER.equalsIgnoreCase( typeOfInput )
									? BasicVariables.TERMINAL_COLOR_BLUE
									: BasicVariables.BASIC_INPUT_RECORDER_TYPE_REPLY_LOCAL.equalsIgnoreCase( typeOfInput )
											? BasicVariables.TERMINAL_COLOR_GREEN
											: BasicVariables.BASIC_INPUT_RECORDER_TYPE_REPLY_REMOTE.equalsIgnoreCase( typeOfInput )
													? BasicVariables.TERMINAL_COLOR_CYAN
													: BasicVariables.TERMINAL_COLOR_RESET
			) );
			return BasicInput.BASIC_SCANNER.next();
		}

		public static String recorder(
				@NotNull String typeOfInput,
				@NotNull String initiator
		) {

			System.out.println( BasicOutput.dyeing(
					true,
					BasicVariables.BASIC_INPUT_RECORDER_TYPE_REGULAR.equalsIgnoreCase( typeOfInput )
							? BasicVariables.TERMINAL_COLOR_WHITE
							: BasicVariables.BASIC_INPUT_RECORDER_TYPE_ANSWER.equalsIgnoreCase( typeOfInput )
									? BasicVariables.TERMINAL_COLOR_BLUE
									: BasicVariables.BASIC_INPUT_RECORDER_TYPE_REPLY_LOCAL.equalsIgnoreCase( typeOfInput )
											? BasicVariables.TERMINAL_COLOR_GREEN
											: BasicVariables.BASIC_INPUT_RECORDER_TYPE_REPLY_REMOTE.equalsIgnoreCase( typeOfInput )
													? BasicVariables.TERMINAL_COLOR_CYAN
													: BasicVariables.TERMINAL_COLOR_RESET
			) + typeOfInput + "(" + initiator + "): " );
			return BasicInput.BASIC_SCANNER.next();
		}
	}

	/**
	 * @author william
	 */

	public static class BasicOutput {

		// Everything here must be static!!!

		public static final String CLASS_NAME = "BasicOutput";

		/**
		 * Colors:(Format ) _FRONT|BACK + COLOR_ <String-Content>
		 */
		public static void greetings() {

			@NotNull String content = Settings.greetingsBeginSideSymbol
									  + BasicVariables.USER_NAME
									  + new Settings().localDateTime.format( new Settings().formatter )
									  + Settings.greetingsEndSideSymbol;

			// Do printing

			System.out.print( BasicOutput.dyeing(
					true,
					BasicVariables.TERMINAL_COLOR_YELLOW
			) + content );
		}

		public static @NotNull String dyeing(
				boolean isFront,
				char color
		) {

			return isFront
					? BasicVariables.TERMINAL_COLOR_DEFAULT_CODE_BEFORE_COLOR_CONTENT +
					  BasicVariables.BASIC_OUTPUT_LOG_FORMAT_COLOR_FRONT +
					  color +
					  BasicVariables.TERMINAL_COLOR_DEFAULT_CODE_AFTER_COLOR_CONTENT
					: BasicVariables.TERMINAL_COLOR_DEFAULT_CODE_BEFORE_COLOR_CONTENT +
					  BasicVariables.BASIC_OUTPUT_LOG_FORMAT_COLOR_BACK +
					  color +
					  BasicVariables.TERMINAL_COLOR_DEFAULT_CODE_AFTER_COLOR_CONTENT;
		}

		public static void log(
				@NotNull String typeOfLog,
				@Nullable String content
		) {

			System.out.println( BasicOutput.dyeing(
					true,
					BasicVariables.BASIC_OUTPUT_LOG_TYPE_REQUEST.equalsIgnoreCase( typeOfLog )
							? BasicVariables.TERMINAL_COLOR_CYAN
							: BasicVariables.BASIC_OUTPUT_LOG_TYPE_INFO.equalsIgnoreCase( typeOfLog )
									? BasicVariables.TERMINAL_COLOR_BLUE
									: BasicVariables.BASIC_OUTPUT_LOG_TYPE_WARN.equalsIgnoreCase( typeOfLog )
											? BasicVariables.TERMINAL_COLOR_YELLOW
											: BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR.equalsIgnoreCase( typeOfLog )
													? BasicVariables.TERMINAL_COLOR_RED
													: BasicVariables.TERMINAL_COLOR_RESET
			) + typeOfLog + ": " + content );
		}

		public static void log(
				@NotNull String typeOfLog,
				@NotNull String initiator,
				@Nullable String content
		) {

			System.out.print( BasicOutput.dyeing(
					true,
					BasicVariables.BASIC_OUTPUT_LOG_TYPE_REQUEST.equalsIgnoreCase( typeOfLog )
							? BasicVariables.TERMINAL_COLOR_CYAN
							: BasicVariables.BASIC_OUTPUT_LOG_TYPE_INFO.equalsIgnoreCase( typeOfLog )
									? BasicVariables.TERMINAL_COLOR_BLUE
									: BasicVariables.BASIC_OUTPUT_LOG_TYPE_WARN.equalsIgnoreCase( typeOfLog )
											? BasicVariables.TERMINAL_COLOR_YELLOW
											: BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR.equalsIgnoreCase( typeOfLog )
													? BasicVariables.TERMINAL_COLOR_RED
													: BasicVariables.TERMINAL_COLOR_RESET
			) + typeOfLog + "(" + initiator + "): " + content );
		}

		/**
		 * @see #log(String, String, String)
		 * @Explaination The {@code content} exists
		 * because {@code BasicOutput.log( String, String, String )}
		 * need {@code cause} here to be transferred into {@code String}.
		 * But then {@code content} would duplicate it. So, {@code content}
		 * could be {@code @Nullable}
		 */

		public static void log(
				@NotNull String typeOfLog,
				Throwable initiator,
				@Nullable String content
		) {

			BasicOutput.log(
					typeOfLog,
					initiator.getLocalizedMessage(),
					content
			);
		}

		public static void log(
				@NotNull String typeOfLog,
				char costumeColor,
				@NotNull String content
		) {

			System.out.println( BasicOutput.dyeing(
					true,
					costumeColor
			) + typeOfLog + ": " + content );
		}

		public static void log(
				@NotNull String typeOfLog,
				char costumeColor,
				@NotNull String initiator,
				@NotNull String content
		) {

			System.out.println( BasicOutput.dyeing(
					true,
					costumeColor
			) + typeOfLog + ": " + content );
		}

	}

	/**
	 * @author william
	 */

	public static class BasicVariables {

		/**
		 * Everything here must be {@code public}!!!<p>
		 * Everything here must be {@code static}!!!<p>
		 * Some variables would be used with adding a {@code SPACE} followed after itself as if you might or will
		 */

		public static final @NotNull String CLASS_NAME = "BasicVariables";

		public static final char DOT = '.';
		public static final char SPACE = ' ';
		public static final char SLASH = '/';
		public static final char ENDL = '\n';
		public static final char TABULATION = '\t';
		public static final String TARGET = "Target" + BasicVariables.SPACE;
		public static final String FILE_MANAGER_TARGET_TYPE_FILE_STRING = "File" + BasicVariables.SPACE,
				FILE_MANAGER_TARGET_TYPE_PATH_STRING = "Path" + BasicVariables.SPACE;
		public static final String FILE_MANAGER_OUTPUT_TEXT_TARGET_FILE_DOES_NOT_EXIST = "Target file does not exist" + BasicVariables.SPACE,
				FILE_MANAGER_OUTPUT_TEXT_TARGET_PATH_DOES_NOT_EXIST = "Target path does not exist" + BasicVariables.SPACE,
				FILE_MANAGER_OUTPUT_TEXT_HAD_ALREADY_EXISTED = BasicVariables.SPACE + "had already existed",
				FILE_MANAGER_OUTPUT_TEXT_FAILED_CAUSED_AND_CANCELED_BY_USER = BasicVariables.SPACE + "failed, caused & canceled by user",
				FILE_MANAGER_OUTPUT_TEXT_HOW_WOULD_YOU_LIKE_TO = "How would you like to" + BasicVariables.SPACE,
				FILE_MANAGER_OUTPUT_TEXT_QUESTIONMARK_YN = BasicVariables.SPACE + "? y/n",
				FILE_MANAGER_OUTPUT_TEXT_Y = "Y",
				FILE_MANAGER_OUTPUT_TEXT_YES = "YES",
				FILE_MANAGER_OUTPUT_TEXT_N = "N",
				FILE_MANAGER_OUTPUT_TEXT_NO = "NO";
		public static final String FILE_MANAGER_ACTIONS_CREATING = "CREATING";
		public static final String FILE_MANAGER_FILE_CREATING_SUCCESS = "File Creating Succeed" + BasicVariables.SPACE;
		public static final String FILE_MANAGER_FILE_CREATING_FAILED = "File Creating Failed" + BasicVariables.SPACE;
		public static final String LINUX_COMMAND_TOUCH = "touch", LINUX_COMMAND_MKDIR = "mkdir";
		public static final int META_YEAR = 1970;
		public static final LocalDateTime META_YEAR_LOCAL_DATE_TIME = LocalDateTime.of(
				// YEAR
				META_YEAR,
				// MONTH
				1,
				// DATE
				1,
				// HOUR
				0,
				// MINUTE
				0,
				// SECOND
				0,
				// NANO SECOND
				0
		);
		public static final int TIME_ZONE_OFFSET_EAST_EIGHT = 8;
		public static final String TERMINAL_COLOR_DEFAULT_CODE_BEFORE_COLOR_CONTENT = "\033[",
				TERMINAL_COLOR_DEFAULT_CODE_AFTER_COLOR_CONTENT = "m";
		public static final String BASIC_OUTPUT_LOG_FORMAT_FRONT = "Front";
		/*
		 * *---------------------------------------------------------------------------------*
		 * |			   COLOR	BELONG_TO		TYPE	NOTE							 |
		 * +---------------------------------------------------------------------------------+
		 * | 				CYAN	-> Request		<OUT>									 |
		 * | 				BLUE	-> Info         <OUT>                                    |
		 * | 			  YELLOW	-> Warn         <OUT>                                    |
		 * | 				 RED	-> Error        <OUT>                                    |
		 * | 			   White	-> Regular      <IN>                                     |
		 * | 				Blue	-> Ans          <IN>                                     |
		 * | 	   GREEN(Ground)	-> Reply-Local	<IN>	Not Scheduled To Use Yet	 	 |
		 * | 		   CYAN(Sky)	-> Reply-Remote	<IN>	Not Scheduled To Use Yet	 	 |
		 * *---------------------------------------------------------------------------------*
		 * ...............................................................July 15th, 2022.....
		 */
		/** Hello are you happy people?	-- Droopy Dog (1943 - 1958) */
		public static final String BASIC_OUTPUT_LOG_TYPE_REQUEST = "Request",
				BASIC_OUTPUT_LOG_TYPE_INFO = "Info",
				BASIC_OUTPUT_LOG_TYPE_WARN = "Warning",
				BASIC_OUTPUT_LOG_TYPE_ERROR = "Error";
		public static final String BASIC_INPUT_RECORDER_TYPE_REGULAR = "Regular",
				BASIC_INPUT_RECORDER_TYPE_ANSWER = "Answer",
				BASIC_INPUT_RECORDER_TYPE_REPLY_LOCAL = "Reply_Local",
				BASIC_INPUT_RECORDER_TYPE_REPLY_REMOTE = "Reply_Remote";
		public static final String BASIC_OUTPUT_LOG_FORMAT_COLOR_FRONT = "3",
				BASIC_OUTPUT_LOG_FORMAT_COLOR_BACK = "4";
		/** {@code TERMINAL_COLOR_RESET}: As what previous one was,
		 *  for the sections of which the both which are {@code Front}|{@code Back} and {@code color} */
		public static final char TERMINAL_COLOR_BLACK = '0',
				TERMINAL_COLOR_RED = '1',
				TERMINAL_COLOR_GREEN = '2',
				TERMINAL_COLOR_YELLOW = '3',
				TERMINAL_COLOR_BLUE = '4',
				TERMINAL_COLOR_MAGENTA = '5',
				TERMINAL_COLOR_CYAN = '6',
				TERMINAL_COLOR_WHITE = '7',
				TERMINAL_COLOR_RESET = '8';
		public static final int APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_NONE = 0,
				APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_NORMAL = 1,
				APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_IMPOTENT = 2,
				APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_URGENT = 3,
				APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_SERIOUS = 4,
				APPLICATIONS_TODOLIST_ITEM_URGENCY_LEVEL_IMMEDIATE = 5;
		public static final String USER_NAME = System.getProperty( "user.name" );
		public static final String HOME_PATH_STRING = "/home" + BasicVariables.SLASH + USER_NAME;
		public static final String DOCUMENTS_PATH_STRING = "/Documents";
		public static final String STUDY_PATH_STRING = HOME_PATH_STRING + BasicVariables.DOCUMENTS_PATH_STRING + "/StudyFiles";

		/**
		 * Starts from 1
		 */
		public static long applicationsTodoListItemIdLoadUp = 1;
		public static long timeLineIdLoadUp = 1;
	}

	/** @author william */

	public static class BasicException
			extends Throwable {


		static final long serialVersionUID = 1L;

		/**
		 * Constructs a new exception with {@code null} as its detail message.
		 * The cause is not initialized, and may subsequently be initialized by a
		 * call to {@link #initCause}.
		 */
		public BasicException() {

			super();
		}

		/**
		 * Constructs a new exception with the specified detail message.  The
		 * cause is not initialized, and may subsequently be initialized by
		 * a call to {@link #initCause}.
		 *
		 * @param message the detail message. The detail message is saved for
		 *                later retrieval by the {@link #getMessage()} method.
		 */
		public BasicException( String message ) {

			super( message );
		}

		/**
		 * Constructs a new exception with the specified detail message and
		 * cause.  <p>Note that the detail message associated with
		 * {@code cause} is <i>not</i> automatically incorporated in
		 * this exception's detail message.
		 *
		 * @param message the detail message (which is saved for later retrieval
		 *                by the {@link #getMessage()} method).
		 * @param cause   the cause (which is saved for later retrieval by the
		 *                {@link #getCause()} method).  (A {@code null} value is
		 *                permitted, and indicates that the cause is nonexistent or
		 *                unknown.)
		 * @since 1.4
		 */
		public BasicException(
				String message,
				Throwable cause
		) {

			super(
					message,
					cause
			);
		}

		/**
		 * Constructs a new exception with the specified cause and a detail
		 * message of {@code (cause==null ? null : cause.toString())} (which
		 * typically contains the class and detail message of {@code cause}).
		 * This constructor is useful for exceptions that are little more than
		 * wrappers for other throwable_s (for example, {@link
		 * java.security.PrivilegedActionException}).
		 *
		 * @param cause the cause (which is saved for later retrieval by the
		 *              {@link #getCause()} method).  (A {@code null} value is
		 *              permitted, and indicates that the cause is nonexistent or
		 *              unknown.)
		 * @since 1.4
		 */
		public BasicException( Throwable cause ) {

			super( cause );
		}

		/**
		 * Constructs a new exception with the specified detail message,
		 * cause, suppression enabled or disabled, and writable stack
		 * trace enabled or disabled.
		 *
		 * @param message            the detail message.
		 * @param cause              the cause.  (A {@code null} value is permitted,
		 *                           and indicates that the cause is nonexistent or unknown.)
		 * @param enableSuppression  whether suppression is enabled
		 *                           or disabled
		 * @param writableStackTrace whether the stack trace should
		 *                           be writable
		 * @since 1.7
		 */
		protected BasicException(
				String message,
				Throwable cause,
				boolean enableSuppression,
				boolean writableStackTrace
		) {

			super(
					message,
					cause,
					enableSuppression,
					writableStackTrace
			);
		}

	}
}
