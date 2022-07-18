package com.study;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
	public void greetings() {

		@NotNull String content = Settings.greetingsBeginSideSymbol
								  + BasicVariables.USER_NAME
								  + new Settings().localDateTime.format( new Settings().formatter )
								  + Settings.greetingsEndSideSymbol;

		// Do printing

		System.out.print( basicOutput.dyeing(
				true,
				BasicVariables.TERMINAL_COLOR_YELLOW
		) + content );
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
	 * @see #log(String, String, String)
	 * @Explaination The {@code content} exists
	 * because {@code BasicOutput.log( String, String, String )}
	 * need {@code cause} here to be transferred into {@code String}.
	 * But then {@code content} would duplicate it. So, {@code content}
	 * could be {@code @Nullable}
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
			@NotNull String content
	) {

		System.out.println( basicOutput.dyeing(
				true,
				costumeColor
		) + typeOfLog + ": " + content );
	}

	public void log(
			@NotNull String typeOfLog,
			char costumeColor,
			@NotNull String initiator,
			@NotNull String content
	) {

		System.out.println( basicOutput.dyeing(
				true,
				costumeColor
		) + typeOfLog + ": " + content );
	}

}