package com.study.OUTPUT;

import com.study.STORAGE.BasicVariables;
import com.study.STORAGE.Settings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author william
 */

public class BasicOutput {

	// Everything here must be static!!!

	public static final String CLASS_NAME = "BasicOutput";

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
	 * @Explaination The {@code content} exists
	 * because {@code BasicOutput.log( String, String, String )}
	 * need {@code cause} here to be transferred into {@code String}.
	 * But then {@code content} would duplicate it. So, {@code content}
	 * could be {@code @Nullable}
	 * @see #log(String, String, String)
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

	/**
	 * @Explaination The {@code content} exists
	 * because {@code BasicOutput.log( String, String, String )}
	 * need {@code cause} here to be transferred into {@code String}.
	 * But then {@code content} would duplicate it. So, {@code content}
	 * could be {@code @Nullable}
	 * @see #log(String, String, String)
	 * @see #log(String, Throwable, String)
	 */
	public static void log(
			Throwable initiator,
			@Nullable String content
	) {

		BasicOutput.log(
				/* Default LOG TYPE */
				BasicVariables.BASIC_OUTPUT_LOG_TYPE_ERROR,
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
		) + typeOfLog + "(" + initiator + "): " + content );
	}

	/**
	 * Colors:(Format ) _FRONT|BACK + COLOR_ <String-Content>
	 */
	public void greetings() {

		@NotNull String content = Settings.greetingsBeginSideSymbol
								  + BasicVariables.USER_NAME
								  + BasicVariables.SPACE
								  + new Settings().localDateTime.format( new Settings().formatter )
								  + Settings.greetingsEndSideSymbol;

		// Do printing

		System.out.print( BasicOutput.dyeing(
				true,
				BasicVariables.TERMINAL_COLOR_YELLOW
		) + content );
	}

}
