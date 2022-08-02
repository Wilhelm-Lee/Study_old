package com.study.STORAGE;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author william
 */
public class Settings {

	// NOTHING HERE COULD BE CONSTANT!!!

	// These are default settings (of course, other wise!?)

	/**
	 * {@code greetingsBeginSideSymbol} is a White Square Button
	 */
	public static @NotNull String greetingsBeginSideSymbol = "$" + BasicVariables.SPACE;
	public static @NotNull String greetingsEndSideSymbol = BasicVariables.SPACE + ">>" + BasicVariables.SPACE;
	public LocalDateTime localDateTime = LocalDateTime.now();
	public DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "MM-dd-yy|HH:mm:ss" );
}
