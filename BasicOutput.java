// TODO: Mark each color with their functions ( request( String) ect.)
package com.michealwilliam;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.format.DateTimeFormatter;

import static com.michealwilliam.Settings.*;

/**
 * @author william
 */

public class BasicOutput implements InteractionsOutput {
	// implement: REALIZING <Interface>;

	/***
	 * @param BLACK        	-> IN SETTINGS
	 * @param RED     	   	-> IN SETTINGS
	 * @param GREEN        	-> IN SETTINGS
	 * @param YELLOW		-> IN SETTINGS
	 * @param BLUE        	-> IN SETTINGS
	 * @param MAGENTA    	-> IN SETTINGS
	 * @param CYAN        	-> IN SETTINGS
	 * @param WHITE        	-> IN SETTINGS
	 * @param RESET        	-> IN SETTINGS
	 */

	// Colors:(Format ) _FRONT | BACK + COLOR_ <String-Content>
	static final String TERMINAL_COLOR_DEFAULT_CODE_BEFORE_COLOR_CONTENT = "\033[";
	static final String TERMINAL_COLOR_DEFAULT_CODE_AFTER_COLOR_CONTENT = "m";
	static final String FRONT = "Front";
	static final String BACK = "Back";
	static final String REQUEST = "Request";	// CYAN
	static final String INFO = "Info";			// BLUE
	static final String WARN = "Warning";		// YELLOW
	static final String ERROR = "Error";		// RED

	public void greetings(String content) {
		if (content != null) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(content);
		} else {
			// @content is [EMPTY]
			Settings settings = new Settings();
			DateTimeFormatter dtf = settings.formatter;
		}
		// Do printing

		System.out.print(dyeing(FRONT, YELLOW) + content);
	}

	public static String dyeing(String frontOrBack, char color) {
		final String COLOR_FRONT = "3";
		final String COLOR_BACK = "4";
		return FRONT.equalsIgnoreCase(frontOrBack.toUpperCase())
				? TERMINAL_COLOR_DEFAULT_CODE_BEFORE_COLOR_CONTENT
				+ COLOR_FRONT + color + TERMINAL_COLOR_DEFAULT_CODE_AFTER_COLOR_CONTENT
				: TERMINAL_COLOR_DEFAULT_CODE_BEFORE_COLOR_CONTENT
				+ COLOR_BACK + color + TERMINAL_COLOR_DEFAULT_CODE_AFTER_COLOR_CONTENT;
	}

	public static void log(boolean costumeIsFront,
						   @NotNull String typeOfLog, @Nullable String content) {

		System.out.println(
				dyeing(costumeIsFront ? FRONT : BACK,
						REQUEST.equalsIgnoreCase(typeOfLog) ?
								CYAN :
								INFO.equalsIgnoreCase(typeOfLog) ?
										BLUE :
										WARN.equalsIgnoreCase(typeOfLog) ?
												YELLOW :
												ERROR.equalsIgnoreCase(typeOfLog) ?
														RED :
														RESET
				)
						+ typeOfLog + ": " + content);
	}

	public static void log(boolean costumeIsFront,
						   @NotNull String typeOfLog,
						   @NotNull String initiator, @Nullable String content) {

		System.out.println(
				dyeing(costumeIsFront ? FRONT : BACK,
						REQUEST.equalsIgnoreCase(typeOfLog) ?
								CYAN :
								INFO.equalsIgnoreCase(typeOfLog) ?
										BLUE :
										WARN.equalsIgnoreCase(typeOfLog) ?
												YELLOW :
												ERROR.equalsIgnoreCase(typeOfLog) ?
														RED :
														RESET
				)
						+ typeOfLog + "(" + initiator + "): " + content);
	}

	public static void log(@NotNull String typeOfLog,
						   @Nullable String content) {

		System.out.println(
				dyeing( FRONT,
						REQUEST.equalsIgnoreCase(typeOfLog) ?
								CYAN :
								INFO.equalsIgnoreCase(typeOfLog) ?
										BLUE :
										WARN.equalsIgnoreCase(typeOfLog) ?
												YELLOW :
												ERROR.equalsIgnoreCase(typeOfLog) ?
														RED :
														RESET
				)
						+ typeOfLog + ": " + content);
	}

	public static void log(@NotNull String typeOfLog,
						   @NotNull String initiator, @Nullable String content) {

		System.out.println(
				dyeing( FRONT,
						REQUEST.equalsIgnoreCase(typeOfLog) ?
								CYAN :
								INFO.equalsIgnoreCase(typeOfLog) ?
										BLUE :
										WARN.equalsIgnoreCase(typeOfLog) ?
												YELLOW :
												ERROR.equalsIgnoreCase(typeOfLog) ?
														RED :
														RESET
				)
						+ typeOfLog + "(" + initiator + "): " + content);
	}

	public static void log(@NotNull String frontOrBack, char costumeColor,
						   @NotNull String typeOfLog, @Nullable String content) {

		System.out.println(dyeing(frontOrBack, costumeColor) + typeOfLog + ": " + content);
	}

	public static void log(@NotNull String frontOrBack, char costumeColor,
						   @NotNull String typeOfLog, @NotNull String initiator, @Nullable String content) {

		System.out.println(dyeing(frontOrBack, costumeColor) + typeOfLog + "(" + initiator + "): " + content);
	}
}
