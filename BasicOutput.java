// TODO: Mark each color with their functions ( request( String) ect.)
package com.michealwilliam;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static com.michealwilliam.Settings.*;

/**
 * @author william
 */

public class BasicOutput implements Interactions {
	// implement: REALIZING <Interface>;

	/***
	 * @param BLACK		-> IN SETTINGS
	 * @param RED		-> IN SETTINGS
	 * @param GREEN		-> IN SETTINGS
	 * @param YELLOW	-> IN SETTINGS
	 * @param BLUE		-> IN SETTINGS
	 * @param MAGENTA	-> IN SETTINGS
	 * @param CYAN		-> IN SETTINGS
	 * @param WHITE		-> IN SETTINGS
	 * @param RESET		-> IN SETTINGS
	 */

	// Colors:(Format ) _FRONT | BACK + COLOR_ <String-Content>
	static final String TERMINAL_COLOR_DEFAULT_CODE_BEFORE_COLOR_CONTENT = "\033[";
	static final String COLOR_FRONT = "3";
	static final String COLOR_BACK = "4";
	static final String TERMINAL_COLOR_DEFAULT_CODE_AFTER_COLOR_CONTENT = "m";
	static final String FRONT = "Front";

	public void greetings( String content ) {
		if( content != null ) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern( content );
		} else {
			// @content is [EMPTY]
			Settings settings = new Settings();
			DateTimeFormatter dtf = settings.formatter;
		}
		// Do printing

