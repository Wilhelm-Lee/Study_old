package com.michealwilliam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author william
 */
public class Settings {

	// NOTHING HERE COULD BE CONSTANT!!!

	// These are default settings (of course, other wise!?)

	public static String userNameOfThisAccountInThisOS = "william";
	public static String homePath = "/home/" + userNameOfThisAccountInThisOS;
	LocalDateTime localDateTime = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "MM-dd-yy|HH:mm:ss" );
}
