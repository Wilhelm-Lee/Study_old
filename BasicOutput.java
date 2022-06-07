package com.michealwilliam;

import java.time.format.DateTimeFormatter;

/**
 * @author william
 */

public class BasicOutput implements Interactions { // implement: REALIZING <Interface>;

	public void greetings( String content ){
		if( content != null ) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern( content );
		} else {
			// format is [EMPTY]
			Settings s = new Settings();
			DateTimeFormatter dtf = s.formatter;
		}
		// Do print
		System.out.print( content );
	}

}
