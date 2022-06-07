package com.michealwilliam;

import java.io.IOException;

/**
 * @author william
 */
public class Main {

	public static void main(String[] args) throws IOException {

		Functions functions = new Functions();
		Settings settings = new Settings();

		System.out.println(settings.formatter.format(settings.localDateTime));

	}
}