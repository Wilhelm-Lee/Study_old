package com.michealwilliam;

import java.io.File;
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
		BasicOutput bo = new BasicOutput();

		// Permanent code
		Functions.TodoList todoList = new Functions.TodoList();
		// Permanent code OVER

//		BasicOutput.information("Study", todoList.onCreate());
		FileManager fm = new FileManager();
		fm.creating(new File("/home/william/t"), "File", false);

	}
}