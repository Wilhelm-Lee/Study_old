package com.michealwilliam;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.format.DateTimeFormatter;

/**
 * @author william
 */

public class BasicOutput {

	// Everything here must be static!!!

	public static final String className = "BasicOutput";

	// Colors:(Format ) _FRONT|BACK + COLOR_ <String-Content>
	private static @NotNull String initiatorModule( @Nullable String initiator ) {

		return "( " + initiator + " )";
	}

	public static void greetings( String content ) {

		if ( content != null ) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern( content );
		} else {
			// @content is [EMPTY]
			Settings settings = new Settings();
			DateTimeFormatter dtf = settings.formatter;
		}
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
				? BasicVariables.TERMINAL_COLOR_DEFAULT_CODE_BEFORE_COLOR_CONTENT + BasicVariables.BASIC_OUTPUT_LOG_FORMAT_COLOR_FRONT + color + BasicVariables.TERMINAL_COLOR_DEFAULT_CODE_AFTER_COLOR_CONTENT
				: BasicVariables.TERMINAL_COLOR_DEFAULT_CODE_BEFORE_COLOR_CONTENT + BasicVariables.BASIC_OUTPUT_LOG_FORMAT_COLOR_BACK + color + BasicVariables.TERMINAL_COLOR_DEFAULT_CODE_AFTER_COLOR_CONTENT;
	}

	/**
	 * @see #dyeing(boolean, char)
	 * @see #log(String, char, String, String)
	 * @see #log(boolean, String, String, String)
	 * @see #log(String, char, String, String, String)
	 * @deprecated This {@code log(boolean, @Notnull String, @Nullable String)}
	 * is deprecated because mainly the console colorizing is not
	 * mostly existed for {@code BACK}'s.
	 * <p>
	 * So far, the console interactions is still not that
	 * detailed needed. It might fix up later on.
	 */

	@Deprecated(since = "20220623191341+0800")
	public static void log(
			boolean costumeIsFront,
			@NotNull String typeOfLog,
			@Nullable String content
	) {

		System.out.println( BasicOutput.dyeing(
				costumeIsFront,
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

	/**
	 * @see #dyeing(boolean, char)
	 * @see #log(boolean, String, String)
	 * @see #log(String, char, String, String)
	 * @see #log(String, char, String, String, String)
	 * @deprecated This {@code log(boolean, @Notnull String, @Nullable String)}
	 * is deprecated because mainly the console colorizing is not
	 * mostly existed for {@code BACK}.
	 * <p>
	 * So far, the console interactions is still not that
	 * detailed needed. It might fix up later on.
	 */

	@Deprecated(since = "20220623191341+0800")
	public static void log(
			boolean costumeIsFront,
			@NotNull String typeOfLog,
			@NotNull String initiator,
			@Nullable String content
	) {

		System.out.println( BasicOutput.dyeing(
				costumeIsFront,
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
	 * @see #dyeing(boolean, char)
	 * @see #log(boolean, String, String)
	 * @see #log(boolean, String, String, String)
	 * @see #log(String, char, String, String, String)
	 * @deprecated This {@code log(boolean, @Notnull String, @Nullable String)}
	 * is deprecated because mainly the console colorizing is not
	 * mostly existed for {@code BACK}.
	 * <p>
	 * So far, the console interactions is still not that
	 * detailed needed. It might fix up later on.
	 */

	@Deprecated(since = "20220623191341+0800")
	public static void log(
			@NotNull String frontOrBack,
			char costumeColor,
			@NotNull String typeOfLog,
			@Nullable String content
	) {

		System.out.println( BasicOutput.dyeing(
				frontOrBack.equalsIgnoreCase( BasicVariables.BASIC_OUTPUT_LOG_FORMAT_FRONT ),
				costumeColor
		) + typeOfLog + ": " + content );
	}

	/**
	 * @see #dyeing(boolean, char)
	 * @see #log(boolean, String, String)
	 * @see #log(String, char, String, String)
	 * @see #log(boolean, String, String, String)
	 * @deprecated This {@code log(boolean, @Notnull String, @Nullable String)}
	 * is deprecated because mainly the console colorizing is not
	 * mostly existed for {@code BACK}.
	 * <p>
	 * So far, the console interactions is still not that
	 * detailed needed. It might fix up later on.
	 */

	@Deprecated(since = "20220623191341+0800")
	public static void log(
			@NotNull String frontOrBack,
			char costumeColor,
			@NotNull String typeOfLog,
			@NotNull String initiator,
			@Nullable String content
	) {

		System.out.println( BasicOutput.dyeing(
				frontOrBack.equalsIgnoreCase( BasicVariables.BASIC_OUTPUT_LOG_FORMAT_FRONT ),
				costumeColor
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
}