package com.michealwilliam;

public class BasicFunctions {

	// All method should be written in form Recursive-Call

	public static int getBitOn(int number, int index) {
		if (index == 1)
			return number % 10;
		else
			return getBitOn(number / 10, index - 1);
	}

}