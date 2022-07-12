package com.michealwilliam;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.format.DateTimeFormatter;

/**
 * @author william
 */

public class BasicOutput {

	// Everything here must be static!!!

	public static final String CLASS_NAME = "BasicOutput";

	static BasicOutput basicOutput = new BasicOutput();

	/**
	 * Colors:(Format ) _FRONT|BACK + COLOR_ <String-Content>
	 */
	public void greetings( @Nullable String content ) {

		if ( content != null ) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern( content );
		} else {
			// @content is [EMPTY]
			Settings settings = new Settings();
			DateTimeFormatter dtf = settings.formatter;
		}
		// Do printing

		System.out.print( basicOutput.dyeing(
				true,
				BasicVariables.TERMINAL_COLOR_YELLOW
		) + content );
		basicOutput.log( BasicVariables. );
	}

	public @NotNull String dyeing(
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
	public void	log(
			boolean costumeIsFront,
			@NotNull String	typeOfLog,
			@Nullable String content
	) {

		System.out.println( basicOutput.dyeing(
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
	public void log(
			boolean costumeIsFront,
			@NotNull String typeOfLog,
			@NotNull String initiator,
			@Nullable String content
	) {

		System.out.println( basicOutput.dyeing(
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

	public void log(
			@NotNull String typeOfLog,
			@Nullable String content
	) {

		System.out.println( basicOutput.dyeing(
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

	public void log(
			@NotNull String typeOfLog,
			@NotNull String initiator,
			@Nullable String content
	) {

		System.out.print( basicOutput.dyeing(
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
	public void log(
			@NotNull String frontOrBack,
			char costumeColor,
			@NotNull String typeOfLog,
			@Nullable String content
	) {

		System.out.println( basicOutput.dyeing(
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
	public void log(
			@NotNull String frontOrBack,
			char costumeColor,
			@NotNull String typeOfLog,
			@NotNull String initiator,
			@Nullable String content
	) {

		System.out.println( basicOutput.dyeing(
				frontOrBack.equalsIgnoreCase( BasicVariables.BASIC_OUTPUT_LOG_FORMAT_FRONT ),
				costumeColor
		) + typeOfLog + "(" + initiator + "): " + content );
	}

	/**
	 * @Explaination The {@code @Nullable} exists
	 * because {@code basicOutput.log(String, String, String)}
	 * need {@code cause} here to be transferred into {@code String}.
	 * But then {@code content} would duplicate it.
	 * @see #log(String, String, String)
	 */

	public void log(
			@NotNull String typeOfLog,
			Throwable initiator,
			@Nullable String content
	) {

		basicOutput.log(
				typeOfLog,
				initiator.getLocalizedMessage(),
				content
		);
	}

	public void log(
			@NotNull String typeOfLog,
			char costumeColor,
			@Nullable String content
	) {
		System.out.println( basicOutput.dyeing(
				true,
				costumeColor
			) + typeOfLog + ": " + content
		);
	}

}