package com.michealwilliam;

/**
 * @author william
 */
public interface Interactions {
	/**
	 * @param format			-> IN SETTINGS
	 * @param content			-> IN SETTINGS
	 */

	private void greetings(String format, String content) {
		System.out.printf(format, content);
	}
}
