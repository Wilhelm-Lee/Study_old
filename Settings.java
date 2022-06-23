package com.michealwilliam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Settings {
	// BasicOutput.*
		// greetings(String)
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy|HH:mm:ss");
	static final char BLACK = '0';
	static final char RED = '1';
	static final char GREEN = '2';
	static final char YELLOW = '3';
	static final char BLUE = '4';
	static final char MAGENTA = '5';
	static final char CYAN = '6';
	static final char WHITE = '7';
	static final char RESET = '8'; // Default to be FRONT - BLACK
}
