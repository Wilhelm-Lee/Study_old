package com.michealwilliam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Settings {
	// greetings(String)
	LocalDateTime localDateTime = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy|HH:mm:ss");
}