		System.out.print( dyeing(FRONT, YELLOW) + content );
	}
	// String
	public static void request( String content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request: " + content );
	}
	public static void information( String content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info: " + content );
	}
	public static void warnings( String content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning: " + content );
	}
	public static void errors( String content ) {
		System.out.println( dyeing(FRONT, RED) + "Error: " + content );
	}
	public static void request( String initiator, String content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request" + "(" + initiator + "): " + content );
	}
	public static void information( String initiator, String content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info" + "(" + initiator + "): " +  content );
	}
	public static void warnings( String initiator, String content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning" + "(" + initiator + "): " + content );
	}
	public static void errors( String initiator, String content ) {
		System.out.println( dyeing(FRONT, RED) + "Error" + "(" + initiator + "): " + content );
	}
	// boolean
	public static void request( boolean content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request: " + content );
	}
	public static void information( boolean content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info: " + content );
	}
	public static void warnings( boolean content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning: " + content );
	}
	public static void errors( boolean content ) {
		System.out.println( dyeing(FRONT, RED) + "Error: " + content );
	}
	public static void request( String initiator, boolean content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request" + "(" + initiator + "): " + content );
	}
	public static void information( String initiator, boolean content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info" + "(" + initiator + "): " +  content );
	}
	public static void warnings( String initiator, boolean content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning" + "(" + initiator + "): " + content );
	}
	public static void errors( String initiator, boolean content ) {
		System.out.println( dyeing(FRONT, RED) + "Error" + "(" + initiator + "): " + content );
	}
	// char
	public static void request( char content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request: " + content );
	}
	public static void information( char content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info: " + content );
	}
	public static void warnings( char content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning: " + content );
	}
	public static void errors( char content ) {
		System.out.println( dyeing(FRONT, RED) + "Error: " + content );
	}
	public static void request( String initiator, char content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request" + "(" + initiator + "): " + content );
	}
	public static void information( String initiator, char content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info" + "(" + initiator + "): " +  content );
	}
	public static void warnings( String initiator, char content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning" + "(" + initiator + "): " + content );
	}
	public static void errors( String initiator, char content ) {
		System.out.println( dyeing(FRONT, RED) + "Error" + "(" + initiator + "): " + content );
	}
	// int
	public static void request( int content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request: " + content );
	}
	public static void information( int content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info: " + content );
	}
	public static void warnings( int content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning: " + content );
	}
	public static void errors( int content ) {
		System.out.println( dyeing(FRONT, RED) + "Error: " + content );
	}
	public static void request( String initiator, int content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request" + "(" + initiator + "): " + content );
	}
	public static void information( String initiator, int content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info" + "(" + initiator + "): " +  content );
	}
	public static void warnings( String initiator, int content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning" + "(" + initiator + "): " + content );
	}
	public static void errors( String initiator, int content ) {
		System.out.println( dyeing(FRONT, RED) + "Error" + "(" + initiator + "): " + content );
	}
	// long
	public static void request( long content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request: " + content );
	}
	public static void information( long content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info: " + content );
	}
	public static void warnings( long content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning: " + content );
	}
	public static void errors( long content ) {
		System.out.println( dyeing(FRONT, RED) + "Error: " + content );
	}
	public static void request( String initiator, long content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request" + "(" + initiator + "): " + content );
	}
	public static void information( String initiator, long content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info" + "(" + initiator + "): " +  content );
	}
	public static void warnings( String initiator, long content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning" + "(" + initiator + "): " + content );
	}
	public static void errors( String initiator, long content ) {
		System.out.println( dyeing(FRONT, RED) + "Error" + "(" + initiator + "): " + content );
	}
	// float
	public static void request( float content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request: " + content );
	}
	public static void information( float content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info: " + content );
	}
	public static void warnings( float content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning: " + content );
	}
	public static void errors( float content ) {
		System.out.println( dyeing(FRONT, RED) + "Error: " + content );
	}
	public static void request( String initiator, float content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request" + "(" + initiator + "): " + content );
	}
	public static void information( String initiator, float content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info" + "(" + initiator + "): " +  content );
	}
	public static void warnings( String initiator, float content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning" + "(" + initiator + "): " + content );
	}
	public static void errors( String initiator, float content ) {
		System.out.println( dyeing(FRONT, RED) + "Error" + "(" + initiator + "): " + content );
	}
	// double
	public static void request( double content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request: " + content );
	}
	public static void information( double content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info: " + content );
	}
	public static void warnings( double content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning: " + content );
	}
	public static void errors( double content ) {
		System.out.println( dyeing(FRONT, RED) + "Error: " + content );
	}
	public static void request( String initiator, double content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request" + "(" + initiator + "): " + content );
	}
	public static void information( String initiator, double content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info" + "(" + initiator + "): " +  content );
	}
	public static void warnings( String initiator, double content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning" + "(" + initiator + "): " + content );
	}
	public static void errors( String initiator, double content ) {
		System.out.println( dyeing(FRONT, RED) + "Error" + "(" + initiator + "): " + content );
	}
	// char[]
	public static void request( char[] content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request: " + Arrays.toString(content));
	}
	public static void information( char[] content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info: " + Arrays.toString(content) );
	}
	public static void warnings( char[] content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning: " + Arrays.toString(content) );
	}
	public static void errors( char[] content ) {
		System.out.println( dyeing(FRONT, RED) + "Error: " + Arrays.toString(content) );
	}
	public static void request( String initiator, char[] content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request" + "(" + initiator + "): " + Arrays.toString(content) );
	}
	public static void information( String initiator, char[] content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info" + "(" + initiator + "): " +  Arrays.toString(content) );
	}
	public static void warnings( String initiator, char[] content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning" + "(" + initiator + "): " + Arrays.toString(content) );
	}
	public static void errors( String initiator, char[] content ) {
		System.out.println( dyeing(FRONT, RED) + "Error" + "(" + initiator + "): " + Arrays.toString(content) );
	}
	// object
	public static void request( Object content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request: " + content );
	}
	public static void information( Object content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info: " + content );
	}
	public static void warnings( Object content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning: " + content );
	}
	public static void errors( Object content ) {
		System.out.println( dyeing(FRONT, RED) + "Error: " + content );
	}
	public static void request( String initiator, Object content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Request" + "(" + initiator + "): " + content );
	}
	public static void information( String initiator, Object content ) {
		System.out.println( dyeing(FRONT, BLUE) + "Info" + "(" + initiator + "): " +  content );
	}
	public static void warnings( String initiator, Object content ) {
		System.out.println( dyeing(FRONT, YELLOW) + "Warning" + "(" + initiator + "): " + content );
	}
	public static void errors( String initiator, Object content ) {
		System.out.println( dyeing(FRONT, RED) + "Error" + "(" + initiator + "): " + content );
	}

	public static String dyeing( String frontOrBack, String color ) {
		return FRONT.equalsIgnoreCase( frontOrBack.toUpperCase() )
				? TERMINAL_COLOR_DEFAULT_CODE_BEFORE_COLOR_CONTENT + COLOR_FRONT + color.toUpperCase() + TERMINAL_COLOR_DEFAULT_CODE_AFTER_COLOR_CONTENT
				: TERMINAL_COLOR_DEFAULT_CODE_BEFORE_COLOR_CONTENT + COLOR_BACK + color.toUpperCase() + TERMINAL_COLOR_DEFAULT_CODE_AFTER_COLOR_CONTENT;
	}
}