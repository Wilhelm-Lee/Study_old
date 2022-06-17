package com.michealwilliam;

import java.io.IOException;

/**
 * @author william
 */
public class Main {

	/**
		These are the classes/methods witch need
		to create realizations (Non-static):
			1. Functions.TodoList				[class]
			2. BasicOutput.greetings(String)	[method]
	 */

	public static void main(String[] args) throws IOException {

//		Functions functions = new Functions();
//		Settings settings = new Settings();
		FileManager fm = new FileManager();

		// Permanent code
		Functions.TodoList todoList = new Functions.TodoList();

		if ( todoList.TodoList() ) {
			BasicOutput.information(true);
		} else {
			BasicOutput.errors(false);
		}
		// Permanent code OVER

	}
}