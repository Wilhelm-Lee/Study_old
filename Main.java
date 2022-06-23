package com.michealwilliam;

/**
 * @author william
 */

public class Main {

	/**
		These are the classes/methods witch need
		to create realizations (AKA Non-static):
			1. Functions.TodoList				[class]
			2. BasicOutput.greetings(String)	[method]
	 */

	public static void main(String[] args) {
		Functions.TodoList todoList = new Functions.TodoList();
		BasicOutput.log(BasicOutput.INFO, "Study.TodoList", String.valueOf(!todoList.onCreate()));
	}
}
