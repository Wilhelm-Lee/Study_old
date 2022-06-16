package com.michealwilliam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Settings {
	// BasicOutput.*
		// greetings(String)
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy|HH:mm:ss");
	static final String BLACK = "0";
	static final String RED = "1";
	static final String GREEN = "2";
	static final String YELLOW = "3";
	static final String BLUE = "4";
	static final String MAGENTA = "5";
	static final String CYAN = "6";
	static final String WHITE = "7";
	static final String RESET = "8"; // Default to be FRONT - BLACK
}
